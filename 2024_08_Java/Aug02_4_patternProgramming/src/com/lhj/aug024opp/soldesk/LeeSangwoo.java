package com.lhj.aug024opp.soldesk;

//2) 같은 패키지에 factory역할을 할 클래스를 추가
public class LeeSangwoo {
	
	private int studentCount;
	
	private static final LeeSangwoo LSW = new LeeSangwoo();
	
	private LeeSangwoo() {
		
	}
	
	public static LeeSangwoo getLsw() {
		return LSW;
	}
	// 3) 학생객체를 찍어낼 메소드
	// 4) 자동화쪽은 프로그램따라 다를테니...
	public Student talk(String name, int age) {
		studentCount++;
		return new Student(studentCount, name, age);
	}
}
