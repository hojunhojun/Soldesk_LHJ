// 
public class OMain {
	
	public static void main(String[] args) {
		
		Dog d1 = new Dog("후추", 3);
		d1.printInfo();
		
		System.out.println("----------");
		
		Human h1 = new Human("홍길동", 30);
		h1.pet = d1;
		h1.printInfo();
		
		System.out.println("----------");
	
		// 사람 이름
		System.out.println(h1.name);
		// 사람이 키우는 반려동물의 이름
		System.out.println(h1.pet.name);
		// 사람이 키우는 반려동물의 정보 출력
		h1.pet.printInfo();
	}
}
