package com.lhj.gbraucp.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.gbraucp.LeeTokenGenerator;
import com.lhj.gbraucp.member.MemberDAO;

@Controller
public class SNSReplyController {
	
	@Autowired
	private SNSReplyDAO sRDAO;
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@Autowired
	private SNSDAO SDAO;
	
	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			sRDAO.writeReply(sr, request);
			ltg.generate(request);
			SDAO.searchClear(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	@RequestMapping(value = "/sns.reply.update", method = RequestMethod.GET)
	public String snsReplyUpdate(SNSReply sr, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			sRDAO.updateReply(sr, request);
			ltg.generate(request);
			SDAO.searchClear(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			sRDAO.deleteReply(sr, request);
			ltg.generate(request);
			SDAO.searchClear(request);
			SDAO.get(1, request);
			request.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
