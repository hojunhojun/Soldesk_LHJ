package com.lhj.oct082uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private UnitConverter uc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goInput() {
		return "input";
	}
	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String unitConverter(UCData ucd, HttpServletRequest request) {
		uc.convert(ucd, request);
		return "output";
	}
}

