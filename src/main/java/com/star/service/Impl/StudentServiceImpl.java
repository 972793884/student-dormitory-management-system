package com.star.service.Impl;

import com.star.Utils.MyResultHandler;
import com.star.mapper.StudentMapper;
import com.star.service.StudentService;
import com.star.vo.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Autowired
    MyResultHandler myResultHandler1;
    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public List<Student> findAll() {
      return   studentMapper.findAll();
    }

    public boolean save(String s) {
        sqlSessionTemplate.insert(s);
        return true;
    }

    @Override
    public List<Student> getStudentAndBedList() {
        return studentMapper.getStudentAndBedList();
    }

    @Override
    public Student getStudentByNo(Integer studentNo) {
       return studentMapper.getStudentByNo(studentNo);
    }

    @Override
    public Student getStudentByNoAndPwd(String stuNum, String stuPwd) {
        return studentMapper.getStudentByNoAndPwd(stuNum,stuPwd);
    }
    /* @Override
    public List<Record> findAll() {
        MyResultHandler myResultHandler = new MyResultHandler();
        sqlSessionTemplate.select(StudentMapper.class.getName() + ".findAll", myResultHandler);
        List<Record> result = myResultHandler.getResultMap();
        return result;
    }*/

    /*@Override
    public Integer save(Student student) {
        return studentMapper.save(student);
    }*/


}
