package com.lhj.gbraucp.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhj.gbraucp.member.MemberDAO;

@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안해도 게시판은 볼수있게
		// 게시판 들어갈때
		MemberDAO.isLogined(request);
		NoticeDAO.getNdao().clearSearch(request);
		NoticeDAO.getNdao().get(1, request);
		request.setAttribute("contentPage", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
	
	// 검색때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.isLogined(request); // 로그인 체크
		NoticeDAO.getNdao().search(request); // 검색
		NoticeDAO.getNdao().get(1, request); // 검색한거에서 1페이지
		request.setAttribute("contentPage", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
