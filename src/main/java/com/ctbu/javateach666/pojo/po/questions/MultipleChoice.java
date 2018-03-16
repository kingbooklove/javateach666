package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 多选题题库
 * @author king
 *
 */
public class MultipleChoice extends DataEntity<MultipleChoice>{

	private static final long serialVersionUID = 1L;
	
	private String couseId;			// 课程id
	private String multipleTitle;	// 多选题目
	private String multipleAnswer;	// 多选答案
	private String degree;			// 题目难度系数
	private Date createTime;		// 创建时间
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public String getMultipleTitle() {
		return multipleTitle;
	}
	public void setMultipleTitle(String multipleTitle) {
		this.multipleTitle = multipleTitle;
	}
	public String getMultipleAnswer() {
		return multipleAnswer;
	}
	public void setMultipleAnswer(String multipleAnswer) {
		this.multipleAnswer = multipleAnswer;
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
