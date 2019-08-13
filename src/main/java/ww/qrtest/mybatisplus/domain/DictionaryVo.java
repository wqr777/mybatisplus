package ww.qrtest.mybatisplus.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class DictionaryVo implements Serializable{
    private String name;
    private String parent;
    private String seqNo;
    private String value;

    private ArrayList<DictionaryVo> children = new ArrayList<>();


}
