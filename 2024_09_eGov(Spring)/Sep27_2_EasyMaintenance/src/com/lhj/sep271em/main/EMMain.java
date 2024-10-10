package com.lhj.sep271em.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

// 포인트 적립율을 바꿀때 어떻게 용이하고 편하게 할까(유지보수 용이)
//		소스정리, OOP, AOP
//		-> 더 나은 방법 : 유지보수를 안하게
//			java소스에 뭐 해놓으면 --컴파일--> 기계어 -> 수정이 어려움
//			java가 아니게 해볼까...?
//			수정당할만한 부분은 외부파일에 써놓고, java에서 불러오게

// 유지보수하기 좋게 프로그램 개발 : 개발때는 더 오래걸림

// 기계어 압축 : .jar(소스 못봄) -> 이해가 안됨

// 유지보수하기 좋은 프로그램 만들게 해주는 framework
// library : 프로그램 개발을 하기 위해 필요한 기능을 모아놓은 소프트웨어
// framework : library + 자체 툴
// spring.jar
// mybatis.jar
// maven

// 1% -> 0.5%로
// 		고객이 메모장 가서 수정만하면됨
public class EMMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("물건 가격 : ");
		int price = sc.nextInt();
		System.out.println("---------------");
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\1134h\\Desktop\\mart2\\point.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			
			String t = br.readLine();
			
			double point = price * Double.parseDouble(t);
			System.out.printf("적립되는 포인트 : %.0f\n", point);
		} catch (Exception e) {	

		}
		try {br.close();} catch (Exception e) {e.printStackTrace();}
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
