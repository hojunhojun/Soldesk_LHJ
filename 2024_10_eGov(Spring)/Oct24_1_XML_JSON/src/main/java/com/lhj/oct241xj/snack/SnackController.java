package com.lhj.oct241xj.snack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SnackController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@RequestMapping(value = "/snack.get", method = RequestMethod.GET, produces="application/xml;charset=utf-8")
	public @ResponseBody Snacks snackGet(HttpServletResponse response) {
		// 외부에서도 사용가능하게 하려면(Cross-domain AJAX 가능하게)
		response.setHeader("Access-Control-Allow-Origin", "*"); // 코멘트 후에 주고싶은 컴 주소 -> *은 모두공개
		Snacks snacks = sDAO.toXML();
		return snacks;
	}
	
	@RequestMapping(value = "/snack.test", method = RequestMethod.GET)
	public @ResponseBody String snackTest(HttpServletRequest request) { // responsebody넣기 (응답용)
		return "index";
	}	
}
