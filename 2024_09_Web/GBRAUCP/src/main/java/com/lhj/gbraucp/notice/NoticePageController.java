package com.lhj.gbraucp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhj.gbraucp.member.MemberDAO;

@WebServlet("/NoticePageController")
public class NoticePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticePageController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.isLogined(request);
		int page = Integer.parseInt(request.getParameter("page"));
		NoticeDAO.getNdao().get(page, request);
		request.setAttribute("contentPage", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
