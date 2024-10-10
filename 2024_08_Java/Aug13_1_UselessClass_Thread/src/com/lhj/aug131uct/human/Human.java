package com.lhj.aug131uct.human;

// 웹 사이트 : 여러명이 동시에
//			한사람 접속할때마다 그 사람을 처리하기위한 쓰레드 생성
//			=> 중요한듯? 근데 JSP, Spring 배울때 자동으로 처리해줌 ㅋㅋ

// 기차 좌석 예매
// 결제 동시 꼬임 상황
// multi-thread 상황에서 공유자원문제
// brain을 이름쓰레드, 취미쓰레드가 같이써서
// brain을 citical-section(임계영역)설정

// synchronized메소드
// 		Thread 가 몇개 돌던간에
//		한 순간에는 s메소드 하나만 실행가능
//		나머지는 차례대로 대기
public class Human {

	private String brain;

	private synchronized void sayName() { // synchronized 작성
		for (int i = 0; i < 10; i++) {
			try {
				brain = "홍길동";
				Thread.sleep(300);
				System.out.println("이름 : " + brain);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private synchronized void sayHobby() {
		for (int i = 0; i < 10; i++) {
			try {
				brain = "여행";
				Thread.sleep(700);
				System.out.println("취미 : " + brain);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		
	}

	public void introduce() {
		new Thread() {
			public void run() {
				sayName();
			};
		}.start();
		
		sayHobby();
	}
}