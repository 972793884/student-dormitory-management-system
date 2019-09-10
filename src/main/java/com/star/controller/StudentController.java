package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Record;
import com.star.Utils.Ret;
import com.star.Utils.SpringUtil;
import com.star.service.Impl.ShiroServiceImpl;
import com.star.service.StudentService;
import com.star.vo.Student;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@RequestMapping("student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    ShiroServiceImpl shiroService;
    @Autowired
    PageUtils pageUtils;


    @GetMapping("getStudentList")
    Ret getStudentList() {
        List<Student> list = studentService.findAll();
        return Ret.ok().set("studentlist", list);
    }
    @GetMapping("getStudentAndBedList")
    List<Student> getStudentAndBedList() {
        List<Student> list = studentService.getStudentAndBedList();
        return list;
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
