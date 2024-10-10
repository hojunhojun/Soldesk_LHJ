package com.lhj.oct082uc;

public class UCData {
	private double num;
	private String what;
	
	private String unit1;
	private double result;
	private String unit2;
	public UCData() {

	}
	public UCData(double num, String what, String unit1, double result, String unit2) {
		super();
		this.num = num;
		this.what = what;
		this.unit1 = unit1;
		this.result = result;
		this.unit2 = unit2;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	public String getUnit1() {
		return unit1;
	}
	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getUnit2() {
		return unit2;
	}
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}

	
}
