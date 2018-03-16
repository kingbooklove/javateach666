package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 单选题题库
 * @author king
 *
 */
public class SingleChoice extends DataEntity<SingleChoice>{

	private static final long serialVersionUID = 1L;
	
	private String couseId;			// 课程id
	private String singleTitle;		// 单选题目
	private String singleAnswer;	// 单选答案
	private String degree;			// 题目难度系数
	private Date createTime;		// 创建时间
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public String getSingleTitle() {
		return singleTitle;
	}
	public void setSingleTitle(String singleTitle) {
		this.singleTitle = singleTitle;
	}
	public String getSingleAnswer() {
		return singleAnswer;
	}
	public void setSingleAnswer(String singleAnswer) {
		this.singleAnswer = singleAnswer;
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
