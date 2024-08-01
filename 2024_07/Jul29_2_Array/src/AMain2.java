// 원래 자바 프로그램 실행 : java -far 파일명 aaa bbb ccc 
// -> a b c 친구들이 배열로 들어감

// DB/AI 분야에 들어가면
// java -jar 파일명 subwat.csv subwayResult.txt // 이 용도임
// java -jar 파일면 분석대상파일 분석결과파일

// 실행파일 만들기, String[] args -> 실전에서 중요

// 빅데이터/AI : PC에서 불가
//				서버급컴 여러대로 병렬처리 해야 봐줄만함

// 회사가면 PC(windows), 서버(linux) -> PC에서 프로그램 만들고 -> 테스트 -> 실행은 서버에서
// 인공신경망 : 컴 사양이 부족해서...
public class AMain2 {
	public static void main(String[] args) throws InterruptedException { //String[] args의 뜻은? -> 클래식 for문
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		System.out.println("-----");
		
		// 신형for
		for (String string : args) {
			System.out.println(string); // 그래서 얘는 뭐임?
		}
		
		Thread.sleep(30000);
	}
}
