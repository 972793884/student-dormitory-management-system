package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.GradeService;
import com.star.vo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("grade")
@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getGradeList")
    Ret getGradeList() {
        List<Grade> list = gradeService.findAll();
        return Ret.ok().set("gradelist", list);
    }
    @GetMapping("getGrade")
    Ret getGrade(Grade grade) {
        Grade g = gradeService.getGrade(grade);
        return g!=null?Ret.ok().set("grade", g):Ret.fail();
    }
    @GetMapping("getGradeById")
    Ret getGradeById(Integer id) {
        Grade grade= gradeService.getGradeById(id);
        return Ret.ok().set("grade", grade);
    }
    @PostMapping("saveGrade")
    Ret saveGrade(Grade grade) {
        Integer result= gradeService.saveGrade(grade);
        return result>0? Ret.ok():Ret.fail();
    }
    @PostMapping("updateGrade")
    Ret updateGrade(Grade grade ) {
        Integer result= gradeService.updateGrade(grade);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("delGrade")
    Ret delGrade(Integer id) {
        Integer result= gradeService.delGrade(id);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("getLastWeekGrade")
    List<Integer> getGradeAvgForWeek() {
        List<Integer> lastWeekGrade= gradeService.getLastWeekGrade();
        return lastWeekGrade;
    }
    @GetMapping("getMajorGrade")
    List<List<Integer>> getMajorGrade() {
        List<Integer> majorGrade= gradeService.getMajorGrade();
        List<Integer> lastWeekGrade= gradeService.getLastWeekGrade();
        List<List<Integer>> lists =new ArrayList<>();
        lists.add(majorGrade);
        lists.add(lastWeekGrade);
        return lists;
    }
}
