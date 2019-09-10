package com.star.shiro;

import com.star.mapper.AuthMapper;
import com.star.service.LoginService;
import com.star.service.PermissionService;
import com.star.vo.Permission;
import com.star.vo.Role;
import com.star.vo.RolePermission;
import com.star.vo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    AuthMapper authMapper;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String name = (String) principalCollection.getPrimaryPrincipal();
        User user = loginService.findByName(name);
        //获取角色绑定的资源
        List<Permission> permissionList = permissionService.findPermissonListByRoleId(user.getId());
        //获取资源绑定的资源
        List<Permission> permissionList1 = permissionService.findPermissonListByPermissions(permissionList);
        permissionList.addAll(permissionList1);
        List<Role> roles = authMapper.findRolesByUserId(user.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        System.out.print("加载用户角色:");
        if (roles != null) {
            for (Role role : roles) {
                System.out.print(role.getName()+",");
                simpleAuthorizationInfo.addRole(role.getName());
            }
        }
        System.out.print("加载用户资源:");
        if (permissionList != null) {
            for (Permission permission : permissionList) {
                System.out.print(permission.getName()+",");
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        String name = authenticationToken.getPrincipal().toString();
        User user = loginService.findByName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
