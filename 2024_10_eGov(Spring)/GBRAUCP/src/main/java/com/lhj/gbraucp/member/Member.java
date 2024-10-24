package com.lhj.gbraucp.member;

import java.util.Date;

public class Member {
	private String gm_id;
	private String gm_pw;
	private String gm_photo;
	private Date gm_birthday;
	
	public Member() {

	}

	public Member(String gm_id, String gm_pw, String gm_photo, Date gm_birthday) {
		super();
		this.gm_id = gm_id;
		this.gm_pw = gm_pw;
		this.gm_photo = gm_photo;
		this.gm_birthday = gm_birthday;
	}

	public String getGm_id() {
		return gm_id;
	}

	public void setGm_id(String gm_id) {
		this.gm_id = gm_id;
	}

	public String getGm_pw() {
		return gm_pw;
	}

	public void setGm_pw(String gm_pw) {
		this.gm_pw = gm_pw;
	}

	public String getGm_photo() {
		return gm_photo;
	}

	public void setGm_photo(String gm_photo) {
		this.gm_photo = gm_photo;
	}

	public Date getGm_birthday() {
		return gm_birthday;
	}

	public void setGm_birthday(Date gm_birthday) {
		this.gm_birthday = gm_birthday;
	}
	
	
}
