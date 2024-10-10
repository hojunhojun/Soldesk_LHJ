package com.lhj.aug024opp.myself.main;

import com.lhj.aug024opp.lhj.HojunLee;

public class OMain {
	public static void main(String[] args) {
		// HojunLee lhj = new HojunLee("이호준", "인천");
		// lhj.printInfo();
		
		HojunLee lhj1 = HojunLee.getLhj();
		lhj1.printInfo();
		
		HojunLee lhj2 = HojunLee.getLhj();
		lhj2.printInfo();
		
		System.out.println(lhj1);
		System.out.println(lhj2);
		System.out.println("---------");
		
		
	}
}
