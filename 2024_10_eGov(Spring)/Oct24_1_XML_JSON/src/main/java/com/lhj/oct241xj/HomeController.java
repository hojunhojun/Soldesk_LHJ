package com.lhj.oct241xj;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.oct241xj.snack.SnackDAO;

@Controller
public class HomeController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		sDAO.getSnack(request);
		return "index";
	}
	
}
