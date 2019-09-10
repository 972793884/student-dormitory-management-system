package com.star.service;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import java.util.Map;

public interface ShiroService {
    void updatePermission(ShiroFilterFactoryBean shiroFilterFactoryBean);
    void reloadPermission();
}
