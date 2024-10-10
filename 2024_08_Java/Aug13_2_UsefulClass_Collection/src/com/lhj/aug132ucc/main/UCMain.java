package com.lhj.aug132ucc.main;

import java.util.ArrayList;
import java.util.Comparator;

// 프로그래밍 언어
//		조건문
//		반복문
//		배열 -> 컬렉션(★)
//		그 언어의 특징적인거
//		-> XML/JSON파싱

// 데이터들(배열) : []
// []의 단점
// 		1. 만들때 크기를 알아야함 + 고정
// 		2. 자료형 섞어서 불가능함 - ??? 억까임 ㅇㅇ
//		3. 인덱스 기반 -> 의미를 파악하기가 어려움
//			-> 간단한 데이터 여러개 처리용

// Collection : 가변사이즈, 자료형 섞기 가능은 하지만
//		객체만 가능(기본형 불가)
//		List계열 : 가변사이즈 배열(인덱스 기반임 의미파악용X)
//		Set계열
//		Map계열

// List(interface) - ArrayList(이놈은 확실히 주력임)

// <클래스명> : generic -> 자료형 제한
public class UCMain {
	public static void main(String[] args) {
		
		// Vector도 있음
		
		ArrayList<Integer> al = new ArrayList<Integer>(); // 객체 사용
		al.add(50); // int -> Integer로 autoboxing해서 넣음
		al.add(30);
		al.add(663);
		al.add(1);
		
		for (Integer v : al) { // foreach
			System.out.println(v);
		}
		System.out.println("------------");
		al.add(999);	// 값 맨 뒤에 넣기 (일반 method)
		al.add(1, 888); // 값 원하는 자리에 넣기
		al.set(3, 777); // 원하는 자리의 값 수정
		al.remove(4);	// 원하는 자리의 값 삭제
		
		// Comparator라는 인터페이스를 구현하는 클래스 객체를 생성
		Comparator<Integer> c = new Comparator<Integer>() { // 자동완성 적극이용
			// 버블정렬 느낌? 하지만 정확히는 모름
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2); // 오름차순
			//	return o2.compareTo(o1); // 내림차순
			}
		};
		
		al.sort(c);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
//		ArrayList al = new ArrayList(); // 몇칸?
//		al.add(10);
//		al.add(true);
//		System.out.println(al.size()); // 가변사이즈 구현예
//		al.add("ㅋ");
//		al.add(10.55);
//		System.out.println(al.size()); // 가변사이즈 구현예
//		System.out.println(al.get(0)); // 인덱스 접근용 get
//		System.out.println(al.get(1)); // 인덱스 접근용 get
//		System.out.println(al.get(2)); // 인덱스 접근용 get
//		System.out.println(al.get(3)); // 인덱스 접근용 get
	}
}
