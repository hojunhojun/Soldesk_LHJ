package com.lhj.oct241xj.drink;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 자바 객체를 -> JSON으로 바꿔줌 (스프링에 기본탑재 X)

@Controller
public class DrinkController {

	@Autowired
	private DrinkDAO dDAO;
	
	@RequestMapping(value = "/drink.get", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public @ResponseBody Drinks drinkGet(HttpServletResponse response) {
		// 작업내용은 같음 -> @ 붙은거 다빼고 -> maven 넣고 -> 이게 json 하는법
		return dDAO.toJSON();
	}
	
}
