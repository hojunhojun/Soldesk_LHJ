import java.util.Scanner;

public class Test2 {
	
	public static void main(String[] args) {
		
		// 입력부
		Scanner user = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("잔돈 계산 프로그램");
		System.out.print("물건 가격 : ");
		int price = user.nextInt();
		System.out.print("낸 돈 : ");
		int input = user.nextInt();
		
		// 조건부
		int result = input - price;
		int a = result / 50000;
		int b = (result % 50000) / 10000; 
		int c = (result % 10000) / 5000; 
		int d = (result % 5000) / 1000;
		int e = (result % 1000) / 500;
		int f = (result % 500) / 100;
		int g = (result % 100) / 50;
		int h = (result % 50) / 10;
		
		// 출력부
		System.out.println("----------------");
		System.out.println("거스름돈 : " + result);
		System.out.println("----------------");
		System.out.println("오만원권 : " + a);
		System.out.println("만원권 : " + b);
		System.out.println("오천원권 : " + c);
		System.out.println("천원권 : " + d);
		System.out.println("오백원 : " + e);
		System.out.println("백원 : " + f);
		System.out.println("오십원 : " + g);
		System.out.println("십원 : " + h);
		
	}
}