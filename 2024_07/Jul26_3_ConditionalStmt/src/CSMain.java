import java.util.Scanner;

public class CSMain {

	public static void main(String[] args) {

		// 입력부
		Scanner user = new Scanner(System.in);
		System.out.print("중간고사 : ");
		int midscore = user.nextInt();
		System.out.print("기말고사 : ");
		int fiscore = user.nextInt();

		// 조건부
		double avgscore = (midscore + fiscore) / 2.0;
		System.out.println("평균점수 : " + avgscore);

		// 출력부
		if (avgscore >= 90) {
			System.out.println("수");
		} else if (avgscore >= 80) {
			System.out.println("우");
		} else if (avgscore >= 70) {
			System.out.println("미");
		} else if (avgscore >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}

	}
}
