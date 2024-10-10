package com.lhj.oct043ns.main;

import com.lhj.oct043ns.avengers.Avengers;
import com.lhj.oct043ns.avengers.Hulk;

public class NSMain {
	public static void main(String[] args) {
		// interface써서
		// 1. 의사소통문제 해결
		// 2. 유지보수 작업량 감소(완전해결은아님)
		Avengers a = new Hulk(); //Ironman();
		a.attack();
	}
}
