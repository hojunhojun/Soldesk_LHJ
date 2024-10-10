package com.lhj.aug021opi.product;


public class Product {
	String name;
	int price;
	
	public Product() {

	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price);
	}
}
