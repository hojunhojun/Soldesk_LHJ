package com.lhj.oct081smvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goInput() {
		return "input";
	}
	
	// request parameter 한글처리 : Get방식 -> 톰캣설정 / Post방식 : 소스로 -> web.xml에 설정
	
//	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
//	public String memberLogin(HttpServletRequest request) {
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		String n = request.getParameter("n");
//		int a = Integer.parseInt(request.getParameter("a"));
//		System.out.println(n);
//		System.out.println(a);
//		return "input";
//	}
	
	// 이걸 Spring 스타일로 해봅시다
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Human h, HttpServletRequest request) { // 이미 값 다 받아서, 형변환 다 해서 h로 만들어놓았는데 이게 의미가 있을까
		// 그러니까 설정파일을 건들자
		System.out.println(h.getN());
		System.out.println(h.getA());
		return "input";
	}
	
	
}
