package com.lhj.gbraucp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.gbraucp.member.MemberDAO;
import com.lhj.gbraucp.sns.SNSDAO;

// JSP : 수작업 singleton
//			실행된다음 -> static시리즈들이 staitc영역에 (DAO가 static이었음)
//			-실행-> DAO -> 톰캣돌면서 시작 -> HomeController
// Spring : 하나 등록시켜놓고 Autowired로 갖다쓰는
//			-> Spring이 객체하나 자동으로만들었을뿐(static영역이아님)
//			-> static영역이 아니어서 먼저 실행이 아니므로 HomeController 기본생성자에서 쓸수 없음

// 자바프로그램 실행순서
//1) JVM이 OS환경에 맞게 구성되서 OS위에 올라감
//2) 기계어상태의 프로그램소스가 stack영역에 꽂힘
//3) static멤버변수가 static영역에 만들어짐
//4) JVM이 OMain.main(...)을 호출하면서 시작

// ... -실행-> static시리즈들이 static영역에 -> main실행 -> ...

// 처음 한번만 전체 갯수 세자
// -> 서비스 시작하고 최초의 요청때
@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	private boolean firstReq;
	
	public HomeController() {
		firstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest request) {
		if (firstReq) {
			sDAO.setAllPostCount();
			firstReq = false;
		}
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest request) {
		return goIndex(request);
	}
	
}
