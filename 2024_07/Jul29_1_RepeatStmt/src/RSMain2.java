// 반복 횟수가 명확 : for
// 반복 조건이 명확 : while / do-while[적어도 한번의 반복은 보장] -> 그닥?
import java.util.Random;

public class RSMain2 {
	public static void main(String[] args) {
		// 10번  -> for
		// 랜덤 뽑을 준비
		Random r = new Random();
		int x = r.nextInt(10); // 0 ~ 9/

		
		while (x != 5) { // 끝낼조건x
			x = r.nextInt(10);
			System.out.println(x);
		}
		
		do { // 하고 나서 검사
			x = r.nextInt(10);
			System.out.println(x);
		} while (x != 5);
	}
}
