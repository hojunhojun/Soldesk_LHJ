package com.lhj.sep043jm.main;

import javax.servlet.http.HttpServletRequest;

// M : 실제 계산
//		순수 java 클래스 (계산만 진행하는데 나머지 기능은 필요없음 ㅋㅋ)
public class Calculator {
	public static void calculate(HttpServletRequest request) { // request 요청 넣게끔 하기
		int xxx = Integer.parseInt(request.getParameter("xx")); // 값 받아오기
		int yyy = Integer.parseInt(request.getParameter("yy")); // 값 받아오기
		request.setAttribute("zzz", xxx + yyy);					// 보내기
		
	}	
}
