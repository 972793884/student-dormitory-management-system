package com.star.service.Impl;

import com.star.mapper.AuthMapper;
import com.star.service.PermissionService;
import com.star.vo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private AuthMapper authMapper;
    @Override
    public List<Permission> findPermissonListByRoleId(Integer userId) {

        return authMapper.findPermissonListByRoleId(userId);

    }

    @Override
    public List<Permission> getAll() {
        return authMapper.findAll();
    }

    @Override
    public List<Permission> getPermsByPerId(Integer id) {
        return authMapper.getPermsByPerId(id);
    }

    @Override
    public List<Permission> findPermissonListByPermissions(List<Permission> permissionList) {
        StringBuffer ids = new StringBuffer();

        for (int i=0;i<permissionList.size();i++){
            if (i!=permissionList.size()-1){
                ids.append(permissionList.get(i).getId()+",");
            }else {
                ids.append(permissionList.get(i).getId());
            }
        }
        return  authMapper.findPermissonListByPermissions(ids.toString());
    }

    @Override
    public Integer bindRoles(Integer id, String ids) {
        String[] roleIds = ids.split(",");
        for (String roleId:roleIds){
            authMapper.bindRoles(id,roleId);
        }
        return 1;
    }

    @Override
    public List<Permission> getUsefulPers(Integer id) {

        return authMapper.getUsefulPers(id);
    }

    @Override
    public Integer bindPers(Integer id, String ids) {
        String[] perIds = ids.split(",");
        for (String perId:perIds){
            authMapper.bindPers(id,perId);
        }
        return 1;
    }

    @Override
    public Integer delBindRole(Integer perId,String roleId) {
        return authMapper.delBindRole(perId,roleId);
    }

    @Override
    public Integer delBindPer(Integer per_main, String ids) {
        return authMapper.delBindPer(per_main,ids);
    }

    @Override
    public Integer savePer(Permission per) {
        if (per.getId()==null)
            return authMapper.savePer(per);
        else
            return authMapper.updatePer(per);
    }

    @Override
    public Integer delPer(String ids) {
        return authMapper.delPer(ids);
    }

    @Override
    public Integer updateNr(Permission per) {
       return authMapper.updateNr(per);
    }

    @Override
    public Permission findById(Integer id) {
       return authMapper.findPerById(id);
    }
}
