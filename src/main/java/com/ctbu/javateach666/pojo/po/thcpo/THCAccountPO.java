package com.ctbu.javateach666.pojo.po.thcpo;

import java.io.Serializable;

public class THCAccountPO implements Serializable{

	private static final long serialVersionUID = -7565870336366851901L;

	public int id;
	
	public String username;
	
	public String password;
	
	public int enable;
	
	public int userdetailid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getUserdetailid() {
		return userdetailid;
	}

	public void setUserdetailid(int userdetailid) {
		this.userdetailid = userdetailid;
	}
	
	
}
