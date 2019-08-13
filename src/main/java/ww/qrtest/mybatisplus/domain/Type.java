package ww.qrtest.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wqrtest
 * @since 2019-03-25
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("t_type")
public class Type extends Model<Type> {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Long pid;

    private String intro;

    @TableField(exist = false)
    private Type parent;
    @TableField(exist = false)
    private List<Type> children = new ArrayList<>();
}
