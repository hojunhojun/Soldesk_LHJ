package com.lhj.aug023oe.shop.coffee;

// 	Java 패키지명
//		com.회사명.프로그램명.카테고리
//		실제 클래스는 다른 패키지에 배치될 수 밖에

//	자기가 작업한거 공유하는 문화
//		이 클래스를 실제로 사용하는 쪽은 다른 패키지를 사용

//	쓸려고 만든건데 private? 안쓸거면 만들질마 ㅋㅋ -> 대부분 public을 쓰겠지
// 	하지만? public을 쓰면 위험해(왜?) 그러므로 캡슐화를 해볼까?

// 	encapsulation(캡슐화) : 기본사항
//		because : public을 써서 외부에서 직접 건들게 해놓으면 잘못된 데이터가 그냥 들어가버릴수가 있음..
public class Coffee {
	// 	1) private 줘서 멤버변수들 외부에서 못건들게 (필수사항 1)
	private String name;
	private int price;
	
	// 	2) 멤버변수들을 건들수 있는 통로 마련
	// 	   -> 빈자리 우클릭 -> source -> Generate getters and setters -> 필요한거 체크
	// 3) 그 통로에 안전장치 붙이기
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	//	ex 3) 안전장치 예시
	public void setPrice(int price) {
		if (price < 0) {
			price = -price;
		}
		this.price = price;
	}

	public Coffee() {

	}

	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("가격 : " + price);
	}
}
