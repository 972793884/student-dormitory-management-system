package com.star.service.Impl;

import com.star.Utils.Record;
import com.star.mapper.GradeMapper;
import com.star.service.BedService;
import com.star.service.GradeService;
import com.star.service.LoginService;
import com.star.service.StudentService;
import com.star.vo.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    LoginService loginService;
    @Autowired
    BedService bedService;
    @Autowired
    StudentService studentService;
    @Override
    public List<Grade> findAll() {
        return gradeMapper.findAll();
    }

    @Override
    public Grade getGradeById(Integer id) {
        return gradeMapper.getGradeById(id);
    }

    @Override
    public Integer saveGrade(Grade grade) {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        User user =loginService.findByName(name);
        Grade g = gradeMapper.getGradeByBuildingAndRoomAndTime(grade.getBuildingNum(),grade.getRoomNum(),grade.getTime());
        if (g!=null){
            return -1;
        }
        Bed bed =bedService.getBedByBuildingAndRoom(grade.getBuildingNum(),grade.getRoomNum());
        if (bed==null){
            return -1;
        }
        if (bed.getStudentNo()!=null){
            Student student =studentService.getStudentByNo(bed.getStudentNo());
            grade.setMajor(student.getMajor());
        }else
            return -1;
        grade.setCreateUser(user.getId());
        grade.setCreateTime(new Date());
        grade.setIsDelete(0);
        return gradeMapper.saveGrade(grade);
    }

    @Override
    public Integer updateGrade(Grade grade) {
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public Integer delGrade(Integer id) {
        Grade grade =getGradeById(id);
        grade.setIsDelete(1);
        return gradeMapper.updateGrade(grade);
    }

    @Override
    public List<Integer> getLastWeekGrade() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        User user =loginService.findByName(name);
        Integer id = user.getBindId();
        Student student =studentService.findById(id);
        Bed bed =bedService.getBedByStudentId(Integer.valueOf(student.getStudentNumber()));
        List<Grade> list =gradeMapper.getLastWeekGrade(new Date(),bed.getBuildingNo(),bed.getRoomNo());
        List<Integer> integers =new ArrayList<>();
        for (Grade grade:list){
            integers.add(grade.getGrade());
        }
        return integers;
    }

    @Override
    public List<Integer> getMajorGrade() {
        String name=(String) SecurityUtils.getSubject().getPrincipal();
        User user =loginService.findByName(name);
        Integer id = user.getBindId();
        Integer major =studentService.findById(id).getMajor();
        Record record =gradeMapper.getMaxAvgAtLastWeekInMyMajor(new Date(),major);
        int building_num =Integer.valueOf(record.get("building_num").toString());
        int room_num =Integer.valueOf(record.get("room_num").toString());
        List<Grade> list =gradeMapper.getLastWeekGrade(new Date(),building_num,room_num);
        List<Integer> integers =new ArrayList<>();
        for (Grade grade:list){
            integers.add(grade.getGrade());
        }
        return integers;
    }

    @Override
    public Grade getGrade(Grade grade) {
        return gradeMapper.getGradeByBuildingAndRoomAndTime(grade.getBuildingNum(),grade.getRoomNum(),grade.getTime());
    }
}
