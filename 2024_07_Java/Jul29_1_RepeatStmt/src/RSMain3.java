// break : 반복문 종료
// continue : 턴 종료

import java.util.Scanner;

public class RSMain3 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			if (i == 2) {
				//break; // 반복문 제어용 break;
				continue; // Jump의 개념 (i가 2면 밑에 반복문을 뛰어넘음)
			}
			System.out.println(i);
		}
		System.out.println("-----");
		
		Scanner ci = new Scanner(System.in);
		int uci;
		// while문 구조상 조건식 쓰기가 애매함
		while (true) { // 냅다 무한루프
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("10. 종료");
			uci = ci.nextInt();
			if (uci == 1) { // 뭔가 처리하는 중인데
				System.out.println("등록관련");
			}
			if (uci == 2) {
				System.out.println("수정관련");
			}
			if (uci == 10) { // 거기에 하나 종료관련 추가
				break;
			}
		}
	}
}
