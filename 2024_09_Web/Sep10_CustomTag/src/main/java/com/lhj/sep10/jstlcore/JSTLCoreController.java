package com.lhj.sep10.jstlcore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JSTLCoreController")
public class JSTLCoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "jstlcore/input.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RandomGenerator.getRg().getRandom(request);
		request.setAttribute("contentPage", "jstlcore/output.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

}
