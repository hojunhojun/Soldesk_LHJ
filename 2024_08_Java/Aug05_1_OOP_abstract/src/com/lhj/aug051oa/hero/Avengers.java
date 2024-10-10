package com.lhj.aug051oa.hero;

// 자바의 특이점 : 생성자 상속 불가

// abstract class : 추상메소드를 하나라도 가지면 추상클래스여야함
//					형체가 없는 추상적인 개념
//					추상클래스로는 객체 생성이 불가능함.
//					추상메서드는 하위클래스에서 반드시 오버라이딩해야함
public abstract class Avengers { // abstract 붙이기
	
	private String name;
	private int age;
	
	public Avengers() {

	}
	
	public Avengers(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	// 형체가 없는 어벤져스의 공격
	// 상속 써먹으려고 만들었는데
	// 내용 어케쓸까?
	public abstract void attack(); // 추상 메서드로 만들기 : 내용없는친구[미완성]
	
}
