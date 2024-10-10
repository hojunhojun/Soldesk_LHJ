package com.lhj.aug021opi.product;


public class Handphone extends Product {
	String os;
	
	public Handphone() {

	}
	
	public Handphone(String name, int price, String os) {
		super(name, price);
		this.os = os;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("OS : " + os);
	}
}
