package com.lhj.sep113db.product;

public class Product {
	private int no;
	private String name;
	private int price;
	
	public Product() {
		
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