// 	지역변수(local variable)
//		기본값이 없어서 초기화 하고 사용해야함.
//		함수 속에서 만든 변수
//		함수 진행하는 동안만 쓰고 버릴 임시 데이터
// 	함수 parameter
//		그 함수 진행에 필요한 재료
//		기본값 개념 없이, 함수 호출할때 넣어주는
//	멤버변수(member variable)
//		객체의 속성
//		기본값이 있음(참조형 : null, 기본형 : 0)

// 클래스 바깥에있으면 함수 -> 안에 있으면 method임 : 바깥에 있는게 불가해서 함수는 존재가 불가능함

// 	함수 			vs 		메소드
//	function 	vs 		method
// 	단순 기능 집합 	vs 		멤버함수(객체의 액션)

// 	Java에는 함수가 없음...(Function도 없는말임)
//	Java 	: perfect한 OOL 	-> 객체지향만을 위한 언어
//	Python 	: hybrid한 OOL	-> 섞여있는(객체지향해도 상관X) 언어
public class Dog { // main이 없음
	// 멤버변수
	// 속성 : 멤버변수
	String name; 	// 기본값 초기화 X
	int age;		// 기본값 초기화 X
	
	// 액션 : 멤버 함수(이건사실없는말임)-> method
	public void bark() {
		System.out.println("멍");
	}
	
	// 프로그램상 필요한 기능도 method로 구현
	public void printInfo() { // 이름찍는거는 실제 행동이 아니지만 필요하니..
		System.out.println(name);
		System.out.println(age);
	}
}
