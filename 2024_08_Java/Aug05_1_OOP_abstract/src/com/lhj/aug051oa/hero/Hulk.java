package com.lhj.aug051oa.hero;

public class Hulk extends Avengers {
	private int pantsSize;
	
	public Hulk() {

	}
	
	public Hulk(String name, int age, int pantsSize) {
		super(name, age);
		this.pantsSize = pantsSize;
	}
	
	public int getPantsSize() {
		return pantsSize;
	}
	public void setPantsSize(int pantsSize) {
		this.pantsSize = pantsSize;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("바지 사이즈 : " + pantsSize);
	}
	
	@Override
	public void attack() {
		// super.attack(); // 추상메서드라 내용이 없는데 어떻게 불러오냐..
		System.out.println("주먹질");
	}
	
}
