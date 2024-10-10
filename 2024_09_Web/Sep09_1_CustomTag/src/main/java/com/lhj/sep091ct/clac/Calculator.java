package com.lhj.sep091ct.clac;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	public static void calcualte(HttpServletRequest request) {
		int xxx = Integer.parseInt(request.getParameter("xx"));
		int yyy = Integer.parseInt(request.getParameter("yy"));
		
		request.setAttribute("a", xxx + yyy);
		request.setAttribute("b", xxx - yyy);
		request.setAttribute("c", xxx * yyy);
		request.setAttribute("d", xxx / yyy);
	}
}
