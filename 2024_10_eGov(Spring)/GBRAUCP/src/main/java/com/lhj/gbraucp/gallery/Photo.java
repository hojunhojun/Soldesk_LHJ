package com.lhj.gbraucp.gallery;

import java.math.BigDecimal;

public class Photo {
	private BigDecimal p_no;
	private String p_gm_id;
	private String p_name;
	private String p_photo;
	
	public Photo() {

	}

	public Photo(BigDecimal p_no, String p_gm_id, String p_name, String p_photo) {
		super();
		this.p_no = p_no;
		this.p_gm_id = p_gm_id;
		this.p_name = p_name;
		this.p_photo = p_photo;
	}

	public BigDecimal getP_no() {
		return p_no;
	}

	public void setP_no(BigDecimal p_no) {
		this.p_no = p_no;
	}

	public String getP_gm_id() {
		return p_gm_id;
	}

	public void setP_gm_id(String p_gm_id) {
		this.p_gm_id = p_gm_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	
}
