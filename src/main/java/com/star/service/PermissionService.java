package com.star.service;

import com.star.vo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findPermissonListByRoleId(Integer userId);

    List<Permission> getAll();

    List<Permission> getPermsByPerId(Integer id);

    List<Permission> findPermissonListByPermissions(List<Permission> permissionList);

    Integer bindRoles(Integer id, String ids);

    List<Permission> getUsefulPers(Integer id);

    Integer bindPers(Integer id, String ids);

    Integer delBindRole(Integer perId,String roleId);

    Integer delBindPer(Integer per_main, String ids);

    Integer savePer(Permission per);

    Integer delPer(String ids);

    Integer updateNr(Permission per);

    Permission findById(Integer id);
}
