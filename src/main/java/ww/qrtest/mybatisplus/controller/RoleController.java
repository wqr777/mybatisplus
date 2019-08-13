package ww.qrtest.mybatisplus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ww.qrtest.mybatisplus.query.RoleQuery;
import ww.qrtest.mybatisplus.service.IRoleService;
import ww.qrtest.mybatisplus.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ww.qrtest.mybatisplus.util.AjaxResult;
import ww.qrtest.mybatisplus.util.PageList;

import java.util.List;
@Api(description = "角色")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    public IRoleService roleService;

    /**
    * 保存和修改公用的
    * @param role  传递的实体
    * @return Ajaxresult转换结果
    */
    @ApiOperation(value = "保存")
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Role role){
        try {
            if(role.getId()!=null){
                roleService.updateById(role);
            }else{
                roleService.save(role);
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
            roleService.removeById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Role get(@PathVariable("id")Long id)
    {
        return roleService.getById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Role> list(){

        return roleService.list(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Role> json(@RequestBody RoleQuery query)
    {
        String t;
        return null;
    }
}
