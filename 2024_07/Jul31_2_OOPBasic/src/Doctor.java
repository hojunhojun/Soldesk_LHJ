// OOD
// 실생활 묘사 -> 소스 알아보기 쉬워서 -> 유지보수에 용이
// 클래스 단위로 나눠서 작업 -> 협업 용이/코드 재사용성 증가
// 데어터 묶어서 갖고 다니
public class Doctor {
	
	// 환자를 부름
	public Guest callGuest() {
		return new Guest();
	}
	
	// 개인정보 조사(질문)
	public void ask(Guest guest) { // 손님에게 질문
		System.out.print("이름 : ");
		guest.name = guest.tellName();
		
		System.out.print("키(m) : ");
		guest.height = guest.tellHeight();
		
		if ( guest.height > 3 ) { 
			guest.height /=100;
		}
		
		System.out.print("몸무게 : ");
		guest.weight = guest.tellWeight();
	}
	
	// BMI 계산
	public void calculate(Guest guest) { // 손님 BMI 계산
		guest.bmi = guest.weight / (guest.height * guest.height);
		guest.status = "저체중";
		if (guest.bmi > 38.9) {
			guest.status = "고도 비만";
		} else if (guest.bmi > 31.9) {
			guest.status = "중도 비만";
		} else if (guest.bmi > 29.9) {
			guest.status = "경도 비만";
		} else if (guest.bmi > 23.9) {
			guest.status = "과체중";
		} else if (guest.bmi > 9.9) {
			guest.status = "정상";
		}
	}
	
	// 결과 전달
	public void tellResult(Guest guest) { // 손님 결과 계산
		System.out.printf("BMI : %.1f\n", guest.bmi);
		System.out.printf("%s씨는 %s\n", guest.name, guest.status);
	}
	
	public void start() { // 업무 시작
		Guest guest = callGuest(); // 의사 입장에서 퇴근하고 나면 없어질 존재
		ask(guest);
		calculate(guest);
		tellResult(guest);
	}
}
