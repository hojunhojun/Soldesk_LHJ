package com.lhj.gbraucp.notice;

import java.util.Date;

public class Reply {
	private int no;
	private String txt;
	private Date date;
	private String writer;
	private int gn_no;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public Reply(int no, String txt, Date date, String writer, int gn_no) {
		super();
		this.no = no;
		this.txt = txt;
		this.date = date;
		this.writer = writer;
		this.gn_no = gn_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getGn_no() {
		return gn_no;
	}

	public void setGn_no(int gn_no) {
		this.gn_no = gn_no;
	}
	
	
}
