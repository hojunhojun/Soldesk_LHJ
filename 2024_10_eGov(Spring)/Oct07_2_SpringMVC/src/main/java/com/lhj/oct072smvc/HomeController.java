package com.lhj.oct072smvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP Model 2
// 주소:포트/프로젝트명/...
// C에서 실행
// C - Servlet(doGet, doPost) -> Controller가 많아짐
// 어쨌든 C는 forward시키면서 끝나는데 소스가 길어
// 마지막에 index.html만들어서 HomeController로 보내면서

// Spring MVC
// 주소:포트/패키지마지막자리/...
// 프로젝트에서 실행
// C - 일반 class(일반 메소드)
// forward 간소화

@Controller
public class HomeController {
	
	@Autowired // Spring식 singleton
	private Calculator c;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "input";
	}
	
	// 요청 파라메터 값 받기
	// 1) JSP 스타일 - request.getParameter
//	@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
//	public String xyCalculate(HttpServletRequest request) {
//		String xxx = request.getParameter("xx");
//		int xxxx = Integer.parseInt(xxx); 
//		int yyyy = Integer.parseInt(request.getParameter("yy"));
//		System.out.println(xxxx);
//		System.out.println(yyyy);
//		return "input"; 
//	}
	
	// 2) Spring 스타일 - 형변환 알아서
//	@RequestMapping(value="/xy.calcuate", method=RequestMethod.GET)
//	public String xyCalculate(@RequestParam(value="xx") int xxx, @RequestParam(value="yy") int yyy) {
//		return "input";
//	}
	
	// 3) Spring 스타일2
	// Spring이 request parameter 받아서 JavaBean객체로 만들어줌
	// 조건 : 멤버변수명 = request parameter이름 통일
	// 좋지만 파일업로드, 날짜때는 좀... -> 그럴땐 1번스타일 가즈아~
	// 최종 : 1 + 3 병행
	@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
	public String xyCalculate(XY xy, HttpServletRequest request) {
		c.Calculate(xy, request);
		return "output";
	}
	
	// test.do주소로 GET방식 요청 들어오면 실행
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	public String test() {
		System.out.println("테스트");
		return "aaa";
	}
	// test.do주소로 GET방식 요청 들어오면 실행
	@RequestMapping(value="/gogo.gogo", method=RequestMethod.GET)
	public String gogo() {
		System.out.println("ㄱㄱ");
		return "bbb";
	}
}
