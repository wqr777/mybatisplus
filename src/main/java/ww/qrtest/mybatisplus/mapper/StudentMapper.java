package ww.qrtest.mybatisplus.mapper;

import com.github.pagehelper.Page;
import ww.qrtest.mybatisplus.domain.Student;

import java.util.List;

public interface StudentMapper {
    void put(Student stu);
    List<Student> get();
    void delete(Long id);
    Page<Student> getPage();
}
