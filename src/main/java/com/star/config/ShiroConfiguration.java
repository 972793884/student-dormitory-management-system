package com.star.config;

import com.star.Utils.MyResultHandler;
import com.star.Utils.ShiroUtil;
import com.star.shiro.CustomAuthorizationPremFilter;
import com.star.shiro.CustomAuthorizationRoleFilter;
import com.star.shiro.MySessionManager;
import com.star.shiro.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    //将自己的验证方式加入容器
    @Autowired
    ShiroUtil shiroUtil;
    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }
    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
         ShiroFilterFactoryBean shiroFilterFactoryBean= new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map= shiroUtil.getPermissionMap();
        Map<String,Filter> filters=new LinkedHashMap<>();
        filters.put("roles",customAuthorizationRoleFilter());
        filters.put("perms",customAuthorizationPremFilter());
        //登出
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/redirect.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorize.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }
    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
            AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
            authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
            return authorizationAttributeSourceAdvisor;

    }
    @Bean
    public SessionManager sessionManager(){
        MySessionManager mySessionManager =new MySessionManager();
        return mySessionManager;
    }
   /* @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }*/
    @Bean
    public CustomAuthorizationRoleFilter customAuthorizationRoleFilter(){
        return new CustomAuthorizationRoleFilter();
    }
    @Bean
    public CustomAuthorizationPremFilter customAuthorizationPremFilter(){return new CustomAuthorizationPremFilter();}
    @Bean
    public MyResultHandler myResultHandler(){
        return new MyResultHandler();
    }
}
