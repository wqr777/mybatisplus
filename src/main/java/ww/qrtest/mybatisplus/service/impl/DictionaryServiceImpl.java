package ww.qrtest.mybatisplus.service.impl;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import org.springframework.beans.factory.annotation.Autowired;
import ww.qrtest.mybatisplus.domain.Dictionary;
import ww.qrtest.mybatisplus.domain.DictionaryExcl;
import ww.qrtest.mybatisplus.domain.DictionaryVo;
import ww.qrtest.mybatisplus.mapper.DictionaryMapper;
import ww.qrtest.mybatisplus.service.IDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wqrtest
 * @since 2019-05-27
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public void add(InputStream inputStream) {
        /*Dictionary value = dictionaryMapper.selectOne(new QueryWrapper<Dictionary>().eq("value", "000000"));
        dictionaryMapper.deleteCity(value.getSeqNo());*/
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<DictionaryExcl> list = reader.readAll(DictionaryExcl.class);
        List<Dictionary> dictionaryList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        Map<String, Dictionary> map1 = new HashMap<>();
        Map<String,List<Dictionary>> map2 = new HashMap<>();
        for (DictionaryExcl dictionaryExcl : list) {
            map.put(dictionaryExcl.getNameId(), dictionaryExcl.getName());
        }
        //保存顶级父类
        Dictionary dictionary2 = new Dictionary();
        Integer parentLast = getParentLast("000");
        //查询当前级别的最后一条的seq_no末尾值
        Integer integer = Integer.valueOf(parentLast);
        //补全（编码+1）
        String seq_no = num3(integer + 1);
        dictionary2.setName("全国城市").setParent("000").setSeqNo(seq_no).setLevel(1).setValue("000000");
        dictionaryList.add(dictionary2);
        map1.put(dictionary2.getValue(), dictionary2);
        map2.put(dictionary2.getSeqNo(), new ArrayList<>());
        for (DictionaryExcl dictionaryExcl : list) {
            if (dictionaryList.size() == 1000) {
                dictionaryMapper.saveList(dictionaryList);
                dictionaryList = new ArrayList<>();
            }
            Dictionary dictionary = new Dictionary();
            String nameId = dictionaryExcl.getNameId();
            if (nameId.substring(nameId.length() - 4).equals("0000")) {
                Dictionary dictionary1 = map1.get("000000");
                int size = map2.get(dictionary1.getSeqNo()).size();
                String seqNo = num3(size + 1);
                //拼接保存
                dictionary.setSeqNo(dictionary1.getSeqNo()+"-"+seqNo)
                        .setValue(dictionaryExcl.getNameId())
                        .setName(dictionaryExcl.getName())
                        .setSeqCn(dictionaryExcl.getName())
                        .setLevel(dictionary1.getLevel() + 1)
                        .setParent(dictionary1.getSeqNo());
                dictionaryList.add(dictionary);
                map1.put(dictionary.getValue(), dictionary);
                map2.get(dictionary1.getSeqNo()).add(dictionary);
                map2.put(dictionary.getSeqNo(),new ArrayList<>());
            } else {
                StringBuffer name = new StringBuffer(dictionaryExcl.getNameId());
                if (nameId.substring(nameId.length() - 2).equals("00")) {
                    name = name.replace(name.length() - 4, name.length(), "0000");
                } else {
                    name = name.replace(name.length() - 2, name.length(), "00");
                    if (map.get(name.toString()) == null) {
                        name = name.replace(name.length() - 3, name.length(), "000");
                        if (map.get(name.toString()) == null) {
                            name = name.replace(name.length() - 4, name.length(), "0000");
                        }
                    }
                }
                //查询父级的数据
                Dictionary parentDict = map1.get(name.toString());
                int size = map2.get(parentDict.getSeqNo()).size();
                String seqNo = num3(size + 1);
                //拼接保存
                dictionary.setName(dictionaryExcl.getName())
                        .setValue(dictionaryExcl.getNameId())
                        .setSeqNo(parentDict.getSeqNo()+"-"+seqNo)
                        .setLevel(parentDict.getLevel() + 1)
                        .setSeqCn(parentDict.getSeqCn() + "-" + dictionary.getName())
                        .setParent(parentDict.getSeqNo());
                dictionaryList.add(dictionary);
                map1.put(dictionary.getValue(), dictionary);
                map2.get(parentDict.getSeqNo()).add(dictionary);
                map2.put(dictionary.getSeqNo(),new ArrayList<>());
            }
        }
        if (null != dictionaryList && dictionaryList.size() != 0) {
            dictionaryMapper.saveList(dictionaryList);
        }
    }

    @Override
    public List<DictionaryVo> listAll() {
        return getLevelData();
    }

    /**
     * 查询指定parent级别的排在最后的一条数据的seq_no的末尾值
     *
     * @param parent 父级的标识
     */
    private Integer getParentLast(String parent) {
        //查询父级下的所有数据
        List<Dictionary> list = dictionaryMapper.selectList(new QueryWrapper<Dictionary>().eq("parent", parent));
        if (null != list && list.size() != 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (Dictionary dictionary : list) {
                String seqNo = dictionary.getSeqNo();
                //获取最后三位
                Integer integer = Integer.valueOf(seqNo.substring(seqNo.length() - 3));
                integers.add(integer);
            }
            return Collections.max(integers);
        }
        return 0;
    }

    /**
     * 补齐3位数
     *
     * @param num
     * @return
     */
    public String num3(Integer num) {
        String str = num.toString();
        while (str.length() < 3) {
            str = 0 + str;
        }
        return str;
    }

    private List<DictionaryVo> getLevelData() {
        List<DictionaryVo> dictionaries = dictionaryMapper.selectAll();

        List<DictionaryVo> result = new ArrayList<>();
        Map<String, DictionaryVo> parentMap = new HashMap<>();
        for (DictionaryVo dictionaryVo : dictionaries) {
            parentMap.put(dictionaryVo.getSeqNo(), dictionaryVo);
        }
        for (DictionaryVo dictionaryVo : dictionaries) {
            String parent = dictionaryVo.getParent();
            if (null != parent) {
                if (parent.equals("001")) {
                    result.add(dictionaryVo);
                } else {
                    DictionaryVo dictionaryParent = parentMap.get(parent);
                    dictionaryParent.getChildren().add(dictionaryVo);
                }
            }
        }
        return result;
    }
}
