// Call By Value, Call By Reference
// 콜 바이 밸류 - 값 참조 / 콜 바이 레퍼런스 - 주소 참조(할당된 참조 주소 속의 값을 불러옴)
// 메모리에 할당된 변수값 타입의 차이를 말함.
// 틈새 면접 Tip : 발표하지 말고 말을 해라
// 배열은 참조형 변수다.
public class AMain4 {
	public static void test(int a, int[] b, int[] c) {
		System.out.println(a); 		// 10
		System.out.println(b[0]); 	// 10 (Call By Reference)
		System.out.println(c[0]); 	// 10
		System.out.println(b);		// 주소값 확인
		System.out.println(c);		// 주소값 확인
		a = 100;	// return이 없으면 메인 메서드에서는 영향이 없음 / test함수 내부에서 값을 수정했기때문
		b[0]= 100;	// return 필요없음(주소 참조이기 떄문)
		c = new int[]{100,200}; // 융통성없는 명확함(c배열의 값을 새로 넣었구나~) 
								// 이건 test함수 내에서 쓸 배열이므로 밑의 main에서는 참조하지 않음 ㅎㅎ
		System.out.println(a); 		// 100
		System.out.println(b[0]); 	// 100 (Call By Reference)
		System.out.println(c[0]); 	// 100 (Call By Reference)
		System.out.println(b);		// 주소값 확인
		System.out.println(c);		// 주소값 확인 (얘만다름 -> C배열은 새로 만들었으니까?)
	}
	
	public static void main(String[] args) { // 결과가 왜 그렇게 나왔니?
		int a = 10; // value(
		int[] b = {10, 20}; // reference(참조 주소값)
		int[] c = {10 ,20}; // reference(참조 주소값)
		System.out.println(a); 		// 10
		System.out.println(b[0]);	// 10
		System.out.println(c[0]);	// 10
		test(a, b, c);				// test함수로 ㄱㄱ~
		System.out.println(a);		// 10
		System.out.println(b[0]);	// 100 (Call By Reference)
		System.out.println(c[0]);	// 10 (Call By Reference)
		System.out.println(b);		// 주소값 확인
		System.out.println(c);		// 주소값 확인
	}								
}