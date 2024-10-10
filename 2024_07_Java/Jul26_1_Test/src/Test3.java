// 밑의 클래스도 일종의 AI임(약간의 머신러닝)
// 설계
// 	- 이름, 키, 몸무게 입력받아서 BMI 지수 계산 후 측정
// 	- 함수 기능을 이용하여 정리하기
import java.util.Scanner;

public class Test3 {
	
	public static String userName() {
		Scanner user = new Scanner(System.in);
		System.out.print("이름 : ");
		return user.next();
	}

	public static double getWeight() {
		Scanner user = new Scanner(System.in);
		System.out.print("몸무게 : ");
		return user.nextDouble();
	}

	public static double getHeight() {
		Scanner user = new Scanner(System.in);
		System.out.print("키 : ");
		double height = user.nextDouble();
		return (height > 3) ? getHeight() : height;
	}
	
	public static double getBmi(double height, double weight) {
		return weight / (height * height);
	}
	
	public static void printResult(String name, double bmi) {
		System.out.printf("BMI : %.1f\n", bmi);
		String result = "저체중";
		if (bmi > 38.9) {
			result = "고도 비만";
		} else if (bmi > 31.9) {
			result = "중도 비만";
		} else if (bmi > 29.9) {
			result = "경도 비만";
		} else if (bmi > 23.9) {
			result = "과체중";
		} else if (bmi > 9.9) {
			result = "정상";
		}
		System.out.printf("%s씨는 %s\n", name, result);
	}
	
	public static void main(String[] args) {
		String name = userName();
		double height = getHeight();
		double weight = getWeight();
		double bmi = getBmi(height, weight);
		printResult(name, bmi);
	}

}
