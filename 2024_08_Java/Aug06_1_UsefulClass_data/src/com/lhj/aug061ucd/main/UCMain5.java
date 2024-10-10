package com.lhj.aug061ucd.main;

import java.text.SimpleDateFormat;
import java.util.Date;

// 숫자라서 숫자가 아님
// 숫자로서 의미가 있으면 숫자임
public class UCMain5 {
	public static void main(String[] args) {
		try {
			String birthday = "2002/04/25";
			
			// String -> Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 포맷 형식 작성
			Date birthday2 = sdf.parse(birthday); // Stirng형식을 Date 형식으로 변환
			
			// Date -> Str
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy"); // 포맷 형식 작성
			String birthYear = sdf2.format(birthday2); // Date형식을 String으로 변환
			int birthYear2 = Integer.parseInt(birthYear); // String을 int로 변환
			
			Date now = new Date(); // 오늘 날짜 생성
			String nowyear = sdf2.format(now); // Date형식을 String으로 변환
			int nowyear2 = Integer.parseInt(nowyear); // String을 int형식으로 변환
			
			System.out.println("나이 : " + (nowyear2 - birthYear2 + 1)); // 최종 계산
			
			// 태어난 요일 구하기
			SimpleDateFormat sdf3 = new SimpleDateFormat("E"); // 포맷 형식 작성(요일)
			String yoil = sdf3.format(birthday2);  // Date 형식을 String형식으로 변환
			System.out.println("태어난 요일 : " + yoil); // 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
