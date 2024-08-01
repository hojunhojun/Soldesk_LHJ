// 변수 : 데이터를 저장할수 있는 메모리상의 공간 (데이터를 담는 그릇)
// 언제? : 프로그램을 진행하는 과정에서 발생하는 데이터 일시적으로 저장해야하는 데이터를 처리할 때에 사용

// 기본형
// 정수 : byte, short, int(정배), long(값이 클때)
// 실수 : float, double(정배)
// 글자 하나 : char
// 논리형 : boolean
// 자리 차지 : void
// 자바 문법, 띄어쓰기, 특수문자 불가 (최대한 뜻이 통하게)
// 기본형 데이터는 여기에 저장 -> 용량이 적음, 일정함

// 참조형
// 객체 String(글자 쓸땐 이게 정배, 문자열 객체)
// 배열
// 나머지

// 기본형 VS 참조형
// RAM은 OS가 논리적으로 나누어져서 사용함
// 기본형 변수는 Stack 밑에서부터 차곡차곡 배정 (프로그램이 종료되면 데이터가 지워짐)
// 참조형은 heap 컴퓨터가 적당한 위치 골라 배정 -> 개발자가 직접 지워야함  (자바에서는 여기에 저장)
// Garbage Collction은 heap 영역 자동정리시스템;

public class VariableMain {
	
	public static void main(String[] args) {
		
		int maxTable = 10; // 전체 테이블 수
		double starPoint = 4.5; // 별점
		String name = "김밥천국"; // 식당이름
		boolean dayOff = false; // 휴무 여부
		
		System.out.println("--------");
		
		System.out.println(maxTable);
		System.out.println(starPoint);
		System.out.println(name);
		System.out.println(dayOff);		
		
		System.out.println("--------");
		
	}
	
}