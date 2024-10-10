package com.lhj.oct083bc;

import java.net.URLEncoder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Doctor {
	private String sik;
	private ScriptEngine se;

	public Doctor() {
	}

	public Doctor(String sik) {
		super();
		this.sik = sik;
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}
	
	public void calculate(Guest g, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/imggg");
			MultipartRequest mr = new MultipartRequest(
					request, 
					path, 							
					20 * 1024 * 1024,				
					"utf-8",						
					new DefaultFileRenamePolicy()	
				);
			
			g.setN(mr.getParameter("n"));
			double h = Double.parseDouble(mr.getParameter("h"));
			g.setH(h);
			double w = Double.parseDouble(mr.getParameter("w"));
			g.setW(w);
			
			String p = mr.getFilesystemName("photo");
			String p2 = URLEncoder.encode(p, "utf-8"); // 인코딩 ㄱㄱ
			p2 = p2.replace("+", " ");
			
			
			sik = sik.replace("w", g.getW() + "");
			sik = sik.replace("h", (g.getH() / 100) + "");
			Double bmi = (Double) se.eval(sik);

			String result = "저체중";
			if (bmi >= 39) {
				result = "고도비만";
			} else if (bmi >= 32) {
				result = "중도비만";
			} else if (bmi >= 30) {
				result = "경도비만";
			} else if (bmi >= 24) {
				result = "과제충";
			} else if (bmi >= 10) {
				result = "정상";
			}
			g.setBmi(bmi);
			g.setResult(result);
			g.setPhoto(p2);
			request.setAttribute("g", g);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
