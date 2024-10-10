package com.lhj.aug022oam.animal.main;

import com.lhj.aug022oam.animail.pet.Cat;

// 	access modifier(접근 제한자(지정자)) : 멤버들의 접근을 제어
//		public 				protected 			안쓰기(default/friendly) 	private   : 4종류
//		다 가능	같은 패키지 or 다른패키지이지만 상속관계			같은 패키지		해당 클래스
public class OMain {
	public static void main(String[] args) {
		Cat c = new Cat("만득이", 3);
		c.printInfo();
		c.name = "기모띠";
	}
	
}
