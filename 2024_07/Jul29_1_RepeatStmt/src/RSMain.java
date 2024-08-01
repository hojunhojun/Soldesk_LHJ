// 반복횟수가 명확 : for(자유자재로 다룰 수 있어야 함
// 	f11 -> 	debug mode
// 			f6 : 한줄 실행
public class RSMain {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		int ans = 0; // 그러므로 밖에 선언
		for (int i = 1; i < 10; i++) {
			ans = 2 * i; // 반복문속에서 변수 만드는 행위는 자제하기
			System.out.printf("2 x %d = %d\n", i, ans);
			// System.out.println("2 x " + i + " = " +  2 * i);
		}
		
		System.out.println("-----");

		int sum = 0;
		for (int i = 1; i < 11; i++) {
			sum += i;
			System.out.println(sum);
		}
		
		System.out.println("-----");
		
		// 반복문속에서 변수 만들기는 피하자
		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan*i);
			}
		}
		
		System.out.println("-----");
		
		for (int j = 1; j < 10; j++) { // 
			for (int dan = 2; dan < 10; dan++) {
				System.out.printf("%d x %d = %d\t", dan, j, dan * j);
			}
			System.out.println(); // 콘솔특화 구구단
		}
		
		System.out.println("-----");

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-----");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("-----");
		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <=i; j++) {
//				if (i == j) {
//					System.out.print("*");
//				} else {
//					System.out.println(" ");
//				}
//			}
//			System.out.println();
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i == j) ? "*" : " ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		String s;
		for (int i = 0; i < 5; i++) {
			s = (i % 2 == 1) ? "ㅎ" : "ㅋ";
			for (int j = 0; j <= (i * 2); j++) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}