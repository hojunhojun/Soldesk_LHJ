package com.lhj.sep302mb.product;

import java.math.BigDecimal;

public class Product2 {
	private BigDecimal price1;
	private BigDecimal price2;
	
	public Product2() {
		// TODO Auto-generated constructor stub
	}

	public Product2(BigDecimal price1, BigDecimal price2) {
		super();
		this.price1 = price1;
		this.price2 = price2;
	}

	public BigDecimal getPrice1() {
		return price1;
	}

	public void setPrice1(BigDecimal price1) {
		this.price1 = price1;
	}

	public BigDecimal getPrice2() {
		return price2;
	}

	public void setPrice2(BigDecimal price2) {
		this.price2 = price2;
	}
	
	
}
