package com.lhj.oct071sdi.animal;

public class Dog {
	// 속성
	private String name;
	private int age;
	private static String barkSound = "멍"; // 객체들의 공통 속성 - static (개가 없어도 짖는소리는 알만함 ㅇㅇ)
	
	public Dog() {

	}
	
	public Dog(String name, int age) {
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
	
	public static String getBarkSound() {
		return barkSound;
	}

	public static void setBarkSound(String barkSound) {
		Dog.barkSound = barkSound;
	}

	// 액션 - 프로그램상 필요한 기능
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("후추 : " + age);
	}
	
	public static void printBarkSound() { // 개 없어도 짖는소리 쓸수 있음 -> 객체가 없어도 쓸수 있음(static 메소드)
		System.out.println(barkSound);
	}
}
