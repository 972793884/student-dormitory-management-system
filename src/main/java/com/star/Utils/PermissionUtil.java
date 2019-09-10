package com.star.Utils;

import com.star.service.ShiroService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

public class PermissionUtil {
    @Autowired
    ShiroService shiroService;
    Ret reload(HttpServletResponse response) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = SpringUtil.getBean(ShiroFilterFactoryBean.class);
        shiroService.updatePermission(shiroFilterFactoryBean);
        return Ret.ok().set("msg", "资源权限更新成功!!");
    }
}
