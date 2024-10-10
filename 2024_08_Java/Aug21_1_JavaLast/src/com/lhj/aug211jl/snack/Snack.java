package com.lhj.aug211jl.snack;

import java.util.Date;

public class Snack {
	private int num;
	private String name;
	private int price;
	private double weight;
	private Date exp; // java.util? / java.sql? -> 걍 util 사용 ㄱㄱ
	private String c_name;
	private String exp2;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(int num, String name, int price, double weight, String c_name, String exp2) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.c_name = c_name;
		this.exp2 = exp2;
	}
	
	public Snack(int num, String name, int price, double weight, Date exp, String c_name) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.exp = exp;
		this.c_name = c_name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	public String getExp2() {
		return exp2;
	}
	
	public void setExp2(String exp2) {
		this.exp2 = exp2;
	}
	
}
