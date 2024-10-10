package com.lhj.aug023oe.shop.computer;

public class Notebook extends Computer {
	private double weight;
	
	public Notebook() {
		
	}

	
	public Notebook(String cpu, int ram, int hdd, double weight) {
		super(cpu, ram, hdd);
		this.weight = weight;
	}


	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("무게 : " + weight + "KG");
		System.out.println("CPU : " + this.getCpu());
		System.out.println("RAM : " + getRam());
		// private는 상속이 안됨 - x
		// cpu : 원래 computer거
		// private : 외부에서 못쓰는거
		// -> notebook은 computer의 외부라서
	}
}
