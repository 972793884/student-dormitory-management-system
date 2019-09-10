package com.star.controller;

import com.star.Utils.PageUtils;
import com.star.Utils.Ret;
import com.star.service.PermissionService;
import com.star.service.RoleService;
import com.star.vo.Permission;
import com.star.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("auth")
@RestController
public class AuthController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    PageUtils pageUtils;
     //主资源id, 资源ids,角色ids
    String savePermissionAndAuths(Integer pid,String pids,String rids){

        return null;
    }
    @GetMapping("permissionlist")
    PageUtils list(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize){
        List<Permission> list=permissionService.getAll();
        pageUtils.setPageList(list,page==null?1:page,pageSize);
        return pageUtils;

    }
   /* @GetMapping("getAuthById")
    Ret authList(Integer id){
        List<Role> list= roleService.getRolesById(id);
        List<Permission> permissionList =permissionService.getPermsById(id);
        return Ret.ok();
    }*/
    @GetMapping("getPermissionsAndRoles")
    PageUtils getPermissionsAndRoles(Integer id){
        List<Role> roleList= roleService.getRolesByPerId(id);
        List<Permission> permissionList =permissionService.getPermsByPerId(id);
        List<Permission> main = new ArrayList<>();
        main.add(permissionService.findById(id));
        List<List<? extends Object>> lists = new ArrayList<>();
        lists.add(roleList);
        lists.add(permissionList);
        lists.add(main);
        return pageUtils.setPageList(lists,1,100);
    }
    @GetMapping("getUsefulRoles")
    PageUtils getUsefulRoles(Integer id){
        List<Role> roleList= roleService.getUsefulRoles(id);
        return pageUtils.setPageList(roleList,1,10000);
    }
    @GetMapping("getUsefulPers")
    PageUtils getUsefulPers(Integer id){
        List<Permission> permissionList= permissionService.getUsefulPers(id);
        return pageUtils.setPageList(permissionList,1,10000);
    }
    @GetMapping("bindRoles")
    Ret bindRoles(Integer id,String ids){
        Integer result=permissionService.bindRoles(id,ids);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("delBindRole")
    Ret delBindRole(Integer perId,String roleId){
        Integer result=permissionService.delBindRole(perId,roleId);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("bindPers")
    Ret bindPers(Integer id,String ids){
        Integer result=permissionService.bindPers(id,ids);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("delBindPer")
    Ret delBindPer(Integer per_main,String ids){
        Integer result=permissionService.delBindPer(per_main,ids);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("saveRole")
    Ret saveRole(Role role){
        Integer result=roleService.saveRole(role);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("delRole")
    Ret delRole(String ids){
        Integer result=roleService.delRole(ids);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("savePer")
    Ret savePer(Permission per){
        Integer result=permissionService.savePer(per);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("updateNr")
    Ret updateNr(Permission per){
        Integer result=permissionService.updateNr(per);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
    @GetMapping("delPer")
    Ret delPer(String ids){
        Integer result=permissionService.delPer(ids);
        return result>0?Ret.ok().set("msg","ok"):Ret.fail().set("msg","failed");
    }
}
