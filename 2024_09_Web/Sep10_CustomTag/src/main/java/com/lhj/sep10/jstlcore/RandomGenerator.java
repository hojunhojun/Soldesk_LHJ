package com.lhj.sep10.jstlcore;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RandomGenerator {
	private Random core;
	
	private static final RandomGenerator RG = new RandomGenerator();
	public RandomGenerator() {
		core = new Random();
	}
	public static RandomGenerator getRg() {
		return RG;
	}
	
	public void getRandom(HttpServletRequest request) {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		int result = core.nextInt(end + 1 - start) + start;
		request.setAttribute("result", result);
		
		// M에서 <table>까지는...
		// V담당 디자이너가 쓰기 최대한 편한 형태로 결과 만들어주기
		ArrayList<String> gugudan = new ArrayList<String>();
		String s;
		for (int i = 1; i < 10; i++) {
			s = String.format("%d X %d = %d", result, i, result*i);
			gugudan.add(s);
		}
		request.setAttribute("gugu", gugudan);
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		snacks.add(new Snack("새우깡", 3000));
		snacks.add(new Snack("양파링", 3500));
		snacks.add(new Snack("빼빼로", 1500));
		request.setAttribute("snacks", snacks);
	}
}
