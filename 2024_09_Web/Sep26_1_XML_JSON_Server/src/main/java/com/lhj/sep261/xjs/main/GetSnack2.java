package com.lhj.sep261.xjs.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetSnack2")
public class GetSnack2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetSnack2() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		// 응답 내용이 웹사이트x, JSON
		response.addHeader("Content-Type", "application/json;charset=utf-8");
		String snacks = SnackDAO.getSnack3(request);

		PrintWriter pw = response.getWriter(); // 응답용 빨대
		pw.print(snacks);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
