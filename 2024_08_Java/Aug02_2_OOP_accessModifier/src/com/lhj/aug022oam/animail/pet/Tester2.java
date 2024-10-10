package com.lhj.aug022oam.animail.pet;

// Tester랑 Cat의 관계 : 아무관계 X
// 패키지 다름, 상속 없음
public class Tester2 extends Cat{
	public void test() {
		Cat c = new Cat();
		c.a = 1; // public이라 됨
		c.b = 2; // protected는 상속X지만 패키지 같아서 가능
		c.c = 3; // default는 패키지 같아서 가능
		c.d = 4; // private라 불가
	}
}
