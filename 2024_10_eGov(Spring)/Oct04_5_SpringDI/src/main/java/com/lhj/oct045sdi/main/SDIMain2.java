package com.lhj.oct045sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhj.oct045sdi.animal.Dog;
// Garbage Collection : Heap 영역 자동 정리 시스템
//			그 자동 발동 시점

// aac : 부르든 말든 일단 객체 만들어버림
//		-> 기존의 가비지컬렉션 시스템이 아님

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("beans.xml"); // 이때 개랑 고양이 다만들어짐
		aac.registerShutdownHook(); // aac가 없어질때, 이미 만들어져있을 객체들(개, 고양이)이 같이 정리되도록 등록
		
		System.out.println("------");
		
		Dog ddd1 = aac.getBean("d1", Dog.class);
		ddd1.printInfo();

		Dog ddd2 = aac.getBean("d1", Dog.class);
		ddd2.printInfo();
		
		aac.close(); // aac 없애기 -> registerShutdownHook발동
	}
}
