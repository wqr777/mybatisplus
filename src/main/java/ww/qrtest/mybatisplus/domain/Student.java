package ww.qrtest.mybatisplus.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("Student")
public class Student {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;
    private Long age;
    private String intro;

}

