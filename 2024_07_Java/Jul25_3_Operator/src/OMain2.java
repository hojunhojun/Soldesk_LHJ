
// 논리 연산자
// > , >= , == , != , <= , <
// &&(and), ||(or), ^(xor), !(not)
//	xor(배타적) -> 서로 달라야함	
//	a	b
//	o	o	->	x
//	x	o	->	o
//	o	x	-> 	o
//	x	x	-> 	x
import java.util.Scanner;

public class OMain2 {
	public static void main(String[] args) {

		// 입력부
		Scanner keyBoard = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = keyBoard.next();
		System.out.print("키 : ");
		double height = keyBoard.nextDouble();
		System.out.print("나이 : ");
		int age = keyBoard.nextInt();

		// 출력부
		System.out.println("-------------------------");
		System.out.printf("이름은 %s, 키는 %.1fcm, 나이는 %d살\n", name, height, age);

		// 조건부
		boolean a = (height >= 150); // 키가 150보다 큰가?
		System.out.println(a);
		boolean b = (age < 20); // 나이가 20살보다 어린가?
		System.out.println(b);
		boolean c = (age % 2 == 1); // 나이가 홀수인가?
		System.out.println(c);
		boolean d = name.equals("홍길동"); // 이름이 홍길동인가? (String 변수는 참조형이기 때문에 차이)
		System.out.println(d);

		// &&(확률 낮은거를 앞으로), ||(확률 높은거를 앞으로) 검사 속도 감소
		
		// 나이가 10살 이상이고, 키가 200cm 초과 (앵간하면 검사 1번)
		boolean e = (height > 200 && age >= 10);
		// 나이가 10살 이상이고, 키가 200cm 초과 (앵간하면 검사 2번)
		// boolean e = (age >= 10 && height > 200);
		System.out.println(e);
		
		// 나이가 10살 이상이거나, 키가 200cm 초과 (앵간하면 검사 1번)
		boolean f = (age >= 10 || height > 200);
		// 나이가 10살 이상이거나, 키가 200cm 초과 (앵간하면 검사 2번)
		// boolean f = (height > 200 || age >=10);
		System.out.println(f);
		
		// 키가 200cm 초과하던지, 나이가 10살 이상이든지 1개만 (순서상관없음 -> 어차피 2개 다 검사)
		boolean g = (height > 200 ^ age >= 10); // xor 연산자 활용
		System.out.println(g);
		
		// g를 탈수있는 사람은 못탐, g를 못타는 사람은 탐 (g반대로)
		boolean h = !g; //not 연산자 활용
		System.out.println(h);
		
		// 단항 	: !
		// 2항 	: 나머지...
		// 3항 	: ? : 
		
		// 나이가 20살 이상이면 "어서오세요"
		// 아니면 "나가"
		String comment = age >= 20 ? "어서오세요" : "나가"; // if문보다 연산량 감소
		System.out.println(comment);
	}
}