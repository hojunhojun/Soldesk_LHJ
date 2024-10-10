// Pen is a Product : 상속
// Product 	: 부모/상위/super	클래스
// Pen 		: 자식/하위 		클래스

// Java : 영어 베이스의 인간어
public class Pen extends Product { // extends : 상속 관계 맺기 Pen is a Product -> 공식 용어 : 확장(기능의 추가)
	// Product에 있는 멤버들을 다 물려받아옴
	String color; // Pen 고유의 멤버
	
	// Product에 있는 printInfo method 물려받아왔음.
	// 물려받아온 printInfo는 제품명, 가격 출력 기능만있는게 아쉬움 / 색깔 출력 기능이 없넹
	// 그러므로 물려받아온 메소드 기능을 바꾸자(재정의) -> overriding
	// 메소드명 앞에 조금 입력하고 자동완성 (Ctrl + Space)
	// @~~~ : annotation -> ~~~에 어떤 내용이 써있냐에따라 다 다름
	//						대부분) 원래는 사람이 직접 ~~~해야하는데, 자동으로 해 주는...
	// @Override : 	없어도 되지만 바로 밑에 overriding된 메소드가 들어가야함
	// 				가독성 상승이요~
	// overriding은 기존 기능에 뭔가 추가를 많이 할것임.
	@Override
		public void printInfo() {
			super.printInfo(); // super method(Product의 printInfo를 호출)
			System.out.println("색상 : " + color); // 메소드 오버라이딩
		}
	
	public Pen() {
		
	}
	
	public Pen(String name, int price, String color) {
		super(name, price);
		this.color = color;
	}
	
	
}
// 	overriding 		VS 		overload           -> 면접 기출
//	상속에서의 재정의			메소드명 동일하게 짓기				