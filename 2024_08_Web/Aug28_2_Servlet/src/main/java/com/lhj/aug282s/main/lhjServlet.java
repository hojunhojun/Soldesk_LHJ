package com.lhj.aug282s.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 원래 서블릿 만들면 tomcat에 수동 등록해야함
@WebServlet("/lhjServlet")
public class lhjServlet extends HttpServlet {
	// HttpServlet의 기능 다 물려받아오고, 추가로 뭐 넣는 lhjServlet
	// 		기능 : 요청받으면 HTML + CSS를 만들어 응답하는 Java프로그램
	// 		WAS에서만 실행됨
	
	// 협업하면서 버전표시하라고 변수하나 만들어준거 - 별 필요 없음
	private static final long serialVersionUID = 1L;
       
    
    public lhjServlet() { // 생성자 : 쓸일이 거의 없을듯?
        super();
        // TODO Auto-generated constructor stub
    }
    
    // HTTP통신 : 요청(Get방식요청, Post방식 요청) - 응답
    
    //	Event-driven Programming
    //		1) Where is main? : Tomcat에 있슴다 ㅎㅎ
    //		2) 실행하면 Tomcat이 lhjServlet객체를 만듦
    // 		3) 이벤트루프돌다가 

    // 		4-1) 클라이언트로부터 Get방식 요청받으면 Tomcat이 여기 호출
    //			주소를 직접 타이핑해서 접속
    //			<a>로 접속(Get방식 요청 날리기)
    //			기본적으로 Get방식을 사용함
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 랜선에 붙어잇는 서-> 클 응답용 빨대 : PrintWriter
		// OutputStreamWriter개조, 기능추가
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.println("<marquee>hi</marquee>");
		pw.println("</body></html>");
	}

    // 		4-2) 클라이온트로부터 Post방식 요청받으면 Tomcat이 여기 호출
    //			특수한 상황에서만 POST방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
