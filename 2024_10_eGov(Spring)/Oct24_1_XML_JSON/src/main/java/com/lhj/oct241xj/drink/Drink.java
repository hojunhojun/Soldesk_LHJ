package com.lhj.oct241xj.drink;

import java.math.BigDecimal;

public class Drink {
	private String d_title;
	private String d_genre;
	private BigDecimal d_price;
	
	public Drink() {
		// TODO Auto-generated constructor stub
	}

	public Drink(String d_title, String d_genre, BigDecimal d_price) {
		super();
		this.d_title = d_title;
		this.d_genre = d_genre;
		this.d_price = d_price;
	}

	public String getD_title() {
		return d_title;
	}
	
	
	public void setD_title(String d_title) {
		this.d_title = d_title;
	}

	public String getD_genre() {
		return d_genre;
	}
	
	
	public void setD_genre(String d_genre) {
		this.d_genre = d_genre;
	}

	public BigDecimal getD_price() {
		return d_price;
	}
	
	
	public void setD_price(BigDecimal d_price) {
		this.d_price = d_price;
	}
	
}
