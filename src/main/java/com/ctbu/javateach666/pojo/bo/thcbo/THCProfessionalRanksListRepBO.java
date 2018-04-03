package com.ctbu.javateach666.pojo.bo.thcbo;

public class THCProfessionalRanksListRepBO {
	private int page;
	private int rows;
	private String is_prof;//申请结果

	public String getIs_prof() {
		return is_prof;
	}
	public void setIs_prof(String is_prof) {
		this.is_prof = is_prof;
	}
	private String prof_person_name;//求职人姓名
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getProf_person_name() {
		return prof_person_name;
	}
	public void setProf_person_name(String prof_person_name) {
		this.prof_person_name = prof_person_name;
	}
}
