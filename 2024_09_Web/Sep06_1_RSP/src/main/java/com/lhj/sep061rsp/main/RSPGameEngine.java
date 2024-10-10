package com.lhj.sep061rsp.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	private Random core;
	private int uh;
	private int ch;
	private int win;
	private int draw;
	private int lose;
	
	private RSPGameEngine() {
		core = new Random();
	}
	
	private final static RSPGameEngine RGE = new RSPGameEngine();
	
	public static RSPGameEngine getRge() {
		return RGE;
	}
	
	public void start(HttpServletRequest request) {
		request.setAttribute("userHand", "start.gif");
		request.setAttribute("comHand", "start.gif");
	}
	
	
	public void play(HttpServletRequest request) {
		uh = Integer.parseInt(request.getParameter("hand"));
		ch = core.nextInt(3) + 1;
		request.setAttribute("userHand", uh+".png");
		request.setAttribute("comHand", ch+".png");
	}
	
	public void judge(HttpServletRequest request) {
		int t = uh - ch;
		if (t == 0) {
			request.setAttribute("result", "무");
			draw++;
		} else if (t == -1 || t == 2) {
			request.setAttribute("result", "패");
			lose++;
		} else {
			request.setAttribute("result", "승");
			win++;
		}
		request.setAttribute("draw", draw);
		request.setAttribute("lose", lose);
		request.setAttribute("win", win);
	}
}