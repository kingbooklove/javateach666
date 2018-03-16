package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 填空题题库
 * @author king
 *
 */
public class Completion extends DataEntity<Completion>{

	private static final long serialVersionUID = 1L;
	
	private String couseId;				// 课程id
	private String completionTitle;		// 填空题目
	private String completionAnswer;	// 填空答案
	private String degree;				// 题目难度系数
	private Date createTime;			// 创建时间
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public String getCompletionTitle() {
		return completionTitle;
	}
	public void setCompletionTitle(String completionTitle) {
		this.completionTitle = completionTitle;
	}
	public String getCompletionAnswer() {
		return completionAnswer;
	}
	public void setCompletionAnswer(String completionAnswer) {
		this.completionAnswer = completionAnswer;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
