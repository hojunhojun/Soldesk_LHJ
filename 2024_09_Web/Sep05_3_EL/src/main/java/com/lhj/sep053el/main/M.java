package com.lhj.sep053el.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void makeData(HttpServletRequest request) {
		String c = "ㅋ";
		request.setAttribute("cc", c);
		
		double d = 123.3768;
		request.setAttribute("dd", d);
		
		Dog e = new Dog("후추", 3);
		request.setAttribute("ee", e);
		
		// 컬렉션
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog("소금", 1));
		dogs.add(new Dog("설탕", 2));
		request.setAttribute("ff", dogs);
	}
}