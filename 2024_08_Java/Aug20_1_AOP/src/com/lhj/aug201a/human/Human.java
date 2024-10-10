package com.lhj.aug201a.human;

public class Human {
	public void ready() {
		System.out.println("씻기");
		System.out.println("옷입기");
		System.out.println("신발신기");
		System.out.println("엘베타기");
	}
	public void goSchool() {
		ready();
		System.out.println("걸어가기");
		System.out.println("지하철타기");
		System.out.println("내려서 걷기");
		System.out.println("학교도착");
	}
	
	public void goMart() {
		ready();
		System.out.println("걸어가기");
		System.out.println("마트도착");
	}
	
	public void goPark() {
		ready();
		System.out.println("걸어가기");
		System.out.println("물하나사서");
		System.out.println("공원도착");
	}
}