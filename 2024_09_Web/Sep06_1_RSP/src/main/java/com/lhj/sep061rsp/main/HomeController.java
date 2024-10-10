package com.lhj.sep061rsp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			RSPGameEngine.getRge().start(request);
		} else {
			RSPGameEngine.getRge().play(request);
			RSPGameEngine.getRge().judge(request);
		}
		request.getRequestDispatcher("RSP.jsp").forward(request, response);
	}
}
