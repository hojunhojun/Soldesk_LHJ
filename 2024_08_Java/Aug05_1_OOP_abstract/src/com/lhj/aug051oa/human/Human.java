package com.lhj.aug051oa.human;

// class 
// O : 멤버변수, 멤버상수, method, 객체 생성 / X : 추상 method

// abstract class
// O : 추상 method, 멤버변수, 멤버상수, method / X : 객체 생성

// interface ★
// O : 멤버상수, 추상 method / X : 멤버변수, 객체 생성, method
// -> 다중상속용으로 사용
public interface Human {
	// int a; // 이거안됨 (멤버변수 불가)
	static final int B = 3; // 멤버 상수는 됩니다
	
//	public void c() { // 이런 일반적인 메소드 안됨.
//		
//	}
	
	public abstract void eat(); // 추상메서드는 가능
}
