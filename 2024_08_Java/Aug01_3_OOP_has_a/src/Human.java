
public class Human {
	String name;
	int age;
	Dog pet; // 사람이 개를 가짐
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		// System.out.println("펫 : " + pet.name);
		// System.out.println("펫 : " + pet.age);
		pet.printInfo(); // 굳이 위에것처럼 출력하지말고 펫의 메소드를 불러오자
	}
}
