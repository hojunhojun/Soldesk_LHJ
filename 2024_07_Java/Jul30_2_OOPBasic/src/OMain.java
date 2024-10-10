// 	Procedural Programming(절차 지향 프로그래밍)
//		if, for, [] 등 -> 이과 마인드
// 		순서대로 효율적으로 잘 써서
//		어쨌든 프로그램 만들어 내자
// 	Object Oriented Programming(객체 지향 프로그래밍)
//		하드워어의 성능이 향상됨에 따라
//		유지보수에 용이한 형태로 만들자. -> 문과 마인드
//		소스코드가 쉬워야 유지보수에 용이함 -> 자바 소스로 실생활을 묘사하자

// 	자바가 어려운 이유?
//		일상생활에서 쓰는 말과 문법이 차이가 있음
//		-> 문법 자체가 일상언어랑 비슷해지면 쉬워질듯?

//	객체(Object) : 실생활에 존재하는 무언가
//	객체를 만들려면 class가 필요함.
public class OMain { // main이 있는 클래스는 ~~~main으로 작명합시다 !!
	public static void main(String[] args) { // main method
		// String???? int????
		String name = "후추";
		System.out.println(name);
		int age = 3;
		System.out.println(age);
		System.out.println("------");
		
		// 개 객체
		Dog dog1 = new Dog(); // 오 이게되네? 개 만들어버림 ㅋㅋ
		dog1.name = "후추";
		dog1.age = 3;
		dog1.bark();
		dog1.printInfo();
		
		Dog dog2 = new Dog();
		dog2.name = "소금";
		dog2.age = 5;
		dog2.bark();
		dog1.printInfo();
	}
}
