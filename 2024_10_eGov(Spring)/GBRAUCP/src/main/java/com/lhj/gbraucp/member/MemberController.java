package com.lhj.gbraucp.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.gbraucp.sns.SNSDAO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinDo(Member m, HttpServletRequest request) {
		mDAO.join(m, request);
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/join.go", method = RequestMethod.GET)
	public String joinGo(Member m, HttpServletRequest request) {
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginDo(Member m, HttpServletRequest request) {
		mDAO.login(m, request);
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(Member m, HttpServletRequest request) {
		mDAO.logout(request);
		mDAO.isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(Member m, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			request.setAttribute("contentPage", "member/info.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");			
		}
		return "index";
	}
	@RequestMapping(value = "/bye.do", method = RequestMethod.GET)
	public String byeDo(Member m, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			mDAO.bye(request);
			mDAO.logout(request);
			mDAO.isLogined(request);
			sDAO.setAllPostCount();
		}
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			mDAO.update(m, request);
			request.setAttribute("contentPage", "member/info.jsp");
		} else {			
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
