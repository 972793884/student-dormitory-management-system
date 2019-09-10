package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.AdviceService;
import com.star.service.Impl.ShiroServiceImpl;
import com.star.service.LoginService;
import com.star.service.StudentService;
import com.star.vo.Advice;
import com.star.vo.Student;
import com.star.vo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RequestMapping("advice")
@RestController
public class AdviceController {
    @Autowired
    private AdviceService adviceService;
    @Autowired
    PageUtils pageUtils;
    @Autowired
    LoginService loginService;

    @GetMapping("getAdviceList")
    Ret getAdviceList() {
        List<Advice> list = adviceService.findAll();
        return Ret.ok().set("advicelist", list);
    }
    @GetMapping("getAdviceById")
    Ret getAdviceById(Integer id) {
        Advice advice= adviceService.getAdviceById(id);
        return Ret.ok().set("advice", advice);
    }
    @PostMapping("saveAdvice")
    Ret saveAdvice(Advice advice) {
        if (advice.getId()==null){
            advice.setCreateTime(new Date());
            String name=(String) SecurityUtils.getSubject().getPrincipal();
            User user =loginService.findByName(name);
            advice.setCreateUser(user.getId());
        }else {
            advice.setUpdateTime(new Date());
        }

        return advice.save()>0? Ret.ok():Ret.fail();
    }
    @GetMapping("updateAdvice")
    Ret updateAdvice(Advice advice) {
        Integer result= adviceService.updateAdvice(advice);
        return result>0? Ret.ok():Ret.fail();
    }
    @GetMapping("delAdvice")
    Ret delAdvice(Integer id) {
        Integer result= adviceService.delAdvice(id);
        return result>0? Ret.ok():Ret.fail();
    }
























    @PostMapping("package")
    Ret test() throws InterruptedException {
        String str = "sh /usr/app/start.sh";
        System.out.println("执行脚本");
        build(str);
        return Ret.ok();
    }
    @GetMapping("package")
    Ret test2() throws InterruptedException {
        String str = "sh /usr/app/start.sh";
        System.out.println("执行脚本");
        build(str);
        return Ret.ok();
    }
    Ret build(String str) throws InterruptedException {
        Process p = null;
        try {
            System.out.println("--------------------开始执行--------------------------");
            p = Runtime.getRuntime().exec(str);
            InputStream inputStream = p.getInputStream();
            byte[] data = new byte[800];
            while ((inputStream.read(data, 0, data.length)) != -1) {
                System.out.println(new String(data));
            }

            InputStream e = p.getErrorStream();
            while ((e.read(data, 0, data.length - 1)) != -1) {
                System.out.println(new String(data));
            }
            p.getOutputStream().close();
            p.getInputStream().close();
            p.getErrorStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.waitFor();
            }
            p.destroy();
            System.out.println("--------------------执行完毕--------------------------");
        }
        return Ret.ok();
    }

}
