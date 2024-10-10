package com.lhj.aug205dbt.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.lhj.aug205dbt.product.Product;

// V
public class ConsoleScreen {
	private Scanner inputSystem;
	
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public String getSearchWord() {
		System.out.print("품명 : ");
		return inputSystem.next();
	}
	
	public void print(ArrayList<Product> products) {
		for (Product product : products) {
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}
	}

	public void close() {
		inputSystem.close();
	}
}
