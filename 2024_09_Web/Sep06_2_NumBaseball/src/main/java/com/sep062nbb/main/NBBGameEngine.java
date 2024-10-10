package com.sep062nbb.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBBGameEngine {
	private Random core;
	private String gameAns;
	private int turn;
	
	private static final NBBGameEngine NBGE = new NBBGameEngine();

	public NBBGameEngine() {
		core = new Random();
	}

	public static NBBGameEngine getNbge() {
		return NBGE;
	}

	public void pickAns() {
		turn = 0;
		int t = core.nextInt(976) + 12; // 12 ~ 987
		gameAns = String.format("%03d", t); // "012" ~ "987"
		if (gameAns.charAt(0) == gameAns.charAt(1) 
		   || gameAns.charAt(1) == gameAns.charAt(2)
		   || gameAns.charAt(0) == gameAns.charAt(2)) {
			pickAns();
		}
	}

	public void judge(HttpServletRequest request) {
		turn++;
		String userAns = request.getParameter("input");
		System.out.println(gameAns);
		System.out.println(userAns);
		int strike = 0, ball = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (userAns.charAt(i) == gameAns.charAt(j)) {
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
					break;
				}
			}
		}
	request.setAttribute("strike", strike);
	request.setAttribute("ball", ball);
	request.setAttribute("turn", turn);
	if (strike == 3) {
		pickAns();
	}
	
	}

}
