package com.lhj.aug024opp.factory;

public class Truck extends Car {
	
	protected Truck() {
		super();
	}

	@Override
	public void test() {
		super.test();
		System.out.println("근데 트럭");
	}
}
