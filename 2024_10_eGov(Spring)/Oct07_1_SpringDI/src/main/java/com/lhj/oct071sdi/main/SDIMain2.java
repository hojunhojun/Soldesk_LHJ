package com.lhj.oct071sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lhj.oct071sdi.cvs.CVStore;

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("oct071beans2.xml"); // 객체 미리 만들고 시작
		aac.registerShutdownHook();
		
//		MealBox mb1 = aac.getBean("mb1", MealBox.class);
//		mb1.printInfo();
		CVStore c = aac.getBean("c", CVStore.class);
		c.printMealBox();
		aac.close();
	}
}
