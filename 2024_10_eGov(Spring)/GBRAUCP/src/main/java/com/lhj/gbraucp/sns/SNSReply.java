package com.lhj.gbraucp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal gsr_no;
	private BigDecimal gsr_gs_no;
	private String gsr_writer;
	private String gsr_txt;
	private Date gsr_date;
	
	public SNSReply() {

	}

	public SNSReply(BigDecimal gsr_no, BigDecimal gsr_gs_no, String gsr_writer, String gsr_txt, Date gsr_date) {
		super();
		this.gsr_no = gsr_no;
		this.gsr_gs_no = gsr_gs_no;
		this.gsr_writer = gsr_writer;
		this.gsr_txt = gsr_txt;
		this.gsr_date = gsr_date;
	}

	public BigDecimal getGsr_no() {
		return gsr_no;
	}

	public void setGsr_no(BigDecimal gsr_no) {
		this.gsr_no = gsr_no;
	}

	public BigDecimal getGsr_gs_no() {
		return gsr_gs_no;
	}

	public void setGsr_gs_no(BigDecimal gsr_gs_no) {
		this.gsr_gs_no = gsr_gs_no;
	}

	public String getGsr_writer() {
		return gsr_writer;
	}

	public void setGsr_writer(String gsr_writer) {
		this.gsr_writer = gsr_writer;
	}

	public String getGsr_txt() {
		return gsr_txt;
	}

	public void setGsr_txt(String gsr_txt) {
		this.gsr_txt = gsr_txt;
	}

	public Date getGsr_date() {
		return gsr_date;
	}

	public void setGsr_date(Date gsr_date) {
		this.gsr_date = gsr_date;
	}
}
