package com.star.mapper;

import com.star.Utils.Record;
import com.star.vo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //根据id查询学生信息
    @Select("select * from student where id=#{id}")
    Student findById(@Param("id") Integer id);

    List<Student> list();

    //查询学生列表
    @Select("select * from student")
    List<Student> findAll();


   /* @Select("select * from student")
    List<Map<String,String>> findAll();*/

    @Insert("insert into student(name,age,status) values(#{name},#{age},#{status})")
    Integer save(Student student);

    @Select("<script>"+
            "select *  from student s where  s.name like #{name}  <if test='age!=null'> and age =#{age} </if>"+
            "</script>")
    List<Record> all(@Param("name") String name,@Param("age") Integer age);
    @Select("select s.*,b.*,b.id as bed_id from student s left join bed b on s.student_number=b.student_no")
    List<Student> getStudentAndBedList();
    @Select("select * from student where student_number = #{studentNo}")
    Student getStudentByNo(@Param("studentNo") Integer studentNo);
    @Select("select * from student where student_number = #{studentNo} and password=#{password}")
    Student getStudentByNoAndPwd(@Param("studentNo") String stuNum,@Param("password") String stuPwd);
}
