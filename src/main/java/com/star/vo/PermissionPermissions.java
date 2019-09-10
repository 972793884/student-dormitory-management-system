package com.star.vo;


import java.io.Serializable;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2018-10-30 10:47:43
 */
public class PermissionPermissions implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer permMain;
	/**
	 * 
	 */
	private Integer perm;
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
	public void setPermMain(Integer permMain) {
		this.permMain = permMain;
	}
	/**
	 * 获取：
	 */
	public Integer getPermMain() {
		return permMain;
	}
	/**
	 * 设置：
	 */
	public void setPerm(Integer perm) {
		this.perm = perm;
	}
	/**
	 * 获取：
	 */
	public Integer getPerm() {
		return perm;
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
