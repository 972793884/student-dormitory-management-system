package com.star.service;

import com.star.vo.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> findAll();

    Grade getGradeById(Integer id);

    Integer saveGrade(Grade grade);

    Integer updateGrade(Grade grade);

    Integer delGrade(Integer id);

    List<Integer> getLastWeekGrade();

    List<Integer> getMajorGrade();

    Grade getGrade(Grade grade);
}
