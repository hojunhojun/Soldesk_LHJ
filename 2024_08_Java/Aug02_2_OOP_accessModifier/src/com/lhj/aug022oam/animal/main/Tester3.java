package com.lhj.aug022oam.animal.main;

import com.lhj.aug022oam.animail.pet.Cat;

// Tester랑 Cat의 관계 : 상속O / 다른 패키지
public class Tester3 extends Cat{
	public void test() {
		Cat c = new Cat();
		c.a = 1; 	// public이라 됨
		c.b = 2; 	// protected는 상속X지만 패키지 같아서 가능 -> 이라면서 상속상태인데 왜안됨?
					// (패키지가 다르면 안됨 : 버그) -> default랑 protected는 같은 녀석이 되어버림.(같은패키지에서만 작동)
		c.c = 3; 	// default는 패키지 다름 안됨
		c.d = 4; 	// private라 불가
	}
}
