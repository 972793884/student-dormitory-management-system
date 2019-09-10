package com.star.vo;



import java.io.Serializable;
import java.util.Date;
import com.star.controller.Vo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2019-05-20 16:13:57
 */

public class Student extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 
	 */
			private String name;
	/**
	 * 
	 */
			private Integer age;
	/**
	 * 0.女 1.男
	 */
			private Integer sex;
	/**
	 * 
	 */
			private String studentNumber;
	/**
	 * 
	 */
			private String phone;
	/**
	 * 
	 */
			private String email;
	/**
	 * 
	 */
			private String address;
			private String buildingNo;
			private String roomNo;
			private String bedNo;
			private Integer bedId;
			private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getBedId() {
		return bedId;
	}

	public void setBedId(Integer bedId) {
		this.bedId = bedId;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	/**
	 * 
	 */
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date birthday;
	/**
	 *  系
	 */
			private Integer dept;
	/**
	 * 专业
	 */
			private Integer major;
	/**
	 * 年级
	 */
			private Integer grade;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setAge(Integer age) {
		this.age = age;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：0.女 1.男
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
        addTab();
	}
	/**
	 * 获取：0.女 1.男
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getStudentNumber() {
		return studentNumber;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：
	 */
	public void setAddress(String address) {
		this.address = address;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置： 系
	 */
	public void setDept(Integer dept) {
		this.dept = dept;
        addTab();
	}
	/**
	 * 获取： 系
	 */
	public Integer getDept() {
		return dept;
	}
	/**
	 * 设置：专业
	 */
	public void setMajor(Integer major) {
		this.major = major;
        addTab();
	}
	/**
	 * 获取：专业
	 */
	public Integer getMajor() {
		return major;
	}
	/**
	 * 设置：年级
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
        addTab();
	}
	/**
	 * 获取：年级
	 */
	public Integer getGrade() {
		return grade;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
