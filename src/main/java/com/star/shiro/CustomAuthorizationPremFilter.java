package com.star.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;

public class CustomAuthorizationPremFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] premArray = (String[]) mappedValue;
        //没有角色限制，有权限访问
        if (premArray == null || premArray.length == 0) {
            return true;
        }


        //若当前用户是rolesArray中的任何一个，则有权限访问
        if (Arrays.asList(premArray).contains("or")) {
            if (premArray.length==1)
                return  true;
            for (int i = 0; i < premArray.length; i++) {
                if (subject.isPermitted(premArray[i])) {
                    return true;
                }
            }
        } else {
            //必须拥有所有角色
           for (String prem:premArray){
               if (!subject.isPermitted(prem)){
                   return false;
               }
           }
           return true;
        }
        return false;
    }
}
