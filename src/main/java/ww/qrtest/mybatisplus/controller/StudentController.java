package ww.qrtest.mybatisplus.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ww.qrtest.mybatisplus.domain.Student;
import ww.qrtest.mybatisplus.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(description = "学生")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public List<Student> getAll(){
        return studentService.get();
    }

    @GetMapping("/getListPage")
    public Page<Student> getListPage(){
        PageHelper.startPage(1,2);
        Page<Student> pagelist = studentService.getPageList();
        return pagelist;
    }
}
