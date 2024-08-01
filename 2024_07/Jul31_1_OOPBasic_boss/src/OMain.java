// build path -> configure build path -> libraries add external jar file로 추가
// Java -> jsp.jar -> spring.jar -> springBoot.jar -> hadoop.jar (교육과정은 jar의 연속)

// 내부 구조가 어떻게 되는지 모르겠는데요...?(나도모름)

// jre system libraries 속의 내용들을 우리가 사용하고 있었던 거임 !!
public class OMain {
	public static void main(String[] args) {
		System.out.println();
		Pen p = new Pen();
		p.name = "제트스트림";
		p.color = "빨강";
		p.price = 1000;
		p.showInfo();
	}
}
