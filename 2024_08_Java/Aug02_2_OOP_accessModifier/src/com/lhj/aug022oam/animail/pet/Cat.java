package com.lhj.aug022oam.animail.pet;

public class Cat {
	String name;
	int age;
	
	public int a;
	protected int b;
	int c;
	private int d;
	
	public Cat() {

	}
	
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
}
