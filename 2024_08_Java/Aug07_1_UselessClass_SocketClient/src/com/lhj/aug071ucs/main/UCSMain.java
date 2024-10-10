package com.lhj.aug071ucs.main;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

//	해당 프로젝트는 학원컴 소켓서버 프로젝트와 연결되어있음

// 	통신
//		실시간(Socket 통신) : 카카오톡
//		실시간아님(HTTP 통신) : 인터넷

//	서버 : 서비스를 제공하는 컴퓨터
//	클라이언트 : 서비스를 이용하는 컴퓨터

// 	통신
//		IP주소	: 192.168.2.5
//		포트번호 	: 어떤 서비스 이용하려고? (접속 목적 구별용도) : 9936은 소켓 접속용 포트번호임
//					1~65536
//					IT바닥에서 약속되어서 이미 사용되고 있는게있음
//					새로운 서비스
//	해당 프로젝트는 클라이언트임
public class UCSMain {
	public static void main(String[] args) {
		Socket s = null;
		Scanner ci = new Scanner(System.in);
		try {
			// s = new Socket("192.168.0.43", 9936); // 학원컴 서버 포트 주소
			// s = new Socket("192.168.2.13", 3434); // 인지누님 놑북 서버 포트 주소
			s = new Socket("192.168.2.5", 9936); // 이 주소는 내 컴퓨터(놑북)를 표현하는 주소
			// s = new Socket("127.0.0.1", 9936); // 이 주소는 내 컴퓨터(놑북)를 표현하는 주소
			// s = new Socket("localhost", 9936); // 이 주소는 내 컴퓨터(놑북)를 표현하는 주소
			System.out.println("클라이언트 : 접속성공"); // 접속 성공시 출력할 문장
			
			OutputStream os = s.getOutputStream(); // 1byte
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			String msg;
			while (true) {
				System.out.print("보낼 내용 입력 : ");
				msg = ci.next();
				bw.write(msg + "\r\n");
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ci.close();
		try {s.close();} catch (Exception e) {} // 클라이언트 접속 종료
	}
}
