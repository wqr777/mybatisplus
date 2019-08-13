package ww.qrtest.mybatisplus.service;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;
import ww.qrtest.mybatisplus.domain.Student;

import java.util.List;

public interface StudentService {
    void put(Student stu);//添加
    List<Student> get();        //获取
    void delete(Long id); //删除

    Page<Student> getPageList();
}
