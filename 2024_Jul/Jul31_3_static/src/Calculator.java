// 객체 왜 만드냐? : 실생활스러운 변수사용
// 변수 왜 만드냐? : 데이터 임시저장
// 데이터를 저장할 일이 없으면 안만드는게 좋음
// -> 계산기 객체 만들필요 X
// 계산기
public class Calculator {
	public static void printResult(int x, int y) { // static 메소드이므로 객체생성 필요X
		System.out.println(x + y);
	}
}
