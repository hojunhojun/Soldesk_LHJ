package com.lhj.sep031j.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/output")
public class output extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public output() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		int xxx = Integer.parseInt(request.getParameter("xx"));
		int yyy = Integer.parseInt(request.getParameter("yy"));
		int bigger = (xxx > yyy) ? xxx : yyy;
		int smaller = (xxx > yyy) ? yyy : xxx;
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.print("더 큰수는");
		pw.printf("<h1>%d</h1><p>", bigger);
		pw.print("더 작은수는");
		pw.printf("<h1>%d</h1><p>", smaller);
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
