// 상속 사용 타이밍 : 공통된거 묶어서... 대충 이런느낌
// 하지만 더있다 !!  -> 뭐임?
public class OMain2 {
	
	public static void main(String[] args) {
		Odd odd = new Odd();
		int result = odd.nextInt(12);
		System.out.println(result);
		Even even = new Even();
		int result2 = even.nextInt(12);
		System.out.println(result2);
	}
	
}
