package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 主观题题库
 * @author king
 *
 */
public class Subjective extends DataEntity<Subjective>{

	private static final long serialVersionUID = 1L;
	
	private String couseId;				// 课程id
	private String subjectiveTitle;		// 主观题目
	private String subjectiveAnswer;	// 主观答案
	private String degree;				// 题目难度系数
	private Date createTime;			// 创建时间
	
	// 查询条件
	private Date bTime;				// 查询开始时间
	private Date eTime;				// 查询结束时间 
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public String getSubjectiveTitle() {
		return subjectiveTitle;
	}
	public void setSubjectiveTitle(String subjectiveTitle) {
		this.subjectiveTitle = subjectiveTitle;
	}
	public String getSubjectiveAnswer() {
		return subjectiveAnswer;
	}
	public void setSubjectiveAnswer(String subjectiveAnswer) {
		this.subjectiveAnswer = subjectiveAnswer;
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
	public Date getbTime() {
		return bTime;
	}
	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}
	public Date geteTime() {
		return eTime;
	}
	public void seteTime(Date eTime) {
		this.eTime = eTime;
	}
	
}
