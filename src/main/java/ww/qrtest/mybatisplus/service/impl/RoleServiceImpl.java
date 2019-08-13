package ww.qrtest.mybatisplus.service.impl;

import ww.qrtest.mybatisplus.domain.Role;
import ww.qrtest.mybatisplus.mapper.RoleMapper;
import ww.qrtest.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wqrtest
 * @since 2019-03-25
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
