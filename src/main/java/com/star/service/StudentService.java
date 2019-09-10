package com.star.service;

import com.star.Utils.Record;
import com.star.vo.Student;

import java.util.List;

public interface StudentService {

    Student findById(Integer id);

   /* List<Record> all(String name, Integer age);*/

    List<Student> findAll();

    boolean save(String s);

    List<Student> getStudentAndBedList();

    Student getStudentByNo(Integer studentNo);

    Student getStudentByNoAndPwd(String stuNum, String stuPwd);

    /*Integer save(Student student);*/
}
