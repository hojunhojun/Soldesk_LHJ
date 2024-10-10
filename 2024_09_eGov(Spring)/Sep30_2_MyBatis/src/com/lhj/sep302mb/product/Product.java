package com.lhj.sep302mb.product;

import java.math.BigDecimal;

// Library : 규칙대로 하면 자동으로 편하게 해주는거
// Framework : Library + 자체툴

// MyBatis
//		DB ORM Framework : 
//			DB의 데이터를 자동으로 자바객체로 만들어주는
//		유지보수 Framework

// - DB필드명, 멤버변수명 통일
// - OracleDB 한정 -> number가 정수/실수 다 소화
//		Java에서도 정수/실수 다 소화하는 -> BigDecimal

// 		varchar2 	-> String
//		char 		-> String
//		date		-> java.util.Date
//		number		-> BigDecimal
public class Product {
	private String p_name;
	private BigDecimal p_price;
	
	public Product() {

	}

	public Product(String p_name, BigDecimal p_price) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}
	
	
}