// 생성자는 상속이 안됨... -> 각자 따로 만들어야함(결론 : 빠짐없이 잘 하자.)
// 그래서 아쉬운가? : 그닥
// 하위 객체(Shoes) 만들면
// -> super(); 라는 소스가 있든 말든 상위클래스의 기본 생성자를 자동호출
// final 메소드 : overriding 못하게
// final 멤버변수 : 변수 값 못바꾸게
// final 클래스 : 클래스 상속 못받게
public class Shoes extends Product {
	int size;
	
	public Shoes() {
		
	}

	public Shoes(String name, int price, int size) { // 키야 ㅋㅋ 이클립스 좋다 ㅋㅋ 상위 클래스의 생성자를 넣어줌..
		super(name, price); // 상품의 이름 가격 불러오기
		// super(); // Product의 기본 생성자 불러오기
		this.size = size; // 사이즈 추가 -> 생성자 오버라이딩 완성 ㅋㅋ
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("사이즈 : " + size);
	}
	
}
