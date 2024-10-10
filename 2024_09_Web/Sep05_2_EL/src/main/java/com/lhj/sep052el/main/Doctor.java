package com.lhj.sep052el.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Doctor {
	
	// 여러 사람이 쓰는중
	// 각 사람마다 다른거 : 숫자, 뭐를 바꾸나
	// 다 똑같은거 : path(그래봐야 램 얼마 안먹을텐데..?)
	// 걍 static ㄱㄱ
	public static void Calculate(HttpServletRequest request) {
		
		try {
			MultipartRequest mr = new MultipartRequest(request,
					request.getSession().getServletContext().getRealPath("imggg"), 10485670, "euc-kr",
					new DefaultFileRenamePolicy());
			String p = mr.getFilesystemName("photo");
			String p2 = URLEncoder.encode(p, "euc-kr"); // 인코딩 ㄱㄱ
			p2 = p2.replace("+", " ");
			
			String n = mr.getParameter("name");
			double h = Double.parseDouble(mr.getParameter("height"));
			double w = Double.parseDouble(mr.getParameter("weight"));

			double bmi = w / ((h / 100) * (h / 100));

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
			
			Guest g = new Guest(n, h, w, bmi, result, p2);
			request.setAttribute("g", g);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}