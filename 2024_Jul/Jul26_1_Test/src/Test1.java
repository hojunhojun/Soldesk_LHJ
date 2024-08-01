import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		// 입력부
		Scanner user = new Scanner(System.in);

		System.out.println("자전거의 이동 거리 계산 프로그램");
		System.out.println("-------------------------------");

		System.out.print("자전거 바퀴 둘레 입력(cm) : ");
		double radius = user.nextDouble();
		System.out.print("앞 기어 톱니 갯수 입력 : ");
		int front = user.nextInt();
		System.out.print("뒷 기어 톱니 갯수 입력 : ");
		int back = user.nextInt();
		System.out.print("페달 구른 횟수 : ");
		int count = user.nextInt();

		// 조건부
		double result = radius * (front / (double)back) * count;

		// 출력부
		System.out.println("-------------------------------");
		System.out.printf("자전거의 이동 거리 : %.2fm", result / 100);

	}

}