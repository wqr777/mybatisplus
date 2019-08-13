package ww.qrtest.mybatisplus.domain;
import lombok.Data;

import java.io.Serializable;

@Data
public class DictionaryExcl implements Serializable{

    //@Excel(name = "行政区划代码")
    private String nameId;

    //@Excel(name = "单位名称")
    private String name;

}
