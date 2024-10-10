package com.lhj.oct083bc;

public class Guest {
	private String n;
	private double h;
	private double w;
	private double bmi;
	private String result;
	private String photo;
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Guest(String n, double h, double w, double bmi, String result, String photo) {
		super();
		this.n = n;
		this.h = h;
		this.w = w;
		this.bmi = bmi;
		this.result = result;
		this.photo = photo;
	}

	public Guest(String n, double h, double w, double bmi, String result) {
		super();
		this.n = n;
		this.h = h;
		this.w = w;
		this.bmi = bmi;
		this.result = result;
	}
	
	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(String n, double h, double w) {
		super();
		this.n = n;
		this.h = h;
		this.w = w;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}
	
	
}
