package com.lhj051jm2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C : 흐름 제어 (PL급 개발자)
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {

    }
    
    // 첫 접속 = Get -> request parameter 없이 접속함
    // 변환하기 = Get -> request parameter 생김
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) { // 첫접속
			request.getRequestDispatcher("input.html").forward(request, response);
		} else { // 변환 버튼 눌렀을떄 (값 변환 했을때)
			UnitConverter.getUc().convert(request);
			request.getRequestDispatcher("output.jsp").forward(request, response);
		}		
	}
}
