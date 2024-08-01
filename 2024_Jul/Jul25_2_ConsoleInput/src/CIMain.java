import java.util.Scanner; // 콘솔 입력받는 세팅

public class CIMain {
	
	public static void main(String[] args) {
		
		System.out.println("식당 정보 등록하기");
		System.out.println("-------------------------");
		
		// 콘솔 입력받을 준비
		Scanner keyBoard = new Scanner(System.in);
		
		// 안내
		System.out.print("테이블 수 : ");
		int tableCount = keyBoard.nextInt();
		
		System.out.print("별점 : ");
		double starScore = keyBoard.nextDouble();
		
		System.out.print("이름 : ");
		String name = keyBoard.next();
		
		System.out.print("휴무 여부 : ");
		boolean dayOff = keyBoard.nextBoolean();
		
		// 결과 출력
		System.out.println("-------------------------");
		System.out.println("식당 정보 등록이 완료되었습니다.");
		System.out.println("등록된 식당 정보");
		System.out.println("식당 테이블 수 : " + tableCount);
		System.out.println("식당 별점 : " + starScore);
		System.out.println("식당 이름 : " + name);
		System.out.println("휴무 여부 : " + dayOff);
		
	}
	
}