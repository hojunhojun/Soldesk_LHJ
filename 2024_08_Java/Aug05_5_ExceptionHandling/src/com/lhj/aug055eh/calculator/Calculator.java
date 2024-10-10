package com.lhj.aug055eh.calculator;

// 직접처리 : 1번
// 대응 방법까지 내장 -> 다른 프로젝트에서 사용하기가...
// 문제 발생에 대응을 신입이 하나? 그게맞아?

// Java : .jar -> 소스 수정 불가
// python : .py -> 소스 수정 가능
public class Calculator {

	public static int divide(int x, int y) {
		
		try {
			int z = x / y;
			return z;
		} catch (Exception e) {
			System.out.println("야");
			return -999;
		} finally {
			System.out.println("어쨌든 끝");
		}
	// 2번) 미루기 ㅡ ///(주력)/// 이걸 잘해야지 이게 나의 주력임
	// throws
	// divide2를 수행하다가 arith 터진거는 divide2 호출한쪽에서 처리하려고 미루기
//	public static int divide2(int x, int y) throws ArithmeticExptcion {
//		int z = x / y;
//		return z;
//	}
	}
}
