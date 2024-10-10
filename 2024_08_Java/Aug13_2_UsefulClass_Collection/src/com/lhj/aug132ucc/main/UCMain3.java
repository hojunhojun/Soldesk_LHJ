package com.lhj.aug132ucc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import com.lhj.aug132ucc.student.Student;

//	Collection : 가변사이즈, 자료형 섞기 가능은 하지만
//	객체만 가능(기본형 불가)
//	List계열 	: 가변사이즈 배열(인덱스 기반임 의미파악용X)
//	Set계열 	: 중복을 없애버림(기본형급), 순서가 지멋대로임 = 잘 안씀
//	Map계열	: 
public class UCMain3 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("ㅋ");
		hs.add("ㅋ"); // 너 out
		hs.add("ㅎ");
		hs.add("ㅠ");
		hs.add("ㅠ"); // 너 out
		System.out.println(hs.size()); // 오?
		// Set -> [] / Set -> List : 사용법
		ArrayList<String> al = new ArrayList<String>(hs); // Set -> List 변환 예시
		for (String s : al) {
			System.out.println(s);
		}
		System.out.println("------------------");
		
		// 중복불가, 순서? 단점이안됨 ㅋㅋ
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student("홍길동", 10, 20, 30));
		students.add(new Student("이길동", 20, 50, 90));
		students.add(new Student("김길동", 0, 0, 0));
		students.add(new Student("김길동", 0, 0, 0));
		students.add(new Student("김길동", 0, 0, 0)); // 어쨌든 다른학생이 3명 생김
		
		Student s = new Student("최길동", 5, 5, 5);
		students.add(s);
		students.add(s);
		students.add(s);
		System.out.println(students.size()); // 
		System.out.println("------------------");
		
		Random r = new Random();
		HashSet<Integer> lotto = new HashSet<Integer>(); // 로또 Set생성
		while (true) { // Set에 랜덤번호 부여
			lotto.add(r.nextInt(45) + 1);
			if (lotto.size() == 6) {
				break;
			}
		}
		ArrayList<Integer> lotto2 = new ArrayList<Integer>(lotto); // ArrayList로 변환
		Comparator<Integer> c = new Comparator<Integer>() { // 정렬 메서드 구현
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		lotto2.sort(c); // 정렬
		for (Integer lo : lotto2) {
			System.out.println(lo); // 출력
		}
	}
}
