package com.lhj.aug061ucd.main;

import java.util.StringTokenizer;

// 책 찾아서 외울건가? 쓸모없음 ㅇㅇ
public class UCMain {
	public static void main(String[] args) {
		// 수정불가능한 문자열 객체 String
		// String s = new String("ㅋㅋㅋ"); // 원래 문법
		String s = "훈련과정 수기 출석부"; // 이거도 허용
		
		// 2번째 글자는 뭘까?
		System.out.println(s.charAt(1));
		
		// 수기의 위치
		System.out.println(s.indexOf("수기"));
		
		// 글자수
		System.out.println(s.length());
		
		// 출석부로 끝나는지
		System.out.println(s.endsWith("출석부"));
		
		// 훈련이라는 말이 들어있는지
		System.out.println(s.contains("훈련"));
		
		// 훈련과정을 수업으로 바꾸기
		System.out.println(s.replace("훈련과정", "수업"));
		
		// 형식 잡아서 문자열 생성
		String s2 = String.format("pi : %.2f\n", 3.1415);
		System.out.print(s2);
		
		// 문자열 뒤에 붙이기 - 이거는 쓰지마셈
		// 왜냐하면 애초에 String 객체는 수정불가능함
		String s3 = "ㅋㅋㅋ"; // 문자열 객체 s3 생성
		// 기존 ㅋㅋㅋ에 ㅎㅎㅎ붙여서 새로운 문자열 객체 만들고
		// S3변수에 있는 stack 주소값 수정
		// 기존에 ㅋㅋㅋ가있던 객체 가비지컬렉션 때리고
		s3 = new String(s3.concat("ㅎㅎㅎ")); // 요약 전 ver
		s3 = s3.concat("ㅇㅇㅇ"); // 요약 ver
		s3 = s3.concat("ㅠㅠㅠ");
//		s3 += "ㅎㅎㅎ";
//		s3 += "ㅇㅇㅇ";
//		s3 += "ㅠㅠㅠ"; // 이거도 쓰지마
		System.out.println(s3);
		
		// part 3 : 유용한 내/외장 클래스 소개
		
		// 수정가능한 문자열 객체가 필요함
		// 문자열 대량으로 붙이기
		StringBuffer sb = new StringBuffer("ㅋㅋㅋ");
		sb.append("ㅎㅎㅎ"); // 붙이기 메서드
		sb.append(12); // 붙이기 메서드
		String s4 = sb.toString(); // 만들때는 stringbuffer로 만들고 수정때린다음 tostring()으로 형변환
		System.out.println(sb);
		
		// 문자열 분리
		String s5 = "뭐가 있다 칩시다."; // 두번째 자리에 있는게 별 의미 없음 -> 비정형데이터	
		StringTokenizer st = new StringTokenizer(s5, " "); // String의 토큰화 (띄어쓰기를 기준으로 자름) : 비정형데이터에는 이게 더 유리함
		// System.out.println(st.nextToken()); // 뭐가
		// System.out.println(st.nextToken()); // 있다
		// System.out.println(st.nextToken()); // 칩시다.
		
		// 반복문으로 해볼까?
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		String s6 = "2024/8/6/17/20"; // 두번째 자리에 있는 월(月) 정보를 써서... -> 정형데이터 
		String[] s6ar = s6.split("/"); // "x" -> x를 기준으로 나눠서 배열화 해줌 : 정형데이터에는 이게 더 유리함
		System.out.println(s6ar[1]);
	}
}
