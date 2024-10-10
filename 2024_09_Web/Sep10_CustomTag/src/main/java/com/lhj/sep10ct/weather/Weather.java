package com.lhj.sep10ct.weather;

public class Weather {
	private String hour;
	private String wfKor;
	private String temp;
	private String img;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String hour, String wfKor, String temp, String img) {
		super();
		this.hour = hour;
		this.wfKor = wfKor;
		this.temp = temp;
		this.img = img;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
