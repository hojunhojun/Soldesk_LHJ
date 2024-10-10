package com.lhj.aug061ucd.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 책 안쓰는 이유 : deprecated
// 코드 외우지 마라..
// deprecated : 쓰지마
//			유예기간을 줄게 ㅇㅇ(현재버전은 ok, 다음버전에 없어져도 받아들여라)
//			언젠간은 만들어졌던 기능이 ----세월----> 그 기능이 안맞음..
//			-> 업그레이드, 삭제하고 신제품(변화에 적응하기 위해서)
//			업그레이드 or 삭제하고 신제품을 만들 계획이 섰음.
// Java가 세상에 나올때 Date()가 처음 나옴 : 1996년 1월
// 2000년대를 생각 안하던 시절 -> 연도를 96같은 형식으로 표시
// 1999 ~ 2000으로 넘어가면서
// 2024년 : 19??, 20?? 어떻게할거임?
// 1996년에 만들었던 Date가 맞지 않음 ㅇㅇ

// 버전 : 1.5.12 -> 1 : major버전 / 5.12 : minor버전(앞자리가 바뀔수록 크게 바뀜)
//	0.x.x : 미완성 프로그램
// 	1.0.0 : 완성한 프로그램
//	1.0.1 : 업그레이드는 되었지만 체감이 거의 안되는
// 	1.1.0 : 체감되는 업그레이드
//	2.0.0 : 새로운 프로그램

public class UCMain4 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now); // 자바 2.0이 나오면 과연 이건 멀쩡할까?
		
// 		옛날얘기
//		System.out.println(now.getYear());
//		System.out.println(now.getMonth());
//		System.out.println(now.getDate());
//		System.out.println("-----------------");
		
		// 통합(마음대로) : 신제품
		// 하는일 : Date -> String 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM/dd"); // 이거 진짜 편함
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		// 특정시간날짜
		// Date d= new Date(0, 0, 0); // 구식..
		// String -> Date
		try {
			String xmas = "2023-12-25";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date xmas2 = sdf2.parse(xmas);
			System.out.println(xmas2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 날짜, 한글처리 : 이녀석들이 나를 괴롭힐것임 ㅇㅇ
	}
}
