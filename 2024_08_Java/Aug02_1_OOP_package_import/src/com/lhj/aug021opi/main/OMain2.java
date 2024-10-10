// 	클래스명 중복되면 안됨 -> 중복안되게 잘 짓자 : x (자바의 공유하는 문화때문에 불가능)
// 	그렇다고 클래스명을 이상하게 짓자니..

// 	package : 클래스명 중복될때 구분할 수 있는 수단, 정리차원
//			모든 클래스는 패키지에 넣읍시다.★
//	package명 짓는 규칙(문화) : 회사 도메인 뒤집어서.프로그램명.카테고리
//	ex) com.soldesk.mspaint.product / org.eclipse.java.ide
//	ex) 나만의 패키지명 : hojun.lee.mspaint.product
// 	만약 패키지명까지 중복되면? : 노답. 진짜 중복 안되게 잘 지어야됨
//	패키지정리 : 진짜 개중요 ★

// 	패키지명 생략
//		1. java의 기본패키지(java.lang)에 포함될때
//		2. 작업중인 클래스와 같은 패키지 소속일때
//		3. import한 클래스
//		import
//		OMain2에서 Scanner라고 쓰는거는 무조건 내거임(콘솔입력은 안쓸예정)
//			-> import 가능 : 했으면 안써도됨
package com.lhj.aug021opi.main;

import com.lhj.aug021opi.product.Scanner;

public class OMain2 {
	public static void main(String[] args) {
		// 객체생성 : 패키지명.클래스명 변수명 = new 패키지명.생성자; -> 최종
		
		// import한 스캐너와 겹치지 않게 패키지명 작성
		java.util.Scanner ci = new java.util.Scanner(System.in);
		
		// 문자열 객체
		// String s = new String("안녕하세요"); -> 생략 전 버전
		// java.lang.String s = new java.lang.String("안녕하세요"); -> 생략 전 버전
		String s = "안녕하세요"; // java.lang 소속이라 생략 가능
		java.lang.System.out.println(); // -> 생략 전 버전
		System.out.println();
		
		Scanner sc = new Scanner("캐논123", 300000);
	}
}
