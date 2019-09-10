package com.star.vo;



import java.io.Serializable;
import java.util.Date;
import com.star.controller.Vo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 卫生评分表
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2019-05-20 16:13:57
 */

public class Grade extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 楼号
	 */
			private Integer buildingNum;
	/**
	 * 房间号
	 */
			private Integer roomNum;
	/**
	 * 评分
	 */
			private Integer grade;
	/**
	 * 评语
	 */
			private String judgement;
			private Integer major;

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	/**
	 * 评分日期
	 */
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date time;
	/**
	 * 
	 */
			private Integer createUser;
	/**
	 * 
	 */
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date createTime;
	/**
	 * 
	 */
			private Integer isDelete;

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
	 * 设置：楼号
	 */
	public void setBuildingNum(Integer buildingNum) {
		this.buildingNum = buildingNum;
        addTab();
	}
	/**
	 * 获取：楼号
	 */
	public Integer getBuildingNum() {
		return buildingNum;
	}
	/**
	 * 设置：房间号
	 */
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
        addTab();
	}
	/**
	 * 获取：房间号
	 */
	public Integer getRoomNum() {
		return roomNum;
	}
	/**
	 * 设置：评分
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
        addTab();
	}
	/**
	 * 获取：评分
	 */
	public Integer getGrade() {
		return grade;
	}
	/**
	 * 设置：评语
	 */
	public void setJudgement(String judgement) {
		this.judgement = judgement;
        addTab();
	}
	/**
	 * 获取：评语
	 */
	public String getJudgement() {
		return judgement;
	}
	/**
	 * 设置：评分日期
	 */
	public void setTime(Date time) {
		this.time = time;
        addTab();
	}
	/**
	 * 获取：评分日期
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
