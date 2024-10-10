package com.lhj.oct071sdi.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhj.oct071sdi.animal.Dog;
import com.lhj.oct071sdi.human.Human;

// 기본적으로 멤버변수, 메소드 써서 클래스
// static 완벽하게 이해했는지
// 생성자 - 객체 생성해주는 도구
// has a
// is a
// package, import
// 접근제어자
// 캡슐화
// -------------------Java특유의 객체 생성 가능
public class SDIMain {
	public static void main(String[] args) {
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("oct071beans.xml"); // 객체 미리 만들고 시작
		aac.registerShutdownHook();
		
		System.out.println("------");

		// 이걸 유지보수 당해? 안당해?
		// 오늘 날짜(2024/10/07) 형태로 -> 나중에 출력형식 바꾸기 편하게
		Date now = new Date();
		SimpleDateFormat sdf = aac.getBean("sdf", SimpleDateFormat.class);
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		System.out.println("------");
		Human hhh1 = aac.getBean("h1", Human.class);
		hhh1.printInfo();
		System.out.println("------");
		
		Human hhh2 = aac.getBean("h2", Human.class);
		hhh2.printInfo();
		System.out.println("------");
		
		// 내가 하는 모든작업 다 설명가능
		// 이름이 후추, 나이가 3살인, sattic멤버변수 써먹을만한거 개
		// 정보출력
		Dog d2 = aac.getBean("d1", Dog.class);
		d2.printInfo();
		Dog.printBarkSound();
		System.out.println("------");
		
		Human hhh3 = aac.getBean("h3", Human.class);
		hhh3.printInfo();
		hhh3.getPet().printInfo();
		System.out.println("------");
		
		Human hhh4 = aac.getBean("h4", Human.class);
		String[] family = hhh4.getFamily();
		for (String f : family) {
			System.out.println(f);
		}
		ArrayList<String> nickname = hhh4.getNickname();
		for (String n : nickname) {
			System.out.println(n);
		}
		HashMap<String, Double> stat = hhh4.getStat();
		System.out.println(stat.get("키"));
		System.out.println(stat.get("몸무게"));
		System.out.println("------");
		
		aac.close();
	}
}
