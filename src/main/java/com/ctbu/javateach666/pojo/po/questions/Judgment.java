package com.ctbu.javateach666.pojo.po.questions;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;
import com.ctbu.javateach666.pojo.po.thcpo.THCCoursePO;

/**
 * 判断题题库
 * @author king
 *
 */
public class Judgment extends DataEntity<Judgment>{

	private static final long serialVersionUID = 1L;
	
	private THCCoursePO course;		// 课程
	private String couname;			// 课程名
	private String judgmentTitle;	// 判断题目
	private String judgmentAnswer;	// 判断答案
	private String degree;			// 题目难度系数
	private Date createTime;		// 创建时间
	
	// 查询条件
	private Date bTime;				// 查询开始时间
	private Date eTime;				// 查询结束时间 
	
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
	public THCCoursePO getCourse() {
		return course;
	}
	public void setCourse(THCCoursePO course) {
		this.course = course;
	}
	public String getCouname() {
		return couname;
	}
	public void setCouname(String couname) {
		this.couname = couname;
	}
	
	
}
