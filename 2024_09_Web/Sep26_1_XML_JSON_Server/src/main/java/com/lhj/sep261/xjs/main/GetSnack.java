package com.lhj.sep261.xjs.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//전통 웹개발 : 전통적인 회사 큰회사 정부회사
//		JSP/Spring/SprinBoot로 대부분 작업 8
//		JavaScript로 유효성검사, 이동, 효과 2
// 새로운 스타일 : 스타트업, 신기술좋아하는회사
//		JSP/Spring/SpringBoot로 XML/JSON 2
//		React/Vue로 대부분 작업 8
@WebServlet("/GetSnack")
public class GetSnack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetSnack() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String snacks = SnackDAO.getSnack2(request);

		// 응답용 빨대
		PrintWriter pw = response.getWriter();
		pw.print(snacks);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
