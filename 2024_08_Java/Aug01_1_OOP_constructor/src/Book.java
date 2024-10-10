// constructor = 생성자
// 		객체가 생성될때 작업할거 있으면 생성자 사용 -> ex) 입고알림
//		메소드임 / 클래스명과 이름이 같음, 리턴이 없음.
//		객체가 만들어질때 할 행동 지정 가능
//		생성자라는 것을 작업한 내용이 없으면
//		->	컴파일때 자동으로 기본생성자를 만들어줌
public class Book {
	String title;
	String company; // 공통은 static
	int price;
	
	// Ctrl + Space bar (빈자리에 하면 생성자 자동생성)
	// default constructor(기본 생성자)
	public Book() {
		System.out.println("책 입고됨"); // 기본값 생성자
		company = "한빛미디어"; // 기본값으로 지정하고싶으면 여기다 하세요 ㅡ.ㅡ
	}
	
	// overloaded constructor(오버로딩된 생성자)
	// 우클릭 -> 소스 -> 밑에서 3번째꺼
	public Book(String title, String company, int price) {
		//super();
		this.title = title;
		this.company = company;
		this.price = price;
	}

	public void print() { // static 메서드로 만들기엔 무리(책이없으면 출력이안되야됨)
		System.out.println("제목 : " + title);
		System.out.println("출판사 : " + company);
		System.out.println("가격 : " + price);
	}
	
	// 멤버변수랑 파라메터/지역변수 이름이 같으면?
	// -> 파라메터/지역변수로 인식 : this.~~~이면 멤버변수로 인식함
	public void test(String company) {
		// 지역변수 : 이 메소드 돌리는동안 임시로 쓰고 버리는
		// 멤버변수 : 어떤 책의 제목
		
		System.out.println(title); // 님 지역변수임? 아닌데 멤버변수임 ㅇㅇ
		// -> 니 진짜 뭐임? / System.out.println(this.title) this 생략임 ㅇㅇ 생략가능함
		// this.~~~ : 지금 ~~~ 객체
		System.out.println(company); // 이지스퍼블리싱 ->지역변수
		System.out.println(this.company); // 멤버변수로 인식함 - 한빛미디어
	}
}
