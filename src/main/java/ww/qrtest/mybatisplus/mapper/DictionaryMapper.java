package ww.qrtest.mybatisplus.mapper;

import ww.qrtest.mybatisplus.domain.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ww.qrtest.mybatisplus.domain.DictionaryVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wqrtest
 * @since 2019-05-27
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    List<DictionaryVo> selectAll();

    void saveList(List<Dictionary> dictionaryList);

    void deleteCity(String seqNo);
}
