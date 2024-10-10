package com.lhj.aug291s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output() {
        super();
    }
    
    // request parameter가 주소에 박힘 -> 인터넷 주소에는 한글이 들어가면 안됨 -> url인코딩형태로 바꿔서 넣어야함
    //	ㅋ -> %2A(URL인코딩)
    //	ㅋ -인코딩-> %2A
    //	%2A -디코딩-> ㅋ : 이 작업은 Tomcat이 자동으로 해버림(iso-8859-1)...? -> Tomcat설정 변경해야.. -> servers -> server.xml가서 설정변경 하고옵시다..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr"); // get방식에는 request.setCharacterEncoding 필요없음
		
		PrintWriter pw = response.getWriter();
		int a = Integer.parseInt(request.getParameter("a"));
		String name = request.getParameter("name");
		
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<h1>%d</h1>", a);
		pw.printf("<h1>%s</h1>", name);
		pw.println("</body></html>");
	}
	
	// request parameter가 주소에 표현되지 않음(내부적으로 전달) -> 보안성이 상대적으로 우수함
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter pw = response.getWriter();
		
		int a = Integer.parseInt(request.getParameter("a"));
		String name = request.getParameter("name");
		
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<h1>포스트</h1>");
		pw.printf("<h1>%d</h1>", a);
		pw.printf("<h1>%s</h1>", name);
		pw.println("</body></html>");
	}

}
