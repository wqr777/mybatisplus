package ww.qrtest.mybatisplus.controller;


import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import ww.qrtest.mybatisplus.domain.DictionaryVo;
import ww.qrtest.mybatisplus.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Api(description = "字典")
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    public IDictionaryService dictionaryService;

    @GetMapping("/list")
    public List<DictionaryVo> getListPage() {
        List<DictionaryVo> list = dictionaryService.listAll();
        return list;
    }

    /**
     * 异步更新省市区
     */
    @PostMapping("/update/city")
    public String updateCity(@RequestParam("cityFiles") MultipartFile cityFiles) throws IOException {
        dictionaryService.add(cityFiles.getInputStream());
         /*MyExecutor myExecutor = new MyExecutor();
        myExecutor.fun();
        String fileName = cityFiles.getOriginalFilename();
        if(fileName.indexOf("\\") != -1){
            fileName = fileName.substring(fileName.lastIndexOf("\\"));
        }
        String filePath = "files/";
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath+fileName);
            out.write(cityFiles.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }*/
        return "上传成功";

    }

    public class MyExecutor {
        private ExecutorService executor = Executors.newCachedThreadPool();

        public void fun() {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    //dictionaryService.add("");
                }
            });
        }
    }
}