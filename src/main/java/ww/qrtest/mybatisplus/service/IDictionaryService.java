package ww.qrtest.mybatisplus.service;

import ww.qrtest.mybatisplus.domain.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;
import ww.qrtest.mybatisplus.domain.DictionaryVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wqrtest
 * @since 2019-05-27
 */
public interface IDictionaryService extends IService<Dictionary> {
    void add(InputStream inputStream);

    List<DictionaryVo> listAll();
}
