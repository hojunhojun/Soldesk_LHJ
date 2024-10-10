package com.lhj.aug122uct.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 2번 방법 2-1) Runnable 인터페이스를 구현하는 클래스 (상속라인 막지 않게)
public class LHJThread22 implements Runnable {
	@Override
	public void run() {
		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setSize(200, 200);
		jf.setLocation(100, 0);
		jf.setVisible(true);
		
		for (int i = 0; i < 10; i++) {
			jta.append("ㅇ\r\n");
			try {
				Thread.sleep(600); // 0.4초동안 Thread 멈추기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
