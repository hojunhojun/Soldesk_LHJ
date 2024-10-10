package com.lhj.sep121jn.third;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ThirdM {
	public static void test(HttpServletRequest request) {
		Object ccc = request.getSession().getAttribute("c");
		int cccc = (Integer) ccc;
		System.out.println(cccc);
		
		// 현재 사용자의 PC에 만들어져있는 쿠키들
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("d")) {
				System.out.println(cookie.getValue());
			}
		}
	}
}
