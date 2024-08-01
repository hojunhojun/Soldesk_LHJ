// 비만도 검사 : OOP 스.타일로 만들어보자 ->	main 부분은 초보자가 봐도 딱 알야아함
// 					최대한 일상생활 묘사
// 객체지향 디자인 (OOD)
// 실제 병원에 가서 비만도검사 하는 상황을 상상해보자
// 시물레이션 느낌 : 실생활묘사 -> 소스 알아보기 쉬워서 -> 유지보수에 용이
// 클래스 단위 작업 -> 협업
// 개발X, 누가 만들어놓은거 잘 찾아쓰기
public class OMain {
	
	public static void main(String[] args) {
		Doctor d = new Doctor(); // 의사 출근
		d.start(); // 의사 업무 시작
	}
}
