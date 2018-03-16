package com.ctbu.javateach666.pojo.po.exam;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 答题卡
 * @author king
 *
 */
public class AnswerSheet extends DataEntity<AnswerSheet> {

	private static final long serialVersionUID = 1L;
	
	private int stuId;					// 学生id
	private int examId;					// 试卷id
	private String singleAnswer;		// 单选答案
	private String multipleAnswer;		// 多选答案
	private String judgmentAnswer;		// 判断答案
	private String completionAnswer;	// 填空答案
	private String completionComment;	// 教师备注
	private String subjectiveAnswer;	// 主观答案
	private String subjectiveComment;	// 教师备注
	private String state;				// 阅卷状态（0未阅览，1已阅览）
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getSingleAnswer() {
		return singleAnswer;
	}
	public void setSingleAnswer(String singleAnswer) {
		this.singleAnswer = singleAnswer;
	}
	public String getMultipleAnswer() {
		return multipleAnswer;
	}
	public void setMultipleAnswer(String multipleAnswer) {
		this.multipleAnswer = multipleAnswer;
	}
	public String getJudgmentAnswer() {
		return judgmentAnswer;
	}
	public void setJudgmentAnswer(String judgmentAnswer) {
		this.judgmentAnswer = judgmentAnswer;
	}
	public String getCompletionAnswer() {
		return completionAnswer;
	}
	public void setCompletionAnswer(String completionAnswer) {
		this.completionAnswer = completionAnswer;
	}
	public String getCompletionComment() {
		return completionComment;
	}
	public void setCompletionComment(String completionComment) {
		this.completionComment = completionComment;
	}
	public String getSubjectiveAnswer() {
		return subjectiveAnswer;
	}
	public void setSubjectiveAnswer(String subjectiveAnswer) {
		this.subjectiveAnswer = subjectiveAnswer;
	}
	public String getSubjectiveComment() {
		return subjectiveComment;
	}
	public void setSubjectiveComment(String subjectiveComment) {
		this.subjectiveComment = subjectiveComment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
