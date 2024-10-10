package com.lhj.gbraucp.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhj.gbraucp.member.MemberDAO;

@WebServlet("/NoticeWriteController")
public class NoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 글쓰러 가기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 안해도 게시판
		if (MemberDAO.isLogined(request)) {
			request.setAttribute("contentPage", "notice/write.jsp");
		} else {
			NoticeDAO.getNdao().get(1, request); // 게시판 나오게
			request.setAttribute("contentPage", "notice/notice.jsp");			
		}
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.isLogined(request)) {
			NoticeDAO.getNdao().write(request);
		}
		NoticeDAO.getNdao().clearSearch(request);
		NoticeDAO.getNdao().get(1, request); // 게시판 나오게
		request.setAttribute("contentPage", "notice/notice.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
