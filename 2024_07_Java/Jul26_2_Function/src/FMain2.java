// 	함수를 재귀적으로 호출 (코딩 skill)
//	ex)
// 	plus1 = 1
// 	plus2 = 2 + plus1
// 	plus3 = 3 + plus2 
// 	plus4 = 4 + plus3 ...

// 	함수 : 정의해놓고 호출해서 사용 -> Jump연산이 발생해 (main에 나열하는것 보다)느려짐
//		-> 하지만 요즘 하드웨어 성능의 상향으로 알고리즘의 퀄리티보다 유지보수에 용이한 프로그램 선호
//		-> 함수를 사용하는 이유 : 가독성이 증가해서 유지보수에 좋다.

// 	함수는 안좋은거
//	왜 if, for문 놔두고 계산문제를 재귀적으로?
public class FMain2 {

	// 팩토리얼 구하기
	public static int factoNum(int numFacto) {
		return (numFacto == 1) ? 1 : (numFacto * factoNum(numFacto - 1));
	}

	// 피보나치 수열의 해당 번호 숫자 확인하기
	public static int pivoNum(int numPivo) {
		return (numPivo < 3) ? 1 : (pivoNum(numPivo - 1) + pivoNum(numPivo - 2));
	}

	// 해당 수까지 모든 정수의 합 구하기
	public static int plusAllNumber(int num) {
		return (num == 1) ? 1 : (num + plusAllNumber(num - 1));
	}

	public static void main(String[] args) {
		System.out.println(plusAllNumber(4));
		System.out.println(factoNum(4));
		System.out.println(pivoNum(5));
	}
}