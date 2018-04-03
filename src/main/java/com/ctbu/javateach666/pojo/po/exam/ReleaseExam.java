package com.ctbu.javateach666.pojo.po.exam;

import java.util.Date;

import com.ctbu.javateach666.common.entity.DataEntity;
import com.ctbu.javateach666.pojo.po.THCCoursePO;

/**
 * 考试发布
 * @author king
 *
 */
public class ReleaseExam extends DataEntity<ReleaseExam>{

	private static final long serialVersionUID = 1L;
	
	private THCCoursePO course;			// 课程
	private String courseName;			// 课程名
	private ExamPaper examPaper;		// 试卷
	private String examPaperName;		// 试卷名
	private String releaseUsername;		// 发布人姓名
	private Integer examTime;			// 考试时长
	private String examPlace;			// 考试地点
	private String beginTime;			// 考试开始时间
	private String invigilator;			// 监考人 
	
	// 查询条件
	private Date bTime;					// 查询开始时间
	private Date eTime;					// 查询结束时间 
	
	public THCCoursePO getCourse() {
		return course;
	}
	public void setCourse(THCCoursePO course) {
		this.course = course;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public ExamPaper getExamPaper() {
		return examPaper;
	}
	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}
	public String getReleaseUsername() {
		return releaseUsername;
	}
	public void setReleaseUsername(String releaseUsername) {
		this.releaseUsername = releaseUsername;
	}
	public Integer getExamTime() {
		return examTime;
	}
	public void setExamTime(Integer examTime) {
		this.examTime = examTime;
	}
	public String getExamPlace() {
		return examPlace;
	}
	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getExamPaperName() {
		return examPaperName;
	}
	public void setExamPaperName(String examPaperName) {
		this.examPaperName = examPaperName;
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
