package com.lhj.gbraucp.dataroom;

import java.math.BigDecimal;

public class Data {
	private BigDecimal gd_no;
	private String gd_gm_id;
	private String gd_name;
	private String gd_data;
	
	public Data() {

	}

	public Data(BigDecimal gd_no, String gd_gm_id, String gd_name, String gd_data) {
		super();
		this.gd_no = gd_no;
		this.gd_gm_id = gd_gm_id;
		this.gd_name = gd_name;
		this.gd_data = gd_data;
	}

	public BigDecimal getGd_no() {
		return gd_no;
	}

	public void setGd_no(BigDecimal gd_no) {
		this.gd_no = gd_no;
	}

	public String getGd_gm_id() {
		return gd_gm_id;
	}

	public void setGd_gm_id(String gd_gm_id) {
		this.gd_gm_id = gd_gm_id;
	}

	public String getGd_name() {
		return gd_name;
	}

	public void setGd_name(String gd_name) {
		this.gd_name = gd_name;
	}

	public String getGd_data() {
		return gd_data;
	}

	public void setGd_data(String gd_data) {
		this.gd_data = gd_data;
	}
	
	
}
