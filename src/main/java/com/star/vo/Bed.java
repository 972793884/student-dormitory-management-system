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
 * @date 2019-05-20 17:32:33
 */

public class Bed extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */		private String name;
	 		private String studentNumber;
	
			private Integer id;
	/**
	 * 楼号
	 */
			private Integer buildingNo;
	/**
	 * 房间号/宿舍号
	 */
			private Integer roomNo;
	/**
	 * 床号
	 */
			private Integer bedNo;
	/**
	 * 学生学号
	 */
			private Integer studentNo;
	/**
	 * 0.可用 1.已占用 2.坏
	 */
			private Integer status;
	/**
	 * 
	 */
			private Integer isDelete;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

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
	public void setBuildingNo(Integer buildingNo) {
		this.buildingNo = buildingNo;
        addTab();
	}
	/**
	 * 获取：楼号
	 */
	public Integer getBuildingNo() {
		return buildingNo;
	}
	/**
	 * 设置：房间号/宿舍号
	 */
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
        addTab();
	}
	/**
	 * 获取：房间号/宿舍号
	 */
	public Integer getRoomNo() {
		return roomNo;
	}
	/**
	 * 设置：床号
	 */
	public void setBedNo(Integer bedNo) {
		this.bedNo = bedNo;
        addTab();
	}
	/**
	 * 获取：床号
	 */
	public Integer getBedNo() {
		return bedNo;
	}
	/**
	 * 设置：学生学号
	 */
	public void setStudentNo(Integer studentNo) {
		this.studentNo = studentNo;
        addTab();
	}
	/**
	 * 获取：学生学号
	 */
	public Integer getStudentNo() {
		return studentNo;
	}
	/**
	 * 设置：0.可用 1.已占用 2.坏
	 */
	public void setStatus(Integer status) {
		this.status = status;
        addTab();
	}
	/**
	 * 获取：0.可用 1.已占用 2.坏
	 */
	public Integer getStatus() {
		return status;
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
