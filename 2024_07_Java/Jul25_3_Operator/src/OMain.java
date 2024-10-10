// 연산자
//	= 대입연산자
//		우항에 있는것을 좌항에 넣어라

import java.util.Scanner;

public class OMain {

	public static void main(String[] args) {

		// 입력부
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산기");
		System.out.print("x : ");
		int x = scanner.nextInt();
		System.out.print("y : ");
		int y = scanner.nextInt();

		// 계산부
		int result1 = x + y;
		int result2 = x - y;
		int result3 = x * y;
		int result4 = x / y;
		// double result4 = x / (double)y; -> 소수점 살리는 나누기(형변환★)
		int result4_1 = x % y;

		// 출력부
		System.out.println("--------------");
		System.out.println(x + " + " + y + " = " + result1);
		System.out.println(x + " - " + y + " = " + result2);
		System.out.println(x + " * " + y + " = " + result3);
		System.out.println(x + " / " + y + " = " + result4 + " ... " + result4_1);

// ----------------------------------------------------------------------------------

		System.out.println("--------------");
		String z = "ㅋ";
		System.out.println(x + z); // 붙여서 출력됨
		int aa = 30;
		String aaa = aa + ""; // 문자열로 바꾸기

		System.out.println("--------------");
		// System.out.println(x * z); : 정수와 문자열의 곱하기 케이스 -> 이건 불가

		System.out.println("--------------");
		// double result4_2 = x / (double)y; -> 소수점 살리는 나누기(형변환★)
		// System.out.printf("%.3f", result4_2);

		System.out.println("--------------");
		// x = x + 3;
		x += 3; // 축약버전 -> 다른것도 다 가능(+,-,*,/,%)
		System.out.println(x);

		System.out.println("--------------");
		// y-=1;
		y--; // 더 축약버전 -> ++ -- 만 가능 (개수 카운팅용)
		System.out.println(y);
		// Java = 컴퓨터 친화적
		// Python = 사람 친화적 -> 효율성X(대체할 수 있으면 없앰)
	
	}

}