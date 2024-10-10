package com.lhj.aug055eh.main;

import java.util.Scanner;

import com.lhj.aug055eh.calculator.Calculator;

// 프로그래밍
// 한국어 -> 번역(coding) -> .java
// .java -> 번역(compile) -> .class(기계어)
// .class -> 압축(archive) -> .jar

// error : Java 문법의 오류로 인해 compile 과정에서 발생한 특이사항으로 기계어로의 번역이 불가능한 상태
//			최종 산출물 안나옴
//			개발자 잘못

// warning : 지저분한 소스(필요없는거 생성, 정리되지 않은 소스)
//			최종 산출물 잘 나옴, 실행 문제 X
//			개발자 잘못

// exception : 프로그램 완성, 실행 잘 되고
//				실행할때 뭔가 외부적 요인으로 정상실행 안되는 상태
//				개발자 잘못? 뭔소리야 ㅋㅋ 그러나 처리해줄수 있는게 개발자뿐
//				개발자가 대비는 해둬야함

// kwon's program
// 기상청에서 인터넷으로 날씨 받아와서 평소에는 잘 되지만? 강남에 어느날 바람이 세게 -> 랜선이 휘날려서 인터넷이 안되버림
// 현재 위치 근처의 ~~~찾기
// 핸드폰에서 접속 -> 지하 5층에 간다면? 이게나때문이야? 개억까임 ㅇㅇ

// 초딩 동생의 의뢰로 시작된 프로젝트

// 수학 상식 : 나누기 0은 없음[성립]
// 초딩 동생의 수학이 짧아서 : exception
// 나눗셈 기능 : 이 프로재ㅔㄱ트에서만 사용될 특별한 기능 ( 온갖 프로젝트에 들어갈 기능) -> 꼬불쳐두자


// OOP : 코드 재사용

// library
public class EHMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		
		System.out.print("x : ");
		int x = ci.nextInt();
		System.out.print("y : ");
		int y = ci.nextInt();
		ci.close();
		
		System.out.println("----------");
		
		int[] ar = {123,11,33};

		int result = Calculator.divide(x, y);
		System.out.println(result);
		//		System.out.println(x + y);
//		System.out.println(x - y);
//		System.out.println(x * y);
//		System.out.println(x / y);
//		try {
//			System.out.println(x / y);
//			System.out.println(ar[y]);
//		} catch (Exception e) {
//			e.printStackTrace(); // 개발자용 : 최종 출시전에 삭제
//			System.out.println("어쨌든 문제"); // 고객용
//		} finally {
//			System.out.println("무조건 여기는 실행됨"); // 무조건 실행되는거 맞아?
//		}
		
//		catch (ArithmeticException e) { // 예외 검사
//			System.out.println("나누기 0이 어딨니?");
//		} catch (ArrayIndexOutOfBoundsException h) { // try 하나에 여러개 가능
//			System.out.println("배열좀 잘 쳐라 이 놈아.");
//		} finally {
//			? 왜 굳이? 왜? 걍밖에쓰지?
//		}

	}
	
}