package com.lhj.aug211jl.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.lhj.aug211jl.company.Company;
import com.lhj.aug211jl.snack.Snack;

public class ConsoleScreen {
	private Scanner inputSystem;
	
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public void end() {
		inputSystem.close();
	}
	
	public int showMainMenu() {
		System.out.println("1. 회사등록");
		System.out.println("2. 회사조회");
		System.out.println("3. 과자등록");
		System.out.println("4. 과자조회");
		System.out.println(".....");
		System.out.println("10. 종료");
		System.out.println("----------");
		System.out.print("선택 : ");
		return inputSystem.nextInt(); // 메인메뉴 보여주고 입력창 하나
	}
	
	public Company showRegCompanyMenu() {
		System.out.print("회사명 : ");
		String n = inputSystem.next();
		System.out.print("위치 : ");
		String a = inputSystem.next();
		System.out.print("직원수 : ");
		int e = inputSystem.nextInt();
		
		return new Company(n, a, e);
	}
	
	public Snack showRegSnackMenu() {
		System.out.print("이름 : ");
		String z = inputSystem.next();
		System.out.print("가격 : ");
		int x = inputSystem.nextInt();
		System.out.print("중량 : ");
		double c = inputSystem.nextDouble();
		System.out.print("유통기한 : ");
		String v = inputSystem.next();
		System.out.print("제조사 : ");
		String b = inputSystem.next();
		return new Snack(0, z, x, c, b, v);
	}
	public void printResult(ArrayList<Company> companys) {
		for (Company company : companys) {
			System.out.println(company.getName());
			System.out.println(company.getAddr());
			System.out.println(company.getEmp());
			System.out.println("----------");
		}
	}
	public void printResult(String result) {
		System.out.println(result);
		System.out.println("----------");
	}
	public void printSnackResult(ArrayList<Snack> snacks) {
		for (Snack snack : snacks) {
			System.out.println("과자 이름 : "+ snack.getName());
			System.out.println("가격 : " + snack.getPrice());
			System.out.println("중량 : " + snack.getWeight());
			System.out.println("유통기한 : " + snack.getExp());
			System.out.println("제조사 : " + snack.getC_name());
			System.out.println("-------------");
		}
	}
	public int getPageNo(int pageCount) {
		System.out.println("몇 페이지(1 ~ " + pageCount + ") : ");
		return inputSystem.nextInt();
	}
}
