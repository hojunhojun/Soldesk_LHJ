package com.lhj.oct021jmb.img;

import java.math.BigDecimal;

public class ImgPager {
	private BigDecimal start;
	private BigDecimal end;
	
	public ImgPager() {
		// TODO Auto-generated constructor stub
	}

	public ImgPager(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
