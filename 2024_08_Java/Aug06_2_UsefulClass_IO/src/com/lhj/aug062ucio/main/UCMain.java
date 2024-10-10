package com.lhj.aug062ucio.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// 그렇다면 애초에 Java가 IO장치에 Buffered급 빨때 붙여놨으면 된거아님? 아 억울한데
// 하지만 미세컨트롤을 위해..

// Java : 규칙의 언어 -> 평온, 융통성이 없을정도로 체계화, 통일된 시스템(가끔 짜증 ㅋㅋ)
// Python : 자유의 언어(MZ언어 ㅋㅋ) -> 혼란

// Stream급 빨대 , Reader/Writer급 빨대, Buffer급 빨대
// Stream : Java 특유의 통일된 시스템 -> 모든 입출력장치에 붙여놓은 빨대

// 기본형 입출력장치 모음
// 		Java가 Stream급 빨대는 붙여놨음
//		근데 용량이 작아서 Reader/Writer급 덧씌우고, 모자라서 Buffered급 덧씌워서 씀

// InputStream : 장치 -> 프로그램 / 1byte
// InputStreamReader : 장치 -> 프로그램 / 2bytes
// BufferedReader : 장치 -> 프로그램 / 1String(line단위)

// OutputStream : 프로그램 -> 장치 / 1byte
// OutputStreamWriter : 프로그램 -> 장치 / 2bytes
// BufferedWriter : 프로그램 -> 장치 / 1String(line단위)

// 개조형 입출력장치 모음
//		FileReader : InputStreamReader를 개조, 파일처리하게 용이하게
//		PrintStream : OutputStream을 개조, 용이한 메소드를 추가
public class UCMain {
	public static void main(String[] args) {
		// 프로그램 -> 콘솔창(장치)
		// 콘솔창에 붙어있는 빨대
		PrintStream ps = System.out;
		ps.println("ㅋ");
		
		// 콘솔창(장치) -> 프로그램
		// 콘솔창에 붙어있는 빨대
		InputStream is = System.in;
		
		// 1.5때추가됨, InputStream사용 도와주는 존재
		Scanner isSuppoter = new Scanner(is);
	}
}
