package com.lhj.aug211jl.company;

public class Company {
	private String name;
	private String addr;
	private int emp;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String addr, int emp) {
		super();
		this.name = name;
		this.addr = addr;
		this.emp = emp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getEmp() {
		return emp;
	}

	public void setEmp(int emp) {
		this.emp = emp;
	}
	
	
}
