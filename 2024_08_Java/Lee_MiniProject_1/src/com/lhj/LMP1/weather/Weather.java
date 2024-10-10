package com.lhj.LMP1.weather;

public class Weather {
	private int description;
	private String temp;
	private String f_temp;
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	public Weather(int description, String temp, String f_temp) {
		super();
		this.description = description;
		this.temp = temp;
		this.f_temp = f_temp;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getF_temp() {
		return f_temp;
	}
	public void setF_temp(String f_temp) {
		this.f_temp = f_temp;
	}
}
