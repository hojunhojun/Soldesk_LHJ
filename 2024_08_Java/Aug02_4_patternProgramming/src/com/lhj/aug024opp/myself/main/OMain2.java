package com.lhj.aug024opp.myself.main;

import com.lhj.aug024opp.soldesk.LeeSangwoo;
import com.lhj.aug024opp.soldesk.Student;

public class OMain2 {
	public static void main(String[] args) {
		LeeSangwoo lsw = LeeSangwoo.getLsw();
		Student s1 = lsw.talk("이호준", 23);
		s1.printInfo();
		System.out.println("----------");
		
		Student s2 = lsw.talk("김길동", 20);
		s2.printInfo();
	}
}
