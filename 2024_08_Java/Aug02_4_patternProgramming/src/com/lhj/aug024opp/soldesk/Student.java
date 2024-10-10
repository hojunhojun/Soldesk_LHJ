package com.lhj.aug024opp.soldesk;

// 객체가 필요하긴 한가?
//		필요없음(멤버변수x) : static 메소드 기반
//		필요함(멤버변수o)
//			객체가 딱 1개만있으면됨 : singleton패턴
//			객체가 여러개 : factory패턴
//						작정하고 여러개 만드는데 그와중에 뭔가 자동화된거
public class Student {
	private int num = 0;
	private String name;
	private int age;
	
	// 1) 생성자를 protected(1-1) or 공백(1-2) : 다른 패키지에서 못만들게
	// 2) 같은 패키지에 factory역할을 할 클래스를 추가 -> LeeSangwoo.java 클래스로 이동
	// 1-1)
	Student() {

	}
	
	// 1-2)
	protected Student(int num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
