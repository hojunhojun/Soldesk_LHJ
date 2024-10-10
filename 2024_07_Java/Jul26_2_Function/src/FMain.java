// 	WORA : 운영체제에 구애받지 않고 어디에서나 실행가능 (100%는 아님)
// 	1) JRE가 JVM을 만들어서 OS위에 올리고
// 	2) JVM위에서 자바프로그램이 실행됨
// 	3) JVM은 main함수를 자동으로 불러서 실행시킴
// 	-> 요즘 나오는 언어들은 다 저런데? 이게 장점?
// 	-> JVM을 얹는 과정때문에 속도가 느려짐
import java.util.Scanner;

public class FMain {

// 함수 정의
// public static 리턴타입 함수명(자료형 변수명, ...) {
// 	
// }

// 함수명 짓는 조건 = 변수명 짓는 조건
// 변수명 : 명사형 -> 함수명 : 동사형
// 동사 + 목적어		목적어 + 동사
// 기능별				주제별
//	deleteData			dataDelete
//	printEmotion		dataPrint
//	printData			weatherDelete
// 	printWeather		weatherUpdate
//	updateEmotion		WeatherPrint
// 함수 정리 팁 : 우클릭 + source + Sort Members (main은 맨 아래로)

	// 정수를 2개 넣으면 더 큰 수를 구하는 함수(구하기만 하기 때문에 리턴타입을 int로)
	public static int compareTwoNumber(int num1, int num2) {
		return (num1 > num2) ? num1 : num2;
	}

	// 날씨 정보 입력받아 콘솔에 출력하는 함수(리턴타입 void)
	public static void printWeather() {
		Scanner user = new Scanner(System.in);
		System.out.print("온도 입력 : ");
		double temp = user.nextInt();
		String comment = temp >= 30 ? "더움" : "추움";
		System.out.println(comment);
	}

	// 날씨 변수 선언Ver(계산하고 출력까지)
	public static void printWeatherVer2(double temp) {
		System.out.println(temp >= 30 ? "더움" : "추움");
	}

	public static void main(String[] args) {
		printWeather();
		printWeatherVer2(35);
		printWeatherVer2(25);
		System.out.println(compareTwoNumber(11, 22));
		int result = compareTwoNumber(11, 22);
		System.out.println(result);
	}
}