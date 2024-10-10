package com.lhj.aug023oe.shop.main;

import java.util.Scanner;

import com.lhj.aug023oe.shop.coffee.Coffee;
import com.lhj.aug023oe.shop.computer.Notebook;

public class OMain {
	
	public static void main(String[] args) {
		Notebook note = new Notebook("i5-1234", 16, 500, 3);
		note.printInfo();
		System.out.println("----------");
		
		Coffee co1 = new Coffee("아메리카노", 4000);
		co1.printInfo();
		System.out.println("----------");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 가격 : ");
//		co1.price = sc.nextInt() // -> 직접 접근 불가하니까
		co1.setPrice(sc.nextInt()); // -> 통로를 통해서만 접근하시오 set = 값 설정
		co1.printInfo();
	}
}