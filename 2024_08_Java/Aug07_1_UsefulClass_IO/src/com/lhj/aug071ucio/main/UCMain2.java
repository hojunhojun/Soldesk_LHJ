package com.lhj.aug071ucio.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 사실 이것들은 이렇게하면 안됨
// 디코딩상황
public class UCMain2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// InputStreamReader 개조형 : 장치 -> 프로그램(2bytes)
			FileReader fr = new FileReader("C:\\Users\\1134h\\Eclipse\\0807.txt");
			br = new BufferedReader(fr);
			
			String line;
			while ((line = br.readLine()) != null) { // line이 없지 않을때까지 반복
				System.out.println(line);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close(); // 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
