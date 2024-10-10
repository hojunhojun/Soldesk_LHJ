package com.lhj.sep113db.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductRegController")
public class ProductRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// 등록하러가기 버튼 눌렀을때
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("product/reg.jsp").forward(request, response);
	}

	// 등록하기 버튼 눌렀을때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO.getPdao().reg(request);
		ProductDAO.getPdao().get(1, request);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
