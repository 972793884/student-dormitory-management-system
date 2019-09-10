package com.star.vo;


import java.io.Serializable;

/**
 * 
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2018-10-23 15:24:22
 */
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer roleid;
	/**
	 * 
	 */
	private Integer permissionid;
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
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
	/**
	 * 获取：
	 */
	public Integer getPermissionid() {
		return permissionid;
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
