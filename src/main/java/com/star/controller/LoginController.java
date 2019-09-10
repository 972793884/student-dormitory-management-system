package com.star.controller;

import com.star.Utils.Ret;
import com.star.service.LoginService;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("login")
    public String index() {
        return "test.html";
    }

    @ResponseBody
    @RequestMapping("doLogin")
    public Ret login(@RequestParam("name") String name,@RequestParam("password")  String password, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                name, password
        );

        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            return Ret.fail().set("msg", "用户名和密码不正确");
        } catch (IncorrectCredentialsException e) {
            return Ret.fail().set("msg", "用户名和密码不正确");
        }catch (LockedAccountException e){
            return Ret.fail().set("msg", "账号被锁定!请联系管理员");
        }catch (ExcessiveAttemptsException e){
            return Ret.fail().set("msg", "未知错误!");
        }catch (AuthenticationException e) {
            return Ret.fail().set("msg", "未知错误!");
        }
        return Ret.ok().set("token",subject.getSession().getId());
    }
}
