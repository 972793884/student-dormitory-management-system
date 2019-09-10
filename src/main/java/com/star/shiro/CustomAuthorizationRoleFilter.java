package com.star.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;
import java.util.List;

public class CustomAuthorizationRoleFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;
        //没有角色限制，有权限访问
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }


        //若当前用户是rolesArray中的任何一个，则有权限访问
        if (Arrays.asList(rolesArray).contains("or")) {
            if (rolesArray.length==1){
                return true;
            }
            for (int i = 0; i < rolesArray.length; i++) {
                if (subject.hasRole(rolesArray[i])) {
                    return true;
                }
            }
        } else {
            //必须拥有所有角色
            boolean[] b = subject.hasRoles(Arrays.asList(rolesArray));
            for (boolean b1:b){
                if (!b1){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
