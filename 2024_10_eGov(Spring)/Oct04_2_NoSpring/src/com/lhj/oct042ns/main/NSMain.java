package com.lhj.oct042ns.main;

import com.lhj.oct042ns.avengers.Hulk;

// 게임회사
//		어벤져스 게임
//		튜토리얼 : 아이먼맨이 나와서 빔 쏘기
//	게임 서비스 시작
//		튜토리얼 캐릭터로 아이언맨은 손해아닌가?
//		그래서 헐크로 바꾸자

// 팀장
//	나 : 아이먼맨(빔쏘기 : 콘솔)
//	동기 : 헐크 (주먹질 : 콘솔)
public class NSMain {
	public static void main(String[] args) {
		// 1. 의사소통문제(메소드명, 변수명...)
		// 2. 유지보수(Java소스를 다 뜯어고쳐야함)
		Hulk h = new Hulk();
		h.punch();
		// Ironman im = new Ironman();
		// im.shootBeam(); // shootBeam이라는 메소드명이 마음에 안듬
	}
}
