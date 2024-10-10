package com.lhj.oct045sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.lhj.oct045sdi.animal.Dog;

public class SDIMain {
	public static void main(String[] args) {
		// DI : 의존성 주입 (객체만들고 값 넣고) -> 수정할때 빡셈 -> 프로그램소스바꾸고 컴파일하고 압축하고 고객한테
		// Spring DI : xml에(외부파일에)
		//		-> 수정때 xml만 수정하면 끝
		// 1) beans.xml에 d1이라는 개 만들어놓고, 불러오기만 -> 주소가 같은 동일한 객체임
		// dlbf : 최초로 d1을 부를 때 객체 실제 생성
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xdbr = new XmlBeanDefinitionReader(dlbf);
		xdbr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		System.out.println("-------");
		
		Dog dd1 = dlbf.getBean("d1", Dog.class); // 이때 개 생성
		dd1.printInfo();
		
		Dog dd2 = dlbf.getBean("d1", Dog.class);
		dd2.printInfo();
		
		Dog dd3 = dlbf.getBean("d2", Dog.class);
		dd3.printInfo();
	}
}
