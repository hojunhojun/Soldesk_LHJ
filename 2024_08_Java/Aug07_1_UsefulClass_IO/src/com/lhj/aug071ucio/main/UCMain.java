package com.lhj.aug071ucio.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//	RAM : 저장장치 - 임시저장장치
//	HDD : 저장장치 - 파일형태로 영구저장할때

// 사실 이것들 전부 이렇게하면안됨
// 인코딩 상황
public class UCMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		
		System.out.print("뭐 : ");
		String s = ci.next();
		System.out.println("-----------");
		System.out.println(s);
		
		// Windows : \ 로 구분, 대소문자 구별X
		//				C:로 시작해서...
		// Linux : / 로 구분, 대소문자 구별
		//				/로 시작해서...
		// \\ , / 중에 선택해서 쓰기
		
// 파일이 없으면? : 만들어줌 / 폴더 없으면 : 못만듬
		BufferedWriter bw = null;
		try {
			// OutputStreamWriter개조형 : 파일처리하기 좋게
			// 프로그램 -> 장치 : 2bytes
			FileWriter fw = new FileWriter("C:\\Users\\1134h\\Eclipse\\0807.txt", true); // true를 붙이면 뒤에 내용 계속추가됨
			bw = new BufferedWriter(fw);
			bw.write(s + "\r\n"); // 쓰기 + 줄바꿈(Win10부터는 \n 한개만 써도 그냥 잘 됨)
			bw.flush(); // 빨대 용량만큼 안채워도 강제 전송됨
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close(); // 닫아야 다른프로그램에서 이 파일 쓸수있게됨.
						// 연관된것들 중에 하나만 닫으면 다 처리됨 (bw,fw 둘중에 하나만닫으면됨)
		} catch (IOException e) {
			e.printStackTrace();
		} 
		ci.close(); // 스캐너도 닫아야합니다.
		
	}
}
