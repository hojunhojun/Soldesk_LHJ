package com.lhj.aug20pp.main;

// 한 프로젝트에 M/V/C 여러개가 있음

// MVC(기본)
// DAO/	DTO 패턴 : MVC 패턴 인데 DAO에서 DB관련 작업이나 데이터를 DTO로 주고받는


// 프로그램 전체의 시작점 역할하는 C : HomeController / MainController 로 보통 이름을 지음
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		Product p = cs.getProduct(); // Singleton 패턴이므로 new 불가
		
		ProductDAO.getInstance().reg(p);
		cs.close();
	}
}
