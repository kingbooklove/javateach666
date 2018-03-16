package com.ctbu.javateach666.pojo.po.exam;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 试卷信息
 * @author king
 *
 */
public class ExamPaper extends DataEntity<ExamPaper>{

	private static final long serialVersionUID = 1L;
	
	private int couseId;			// 课程id
	private String examPaperName;	// 试卷名
	private int ruleId;			// 规则id
	private String examScore;		// 试卷分数
	
	public int getCouseId() {
		return couseId;
	}
	public void setCouseId(int couseId) {
		this.couseId = couseId;
	}
	public String getExamPaperName() {
		return examPaperName;
	}
	public void setExamPaperName(String examPaperName) {
		this.examPaperName = examPaperName;
	}
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public String getExamScore() {
		return examScore;
	}
	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}
	
	
}
