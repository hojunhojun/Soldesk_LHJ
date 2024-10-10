package com.lhj.aug132ucc.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//	Collection : 가변사이즈, 자료형 섞기 가능은 하지만
//	객체만 가능(기본형 불가)
//	[]					: 이건 별로임
//	List계열 				: 가변사이즈 배열(인덱스 기반임 의미파악용X) = 주력
//	Set계열 				: 중복을 없애버림(기본형급, 객체는 무력함), 순서가 지멋대로임 = 잘 안씀
//	Map계열(dictionary)	: 순서라는 개념이 없음, 키-값
public class UCMain4 {
	public static void main(String[] args) {
		HashMap<String, Double> hm = new HashMap<String, Double>(); // 키값과 value 값 지정
		hm.put("탄수화물", 30.32);
		hm.put("지방", 3.32);
		hm.put("단백질", 13.132);
		hm.put("단백질", 53.132); // 같은 키에 다른 값을 넣으면 값이 바뀜
		
		System.out.println(hm.get("단백질"));
		System.out.println("------------");
		
		Set<String> keys = hm.keySet(); // 키값 추출
		ArrayList<String> keys2 = new ArrayList<String>(keys); // ArrayList로 변환
		for (String k : keys2) {
			System.out.println(k); // 키값 출력
			System.out.println(hm.get(k)); // value값 출력
			System.out.println("------------");
		}
		
		System.out.println(hm.containsKey("비타민")); // 해당 키값이 있는지를 판단하여 boolean으로 반환
		
	}
}