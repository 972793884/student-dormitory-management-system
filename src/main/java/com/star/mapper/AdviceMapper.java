package com.star.mapper;

import com.star.vo.Advice;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdviceMapper {
    @Select("select a.*,(select u.name from user u where u.id=a.create_user) as  create_user_name from advice a where a.is_delete=0")
    List<Advice> findAll();
    @Select("select * from advice where id=#{id}")
    Advice getAdviceById(@Param("id") Integer id);
    @Insert("insert into advice(title,content,create_user,create_time,update_time,is_delete) values(#{title},#{content},#{createUser},#{createTime},#{updateTime},#{isDelete})")
    Integer saveAdvice(Advice advice);
    @Update("update advice set id=#{id},title=#{title},content=#{content},create_user=#{createUser},create_time=#{createTime},update_time=#{updateTime},is_delete=#{isDelete} where id=#{id}")
    Integer updateAdvice(Advice advice);
}
