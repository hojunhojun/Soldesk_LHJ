// 와이파이 	: 1 << 0 : 1
// 24시간 	: 1 << 1 : 2
// 주차장		: 1 << 2 : 4
// 흡연실		: 1 << 3 : 8
public class PPSMain2 {
	
	public static void main(String[] args) {
		String[] ar = { "와이파이", "24시간", "주차장", "흡연실" };
		int option = 13;
		for (int i = ar.length -1 ; i >= 0; i--) {
			if ( option >= 1 << i ) {
				System.out.println(ar[i]);
				option -= 1 << i;
			}
		}
	}
}
