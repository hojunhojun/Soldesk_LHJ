package com.lhj.aug071ucio.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// 파일에서 읽어오기
// FileReader, FileWriter : 인코딩방식 쓰는 생성자 있음 생겼음'

// 최신기능 막쓰지마라 ㅡ.ㅡ
public class UCMain4 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String line;
		try {
			// FileReader fr; // 2bytes -> 이미 글자를 깨서 갖고옴
			FileInputStream fis = new FileInputStream("C:\\Users\\1134h\\Eclipse\\0807.txt"); // 1bytes
			InputStreamReader isr = new InputStreamReader(fis, "utf-8"); // 2bytes
			br = new BufferedReader(isr);
			
			while ((line = br.readLine()) != null) { // line이 없지 않을때까지 반복
				System.out.println(line);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try { br.close(); } catch (IOException e) {}
	}
}
