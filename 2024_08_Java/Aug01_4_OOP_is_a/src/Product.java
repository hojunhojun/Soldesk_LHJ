
public class Product { 	// 모든 제품들은 이름과 가격, 정보출력 기능을 갖게됨.
						// Product 뒤에 빈칸으로 냅두면 extends Object가 자동 으로 불러와짐.
						// == public class Product extends Object {
	String name;
	int price;
	
	// 생성자 -> 상속 불가 : 하지만 만들어놓으시길..
	public Product() {
		//System.out.println("상품 생성");
	}
	
	// 오버로딩된 생성자 -> 상속 불가
	public Product(String name, int price) {
		super(); // extends Objects
		this.name = name;
		this.price = price;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.printf("가격 : %d원\n",price);
	}
}
