package com.lhj.aug301fu.main;

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

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Output() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	// 파일 업로드 처리 구현완료
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
//		request.setCharacterEncoding("euc-kr");
		
		// 이클립스랑 연동된 복사본 톰캣 위치
		//	-> 워크스페이스\.metadata\.plugins\.otg.eclipse.wst.server.core\tmp0\wtpwebapps\프로젝트폴더\최종폴더
		
		// 상대경로를 -> 서버상의 절대경로를 리턴해주는 메서드가 있음 ㅇㅇ
		String path = request.getSession().getServletContext().getRealPath("imggg");
		
		// 인코딩 방식 톰캣 -> cos.jar으로 바뀌었으니
		// 디코딩 방식도 바뀌는게 당연
		MultipartRequest mr = new MultipartRequest(
			request, 
			path, 							// 파일이 업로드될 폴더 절대경로
			20 * 1024 * 1024,				// 파일의 최대 크기(byte 단위)
			"euc-kr",						// 요청 파라메터 인코딩 방식
			new DefaultFileRenamePolicy()	// 파일명 중복처리	
		);
		
//		String title = request.getParameter("title");
		
		
		// 파일명 중복정책때문에 바뀌어있을 실제 파일명
		// 톰캣이 한글로된 파일명 인식을 못함 ㅋㅋ
		// 근데 인코딩할때 띄어쓰기가있으면 +가 됨
		// 근데 띄어쓰기는 +로 바꾸지말고 그대로 띄어쓰기여야함 그래야 인식함
		String p = mr.getFilesystemName("photo");
		String p2 = URLEncoder.encode(p, "euc-kr"); // 인코딩 ㄱㄱ
		p2 = p2.replace("+", " "); // 띄어쓰기처리 ㄱㄱ
		
		String title = mr.getParameter("title");
		
		String zip = URLEncoder.encode(mr.getFilesystemName("zippp"), "euc-kr").replace("+", " ");

		PrintWriter pw = response.getWriter();
		
		pw.println("<html><head>");
		pw.println("<meta charset=\"euc-kr\">");
		pw.println("</head><body>");
		pw.printf("<h2>제목 : %s</h2>", title);
		pw.printf("<h2>파일명 : %s</h2>", p);
		pw.printf("<img src=\"imggg/%s\">", p2);
		pw.print("<hr>");
		pw.printf("<a href=\"imggg/%s\">다운받기</a>", zip);
		pw.println("</body></html>");
	}

}
