package com.lhj.aug122uct.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 멀티쓰레드 프로그래밍 하는법
// 1-1) Thread를 상속받는 클래스 생성 /-> 다중상속이 안되는데 이렇게?(다른방법을 사용해보자)
public class LHJThread extends Thread {
	@Override
	public void run() {
		super.run();
		
		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		
		jf.setSize(200, 200);
		jf.setVisible(true);
		
		for (int i = 0; i < 8; i++) {
			jta.append("ㅎ\r\n");
			try {
				Thread.sleep(400); // 0.4초동안 Thread 멈추기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
