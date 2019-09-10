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

public class Repairs extends Vo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
			private Integer id;
	/**
	 * 标题
	 */
			private String name;
	/**
	 * 损坏公务的类型（1.电器 2.水管 3.家具 0.其他）
	 */
			private Integer type;
	/**
	 * 详细内容
	 */
			private String content;
	/**
	 * 报修人填写的号码
	 */
			private String phone;
	/**
	 * 
	 */
			private String createUser;
	/**
	 * 
	 */
		@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
		private Date createTime;
	/**
	 * 0.待处理 1.处理中 2.待反馈 3.已结束
	 */
			private Integer status;
	/**
	 * 
	 */
			private Integer isDelete;
	/**
	 * 
	 */
			private Integer repairUser;
	/**
	 * 
	 */
			@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date repairTime;
	/**
	 * 反馈id（1.满意 2.不满意 3.一般）
	 */
			private Integer feedbackId;
	/**
	 * 反馈内容，评论
	 */
			private String feedbackComment;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
			private Date doneTime;
			private String repairName;

	public String getRepairName() {
		return repairName;
	}

	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}

	public Date getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(Date doneTime) {
		this.doneTime = doneTime;
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
	 * 设置：标题
	 */
	public void setName(String name) {
		this.name = name;
        addTab();
	}
	/**
	 * 获取：标题
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：损坏公务的类型（1.电器 2.水管 3.家具 0.其他）
	 */
	public void setType(Integer type) {
		this.type = type;
        addTab();
	}
	/**
	 * 获取：损坏公务的类型（1.电器 2.水管 3.家具 0.其他）
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：详细内容
	 */
	public void setContent(String content) {
		this.content = content;
        addTab();
	}
	/**
	 * 获取：详细内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：报修人填写的号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
        addTab();
	}
	/**
	 * 获取：报修人填写的号码
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
        addTab();
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
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
	 * 设置：0.待处理 1.处理中 2.待反馈 3.已结束
	 */
	public void setStatus(Integer status) {
		this.status = status;
        addTab();
	}
	/**
	 * 获取：0.待处理 1.处理中 2.待反馈 3.已结束
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
	/**
	 * 设置：
	 */
	public void setRepairUser(Integer repairUser) {
		this.repairUser = repairUser;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Integer getRepairUser() {
		return repairUser;
	}
	/**
	 * 设置：
	 */
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
        addTab();
	}
	/**
	 * 获取：
	 */
	public Date getRepairTime() {
		return repairTime;
	}
	/**
	 * 设置：反馈id（1.满意 2.不满意 3.一般）
	 */
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
        addTab();
	}
	/**
	 * 获取：反馈id（1.满意 2.不满意 3.一般）
	 */
	public Integer getFeedbackId() {
		return feedbackId;
	}
	/**
	 * 设置：反馈内容，评论
	 */
	public void setFeedbackComment(String feedbackComment) {
		this.feedbackComment = feedbackComment;
        addTab();
	}
	/**
	 * 获取：反馈内容，评论
	 */
	public String getFeedbackComment() {
		return feedbackComment;
	}
	private void addTab() {
        tab.add(Thread.currentThread().getStackTrace()[2].getMethodName().substring(3).toLowerCase());
	}
}
