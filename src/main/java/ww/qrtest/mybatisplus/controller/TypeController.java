package ww.qrtest.mybatisplus.controller;

import io.swagger.annotations.Api;
import ww.qrtest.mybatisplus.service.ITypeService;
import ww.qrtest.mybatisplus.domain.Type;
import ww.qrtest.mybatisplus.query.TypeQuery;
import ww.qrtest.mybatisplus.util.AjaxResult;
import ww.qrtest.mybatisplus.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(description = "类型")
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    public ITypeService typeService;

    /**
    * 保存和修改公用的
    * @param type  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Type type){
        try {
            if(type.getId()!=null){
                typeService.updateById(type);
            }else{
                typeService.save(type);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            typeService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Type get(@PathVariable("id")Long id)
    {
        return typeService.getById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Type> list(){

        return typeService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Type> json(@RequestBody TypeQuery query)
    {
        return null;
    }

    /*
     * 列表树
     * */
    @RequestMapping(value = "/treeData",method = RequestMethod.GET)
    public List<Type> treeData(){
        return typeService.treeData();
    }
}
