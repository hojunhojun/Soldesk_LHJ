package com.lhj.aug024opp.factory;


public class CarFactory {
	public static Car produce(int i) {
		if ( i == 1 ) {
			return new Truck();
		} else if ( i == 2 ) {
			return new Sedan();
		} return new Bus();
	}
}
