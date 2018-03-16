package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 判断题题库
 * @author king
 *
 */
public class Judgment extends DataEntity<Judgment>{

	private static final long serialVersionUID = 1L;
	
	private String couseId;			// 课程id
	private String judgmentTitle;	// 判断题目
	private String judgmentAnswer;	// 判断答案
	private String degree;			// 题目难度系数
	private Date createTime;		// 创建时间
	public String getCouseId() {
		return couseId;
	}
	public void setCouseId(String couseId) {
		this.couseId = couseId;
	}
	public String getJudgmentTitle() {
		return judgmentTitle;
	}
	public void setJudgmentTitle(String judgmentTitle) {
		this.judgmentTitle = judgmentTitle;
	}
	public String getJudgmentAnswer() {
		return judgmentAnswer;
	}
	public void setJudgmentAnswer(String judgmentAnswer) {
		this.judgmentAnswer = judgmentAnswer;
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
