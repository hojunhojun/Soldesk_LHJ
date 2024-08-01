import java.util.Scanner;

public class Guest {
	String name;
	double height;
	double weight;
	Scanner mouth = new Scanner(System.in); // 의미에 맞게 재사용
	double bmi;
	String status;
	
	// 개인정보 말하기
	public String tellName() {
		return mouth.next();
	}
	
	public Double tellHeight() {
		return mouth.nextDouble();		
	}
	
	public Double tellWeight() {
		return mouth.nextDouble();
	}
}
