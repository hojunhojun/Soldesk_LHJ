package com.lhj.sep054ud.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

// 자바 콘솔 프로그램 	-> 정답 나오면 끝
// 웹 				-> 정답 나오면 다시 뽑기	

// M : Singleton
public class upDownGameEngine {
	private Random core;
	private int gameAns;
	private int turn;
	
	private upDownGameEngine() {
		core = new Random();
	}
	
	private final static upDownGameEngine udge = new upDownGameEngine(); 
	
	public static upDownGameEngine getUdge() {
		return udge;
	}
	
	public int getRan() {
		turn = 0;
		gameAns = core.nextInt(10000) + 1;
		return gameAns;
	}
	
	public void judge(HttpServletRequest request) {
		turn++;
		int no = Integer.parseInt(request.getParameter("no"));
			if (no == gameAns) {
				request.setAttribute("result", turn + "턴 만에정답");
				getRan();
			} else if (no > gameAns) {
				request.setAttribute("result", "Down");
			} else {
				request.setAttribute("result", "UP");
			}			
	}
}
