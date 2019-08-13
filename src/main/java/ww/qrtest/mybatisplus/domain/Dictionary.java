package ww.qrtest.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wqrtest
 * @since 2019-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_sys_dictionary")
//@ApiModel(description = "字典表")
public class Dictionary extends Model<Dictionary> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    //@ApiModelProperty(name = "id",value = "主键")
    private Long id;
    //@ApiModelProperty(name = "name",value = "name")
    private String name;

    /**
     * 值
     */
    //@ApiModelProperty(name = "value",value = "value")
    private String value;

    /**
     * 编码,例：001-002-003
     */
    //@ApiModelProperty(name = "seqNo",value = "编码,例：001-002-003")
    private String seqNo;

    /**
     * 中文序列,例：中国-成都-武侯区
     */
    //@ApiModelProperty(name = "seqCn",value = "中文序列,例：中国-成都-武侯区")
    private String seqCn;

    /**
     * 排序
     */
    //@ApiModelProperty(name = "sort",value = "排序")
    private Integer sort;

    /**
     * 首字母
     */
    //@ApiModelProperty(name = "acronym",value = "首字母")
    private String acronym;

    /**
     * 备注
     */
    //@ApiModelProperty(name = "remark",value = "备注")
    private String remark;
    //@ApiModelProperty(name = "createTime",value = "创建时间")
    private LocalDateTime createTime;
    //@ApiModelProperty(name = "updateTime",value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    //@ApiModelProperty(name = "creator",value = "创建人")
    private Integer creator;

    /**
     * 级别
     */
    //@ApiModelProperty(name = "level",value = "级别")
    private Integer level;

    /**
     * 父级编码
     */
    //@ApiModelProperty(name = "parent",value = "父级编码")
    private String parent;
    /**
     * 显示状态 0/不显示 1/显示
     */
    //@ApiModelProperty(name = "dictStatus",value = "显示状态 0/不显示 1/显示")
    private Boolean dictStatus;
    private String nameId;

    @TableField(exist = false)
    private ArrayList<Dictionary> children = new ArrayList<>();

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
