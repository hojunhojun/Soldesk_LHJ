package com.lhj.oct101smmb.menu;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SqlSession  vs 	SqlSessionTemplate
// 수동연결관리			자동연결관리(연결하고 작업하고 끊고 하지 않아도됨)
// 수동commit			자동commit
//					SqlSession의 하위
@Service
public class MenuDAO {
	
	@Autowired
	SqlSessionTemplate ss;
	
//	public void register(Menu m) { // m에는 값이 들어있음
//		// intergace를 불러오자
////		MenuMapper mm = ss.getMapper(MenuMapper.class); // interface 불러오기
////		mm.reg(m); // 추상메소드 호출 -> 연결된 mapper.xml가서 실행됨 -> sql문 실행
//		ss.getMapper(MenuMapper.class).reg(m);
//	}
	
	// 새로고침 할때마다 계속등록되는건 어떻게할래?
	//		JavaScript로 F5를 못누르게, 마우스 우클릭 못하게 할수있음.
	//		근데 이제는 다른방법으로 해보자
	// 새로고침 : 직전요청 그대로 한번 더 -> 똑같은 요청 두번째부터는 등록 안되게
	
	// 새 메뉴 등록 vs 새로고침
	// Token : 새 요청때마다 부여될 유니크한 값
	public void register(Menu m, HttpServletRequest request) {
		try {
			String token = request.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				request.setAttribute("result", "등록실패(새로고침)");
				return;				
			}

			if(ss.getMapper(MenuMapper.class).reg(m) == 1) {
				request.setAttribute("result", "등록성공");
				request.getSession().setAttribute("successToken", token);
			} else {				
				request.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "등록실패(DB서버)");
		}
	}
	
	public void get(HttpServletRequest request) {
		request.setAttribute("menus", ss.getMapper(MenuMapper.class).getMenu());
	}
}
