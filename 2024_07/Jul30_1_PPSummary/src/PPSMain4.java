// 로또 프로그램
// 1 ~ 45중 중복되지 않는 6개의 숫자를 랜덤으로 추출하여 정렬
import java.util.Arrays;
import java.util.Random;

public class PPSMain4 {
	
	public static int pick(int[] lotto, int pos) {
		Random r = new Random();
		int no = r.nextInt(45) + 1;
		for (int i = 0; i < pos; i++) {
			if (lotto[i] == no) {
				return pick(lotto, pos); // 함수의 재귀적 호출
			}
		}
		
		return no;
	}
	
	public static void main(String[] args) throws InterruptedException {
		int [] lotto = new int[6]; // 로또 숫자 6개 배열 생성
		
		for (int i = 0; i < 6; i++) { // 로또 번호 생성
			lotto[i] = pick(lotto, i);			
		}
		Arrays.sort(lotto); // 정렬
		for (int i : lotto) {
			System.out.println(i); // 출력
		}
		Thread.sleep(300000);
	}
}
