// 배열은 다 참조형 변수임.

// 기상청 100년치 날씨
// double weather = new double[] {???? 어케넣? 오늘, 내일꺼는 언제넣? 개빡인데};
// double만잇는것도 아닌데..? 맑음? 흐림?
// -> 객체 지향 언어에서는 사실상 배열 실전 사용 불가(실전 데이터 다루는 용으로는 부적합)
// -> 간단하게 데이터 몇개 표현하는 용도

// 배열 만들때 크기를 알아야함 ( 크기를 변경 불가능함 ) - 큰 단점
// 자료형 믹스 불가
public class Amain {
	public static void main(String[] args) {
		// 발전순서 1
		int[] eng = new int[3];
		eng[0] = 100;
		eng[1] = 90;
		eng[2] = 30;
		
		// 발전순서 2
		int[] mat = new int[] { 50, 30, 20 };
		
		// 발전순서 3
		int[] kor = { 100, 90, 30 }; // 안되는 순간이 있음 -> 순서2로 대체하시길..
		
		System.out.println(kor[0]);
		System.out.println(kor[1]);
		System.out.println(kor[2]);
		
		System.out.println(kor.length); // 배열 길이
		
		for (int i = 0; i < kor.length; i++) { // for문 자동완성시 가장 가까운 배열에 맞춰서 길이 세팅
			int t = kor[i];
			System.out.println(t); // 1
		}
		for (int t : kor) {
			System.out.println(t); // 2 -> 1과 같음(짧은 문법) : 배열을 차례대로 돌면서 반복
		}
		// 배열 탐색 : for
		// 반복 횟수 : for
		// 반복 조건 : while, do-while
	}
}
