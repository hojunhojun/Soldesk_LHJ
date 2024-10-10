package com.lhj.aug023oe.shop.computer;

public class Computer {
	// 1) 멤버변수[100% 타이핑]
	private String cpu;
	private int ram;
	private int hdd;
	
	// 2) 생성자시리즈
	// 2-1) 기본생성자[Ctrl + space]
	public Computer() {

	}
	
	// 2-2) 오버로딩된 생성자[ctrl + shift + a]
	public Computer(String cpu, int ram, int hdd) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}

	// 3) getter, setter[ctrl + shift + s]
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	
	// 4) 기타 method
	public void printInfo() {
		System.out.println("CPU : " + cpu);
		System.out.println("RAM : " + ram + "GB");
		System.out.println("HDD : " + hdd + "GB");
	}
}
