
public class Dog {
	String name;
	int age;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
