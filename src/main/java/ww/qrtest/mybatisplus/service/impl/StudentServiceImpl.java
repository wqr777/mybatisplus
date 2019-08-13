package ww.qrtest.mybatisplus.service.impl;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ww.qrtest.mybatisplus.domain.Student;
import ww.qrtest.mybatisplus.mapper.StudentMapper;
import ww.qrtest.mybatisplus.service.StudentService;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public void put(Student stu) {

    }

    @Override
    public List<Student> get() {
        return studentMapper.get();
    }

    @Override
    @Transactional
    public void delete(Long id) {

    }

    @Override
    public Page<Student> getPageList() {
        return studentMapper.getPage();
    }
}
