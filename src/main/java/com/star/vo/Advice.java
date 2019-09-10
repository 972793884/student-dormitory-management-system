package com.star.vo;



import java.io.Serializable;
import java.util.Date;
import com.star.controller.Vo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 通知，公告
 * 
 * @author zzq
 * @email 972793884@qq.com
 * @date 2019-05-20 16:13:57
 */

public class Advice extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 通知标题
	 */
			private String title;
	/**
	 * 通知内容
	 */
			private String content;
	/**
	 * 
	 */
			private Integer createUser;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;
	/**
	 * 
	 */
			private Integer isDelete;
			private String createUserName;

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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
	 * 设置：通知标题
	 */
	public void setTitle(String title) {
		this.title = title;
        addTab();
	}
	/**
	 * 获取：通知标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：通知内容
	 */
	public void setContent(String content) {
		this.content = content;
        addTab();
	}
	/**
	 * 获取：通知内容
	 */
	public String getContent() {
		return content;
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
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
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
