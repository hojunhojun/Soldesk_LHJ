package com.lhj.aug024opp.myself.main;

import com.lhj.aug024opp.factory.Car;
import com.lhj.aug024opp.factory.CarFactory;

public class OMain3 {
	public static void main(String[] args) {
		Car c1 = CarFactory.produce(1); // 트럭
		c1.test();
		
		Car c2 = CarFactory.produce(2); // 세단
		c2.test();
		
		Car c3 = CarFactory.produce(3); // 버스
		c3.test();
	}
}
