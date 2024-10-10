// 객체와의 관계
//		A 	"has" a 	B
//		A 	"is"  a 	B
//	"택시" 	is    a 	"자동차" -> 택시는 자동차이다.
public class OMain {
	public static void main(String[] args) {
		Pen pen = new Pen();	// Product에 있는 멤버변수들을 물려받음
		pen.name = "모나미153"; 	// Product에 있는 멤버변수들을 물려받음
		pen.price = 500;		// Product에 있는 멤버변수들을 물려받음
		pen.color = "검정";
		pen.printInfo();
		System.out.println("----------");
		
		Computer com = new Computer();
		com.name = "조립식12312";
		com.price = 800000;
		com.cpu = "i7-1234";
		com.ram = 16;
		com.hdd = 500;
		com.printInfo();
		System.out.println("----------");
		
		Notebook note = new Notebook();
		note.name = "그램1234";
		note.price = 2000000;
		note.cpu = "i5-4412";
		note.ram = 32;
		note.hdd = 250;
		note.weight = 5;
		note.battery = 8;
		note.printInfo();
		System.out.println("----------");
		
		Shoes s = new Shoes("에어맥스123", 100000, 260); // 생성자를 이용한 생성
		s.printInfo();
		System.out.println("----------");
		
		Monitor m = new Monitor("삼성123", 500000);
		m.printInfo();
	}
}
