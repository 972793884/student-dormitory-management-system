package com.star.mapper;

import com.star.vo.Bed;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BedMapper {
    @Select("select b.*,s.student_number,s.name from bed b left join student s on s.id=b.student_no where b.is_delete=0")
    List<Bed> findAll();
    @Select("select * from bed where id=#{id}")
    Bed getBedById(@Param("id") Integer id);
    @Insert("insert into bed(building_no,room_no,bed_no,student_no,status,is_delete) values(#{buildingNo},#{roomNo},#{bedNo},#{studentNo},#{status},#{isDelete})")
    Integer saveBed(Bed bed);
    @Update("update bed set id=#{id},building_no=#{buildingNo},room_no=#{roomNo},bed_no=#{bedNo},student_no=#{studentNo},status=#{status},is_delete=#{isDelete} where id=#{id}")
    Integer updateBed(Bed bed);
    @Select("select * from bed where student_no=#{id} and is_delete=0 and status=1")
    Bed getBedByStudentNo(@Param("id") Integer id);
    @Select("select count(*) from bed where student_no=#{studentNo}")
    Integer isHasBed(Integer studentNo);
    @Select("select * from bed where building_no=#{buildingNo} and room_no=#{roomNo} and bed_no=#{bedNo} and status=0")
    Bed getBedByBuildingNoAndRoomNoAndBedBo(@Param("buildingNo") Integer buildingNo, @Param("roomNo") Integer roomNo, @Param("bedNo") Integer bedNo);
    @Select("select * from bed where building_no=#{buildingNo} and room_no=#{roomNo} and status=1 limit 0,1")
    Bed getBedByBuildingAndRoom(@Param("buildingNo")Integer buildingNum, @Param("roomNo")Integer roomNum);
    @Select("select building_no from bed where status=0 group by building_no")
    List<Integer> getBuilding();
    @Select("select room_no from bed where building_no=#{building_no} and status=0 group by room_no")
    List<Integer> getRoom(@Param("building_no") Integer id);
    @Select("select bed_no from bed where building_no=#{building_no} and room_no=#{room_no} and status=0")
    List<Integer> getBed(@Param("building_no") Integer building_no,@Param("room_no") Integer room_no);
}
