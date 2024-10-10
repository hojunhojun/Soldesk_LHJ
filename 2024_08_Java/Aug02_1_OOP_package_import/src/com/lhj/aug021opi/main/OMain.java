// 클래스명 중복되면 안됨 -> 중복안되게 잘 짓자 x(자바의 공유하는 문화때문에 불가능)
package com.lhj.aug021opi.main;

import com.lhj.aug021opi.product.Handphone;
import com.lhj.aug021opi.product.Scanner;
import com.lhj.aug021opi.product.Snack;

public class OMain {
	public static void main(String[] args) {
		Snack s1 = new Snack("새우깡", 2000, "내일");
		s1.printInfo();
		System.out.println("----------");
		Handphone p1 = new Handphone("갤S23", 500000, "안드로이드");
		s1.printInfo();
		System.out.println("----------");
		Scanner sc1 = new Scanner("캐논123", 600000);
		s1.printInfo();
		System.out.println("----------");
		java.util.Scanner ci = new java.util.Scanner(System.in);
		System.out.print("이름 : ");
		String user = ci.next();
		System.out.println("당신의 이름은 : " + user);
	}
}
