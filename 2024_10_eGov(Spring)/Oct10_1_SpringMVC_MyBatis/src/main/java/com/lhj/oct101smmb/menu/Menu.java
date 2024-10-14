package com.lhj.oct101smmb.menu;

import java.math.BigDecimal;

// Spring : Java DI & IoC Framework

// MyBatis : DB ORM Framework(DB - Java객체)
//		1) DB필드명 == 멤버변수명
//		2) OracleDB : OracleDB의 number는 Java의 BigDecimal로
// SpringMVC : Spring + 웹개발 IoC Framework(request parameter - Java객체)
//		1) request parameter명 == 멤버변수명

// SpringMVC + MyBatis
//		DB필드명 == 멤버변수명 == request paramter명
//		2) OracleDB의 number는 Java의 BigDecimal로
public class Menu {
	private String m_name;
	private BigDecimal m_price;
	private BigDecimal m_no;
	
	public Menu() {
	
	}

	public Menu(String m_name, BigDecimal m_price, BigDecimal m_no) {
		super();
		this.m_name = m_name;
		this.m_price = m_price;
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BigDecimal getM_price() {
		return m_price;
	}

	public void setM_price(BigDecimal m_price) {
		this.m_price = m_price;
	}

	public BigDecimal getM_no() {
		return m_no;
	}

	public void setM_no(BigDecimal m_no) {
		this.m_no = m_no;
	}
	
	
	
}
