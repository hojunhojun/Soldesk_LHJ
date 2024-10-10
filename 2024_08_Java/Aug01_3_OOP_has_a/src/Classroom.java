// Soldesk
// 강의실이 여러개
// 프린터는 5층에 한대있는걸 모든 강의실에서 공용으로 사용
public class Classroom {
	String name;
	int floor;
	static Printer printer = new Printer("캐논123", 500000); // 공용으로 사용
	public Classroom() {
		
	}

	public Classroom(String name, int floor) {
		super();
		this.name = name;
		this.floor = floor;
	}

}
