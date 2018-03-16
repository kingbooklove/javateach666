package com.ctbu.javateach666.pojo.po.exam;

import com.ctbu.javateach666.common.entity.DataEntity;


/**
 * 学生成绩表
 * @author king
 *
 */
public class Achievement extends DataEntity<Achievement>{

	private static final long serialVersionUID = 1L;
	
	private int stuId;				// 学生id
	private int teaId;				// 教师id
	private int score;				// 总成绩
	private int paperId;			// 试卷id
	private int singleScore;		// 单选分数
	private int multipleScore;		// 多选分数
	private int judgmentScore;		// 判断分数
	private int completionScore;	// 填空分数
	private int subjectiveScore;	// 主观分数
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getTeaId() {
		return teaId;
	}
	public void setTeaId(int teaId) {
		this.teaId = teaId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(int singleScore) {
		this.singleScore = singleScore;
	}
	public int getMultipleScore() {
		return multipleScore;
	}
	public void setMultipleScore(int multipleScore) {
		this.multipleScore = multipleScore;
	}
	public int getJudgmentScore() {
		return judgmentScore;
	}
	public void setJudgmentScore(int judgmentScore) {
		this.judgmentScore = judgmentScore;
	}
	public int getCompletionScore() {
		return completionScore;
	}
	public void setCompletionScore(int completionScore) {
		this.completionScore = completionScore;
	}
	public int getSubjectiveScore() {
		return subjectiveScore;
	}
	public void setSubjectiveScore(int subjectiveScore) {
		this.subjectiveScore = subjectiveScore;
	}
	
	
	
}
