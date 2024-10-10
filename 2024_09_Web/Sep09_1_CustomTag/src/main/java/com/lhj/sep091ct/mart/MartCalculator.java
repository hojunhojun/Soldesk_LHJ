package com.lhj.sep091ct.mart;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

public class MartCalculator {
	public static void calculate(HttpServletRequest request) {
		String martInput = request.getParameter("martInput");
		int sum = 0;
		StringTokenizer st = new StringTokenizer(martInput, "\r\n");
		while (st.hasMoreTokens()) {
			try {
				sum += Integer.parseInt(st.nextToken());
			} catch (Exception e) {

			}
			request.setAttribute("mtotal", sum);
		}
	}
}
