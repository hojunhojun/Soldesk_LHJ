package com.lhj.aug071ucio.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 이미지를 인식하는 AI -> 동영상은요?

// AI - 이미지, 동영상 따로따로? 그게 AI임?
// 컴퓨터에(그저 전자기기)에 ㅋ가 저장되나?
// 전자기기 : 전기가 흐름/전기가 안흐름
//		ㅋ -> 전기신호로 바뀌어서 저장됨 (1001)
//		동영상 -> 00110101

// 인코딩(encoding) : 데이터를 전기신호 형태로 바꾸는거
// 디코딩(decoding) : 전기 신호 형태의 데이터를 원상복구
//			ㅋ -encoding-> 1001 - decoding -> ㅋ

//			ㅋ 파일에 저장할때 무슨방식? / 파일에있는 ㅋ 불러올때 무슨방식?

//			ㅋ 	-A-> 1111 -A-> ㅋ
//			ㅋ 	-B-> 0101 -C-> 깨짐
//			   	-C-> 0110

// 인코딩 방식 다양
//		utf-8 		: 전세계적으로 주력
//		euc-kr		: 국내 2인자
//		iso-8859-1 	: MS쪽에서 기본으로 이쪽으로 미는중(ㅇ즘들어서는 utf-8쓰던데)

public class UCMain3 {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);

		System.out.print("뭐 : ");
		String s = ci.next();
		System.out.println("----------");
		System.out.println(s);
		BufferedWriter bw = null;
		try {
			// OutputStream의 개조형 : 1byte
			// 글자개념이 없는 상태
			FileOutputStream fos = new FileOutputStream("C:\\Users\\1134h\\Eclipse\\0807.txt", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8"); // 인코딩 방식 넣기
			bw = new BufferedWriter(osw);
			bw.write(s + "\r\n");
			bw.flush();
			// FileWriter
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {bw.close();} catch (IOException e) {} // 개발자들의 가독성을 위한 정리법
		ci.close();
	}
}
