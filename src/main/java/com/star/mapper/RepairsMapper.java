package com.star.mapper;

import com.star.vo.Repairs;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface RepairsMapper {
    @Select("select * from repairs where is_delete=0")
    List<Repairs> findAll();
    @Select("select * from repairs where id=#{id}")
    Repairs getRepairsById(@Param("id") Integer id);
    @Insert("insert into repairs(name,type,content,phone,create_user,create_time,status,is_delete,repair_user,repair_time,feedback_id,feedback_comment) values(#{name},#{type},#{content},#{phone},#{createUser},#{createTime},#{status},#{isDelete},#{repairUser},#{repairTime},#{feedbackId},#{feedbackComment})")
    Integer saveRepairs(Repairs repairs);
    @Update("update repairs set id=#{id},name=#{name},type=#{type},content=#{content},phone=#{phone},create_user=#{createUser},create_time=#{createTime},status=#{status},is_delete=#{isDelete},repair_user=#{repairUser},repair_time=#{repairTime},feedback_id=#{feedbackId},feedback_comment=#{feedbackComment} where id=#{id}")
    Integer updateRepairs(Repairs repairs);
    @Select("select * from repairs where create_user=#{name} and is_delete=0 and status in (0,1)")
    List<Repairs> getMyRepairs(String name);
    @Select("select * from repairs where create_user=#{name} and is_delete=0 and status in (2)")
    List<Repairs> getFeedBackRepairs(String name);
    @Select("select * from repairs where create_user=#{name} and is_delete=0 and status in (3)")
    List<Repairs> getHistoryRepairs(String name);
    @Select("select r.*,(select u.name from user u where u.id=r.repair_user) as repair_name from repairs r where (r.repair_user=#{id} or r.status=0) and r.is_delete=0")
    List<Repairs> getRepairs(@Param("id") Integer id);
}
