package com.lhj.oct101smmb.menu;

import java.util.List;

public interface MenuMapper {
	// insert/update/delete : int
	// select : resultType맞춰서
	//	메소드명
	//		mapper.xml id랑 같게
	//	prarmeter
	//		mapper.xml의 parameterType과 맞춰서 없으면 공백
	public abstract List<Menu> getMenu();
	public abstract int reg(Menu m); 
}
