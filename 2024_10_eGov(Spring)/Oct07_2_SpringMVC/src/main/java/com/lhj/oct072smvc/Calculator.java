package com.lhj.oct072smvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 계산 담당하는 M/DAO : singleton
// 1) servlet-context.xml에 등록시켜서 -> C에서 Autowired로 연결 (M쪽에 유지보수거리 있으면 이거)
// 2) @Service -> 1번과 같은 효과 (M쪽에 유지보수거리 없이 단순 singleton이면
// 3) 기존 singleton - 굳이?

@Service // 2번은 이거임 ㅋㅋ
public class Calculator {
	public void Calculate(XY xy, HttpServletRequest request) {
		int result = xy.getXx() + xy.getYy();
		System.out.println(result);
		request.setAttribute("z", result);
	}
}
