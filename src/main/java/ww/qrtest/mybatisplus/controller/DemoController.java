package ww.qrtest.mybatisplus.controller;

import ww.qrtest.mybatisplus.service.IDemoService;
import ww.qrtest.mybatisplus.domain.Demo;
import ww.qrtest.mybatisplus.query.DemoQuery;
import ww.qrtest.mybatisplus.util.AjaxResult;
import ww.qrtest.mybatisplus.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    public IDemoService demoService;


    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Demo get(@PathVariable("id")Long id)
    {
        return demoService.getById(id);
    }


    /**
    * 查看所有信息
    * @return
    */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Demo> list(){
        return demoService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Demo> json(@RequestBody DemoQuery query)
    {
        return null;
    }
}
