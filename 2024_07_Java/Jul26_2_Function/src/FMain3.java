// 	함수의 재귀적 사용은 검사용(원하는 데이터 나올때까지 반복)
import java.util.Scanner;

public class FMain3 {
	
	public static int getEven() { // 재귀 예제
		Scanner user2 = new Scanner(System.in);
		System.out.print("짝수 : ");
		int num = user2.nextInt();
		return (num % 2 == 0) ? num : getEven();
	}
	
	public static void main(String[] args) {
		int x = getEven();
		System.out.println("----------");
		System.out.println(x);
	}
}
