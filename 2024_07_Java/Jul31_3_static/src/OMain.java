// 	static을 잘써야 OOP를 잘한다는 소리를 들을듯?
//	이 세상의 모든 게장은 다 김수미가 생산 한다면?
// .java -> compile -> .class

//	1) JVM이 OS환경에 맞게 구성되서 OS위에 올라감
//	2) 기계어상태의 프로그램소스가 stack영역에 꽂힘
//	3) static멤버변수가 static영역에 만들어짐
//	4) JVM이 OMain.main(...)을 호출하면서 시작
public class OMain {
	
	public static void main(String[] args) {
		// 게장 없는 시점에서
		System.out.println(GaeJang.producer); // 클래스명.멤버변수명으로 가능 !!
		
		GaeJang g1 = new GaeJang();
		g1.name = "추석특선세트"; // 객체변수명.멤버변수명
		g1.price = 59900;
		g1.weight = 5;
		g1.producer = "최수미";
		g1.show();
		
		System.out.println("---------------");
		
		GaeJang g2 = new GaeJang();
		g2.name = "양념게장세트";
		g2.price = 39900;
		g2.weight = 5;
		g2.show();
		
	}

}
