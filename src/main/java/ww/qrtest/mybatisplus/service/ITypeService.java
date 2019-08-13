package ww.qrtest.mybatisplus.service;

import ww.qrtest.mybatisplus.domain.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wqrtest
 * @since 2019-03-25
 */
public interface ITypeService extends IService<Type> {

    List<Type> treeData();
}
