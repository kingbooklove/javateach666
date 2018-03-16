package com.ctbu.javateach666.pojo.po.exam;

import com.ctbu.javateach666.common.entity.DataEntity;

/**
 * 考试发布
 * @author king
 *
 */
public class ReleaseExam extends DataEntity<ReleaseExam>{

	private static final long serialVersionUID = 1L;
	
	private int couseId;				// 课程id
	private int paperId;				// 试卷内容id
	private String releaseUsername;		// 发布人姓名
	private int examTime;				// 考试时间
	private String examPlace;			// 考试地点
	private String invigilator;			// 监考人
	public int getCouseId() {
		return couseId;
	}
	public void setCouseId(int couseId) {
		this.couseId = couseId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public String getReleaseUsername() {
		return releaseUsername;
	}
	public void setReleaseUsername(String releaseUsername) {
		this.releaseUsername = releaseUsername;
	}
	public int getExamTime() {
		return examTime;
	}
	public void setExamTime(int examTime) {
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
	
}
