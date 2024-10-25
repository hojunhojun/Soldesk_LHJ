package com.lhj.oct241xj.snack;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackDAO {

	@Autowired
	private SqlSession ss;

	public void getSnack(HttpServletRequest request) {
		List<Snack> snacks = ss.getMapper(SnackMapper.class).getSnack();
		request.setAttribute("snacks", snacks);
	}
	
	public Snacks toXML() { // 리턴타입을 복수형으로
		List<Snack> snacks = ss.getMapper(SnackMapper.class).getSnack();
		Snacks books2 = new Snacks(snacks);
		
		return books2;
	}
}
