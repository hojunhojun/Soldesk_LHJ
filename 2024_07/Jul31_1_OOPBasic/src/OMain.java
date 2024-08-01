// class : object(객체)만들때 필요한거 -> 붕어빵틀(생산시설) , 도장을 판 느낌
// object/instance : class로 만들어낸거 -> 붕어빵(실제 제품) , 도장 찍은 느낌

// stack 영역은 프로그램 종료시 알아서 다 지워줌
// -> GC 발동 -> heap 영역 삭제

// heap은...?
// Garbage Collection(GC) -> 메모리 영역중에 하나인 heap영역의 자동정리시스템임 <<<<<<<<------ 이거 면접 기출
//		Tip : 재부팅해라(RAM에 있는거 다 지워봐라) , 메모리 정리 어플(heap영역 정리)
//		heap 영역은 개발자가 직접 지워야함 (메모리 사용량 측면에서 이게 좋음)
//		GC : heap 영역을 언어 자체적으로 지워주는 시스템(자동정리시스템)
//		-> 발동시점 : heap 영역에 접근할 방법이 없게되면 발동 ex) null 처리
//		null이 들어가면 stack 영역에 들어있던 참조 주소값이 사라짐 -> heap이 지워지는 GC 당함
//		C언어는 메모리 공간에 접근 가능하지만 Java는 불가능하므로 GC가 있음.
//		그러나 프로그램 종료하면 stack 영역이 알아서 날아가니까 heap도 사라짐 / 결론 : 프로그램만 끄면 자동GC
//		수동 GC는 메모리 용량 확보에 큰 도움이됩니다 ^^
// 면접요령 : 발표 ㄴㄴ 말 ㅇㅇ
// 알고있다는 느낌을 증명해야죠
public class OMain {
	public static void main(String[] args) {
		String name = "모나미153";
		String color = "black";
		int price = 500;
		System.out.println("이름 : " + name);
		System.out.println("색깔 : " + color);
		System.out.println("가격 : " + price);
		System.out.println("----------"); // 왜이리김 ㅡ.ㅡ
		
		Pen pen1 = new Pen();
		pen1.name = "모나미153";
		pen1.color = "black";
		pen1.price = 500;
		pen1.showInfo(); // 어? 훨씬 간결한데?
		System.out.println("----------");
		
		Pen pen2 = new Pen();
		pen2.name = "모나미153골드";
		pen2.color = "blue";
		pen2.price = 5000;
		pen2.showInfo();
		System.out.println("----------");
		
		Pen pen3 = pen1; 	// pen1과 같은 값을 넣었을뿐(참조) 새로운 펜이 만들어진게 아님
							// 펜 1개에 호칭이 2개인 느낌 pen1, pen3
							// pen3로도 pen1에 접근할 수 있게 만든것임 (실제펜은2개)
		pen3.showInfo();
		System.out.println("----------");
		
		pen3.price = 100; // ㅋㅋ 이거 100원이됨
		pen3.showInfo();
		System.out.println("----------");

		pen1.showInfo(); // 그래서 이것도 가격이 100원이됨
		
		System.out.println(pen1); // 주소값이 같음
		System.out.println(pen2);
		System.out.println(pen3); // 주소값이 같음
		
		System.out.println("----------");
		
		pen1 = null;	// pen1이라는 변수로는 첫번째 펜에 접근 불가 / pen3로는 가능
		pen1.showInfo();// 되겠냐?
		pen3.showInfo();// pen3로는 첫번째 펜에 접근 가능
		pen3 = null;	// pen3라는 변수로는 펜에 접근 불가 -> 더이상 접근 방법이 없네?
						// 이때 첫번째 펜이 GC 당함 / 메모리 용량 정리 완료~
		pen3.showInfo();// 되겠냐?
		
	}
}
