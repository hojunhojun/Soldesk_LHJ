package com.lhj.aug122uct.main;

// Java : 동시에 여러작업 가능

// Python : 동시에 여러작업을 잘 못함
// Go : 동시에 여러작업이 특기임.

// Thread : 좌 -> 우, 위 -> 아래, 닿는 코드가 실행되는것임.

// 1) JVM이 OS위에 올라가고
// 2) program 소스(기계어상태)가 stack영역에 실림
// 3) static멤버변수가 static 영역에 만들어짐
// 4) JVM이 Thread라는걸 하나 만들어서 UCMain.main(...)을 호출
// Multi-thread 프로그래밍
// 	  Main-Thread 	: JVM이 만들어준 Thread
//	  Sub-Thread 	: 개발자가 만들어쓰는 Thread
public class UCMain {
	public static void main(String[] args) {
		LHJThread lt = new LHJThread();
		lt.start(); // 1-2 새 Thread 만들어서 run쪽으로 보내기
		Thread t = new Thread(new LHJThread22());
		t.start(); // 2-2
		
		for (int i = 0; i < 10; i++) {
			System.out.println("ㅋ");
			try {
				Thread.sleep(300); // 0.3초동안 Thread 멈추기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
