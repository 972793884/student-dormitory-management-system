package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.service.UserService;
import com.star.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class RegisterController {
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @PostMapping("doRegister")
    Ret doRegister(User user){
        User u =loginService.findByName(user.getName());
        Integer result=-1;
        String msg="发生错误!";
        if (u==null){
            result  =  userService.save(user);
        }else {
            msg="该用户名已被注册!";
        }
       return result >0?Ret.ok().set("msg","注册成功"):Ret.fail().set("msg",msg);
    }
}
