// if문

import java.util.Scanner;

public class RSMain4 {
	public static void main(String[] args) {
		
		a : for (int i = 0; i < 5; i++) {
			bb : for (int j = 0; j < 5; j++) {
				cc : for (int j2 = 0; j2 < 5; j2++) {
					System.out.println("-----");
					System.out.println(i);
					System.out.println(j);
					System.out.println(j2);
					if (j2==2) {
						break; // ??? 누구의 break인가? -> j2(가까운곳이 주인)
					}
				}
			}
		}
		Scanner ci = new Scanner(System.in);
		int menu = 0;
		dd : while (true) { // 반복문의 이름 지정(dd)
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("10. 종료");
			System.out.print("선택 : ");
			menu = ci.nextInt();
			switch (menu) {
			case 1:
				System.out.println("등록관련");
				break;
			case 2:
				System.out.println("수정관련");
				break;
			case 10:
				System.out.println("종료");
				break dd; // switch (dd종료)
			} 
		}
	}
}
