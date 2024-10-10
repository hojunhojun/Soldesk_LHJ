package com.lhj.aug20pp.main;

// DB
// 		열, column, field
//		행, row, record, data

// JavaBean - 자바의 기본 클래스
// VO(Value Object)
// DTO(Data Transfer Object)
public class Product {
	private int no; // 멤버변수, 속성, field
	private String name;
	private int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int no, String name, int price) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
