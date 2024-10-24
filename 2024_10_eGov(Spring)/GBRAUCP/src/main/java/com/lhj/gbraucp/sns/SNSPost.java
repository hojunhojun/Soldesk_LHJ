package com.lhj.gbraucp.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSPost {
	private BigDecimal gs_no;
	private String gs_txt;
	private Date gs_date;
	private String gs_writer;
	private String gm_photo; // join
	private List<SNSReply> gs_replys; // java -> 댓글을 글의 부속품.
	
	public SNSPost() {

	}

	public SNSPost(BigDecimal gs_no, String gs_txt, Date gs_date, String gs_writer, String gm_photo,
			List<SNSReply> gs_replys) {
		super();
		this.gs_no = gs_no;
		this.gs_txt = gs_txt;
		this.gs_date = gs_date;
		this.gs_writer = gs_writer;
		this.gm_photo = gm_photo;
		this.gs_replys = gs_replys;
	}

	public BigDecimal getGs_no() {
		return gs_no;
	}

	public void setGs_no(BigDecimal gs_no) {
		this.gs_no = gs_no;
	}

	public String getGs_txt() {
		return gs_txt;
	}

	public void setGs_txt(String gs_txt) {
		this.gs_txt = gs_txt;
	}

	public Date getGs_date() {
		return gs_date;
	}

	public void setGs_date(Date gs_date) {
		this.gs_date = gs_date;
	}

	public String getGs_writer() {
		return gs_writer;
	}

	public void setGs_writer(String gs_writer) {
		this.gs_writer = gs_writer;
	}

	public String getGm_photo() {
		return gm_photo;
	}

	public void setGm_photo(String gm_photo) {
		this.gm_photo = gm_photo;
	}

	public List<SNSReply> getGs_replys() {
		return gs_replys;
	}

	public void setGs_replys(List<SNSReply> gs_replys) {
		this.gs_replys = gs_replys;
	}
	
	
}
