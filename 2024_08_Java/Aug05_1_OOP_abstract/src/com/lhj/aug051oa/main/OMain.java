package com.lhj.aug051oa.main;

import com.lhj.aug051oa.hero.Avengers;
import com.lhj.aug051oa.hero.Hulk;
import com.lhj.aug051oa.hero.Ironman;
import com.lhj.aug051oa.hero.Thor;

public class OMain {
	public static void main(String[] args) {
		
		// 자바의 특이점 : 객체를 만들면서 1회용 클래스도 생성할 수 있음.
		// 익명 내부 클래스
		// anonymous inner class
		Avengers a = new Avengers() {
			@Override
			public void attack() {
				System.out.println("방패 던지기");
			}
		}; // 그래서 클래스명이 뭔가요?
		a.attack();;
		
		Ironman h1 = new Ironman("토니", 35, "자비스");
		h1.printInfo();
		h1.attack();
		h1.eat();
		h1.fly();
		
		System.out.println("---------");
		
		Avengers h2 = new Hulk("헐크", 40, 360);
		h2.printInfo();
		h2.attack();
		
		System.out.println("---------");
		
		Avengers h3 = new Thor("토르", 35);
		h3.printInfo();
		h3.attack();
	}
}
