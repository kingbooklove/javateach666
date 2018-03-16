package com.ctbu.javateach666.pojo.po.exam;

import com.ctbu.javateach666.common.entity.DataEntity;


/**
 * 试卷规则
 * @author king
 *
 */
public class ExamRule extends DataEntity<ExamRule>{

	private static final long serialVersionUID = 1L;
	
	private int couseId;				// 课程id
	private String ruleName;			// 规则名
	private String singleRules;			// 单选规则
	private int singleNum;				// 单选数量
	private int singleScore;			// 单选分数
	private String multipleRules;		// 多选规则
	private int multipleNum;			// 多选数量
	private int multipleScore;			// 多选分数
	private String judgmentRules;		// 判断规则
	private int judgmentNum;			// 判断数量
	private int judgmentScore;			// 判断分数
	private String completionRules;		// 填空规则
	private int completionNum;			// 填空数量
	private int completionScore;		// 填空分数
	private String subjectiveRules;		// 主观规则
	private int subjectiveNum;			// 主观数量
	private int subjectiveScore;		// 主观分数
	
	public int getCouseId() {
		return couseId;
	}
	public void setCouseId(int couseId) {
		this.couseId = couseId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getSingleRules() {
		return singleRules;
	}
	public void setSingleRules(String singleRules) {
		this.singleRules = singleRules;
	}
	public int getSingleNum() {
		return singleNum;
	}
	public void setSingleNum(int singleNum) {
		this.singleNum = singleNum;
	}
	public int getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}
	public String getMultipleRules() {
		return multipleRules;
	}
	public void setMultipleRules(String multipleRules) {
		this.multipleRules = multipleRules;
	}
	public int getMultipleNum() {
		return multipleNum;
	}
	public void setMultipleNum(int multipleNum) {
		this.multipleNum = multipleNum;
	}
	public int getMultipleScore() {
		return multipleScore;
	}
	public void setMultipleScore(int multipleScore) {
		this.multipleScore = multipleScore;
	}
	public String getJudgmentRules() {
		return judgmentRules;
	}
	public void setJudgmentRules(String judgmentRules) {
		this.judgmentRules = judgmentRules;
	}
	public int getJudgmentNum() {
		return judgmentNum;
	}
	public void setJudgmentNum(int judgmentNum) {
		this.judgmentNum = judgmentNum;
	}
	public int getJudgmentScore() {
		return judgmentScore;
	}
	public void setJudgmentScore(int judgmentScore) {
		this.judgmentScore = judgmentScore;
	}
	public String getCompletionRules() {
		return completionRules;
	}
	public void setCompletionRules(String completionRules) {
		this.completionRules = completionRules;
	}
	public int getCompletionNum() {
		return completionNum;
	}
	public void setCompletionNum(int completionNum) {
		this.completionNum = completionNum;
	}
	public int getCompletionScore() {
		return completionScore;
	}
	public void setCompletionScore(int completionScore) {
		this.completionScore = completionScore;
	}
	public String getSubjectiveRules() {
		return subjectiveRules;
	}
	public void setSubjectiveRules(String subjectiveRules) {
		this.subjectiveRules = subjectiveRules;
	}
	public int getSubjectiveNum() {
		return subjectiveNum;
	}
	public void setSubjectiveNum(int subjectiveNum) {
		this.subjectiveNum = subjectiveNum;
	}
	public int getSubjectiveScore() {
		return subjectiveScore;
	}
	public void setSubjectiveScore(int subjectiveScore) {
		this.subjectiveScore = subjectiveScore;
	}
	
}
