package com.lhj.oct071sdi.cvs;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhj.oct071sdi.MealBox;

// 편의점은 많은데
// 도시락은 그 반반도시락이 유일 -> singleton
// 기존의 singleton : 유지보수가...
// -> Spring식 singleton : beans.xml에 하나만 해놓으면 됨 간단 ㅇㅈ?
public class CVStore {
	
	// aac 방식 + annotation-config
	// beans.xml에 등록된 그 하나뿐인 도시락과 자동연결됨
	@Autowired
	private MealBox mealBox;
	
	// 생성자 - x / setter - x
	
	public void printMealBox() {
		mealBox.printInfo();
	}
}
