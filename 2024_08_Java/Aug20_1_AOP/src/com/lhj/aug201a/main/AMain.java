package com.lhj.aug201a.main;

import com.lhj.aug201a.human.Human;

// PP
// OOP : 리얼월드를 묘사 -> 유시보수에 용이
// AOP(Aspect Oriented Programming) -> 관점지향 프로그래밍 : 현대적인 프로그래밍 기법
//		-> 객체지향의 업그레이드 버전
//		OOP를 다른관점에서 봐서
//		공통된거를 정리함.
public class AMain {
	public static void main(String[] args) {
		Human h = new Human();
		h.goMart();
		h.goMart();
		h.goPark();
	}
}
