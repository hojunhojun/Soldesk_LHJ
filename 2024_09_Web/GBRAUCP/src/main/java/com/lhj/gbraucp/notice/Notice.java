package com.lhj.gbraucp.notice;

import java.util.Date;

public class Notice {
	private int no;
	private String title;
	private String txt;
	private Date date;
	private String writer;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int no, String title, String txt, Date date, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.txt = txt;
		this.date = date;
		this.writer = writer;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
}
