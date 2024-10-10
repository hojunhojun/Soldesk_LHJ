package com.lhj.aug205dbt.product;

public class Product {
	private int p_no;
	private String name;
	private int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int p_no, String name, int price) {
		super();
		this.p_no = p_no;
		this.name = name;
		this.price = price;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
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
