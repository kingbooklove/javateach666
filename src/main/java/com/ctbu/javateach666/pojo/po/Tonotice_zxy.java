package com.ctbu.javateach666.pojo.po;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Tonotice_zxy {
	public int id;
	
	public int notid;
	
	public int tonotid;
	
	public int nottype;
	
	public String notname;
	
	public String nottitle;
	
	public String notcontent;
	
	public int is_look;
	
	public int getIs_look() {
		return is_look;
	}

	public void setIs_look(int is_look) {
		this.is_look = is_look;
	}

	public String noturl;
	@JSONField(format = "yyyy-MM-dd")

	public Date starttime;
	@JSONField(format = "yyyy-MM-dd")

	public Date endtime;
	
	public int is_delete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNotid() {
		return notid;
	}

	public void setNotid(int notid) {
		this.notid = notid;
	}

	public int getTonotid() {
		return tonotid;
	}

	public void setTonotid(int tonotid) {
		this.tonotid = tonotid;
	}

	public int getNottype() {
		return nottype;
	}

	public void setNottype(int nottype) {
		this.nottype = nottype;
	}

	public String getNotname() {
		return notname;
	}

	public void setNotname(String notname) {
		this.notname = notname;
	}



	public String getNottitle() {
		return nottitle;
	}

	public void setNottitle(String nottitle) {
		this.nottitle = nottitle;
	}

	public String getNotcontent() {
		return notcontent;
	}

	public void setNotcontent(String notcontent) {
		this.notcontent = notcontent;
	}

	public String getNoturl() {
		return noturl;
	}

	public void setNoturl(String noturl) {
		this.noturl = noturl;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}
	
	
}
