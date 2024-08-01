import java.util.Random;
import java.util.Scanner;

public class PPSMain {
	
	public static void printRule(String[] hand) {
		for (int i = 0; i < hand.length; i++) {
			if (i > 0) {
				System.out.printf("%d. %s\n", i, hand[i]);
			}
		}
	}
	
	public static int getInput() {
		Scanner ci = new Scanner(System.in);
		System.out.println("----------");
		System.out.print("뭐 낼래? : "); // 1 가위 2 바위 3 보
		int hand = ci.nextInt();
		System.out.println("----------");
		return (hand < 1 || hand > 3) ? getInput() : hand;
	}
	
	public static int getCom() {
		Random ran = new Random();
		return ran.nextInt(3) + 1;
	}
	
	// 	알고리즘
	//	1) 사람이 사고하는 과정 묘사
	//	2) 뭔가 효율적인거 없을까
	//	3) 아예 다른 생각 -> 계속 해보기 -> 유연한 사고
	
	//	가위바위보 알고리즘
	public static int judge(int userHand, int comHand) {
		int t = userHand - comHand;
		String line = "----------";
		int count=0;
		if (t == 0) {
			System.out.printf("%s\n무\n", line);
			return 0;
		} else if (t == -1 || t == 2) {
			System.out.printf("%s\n패\n", line);			
			return 2;
		}
		System.out.printf("%s\n승\n", line);
		return 1;
		
	}
	
	public static void printHand(int userHand, int comHand, String[] hand) {
		System.out.printf("나 : %s\n", hand[userHand]);
		System.out.printf("컴 : %s\n", hand[comHand]);
	}
	
	public static void main(String[] args) {
		String[] hand = {null, "가위", "바위", "보"};
		printRule(hand);
		int userHand;
		int comHand;
		int result;
		int win = 0;
		while (true) {
			userHand = getInput();
			comHand = getCom();
			printHand(userHand, comHand, hand);
			result = judge(userHand, comHand);
			if (result == 2) {
				break;
			}
			win += result;
		}
		System.out.println(win + "연승");
	}
}
