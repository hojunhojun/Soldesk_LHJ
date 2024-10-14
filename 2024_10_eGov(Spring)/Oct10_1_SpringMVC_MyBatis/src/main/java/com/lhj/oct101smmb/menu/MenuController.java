package com.lhj.oct101smmb.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.oct101smmb.LeeTokenGenerator;

@Controller
public class MenuController {
	
	@Autowired
	private MenuDAO mDAO;
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET)
	public String regMenu(Menu m, HttpServletRequest request) {
		mDAO.register(m, request);
		mDAO.get(request);
		ltg.generate(request);
		return "index";
	}
}
