package com.lhj.gbraucp.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhj.gbraucp.LeeTokenGenerator;
import com.lhj.gbraucp.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private SNSDAO SDAO;

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private LeeTokenGenerator ltg;

	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsgo(SNSPost sp, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.write", method = RequestMethod.POST)
	public String snsPostWrite(SNSPost sp, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			SDAO.write(sp, request);
			ltg.generate(request);
			SDAO.searchClear(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String snsPageChange(@RequestParam(value = "page") int page, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			SDAO.get(page, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String snsSearch(HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			SDAO.search(request);
			ltg.generate(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.delete", method = RequestMethod.GET)
	public String snsPostDelete(SNSPost sp, @RequestParam(value="page") int page, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			SDAO.delete(sp, request);
			ltg.generate(request);
			SDAO.searchClear(request);
			SDAO.get(page, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.update", method = RequestMethod.GET)
	public String snsPostUpdate(SNSPost sp, @RequestParam(value="page") int page, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			SDAO.update(sp, request);
			ltg.generate(request);
			SDAO.get(page, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
