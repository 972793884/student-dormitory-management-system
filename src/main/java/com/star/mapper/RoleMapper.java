package com.star.mapper;

import com.star.vo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("select * from role where id in(select roleid from role_permission where permissionid=#{id})")
    List<Role> getRolesByPerId(Integer id);

    @Select("select * from role where id not in (select roleid from role_permission where permissionid=#{id})")
    List<Role> getUsefulRoles(Integer id);

    @Insert("insert into role(name,is_delete,is_locked) values(#{name},0,0)")
    Integer saveRole(Role role);

    @Update("update role set name=#{name},is_delete=#{isDelete},is_locked=#{isLocked} where id=#{id}")
    Integer updateRole(Role role);

    @Delete("delete from role where id in (${ids})")
    Integer delRole(@Param("ids") String ids);
}
