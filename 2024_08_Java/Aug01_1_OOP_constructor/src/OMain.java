// 쇼핑몰에서 품절이라면? -> 찜 기능
// 입고되었을때 알림
public class OMain {
	public static void main(String[] args) {
		// 객체 생성
		// 클래스명 변수명 = new 생성자;
		Book b1 = new Book(); // 객체 생성 예
		b1.title="혼자 공부하는 자바";
		// b1.company="한빛미디어";
		b1.price=30000;
		b1.print();
		System.out.println("--------------------");
		b1.test("이지스퍼블리싱"); // 이지스퍼블리싱으로 인식
		System.out.println("--------------------");
		Book b2 = new Book("C++", "한빛", 50000);
		b2.print();
		System.out.println("--------------------");
		
		Mouse m1 = new Mouse("로지텍1234", 20000);
		m1.show();
		
	}
}
