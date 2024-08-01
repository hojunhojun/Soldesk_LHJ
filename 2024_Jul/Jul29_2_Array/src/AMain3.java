
public class AMain3 {
	public static void getSum(int a, int b) { // 숫자 2개 합 출력 함수
		System.out.println(a + b);
	}

	// 함수명 : 기능 알아보기 좋게 만들기
	// 기본적으로 함수명은 달라야함
	// 숫자 2개 넣으면 합 출력 / 숫자 3개 넣으면 합 출력 -> 이게 뭐가다름 왜? 굳이?
	// 함수 인수가 다르면 함수 이름 같아도 됨(개수가 다르던지, 자료형이 다르던지 -> parameter 부분이 다르면)
	// 호출할때 구분이 되니까 가능 ㅇㅇ
	// overloading : 일부러 함수명 같게(파라미터부분은 다르고) 짓는 기술명 (함수 overloading)
	// 파이썬은 불가?

	public static void getSum(int a, int b, int c) { // 숫자 3개 합 출력 함수(overloading의 예)
		System.out.println("3개짜리");
		System.out.println(a + b + c);
	}

	// 정수를 몇개 넣든지 그 곱을 출려하는 함수
	// 함수 파라메터 쓸때 : 자료형... 변수명 -> 함수 내부에서는 배열취급
	public static void getMul(int...is) {
		// 함수 내부에서는 배열취급
		int result = 1;
		for (int i = 0; i < is.length; i++) {
			result *=is[i];
		}
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		getMul(1,2,3,4);
		
		System.out.println(10);
		System.out.println("ㅋ");
		System.out.println(10 + ""); // String으로 바꾸는 스킬
		System.out.println(1.5 + ""); // 지금은 굳이 필요 없음
		
		getSum(1, 2);
		getSum(2, 33);

		getSum(1, 2, 3);
		getSum(1, 3, 5);
	}
}
