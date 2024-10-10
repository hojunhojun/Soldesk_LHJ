package com.lhj.sep121jn.second;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// request parameter
//		V에서 만들어진 값
//		request 소속
//		String or String[]
//		Java : request.getParameter("파라메터변수명")
//		EL : ${param.파라메터변수명}
//	request attribute
//		M에서 만들어진 값
//		request 소속
//		Object
//		Java : request.getAttribute("어트리뷰트명")
//		EL : ${어트리뷰트명}
//	session attribute
//		M에서 만들어진 값
//		session(서버-사용자 연결) 소속
//		서버-사용자 연결이 끊어지지만 않으면 어디서든 사용가능
//		끊어지는거 : 브라우저 닫으면, session 유지시간(기본 30분) 넘어가면
//									설정시간동안 요청을 하면 갱신
//		사용자 개인의 공간
//		Object
//		Java : req.getSession().getAttribute("어트리뷰트명")
//		EL :${sessionScope.어트뷰트명}
// cookie
//		M에서 만들어진 값
//		사용자 컴퓨터에서 파일형태로
//			파일 : 재부팅해도 살아있으니 -> 보안상 위험(요즘은 암호화)
//		String
//		Java : ThirdM 참조
//		EL : ${cookie.이름.value}
public class SecondM {
	public static void test(HttpServletRequest request, HttpServletResponse response) {
		
		//////////////////////////////////////
		String aa = request.getParameter("a");
		int aaa = Integer.parseInt(aa);
		System.out.println(aaa);
		
		int bb = 100;
		request.setAttribute("b", bb);
		
		Object bbb = request.getAttribute("b");
		int bbbb = (Integer) bbb;
		System.out.println(bbbb);
		
		int cc = 200;
		HttpSession hs = request.getSession();
		hs.setMaxInactiveInterval(60);   // session 유지시간
		hs.setAttribute("c", cc);
		
		int dd = 300;
		String ddd = dd + "";
		Cookie dddd = new Cookie("d", ddd);
		dddd.setMaxAge(60 * 60 * 24); // 쿠키유지시간
		response.addCookie(dddd);
	}
}
