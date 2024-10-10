package com.lhj.aug302vc.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// 유효성 검사를 굳이 하는거보단 애초에 잘못되었으면 안넘어오게 하자
@WebServlet("/O")
public class O extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public O() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");

		MultipartRequest mr = new MultipartRequest(				
			request, 
			request.getSession().getServletContext().getRealPath("imggg"), 							// 파일이 업로드될 폴더 절대경로
			10485670,				// 파일의 최대 크기(byte 단위)
			"euc-kr",						// 요청 파라메터 인코딩 방식
			new DefaultFileRenamePolicy()	// 파일명 중복처리	
		);
		
		String p2 = URLEncoder.encode(mr.getFilesystemName("photo"), "euc-kr").replace("+", " "); // 인코딩 ㄱㄱ
		
		int w = Integer.parseInt(mr.getParameter("width"));
		int h = Integer.parseInt(mr.getParameter("height"));
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<img src=\"imggg/%s\" width=\"%s\" height=\"%s\">", p2, w, h);
		pw.println("</body></html>");
	}

}
