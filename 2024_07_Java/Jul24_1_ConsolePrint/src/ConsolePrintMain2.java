// \n : new line(줄만 바꿈)
// \r : carriage return(커서를 맨 앞으로)
// \r\n : 제대로 줄바꿈
// \t : Tab키
// \b : 백스페이스(1byte 지우기)
// \\ : 역슬래시 글자 입력(\)

public class ConsolePrintMain2 {

	public static void main(String[] args) {

		System.out.println("ㅋㅋㅋ\nㅎㅎㅎ");
		System.out.println("ㅋㅋㅋ\rㅎㅎㅎ");
		System.out.println("ㅋㅋㅋ\r\nㅎㅎㅎ");
		
		System.out.println("-----");
		
		System.out.println("ㅋㅋㅋ\tㅎㅎㅎ");
		System.out.println("ㅋㅋㅋ\bㅎㅎㅎ");
		System.out.println("ㅋㅋㅋ\\ㅎㅎㅎ");
		System.out.println("C:\\Users\\soldesk\\Eclipse\\Java");
		
		int a = 10;
		System.out.printf("a는 %d\n", a);
		System.out.printf("b는 %04d\n", 5);
		System.out.printf("c는 %f\n", 5.1654234);
		System.out.printf("d는 %.2f\n", 5.1654234);
		System.out.printf("e는 %s\n", "ㅋㅋㅋ");
		System.out.printf("e는 %s, a는 %d다\n", "ㅋㅋㅋ", 10);
		System.out.printf("습도 : %.2f%%\n", 65.1234);
		
	}

}

// %d = decimal -> 정수형 데이터 들어갈 자리
//		%04d : 4자리로, 빈자리는 0채워서
// %f = float -> 실수형 데이터 들어갈 지리
//		%.3f : 소수점 이하 3자리로(반올림)
// %s = string -> 문자열 데이터 들어갈 자리
// %% = %