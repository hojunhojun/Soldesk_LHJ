package com.lhj051jm2.main;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

// M : Back-end 개발자
//		계산을 담당하는 M이 여러개 있을 필요는 없음
//		여러개 만들면 RAM이 작살남
//		계산을 담당하는 M은 하나만 만들자
//		-> singleton
public class UnitConverter {
	private HashMap<String, String[]> units;

	private UnitConverter() {
		units = new HashMap<String, String[]>();
		units.put("cti", new String[]{"cm", "inch"});
		units.put("mtp", new String[]{"㎥", "평"});
		units.put("ctf", new String[]{"℃", "℉"});
		units.put("ktm", new String[]{"km/h", "mi/h"});
	}
	public static UnitConverter getUc() {
		return UC;
	}
	
	private static final UnitConverter UC = new UnitConverter();
	
	public String cut(double d) {
		return String.format("%.1f", d);
	}
	
	public void convert(HttpServletRequest request) {
		double n = Double.parseDouble(request.getParameter("num"));
		String u = request.getParameter("user");
		
		double result = n * 0.621371;
		if (u.equals("cti")) {
			result = n * 0.393701;
		} else if (u.equals("mtp")) {
			result = n * 0.3025;
		} else if (u.equals("ctf")) {
			result = n * 1.8 + 32;
		}
		UCResult ucr = new UCResult(n, units.get(u)[0], result,
				units.get(u)[1], u);
		
		request.setAttribute("result", ucr);
		
	}
}
