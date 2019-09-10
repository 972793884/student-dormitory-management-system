package com.star.service;

import com.star.vo.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRolesByPerId(Integer id);

    List<Role> getUsefulRoles(Integer id);

    Integer saveRole(Role role);

    Integer delRole(String ids);
}
