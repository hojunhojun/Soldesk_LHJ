package com.lhj.oct241xj.drink;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void getDrink(HttpServletRequest request) {
		List<Drink> drinks = ss.getMapper(DrinkMapper.class).getDrink();
		request.setAttribute("drinks", drinks);
	}
	
	public Drinks toXML() {
		List<Drink> drinks = ss.getMapper(DrinkMapper.class).getDrink();
		Drinks drinks2 = new Drinks(drinks);
		
		return drinks2;
	}
	
	public Drinks toJSON() {
		return new Drinks(ss.getMapper(DrinkMapper.class).getDrink());
	}
}
