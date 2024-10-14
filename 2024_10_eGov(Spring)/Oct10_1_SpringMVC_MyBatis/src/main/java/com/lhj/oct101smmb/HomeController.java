package com.lhj.oct101smmb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.oct101smmb.menu.MenuDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MenuDAO mDAO;
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		mDAO.get(request);
		ltg.generate(request);
		return "index";
	}
	

}
