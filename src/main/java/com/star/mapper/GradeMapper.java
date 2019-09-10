package com.star.mapper;

import com.star.Utils.Record;
import com.star.vo.Grade;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface GradeMapper {
    @Select("select * from grade where is_delete=0")
    List<Grade> findAll();

    @Select("select * from grade where id=#{id}")
    Grade getGradeById(@Param("id") Integer id);

    @Select("select * from grade where time=#{time}")
    Grade getGradeByTime(@Param("time") Date time);

    @Insert("insert into grade(building_num,room_num,grade,judgement,time,create_user,create_time,is_delete,major) values(#{buildingNum},#{roomNum},#{grade},#{judgement},#{time},#{createUser},#{createTime},#{isDelete},#{major})")
    Integer saveGrade(Grade grade);

    @Update("update grade set id=#{id},building_num=#{buildingNum},room_num=#{roomNum},grade=#{grade},judgement=#{judgement},time=#{time},create_user=#{createUser},create_time=#{createTime},is_delete=#{isDelete} where id=#{id}")
    Integer updateGrade(Grade grade);

    //根据日期查询该日期所属的一周共有多少天记录评分
    @Select("SELECT COUNT(*) FROM grade WHERE DATE_FORMAT(time,'%Y-%m-%u') = DATE_FORMAT(#{date},'%Y-%m-%u') and is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum}")
    Integer getWeekDaysNumber(@Param("date") Date date, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //根据月份,第几周查询周平均评分
    @Select("SELECT avg(grade) avgGrade, ((DAY(time)+WEEKDAY(time-INTERVAL DAY(time) DAY)) DIV 7 + 1 ) as weekofmonth from grade WHERE ((DAY(time)+WEEKDAY(time-INTERVAL DAY(time) DAY)) DIV 7 + 1)  = #{week} and  MONTH(time) =#{month} and  YEAR(time) =#{year} and is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum} GROUP BY weekofmonth")
    Record getWeekAvgGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("week") Integer week, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询全年每周平均分
    @Select("SELECT DATE_FORMAT(time,'%u') as weekOfYear,YEAR(time) year, DATE_FORMAT(time,'%m') mon,((DAY(time)+WEEKDAY(time-INTERVAL DAY(time) DAY)) DIV 7 + 1) as weekOfMonth,AVG(grade) ag FROM grade  where is_delete=0  and building_num=#{buildingNum} and room_num=#{roomNum} GROUP BY weekOfYear,year")
    Record getEveryWeekOfYearAvgGrade(@Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //根据月份,第几周查询一周所有评分信息
    @Select("SELECT * from grade WHERE ((DAY(time)+WEEKDAY(time-INTERVAL DAY(time) DAY)) DIV 7 + 1)  = #{week} and  MONTH(time) =#{month} and YEAR(time) =#{year} and is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum} ")
    List<Grade> getWeekGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("week") Integer week, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询某年某月平均分,总分,天数
    @Select("SELECT  avg(grade) avgGrade,sum(grade) sumGrade,count(*) count, MONTH(time) mon FROM grade WHERE  MONTH(time) =#{month} and YEAR(time) =#{year} and is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum}  GROUP BY mon ")
    Record getMonthAvgGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询某年每个月的平均分,总分,每月天数
    @Select("SELECT  avg(grade) avgGrade,sum(grade) sumGrade,count(*) count, MONTH(time) mon FROM grade WHERE   is_delete=0 and YEAR(time) =#{year} and building_num=#{buildingNum} and room_num=#{roomNum}  GROUP BY mon ")
    Record getEveryMonthOfYearAvgGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询某年某月的评分信息
    @Select("SELECT * FROM grade WHERE  MONTH(time) =#{month} and is_delete=0 and YEAR(time) =#{year}  and building_num=#{buildingNum} and room_num=#{roomNum}")
    Record getMonthGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询上周评分信息
    @Select("SELECT * FROM grade  where DATE_FORMAT(time,'%u') = DATE_FORMAT(#{date},'%u')-1 and YEAR(time) =YEAR(#{date}) AND  is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum} order by time")
    List<Grade> getLastWeekGrade(@Param("date") Date date, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询上周平均评分
    @Select("SELECT  AVG(grade) FROM grade  where DATE_FORMAT(time,'%u') = DATE_FORMAT(#{date},'%u')-1 and YEAR(time) =YEAR(#{date}) AND is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum}  GROUP BY is_delete  ")
    Double getLastWeekAvgGrade(@Param("date") Date date, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询某年某月每周的平均分
    @Select("SELECT avg(grade) avgGrade, ((DAY(time)+WEEKDAY(time-INTERVAL DAY(time) DAY)) DIV 7 + 1) as weekOfMonth,count(*) dayNumber FROM grade WHERE  MONTH(time) =#{month} and YEAR(time) =#{year} and is_delete=0 and building_num=#{buildingNum} and room_num=#{roomNum}  GROUP BY weekOfMonth ")
    Record getEveryWeekOfMonthAvgGrade(@Param("year") Integer year, @Param("month") Integer month, @Param("buildingNum") Integer buildingNum, @Param("roomNum") Integer roomNum);

    //查询某专业上周最高平均分,楼号,房间号
    @Select("SELECT AVG(grade) ag,building_num,room_num  FROM grade where DATE_FORMAT(time,'%u') = DATE_FORMAT(#{date},'%u')-1 and YEAR(time) =YEAR(#{date}) AND is_delete=0 and major=#{major} GROUP BY building_num,room_num ORDER BY ag desc LIMIT 0,1")
    Record getMaxAvgAtLastWeekInMyMajor(@Param("date") Date date,@Param("major")Integer major);
    @Select("select * from grade where building_num=#{buildingNum} and room_num=#{roomNum} and time=DATE_FORMAT(#{time},'%y-%m-%d')")
    Grade getGradeByBuildingAndRoomAndTime(@Param("buildingNum")Integer buildingNum, @Param("roomNum") Integer roomNum, @Param("time") Date time);
}
