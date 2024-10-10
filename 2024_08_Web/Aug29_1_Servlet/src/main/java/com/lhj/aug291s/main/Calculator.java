package com.lhj.aug291s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Calculator() {
        super();
    }
    
    // http://주소:포트/폴더명/.../파일명?변수명=값&변수명=값&...
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<table border=\"1\">");
		pw.printf("<tr><td> %d + %d = %d </td></tr>", x, y, x + y);
		pw.printf("<tr><td> %d - %d = %d </td></tr>", x, y, x - y);
		pw.printf("<tr><td> %d * %d = %d </td></tr>", x, y, x * y);
		pw.printf("<tr><td> %d / %d = %d </td></tr>", x, y, x / y);
		pw.println("</table>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
