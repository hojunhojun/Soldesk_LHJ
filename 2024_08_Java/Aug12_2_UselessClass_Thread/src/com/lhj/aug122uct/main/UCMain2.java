package com.lhj.aug122uct.main;

// Main-Thread : 0.3초마다 ㅋ찍기 X 10
// Sub-Thread : 0.5초마다 ㅋ찍기 X 무한

// 이 프로그램의 메인 기능 : ㅋ찍기 X 10
// 메인 기능 끝나면 subThread들은 알아서 끝나겠지? -> 이거 아님 ㅋㅋ
public class UCMain2 {
	public static void main(String[] args) {
		// 익명 내부 클래스 (1번방법)
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				while (true) {
					System.out.println("ㅎ");
					try {
						Thread.sleep(500);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("ㅋ");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		t.stop();
	}
}
