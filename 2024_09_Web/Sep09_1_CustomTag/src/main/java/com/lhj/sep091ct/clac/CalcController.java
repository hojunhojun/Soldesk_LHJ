package com.lhj.sep091ct.clac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcController")
//	import 당하면 패키지명은 안쓰니까 Controller이름은 구별해야함
// 	하지만 .jsp는 폴더명을 쓰게되니 ㄱㅊ음
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPageee", "calc/input.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calculator.calcualte(request);
		request.setAttribute("contentPageee", "calc/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
