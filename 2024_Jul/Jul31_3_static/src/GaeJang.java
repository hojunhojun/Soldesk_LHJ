// 익숙해졌다 -> 속도전(Speed를 향상시켜보자)

// 메모리 -> static, stack, heap의 3공간

// 멤버변수에 "언제" 값을 넣고싶은가
// 	->	따로 입력안해도 세팅되어있는 기본값 -> 내일
//	static 멤버변수
//		- 모든 객체들의 공통속성
//		- 메모리 절약
//		- 객체를 만들지 않아도 쓸수 있는 변수
//		- main메소드 실행 이전에 만들어지는 것

// 	static 메소드
//	-> 객체를 만들지 않아도 쓸수있는 메소드
//	-> static 메소드에서 static이 아닌거 사용 불가
//	-> 메모리 절약
// 	static final : 상수(수정불가) -> 전부 대문자로
public class GaeJang {
	String name;
	int price;
	double weight;
	static String producer = "김수미";
	// Q1. 이 세상의 모든 게장은 다 김수미가 생산 한다면?
	// final static String PRODUCER = "김수미"; // 세팅완료
	
	public static void test() {
		// System.out.println(name); // 오류 : static이 아님
		System.out.println(producer);
		System.out.println("ㅋ");
	}
	
	public void show() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price + "원");
		System.out.println("무게 : " + weight + "kg");
		System.out.println("생산자 : " + producer);
	}
}
