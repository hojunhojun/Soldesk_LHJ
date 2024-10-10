package com.lhj.aug291s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanServlet")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GugudanServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버가 응답할때 쓴 인코딩방식을 클라이언트에게 알려줘야함
		// 서버				클라이언트
		// euc-kr	-전송->	??
		int g = Integer.parseInt(request.getParameter("g"));
		response.setCharacterEncoding("euc-kr");
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<table border=\"1\"><tr><th>%d단</th></tr>", g);
		for (int i = 1; i < 10; i++) {
			pw.printf("<tr><td>%d X %d = %d</td></tr>", g, i, g*i);
		}
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
