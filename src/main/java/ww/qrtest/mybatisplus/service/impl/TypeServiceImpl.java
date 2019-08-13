package ww.qrtest.mybatisplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ww.qrtest.mybatisplus.domain.Type;
import ww.qrtest.mybatisplus.mapper.TypeMapper;
import ww.qrtest.mybatisplus.service.ITypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wqrtest
 * @since 2019-03-25
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements ITypeService {
    @Autowired 
    private TypeMapper typeMapper;
    @Override
    public List<Type> treeData() {
        List<Type> treeDataByDb = getTreeDataLoop(0L); //调用列表树查询方法
        return treeDataByDb;
    }
    /*
     * 实现列表的方法
     * */
    private List<Type> getTreeDataLoop(long l) {
        //返回数据 一级类型,下面挂了子子孙孙类型
        List<Type> result = new ArrayList<>();
        //1)获取所有的类型
        List<Type> types = typeMapper.selectList(null);
        //2)遍历所有的类型
        Map<Long,Type> typesDto = new HashMap<>();
        for (Type type : types) {
            typesDto.put(type.getId(), type);
        }
        for (Type type : types) {
            Long pid = type.getPid();
            // ①如果没有父亲就是一级类型 放入返回列表中
            if (pid.longValue() == 0){
                result.add(type);
            }else{
                // ②如果有父亲就是把自己当做一个儿子就ok
                //通过Map建立id和类型直接关系,以后通过pid直接获取父亲
                Type parent = typesDto.get(pid);
                parent.getChildren().add(type);
            }
        }
        return result;
    }
}
