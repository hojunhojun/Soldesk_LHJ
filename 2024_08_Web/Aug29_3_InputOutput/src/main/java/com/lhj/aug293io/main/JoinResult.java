package com.lhj.aug293io.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinResult")
public class JoinResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinResult() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("ID : <h2>%s</h2>", id);
		pw.println("</body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		String pwo = request.getParameter("pw");
		String gen = request.getParameter("gender");
		String adr = request.getParameter("addr");
		String[] hob = request.getParameterValues("hobby"); // CheckBox의 경우
		String intro = request.getParameter("introduce");
		intro = intro.replace("\r\n", "<br>");
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("ID : <h2>%s</h2>", id);
		pw.printf("Password : <h2>%s</h2>", pwo);
		pw.printf("Gender : <h2>%s</h2>", gen);
		pw.printf("Address : <h2>%s</h2>", adr);
		pw.print("Hobby : ");
		// 체크박스 쓰려면 post방식을 씁시다.(Get으로는 애매함ㅡ.ㅡ)
		if (hob != null) {
			for (String s : hob) {
				pw.printf("<h2>%s</h2>", s);
			}
		}
		// textarea에서 엔터치면 : \r\n
		// html에서 줄바꿈 : <br>
		// 입력한거를 java쪽 or textarea에서 쓸거면 그냥두고
		// 웹에서 쓸거면 \r\n -> <br>로 바꿔줘야함
		pw.printf("Itroduce : <h2>%s</h2>", intro);
		pw.println("</body></html>");
	}

}
