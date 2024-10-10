package com.lhj.aug20pp.main;

import java.util.Scanner;

public class ConsoleScreen {
	private Scanner InputSystem;
	public ConsoleScreen() {
		InputSystem = new Scanner(System.in);
	}
	
	public Product getProduct() {
		System.out.print("품명 : ");
		String name = InputSystem.next();
		
		System.out.print("가격 : ");
		int price = InputSystem.nextInt();
		
		Product p = new Product(0, name, price);
		
		return p;
	}
	
	public void close() {
		InputSystem.close();
	}
}
