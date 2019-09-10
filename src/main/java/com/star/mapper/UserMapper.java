package com.star.mapper;

import com.star.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,password,is_delete,is_locked,duty,sign_in_time,phone,email) values(#{name},#{password},#{isDelete},0,#{duty},#{signInTime},#{phone},#{email})")
    Integer save(User user);

    @Update("update user set name=#{name},password=#{password},nick_name=#{nickName},is_delete=#{isDelete},is_locked=#{isLocked},duty=#{duty},bind_id=#{bindId},sign_in_time=#{signInTime},last_login_time=#{lastLoginTime},this_login_time=#{thisLoginTime} where id=#{id}")
    Integer update(User user);
    @Select("select * from user where id=#{id} and is_delete=0")
    User findById(Integer id);
    @Select("select * from user where duty!=0")
    List<User> getUserList();
}
