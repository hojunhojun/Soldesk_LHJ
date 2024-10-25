package com.lhj.oct241xj.snack;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// JavaBean, DTO, VO
// DB에 있는 데이터 하나를 표현 가능

@XmlRootElement // 여기에 이거 작성
public class Snack {
	private String s_title;
	private String s_genre;
	private BigDecimal s_price;
	
	public Snack() {

	}

	public Snack(String s_title, String s_genre, BigDecimal s_price) {
		super();
		this.s_title = s_title;
		this.s_genre = s_genre;
		this.s_price = s_price;
	}

	public String getS_title() {
		return s_title;
	}
	
	@XmlElement
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public String getS_genre() {
		return s_genre;
	}
	
	@XmlElement
	public void setS_genre(String s_genre) {
		this.s_genre = s_genre;
	}

	public BigDecimal getS_price() {
		return s_price;
	}
	
	@XmlElement
	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}
	
}
