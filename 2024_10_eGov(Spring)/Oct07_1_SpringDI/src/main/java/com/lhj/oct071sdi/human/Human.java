package com.lhj.oct071sdi.human;

import java.util.ArrayList;
import java.util.HashMap;

import com.lhj.oct071sdi.animal.Dog;

public class Human {
	// 기본형급
	private String name;
	private int age;
	
	// 객체급
	private Dog pet;
	
	// 컬렉션급
	private String[] family; // [] : 배열
	private ArrayList<String> nickname; // <> : 가변사이즈 배열
	private HashMap<String, Double> stat;
	
	public Human() {

	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("생성자");
	}
	
	public Human(String name, int age, Dog pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public Human(String name, int age, Dog pet, String[] family, ArrayList<String> nickname,
			HashMap<String, Double> stat) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
		this.family = family;
		this.nickname = nickname;
		this.stat = stat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("세터");
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
		System.out.println("세터");
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}
	
	public String[] getFamily() {
		return family;
	}

	public void setFamily(String[] family) {
		this.family = family;
	}

	public ArrayList<String> getNickname() {
		return nickname;
	}

	public void setNickname(ArrayList<String> nickname) {
		this.nickname = nickname;
	}

	public HashMap<String, Double> getStat() {
		return stat;
	}

	public void setStat(HashMap<String, Double> stat) {
		this.stat = stat;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
