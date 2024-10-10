package com.lhj.sep111ct.main;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest request) {
		int a = 123123;
		request.setAttribute("a", a);
		
		String b = "12345678";
		request.setAttribute("b", b);
		
		double c = 123.45678;
		request.setAttribute("c", c);
		
		String d = "2024-09-11";
		request.setAttribute("d", d);
		
		Date e = new Date();
		request.setAttribute("e", e);
	}
}
