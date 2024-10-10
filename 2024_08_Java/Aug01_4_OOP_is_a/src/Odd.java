// 자바에 랜덤기능이 있음 : 하지만 부족하지
// 전세계의 개발자중에 누군가가 ???기능을 만들어놨음 : 100% 딱맞지는 않기때문에
// -> 기존에 만들어진거에 추가
import java.util.Random;

public class Odd extends Random { // 자바 기본제공 기능들도 상속받아서 수정 가능합니다~
	Random r = new Random();
	public int nextInt(int bound) {
		int x = super.nextInt(bound);
		return ( x % 2 == 0 ) ? nextInt(bound) : x;
	}
	
}