package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.service.StudentService;
import com.star.service.UserService;
import com.star.vo.Student;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @Autowired
    StudentService studentService;

    @GetMapping("getUser")
    User getUser() {
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        User user = loginService.findByName(name);
        return user;
    }
    @GetMapping("getUserList")
    List<User> getUserList() {

        return userService.getUserList();
    }
    @GetMapping("updateUser")
    Ret updateUser(User user){
      return   user.save()>0?Ret.ok():Ret.fail();
    }
    @PostMapping("saveUser")
    Ret saveUser(User user, HttpServletRequest request) {
        String stuNum=request.getParameter("stuNum");
        String stuPwd=request.getParameter("stuPwd");
        if (stuNum!=null&&stuPwd!=null){
            Student student =studentService.getStudentByNoAndPwd(stuNum,stuPwd);
            if (student==null){
                return Ret.fail().set("msg", "学生信息不存在!");
            }else {
                user.setBindId(student.getId());
            }
        }
        String pwd =user.getPassword();
        if (pwd.trim().equals("")){
            user.setPassword(null);
        }
        Integer b = user.save();
        return b>0 ? Ret.ok().set("msg", "修改成功!") : Ret.fail().set("msg", "修改失败!");
    }
}
