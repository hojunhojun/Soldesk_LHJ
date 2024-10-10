package com.lhj.aug022oam.animal.main;

import com.lhj.aug022oam.animail.pet.Cat;

// Tester랑 Cat의 관계 : 아무관계 X
// 패키지 다름, 상속 없음
public class Tester {
	public void test() {
		Cat c = new Cat();
		c.a = 1; // public이라 됨
		c.b = 2; // protected는 상속X, 패키지도 다름 그래서 불가
		c.c = 3; // default는 패키지가 달라서 불가
		c.d = 4; // private라 불가
	}
}
