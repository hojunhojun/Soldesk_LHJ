package com.lhj.oct044s.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.lhj.oct044s.avengers.Avengers;

// POJO, DI, IoC, AOP

// EJB				vs		Spring
// JavaBean에 설정				POJO(Plain Old Java Object)
//							평소에 쓰던 자바 객체
// Spring : Java진영에서, IOC로 DI지원해주는 Framework
//			-> 객체를 자바소스X -> 외부파일에
// DI(Dependenct injuciton - 의존성 주입)
//		객체 만들고, 값 넣고
// IOC(Inversiol of Control - 제어의 역전)
//		파일로 프로그램제어
public class SMain {
	public static void main(String[] args) {
		// 1. 의사소통문제는 아까 해결
		// 2. 유지보수
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xdbr = new XmlBeanDefinitionReader(dlbf);
		xdbr.loadBeanDefinitions(new ClassPathResource("abcd.xml"));
		
		Avengers a = dlbf.getBean("aa", Avengers.class);
		a.attack();
	}
}
