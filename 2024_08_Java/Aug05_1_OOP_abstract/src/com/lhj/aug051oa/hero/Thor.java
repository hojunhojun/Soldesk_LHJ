package com.lhj.aug051oa.hero;

public class Thor extends Avengers {

	public Thor() {
		// TODO Auto-generated constructor stub
	}
	
	public Thor(String name, int age) {
		super(name, age);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("망치");
	}
	
}
