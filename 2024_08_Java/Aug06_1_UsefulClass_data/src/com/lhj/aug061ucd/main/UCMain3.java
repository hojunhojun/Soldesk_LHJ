package com.lhj.aug061ucd.main;

import java.util.Scanner;
import java.util.StringTokenizer;

// 숫자(A,B,C...,Z) : 
// ----------
// 합계 : 
//
public class UCMain3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력(A,B,C...,Z) : ");
		String num = sc.next();
		System.out.println("-------------------");
		
		int sum = 0;
		
		StringTokenizer numar = new StringTokenizer(num, ",");
		while (numar.hasMoreTokens()) {
			try {
				sum += Integer.parseInt(numar.nextToken());
			} catch (Exception e) {
 
			}
			
		}
		System.out.println("합계 : " + sum);
	}
}
