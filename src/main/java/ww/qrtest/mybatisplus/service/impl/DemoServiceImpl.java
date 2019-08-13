package ww.qrtest.mybatisplus.service.impl;

import ww.qrtest.mybatisplus.domain.Demo;
import ww.qrtest.mybatisplus.mapper.DemoMapper;
import ww.qrtest.mybatisplus.service.IDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wqrtest
 * @since 2019-08-08
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements IDemoService {

}
