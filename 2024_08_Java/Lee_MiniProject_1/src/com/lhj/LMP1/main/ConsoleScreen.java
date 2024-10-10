package com.lhj.LMP1.main;

import java.util.Scanner;

import com.lhj.LMP1.lalo.laloDAO;
import com.lhj.LMP1.weather.WeatherDAO;

// V
public class ConsoleScreen {
	private Scanner inputSystem;
	laloDAO ld = new laloDAO();
	WeatherDAO wd = new WeatherDAO();
	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}
	
	public String showInputAddr() {
		System.out.print("주소 입력 : ");
		String addr = inputSystem.next();
		return addr;
	}
	public void showWeather(String addr) {
		String[] coordinates = ld.getLalo(addr);
		
		String lat = coordinates[0];  
		String lon = coordinates[1];
		String addr2 = coordinates[2];
		
		String[] st = wd.getWeather(lat, lon, addr2);
		System.out.println(st[0]);
		System.out.println(st[1]);
		System.out.println(st[2]);
		
	}
	public void show(String addr) {
		
		String[] coordinates = ld.getLalo(addr);
		
		String lat = coordinates[0];  
		String lon = coordinates[1];
		String addr2 = coordinates[2];
		
		String[] st = wd.getWeather(lat, lon, addr2);
		Double st1 = Double.parseDouble(st[1]);
		if (st1 <= 0) { // 겨울
			System.out.println("겨울");
		} else if (st1 <= 10) { // 봄가을
			System.out.println("봄가을");
		} else if (st1 <= 20) {
			System.out.println("여름");
		}
	}
	public void end() {
		inputSystem.close();
	}
}
