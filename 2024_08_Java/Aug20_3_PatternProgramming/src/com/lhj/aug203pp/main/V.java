package com.lhj.aug203pp.main;

import java.util.Scanner;

// V
// 사용자 눈에 보이는 입력받고 출력하는 기능
// Front-end개발자, 디자이너

// 현시점에서 V는 콘솔창
// System.in : 콘솔창 -> 프로그램 빨대(InputStream)
// Scanner : InutStream 서포터
public class V {
	private Scanner inputSystem;
	
	public V() {
		inputSystem = new Scanner(System.in);
	}
	
	public int getX() {
		System.out.print("X : ");
		return inputSystem.nextInt();
	}
	public int getY() {
		System.out.print("Y : ");
		return inputSystem.nextInt();
	}
	
	public void end() {
		inputSystem.close();
	}
	
	public void print(int z) {
		System.out.println(z);
	}
}
