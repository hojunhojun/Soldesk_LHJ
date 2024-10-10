package com.lhj.aug025op.main;

import com.lhj.aug025op.human.Guard;
import com.lhj.aug025op.human.Human;
import com.lhj.aug025op.human.Student;

//	polymorphism(다형성)
//	상위타입 변수에 하위타입 객체 담기 가능
// 	최종적으로는 하위타입 객체
public class OMain {
	
	public static void main(String[] args) {
		 Student s = new Student();
		 
		 // 모든 사람을 다 담을수있는 h에 학생 담음
		 Human h = new Student();
		 h.print();
		 h = new Guard();
		 h.print();
		 
		 Guard g = new Guard();
		 Human[] ar = {s, g};
	}	
}
