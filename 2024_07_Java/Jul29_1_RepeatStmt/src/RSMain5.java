import java.util.Random;
import java.util.Scanner;

public class RSMain5 {

	public static int pickGameAns() {
		Random r = new Random();
		return r.nextInt(10001);
	}

	public static int tell() {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 : ");
		int ans = scan.nextInt();
		return (ans < 1 || ans > 10000) ? tell() : ans;
	}
	
	public static boolean jugde(int gameAns, int userAns) {
		if (gameAns < userAns) {
			System.out.println("DOWN");
		} else if (gameAns > userAns) {
			System.out.println("UP");
		} else {
			System.out.println("정답");
			return false;
		} return true;
	}

	public static void printResult(int count) {
		System.out.println(count + "번 만에 성공");		
	}

	public static void main(String[] args) {
		int gameAns = pickGameAns();
		int userAns;
//		int count = 0;
//		while (true) {
//			count++;
		for (int count = 0; true; count++) { // 대체문
			userAns = tell();
			if (!jugde(gameAns, userAns)) {
				printResult(count);
				break;
			}
		}
	}
}
