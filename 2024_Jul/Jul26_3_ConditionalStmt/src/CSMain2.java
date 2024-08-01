// 	자바 조건문
// 	1) if - else if - else (조건식 사용 가능) : if문이 짱이얌
// 	2) switch - case (값 사용 가능 -> 식 사용 불가) : 기본형 변수만 가능하지만 버전이 바뀌며 패치해줌
//					  잘 안씀(밑에처럼 특수한 상황에 좋음 -> 권한설정)
public class CSMain2 {

	public static void main(String[] args) {

		int score = 80;

		switch (score) {
		case 80:
			System.out.println("80점이네");
			break;
		case 70:
			System.out.println("70점이네");
			break;
		default:
			System.out.println("나머지");
			break;
		}
		
		System.out.println("---------");
		
		String grade = "이병";
		
		switch (grade) {
		case "이병":
			System.out.println("눈치");
		case "일병":
			System.out.println("관등성명");
		case "상병":
			System.out.println("훈련");
		default:
			System.out.println("잠");
			break;
		}
		
		System.out.println("---------");
		
		String role = "DBA";
		
		switch (role) {
		case "DBA":
			System.out.println("계정관리");
			System.out.println("백업/복구");
			System.out.println("서버관리");			
		case "DBP":
			System.out.println("CRUD");
		case "DBU":
			System.out.println("서비스 이용");
		default:
			break;
		}
	}

}