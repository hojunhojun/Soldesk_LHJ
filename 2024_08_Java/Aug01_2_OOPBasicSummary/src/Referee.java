import java.util.Scanner;

public class Referee { // 실질적 main

	final static String[] RULEBOOK = { null, "가위", "바위", "보" };
	
	public static void start() {
		Enemy red = callRedCorner();
		User blue = callBlueCorner();
		readRuleBook();
		int redPaper;
		int bluePaper;
		int result;
		while (true) {
			redPaper = getRedPaper(red);
			bluePaper = getBluePaper(blue);
			tellHand(redPaper, bluePaper);
			
			result = judge(redPaper, bluePaper);
			if (result == 2) {
				break;
			}
			blue.win += result;
		}
		System.out.println(blue.win + "승");
	}
	
	public static void readRuleBook() {
		for (int i = 0; i < RULEBOOK.length; i++) {
			if (i > 0) {
				System.out.printf("%d. %s\n", i, RULEBOOK[i]);
			}
		}
	}

	public static Enemy callRedCorner() {
		return new Enemy();
	}

	public static User callBlueCorner() {
		return new User();
	}
	
	public static int getRedPaper(Enemy enemy) {
		return enemy.submit();
	}
	
	public static int getBluePaper(User user) {
		System.out.println("----------");
		System.out.print("뭐 낼래? : "); // 1 가위 2 바위 3 보
		int paper = user.submit();
		return (paper < 1 || paper > 3) ? getBluePaper(user) : paper;
	}
	
	public static int judge(int userHand, int comHand) {
		int t = userHand - comHand;
		String line = "----------";
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
	
	public static void tellHand(int redPaper, int bluePaper) {
		System.out.println("----------");
		System.out.printf("나 : %s\n", RULEBOOK[redPaper]);
		System.out.printf("컴 : %s\n", RULEBOOK[bluePaper]);
	}
	
	public static void tellWInCount(User user) {
		System.out.println(user.win + "승");
	}
}
