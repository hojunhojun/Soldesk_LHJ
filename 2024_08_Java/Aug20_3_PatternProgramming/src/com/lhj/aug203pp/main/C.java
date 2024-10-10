package com.lhj.aug203pp.main;

// singleton : only one 객체
// factory : 대놓고 여러개 찍어내는 객체(자동화)
// MVC(실무용) : 파일을 나눠서 작업 (파일 하나는 M/V/C중에 정확히 하나의 역할만 하도록)
//				M : Model(실제 계산[비즈니스 로직] -> back-end개발자)
//				V : View(사용자 눈에 보이는 파일 -> Front-end개발자, 디자이너)
//				C : Controller(흐름 제어[교통정리 M/V 호출] -> PL급 개발자)

// Controller
// 	상황판단해서 M/V 소환
// 	프로그램 전체의 시작점
//	리더급 개발자
public class C {
	public static void main(String[] args) {
		V v = new V();
		int x = v.getX();
		int y = v.getY();
		int z = M.calculate(x, y);
		
		v.print(z);
		v.end();
	}
}
// M/V/C 패턴 필수