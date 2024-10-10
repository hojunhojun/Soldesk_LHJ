// 오버로딩된 생성자를 작업했으니
// -> 기본생성자 안만들어주는데 이게 아쉬운가?
// ㄴㄴ 오히려좋아 어차피안써
//		Spring같은데 가면 개발자가 타이핑한 소스뿐만아니라 Spring이 객체를 자동으로 생성해줌(기본생성자로)
// 하지만 상속어쩌고 상황에서 기본생성자 필요함
//		-> 기본생성자를 무조건 만드는 문화

// 다양한 시도를 해보자
// 쌤을 따라할 생각 O -> 완성했으니까 X
// 일단 먼저 시도, 도전을 해본다음에
// 어떻게든 쌤이랑 다르게 써보려고 하지마 그냥 따라해

// Java -> JSP -> EJB(Enterprise JavaBean) :  무겁고 어렵고 작업량많고
// EJB의 단점을 극복한 Spring(겨울이 지고 봄이 왔다.)
// Java : 어쩌다 이름이 자바가 되었을까? -> (커피)
// JavaBean : 커피원두

// DTO(Data Temp/Transfer Object)
// VO(Value Object)
public class Mouse {
	
	// 1. 멤버변수들[타이핑]
	String name;
	int price;
	
	// 2. 생성자들
	// 2-1. 기본 생성자[Ctrl + space]
	public Mouse() {
		
	}
	// 2-2 오버로딩된 생성자[ctrl + shift + a]
	// 오버로딩 생성자 Ctrl+Shift+a 로 단축키 해버림
	public Mouse(String name, int price) {
		//super();
		this.name = name;
		this.price = price;
	}
	
	// 3. 기타 method
	public void show() {
		System.out.println("제품명 : " + name);
		System.out.println("가격 : " + price);
	}
}
