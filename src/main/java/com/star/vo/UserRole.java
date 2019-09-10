package com.star.vo;


import com.star.controller.Vo;

import java.io.Serializable;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2018-10-30 10:34:39
 */
public class UserRole extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer userid;
	/**
	 * 
	 */
	private Integer roleid;
	/**
	 * 
	 */
	private Integer isDelete;
	/**
	 * 
	 */
	private Integer isLocked;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取：
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置：
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
	}
	/**
	 * 获取：
	 */
	public Integer getIsLocked() {
		return isLocked;
	}
}
