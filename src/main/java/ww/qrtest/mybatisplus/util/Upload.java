package ww.qrtest.mybatisplus.util;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ww.qrtest.mybatisplus.domain.DictionaryExcl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Upload {


    public  static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass){
        if (StringUtils.isBlank(filePath)){
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
        }catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public static List<DictionaryExcl> ExcelParser(String fileName)throws Exception{
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<DictionaryExcl> list=new ArrayList<>();
        list = Upload.importExcel("G:/IdeaProjects/mybatisplus/src/"+fileName, 0, 1, DictionaryExcl.class);
        return list;
        /*int testId=1;
        int isInsert=0;
        for (int i = 0; i <list.size() ; i++) {
            Layer layer=new Layer();
            UUID uuid=UUID.randomUUID();
            String layerId=uuid.toString();
            layer.setLayerId(layerId);
            layer.setLayerName(list.get(i).getLayerName());
            layer.setDescription(list.get(i).getDescription());
            layer.setRecordTime(list.get(i).getRecordTime());
            layer.setReleaseTime(list.get(i).getReleaseTime());
            int is_add=layerService.InsertLayer(layer);
            System.out.println(is_add);
        }*/
    }
}
