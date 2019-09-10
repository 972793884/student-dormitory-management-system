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

public class User extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 登录名
	 */
			private String name;
	/**
	 * 密码
	 */
			private String password;
	/**
	 * 昵称
	 */
			private String nickName;
	/**
	 * 
	 */
			private Integer isDelete;
	/**
	 * 
	 */
			private Integer isLocked;
	/**
	 * 职务/角色  默认初级角色 0超级管理员1学生2老师3工人
	 */
			private Integer duty;
	/**
	 * 根据duty对应的表所对应的的id
	 */
			private Integer bindId;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date signInTime;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date lastLoginTime;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date thisLoginTime;
	/**
	 * 
	 */
			private String phone;
	/**
	 * 
	 */
			private String email;

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
	 * 设置：登录名
	 */
	public void setName(String name) {
		this.name = name;
        addTab();
	}
	/**
	 * 获取：登录名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
        addTab();
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
        addTab();
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() {
		return nickName;
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
	/**
	 * 设置：
	 */
	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getIsLocked() {
		return isLocked;
	}
	/**
	 * 设置：职务/角色  默认初级角色 0超级管理员1学生2老师3工人
	 */
	public void setDuty(Integer duty) {
		this.duty = duty;
        addTab();
	}
	/**
	 * 获取：职务/角色  默认初级角色 0超级管理员1学生2老师3工人
	 */
	public Integer getDuty() {
		return duty;
	}
	/**
	 * 设置：根据duty对应的表所对应的的id
	 */
	public void setBindId(Integer bindId) {
		this.bindId = bindId;
        addTab();
	}
	/**
	 * 获取：根据duty对应的表所对应的的id
	 */
	public Integer getBindId() {
		return bindId;
	}
	/**
	 * 设置：
	 */
	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getSignInTime() {
		return signInTime;
	}
	/**
	 * 设置：
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * 设置：
	 */
	public void setThisLoginTime(Date thisLoginTime) {
		this.thisLoginTime = thisLoginTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getThisLoginTime() {
		return thisLoginTime;
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
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
