// 	Android vs 	iPhone
//	Java	vs	Objective-C
//	유명함	vs 	뭐임....?
//	자료많음	vs	자료 적음
// 	GC O	vs	GC X

// Java :	전세계적으로 엄청 많이 사용되는 언어
//			개발자들끼리 자기가 작업한거 공유하는 문화가 생김
//			Maven, Gradle

// 어떤 프로그래밍언어를 마스터
// 		조건문
//		반복문
//		배열
//		그 언어(자바)만의 특징적인 부분 : 개발자들끼리 자기가 작업한거 공유하는 문화가 생김
//		C언어 : 메모리 공간 직접 타격

// Pen.java 제출 -> 소스 다 보이는데...? -> 내 아이디어(지적재산권은..?)

// ~~~.java[영어] -> compile -> .class[기계어] -> .jar[자바 압축파일]
// 직장상사한테 Pen.java의 기능만 주면됨, 소스까지는 ㄴㄴ -> .jar을 제출
// Export -> JAR file
// -> 소스를 못보니 사용하는 사람이 잘못쓸수도 -> 설명서 필요
// 사용법
/** 
 * 이것은 볼펜입니다. 여기에 할 말을 쓰시면 됩니다
 * 네 물론 enter키도 먹고요 ㅋㅋ 
 * */

// 설명서까지 다 쓴다음 -> Project -> Generate javadoc -> 경로 폴더 새로 만들고 지정 -> index.html 제출

// 최종 제출물 : ~~~.jar, index.html
public class Pen {
	String name; // 클래스 영역에서 생성된 변수(member variable)
	String color; // attribute(속성) 이라고도 함
	int price; // field 라고도 함
	
	/** 
	 * 펜의 이름, 색깔, 가격을 출력해주는 method입니다. showInfo();
	 * */
	public void showInfo() { // method
		System.out.println("이름 : " + name);
		System.out.println("색깔 : " + color);
		System.out.println("가격 : " + price);
	}
	
	/**
	 * bmi계산기
	 * @param height 키, 미터단위
	 * @param weight 몸무게
	 * @return 계산된 bmi
	 **/
	public double calculate(double height, double weight) {
		return 1;
	}
}
