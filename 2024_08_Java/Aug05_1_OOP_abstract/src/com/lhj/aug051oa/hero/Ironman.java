package com.lhj.aug051oa.hero;

import com.lhj.aug051oa.flyer.Flyer;
import com.lhj.aug051oa.human.Human;

// object - product - computer - notebook

// 이놈은 다중상속임 : 언어마다 지원여부가 갈림(대부분은 안됨) - 자바도 안됨
// 													정식 상속은 불가. (마이너버전 상속)

// Ironman is Avengers
// Ironman is Human
public class Ironman extends Avengers implements Human, Flyer {
	
	private String comName;
	
	public Ironman() {

	}
	
	public Ironman(String name, int age, String comName) {
		super(name, age);
		this.comName = comName;
	}
	
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("컴퓨터 이름 : " + comName);
	}
	
	@Override
	public void attack() {
		// super.attack(); // 추상메서드라 내용이 없는데 어떻게 불러오냐..
		System.out.println("빔 발사");
	}

	@Override
	public void eat() {
		System.out.println("냠");
	}
	
	@Override
	public void fly() {
		System.out.println("슝");
	}
}
