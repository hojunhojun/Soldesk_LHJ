package com.lhj.sep271bm.main;

import java.util.Scanner;

// .java(소스) -컴파일-> 	.class(기계어)
// .class	  -압축--->	.jar(최종산출물)
// 1% -> 0.5%로 바꾸려면
//		마트사장님이 개발자에게 바꿔달라고 연락해야함(퇴사해서 없으면?)
//		개발자가 .java 수정 후에 위 작업을 똑같이 다시 ... -> .jar만들어서 전달
//		근데 또 바꾸라면? 너무 비효율적인데..
//		포인트 적립율 바꿀때마다 반복해야함....
//		이걸 안하는게 Spring의 유지보수임 !!!

// 포인트 적립율 1%
public class BMmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("물건 가격 : ");
		int price = sc.nextInt();
		System.out.println("---------------");
		
		double point = price * 0.01;
		System.out.printf("적립되는 포인트 : %.0f\n", point);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
