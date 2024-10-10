package com.lhj.aug021opi.product;


public class Snack extends Product {
	String sellTime;
	
	public Snack() {

	}
	
	public Snack(String name, int price, String sellTime) {
		super(name, price);
		this.sellTime = sellTime;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("유통기한 : " + sellTime);
	}
}
