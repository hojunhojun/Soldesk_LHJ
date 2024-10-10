package com.lhj.oct071sdi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MealBox {
	private String name;
	private int price;
	private HashMap<String, Double> side;
	
	public MealBox() {

	}
	
	public MealBox(String name, int price, HashMap<String, Double> side) {
		super();
		this.name = name;
		this.price = price;
		this.side = side;
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

	public HashMap<String, Double> getSide() {
		return side;
	}

	public void setSide(HashMap<String, Double> side) {
		this.side = side;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price + "원");
		Set<String> what = side.keySet();
		ArrayList<String> what2 = new ArrayList<String>(what);
		for (String w : what2) {
			System.out.println(w + " : " + side.get(w) + "g");
		}
	}
}
