package com.star.mapper;

import com.star.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthMapper {
    @Select("select * from permission where id in (select permissionid from role_permission where roleid in (select roleid from user_role where userid=#{userId}))")
    List<Permission> findPermissonListByRoleId(Integer userId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Select("select * from role where id=#{roleid}")
    Role findRoleById(Integer roleid);

    @Select("select * from role_permission")
    List<RolePermission> findAllRolePermission();

    @Select("select * from user_role")
    List<UserRole> findAllUserRoles();

    @Select("select * from permission_permissions")
    List<PermissionPermissions> findAllPermissionPermissions();

    @Select("select * from role")
    List<Role> findAllRoles();

    @Select("select * from role where id in (select roleid from user_role where userid=#{id})")
    List<Role> findRolesByUserId(Integer id);

    @Select("select * from permission where id in (select perm from permission_permissions where perm_main=#{id} )")
    List<Permission> getPermsByPerId(Integer id);

    @Select("select * from permission where id in (${ids})")
    List<Permission> findPermissonListByPermissions(@Param("ids") String ids);

    @Insert("insert into role_permission(roleid,permissionid,is_delete,is_locked) values(#{roleId},#{id},0,0)")
    void bindRoles(@Param("id") Integer id, @Param("roleId") String roleId);

    @Select("select * from permission where id not in (select perm from permission_permissions where perm_main=#{id})")
    List<Permission> getUsefulPers(Integer id);

    @Insert("insert into permission_permissions(perm_main,perm,is_delete,is_locked) values(#{id},#{perId},0,0)")
    Integer bindPers(@Param("id") Integer id, @Param("perId") String perId);

    @Delete("delete from role_permission where permissionid=#{perId} and roleid in (${roleid})")
    Integer delBindRole(@Param("perId") Integer perId,@Param("roleid") String roleid);

    @Delete("delete from permission_permissions where perm_main=#{perm_main} and perm in (${ids})")
    Integer delBindPer(@Param("perm_main") Integer per_main,@Param("ids") String ids);

    @Insert("insert into permission(name,url,needallroles,needallperms,is_delete,is_locked) values(#{name},#{url},#{needallroles},#{needallperms},0,0)")
    Integer savePer(Permission per);

    @Update("update permission set name=#{name},url=#{url},needallroles=#{needallroles},needallperms=#{needallperms},is_delete=#{isDelete},is_locked=#{isLocked} where id=#{id}")
    Integer updatePer(Permission per);

    @Delete("delete from permission where id in(${ids})")
    Integer delPer(@Param("ids") String ids);
    @Update("update permission set needallroles=#{needallroles} where id=#{id}")
    Integer updateNr(Permission per);
    @Update("update permission set needallroles=#{needallperms} where id=#{id}")
    Integer updateNp(Permission per);
    @Select("select * from permission where id=#{id}")
    Permission findPerById(@Param("id") Integer id);
}
