package com.star.service.Impl;

import com.star.mapper.RoleMapper;
import com.star.service.RoleService;
import com.star.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRolesByPerId(Integer id) {

        return roleMapper.getRolesByPerId(id);
    }

    @Override
    public List<Role> getUsefulRoles(Integer id) {
        return roleMapper.getUsefulRoles(id);
    }

    @Override
    public Integer saveRole(Role role) {
        if (role.getId()==null)
            return roleMapper.saveRole(role);
        else
            return roleMapper.updateRole(role);
    }

    @Override
    public Integer delRole(String ids) {
        return roleMapper.delRole(ids);
    }

}
