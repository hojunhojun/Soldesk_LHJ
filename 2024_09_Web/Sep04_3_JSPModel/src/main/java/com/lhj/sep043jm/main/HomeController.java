package com.lhj.sep043jm.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C : 상황판단해서 흐름제어, 사이트 전체의 진입점
//		웹 환경에서 상황판단 : 요청 구분
//		요청 처리 가능한게 Servlet or JSP
//		JSP는 GET/POST 구별이 불가능
//		-> JSP Model 2 프로젝트에서 C는 Servlet
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {

    }
    
    // 첫 접속은 GET방식 요청임.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("input.html").forward(request, response); // 첫 접속과 동시에 입력 페이지로
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.calculate(request); // 계산 하기
		request.getRequestDispatcher("output.jsp").forward(request, response);; // 결과 출력창으로 보내기
	}
	
}
