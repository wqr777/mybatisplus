package ww.qrtest.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wqrtest
 * @since 2019-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_demo")
public class Demo extends Model<Demo> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String navbarName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
