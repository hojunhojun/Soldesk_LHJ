package com.lhj.oct083bc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP
//		1) request.getParameter("이름")
//		2) 형변환
//		3) JavaBean객체로
// 파일업로드
// 		mr.getParameter("이름")
// Spring
//		1 ~ 3을 자동으로 해서 g
//		파일업로드때는 g에 아무것도 없음.. (자동이 아님)
//		걍 JSP에서 하던대로 ㄱㄱ
@Controller
public class HomeController {
	
	@Autowired
	private Doctor d;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goInput() {
		return "input";
	}
	
	@RequestMapping(value = "/bmi.calculate", method = RequestMethod.POST)
	public String bmiCalculate(Guest g, HttpServletRequest request) {
		d.calculate(g, request);
		return "output";
	}
	
}
