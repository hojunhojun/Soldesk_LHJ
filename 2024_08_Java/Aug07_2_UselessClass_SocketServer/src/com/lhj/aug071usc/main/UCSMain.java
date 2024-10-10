package com.lhj.aug071usc.main;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 해당 프로젝트는 서버임
public class UCSMain {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9936); // 포트번호 9936 : 9936번 포트를 써서 소켓서비스 시작
			System.out.println("서버 : 대기중");
			
			Socket s = ss.accept(); // 클라이언트가 접속할때까지 멈춰 / 접속하면 연결되고, 통신채널 s
			System.out.println("서버 : 누군가가 접속하였습니다.");
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			Robot r = new Robot();
			String msg;
			String msg2[];
			int x,y;
			while (true) {
				msg = br.readLine();
				if (msg.equals("l")) {
					r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
				} else if (msg.equals("r")) {
					r.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
					r.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
				} else {
					msg2 = msg.split(",");
					x = Integer.parseInt(msg2[0]);
					y = Integer.parseInt(msg2[1]);
					r.mouseMove(x, y);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {ss.close();} catch (IOException e) {}
	}
}
