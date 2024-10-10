package com.lhj.aug056eh.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.lhj.aug055eh.calculator.Calculator;

// 총 가격 : 
// 중량 :
public class EHMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		
		System.out.print("총 가격 : ");
		int price = ci.nextInt();
		System.out.print("중량 : ");
		int weight = ci.nextInt();
		
		try {
			System.out.println("----------");
			int result = Calculator.divide(price, weight);
			System.out.println("g당 가격 : " + result);
		} catch (Exception e) {
			System.out.println("0 오타가 발생하였습니다.");
		}
		
//		System.out.println("----------");
//		int result = Calculator.divide(price, weight);
//		System.out.println("g당 가격 : " + result);
		
		// / 0 (나누기0) , 배열 인덱스 -> 이건 애교스러운데?
		
		// 위험함 코드들은 예외처리 안하면 에러
		// 처리 안하고싶어도 해야하되는 ㅅㅂ같은상황
		
		// 컴에 a.txt 있나? 없으면 어칼거야?
		try {
			FileReader fr = new FileReader("C:/a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
