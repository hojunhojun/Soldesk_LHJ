// 코딩테스트 : 웹개발x
//	즉발 : 알고리즘 구상
//	과제 : 웹개발, 빅데이터

// 	정수 배열 넣으면, 정렬하는 함수
// 	버블정렬 = 최악의 알고리즘
//	선택정렬 = 인간스러운 정렬
public class PPSMain3 {
	
	// 선택정렬 : 실전 용도 X
	public static void selectionSort(int[] ar) {
		int t;
		int min;
		int minIndex;
		
		for (int turn = 0; turn < ar.length-1; turn++) {
			min = ar[turn];
			minIndex = turn;
			for (int i = turn + 1; i < ar.length; i++) {
				if (min > ar[i]) {	
					min = ar[i];
					minIndex = i;
				}
			}
			t = ar[minIndex];
			ar[minIndex] = ar[turn];
			ar[turn] = t;
		}
	}
	
	// 버블정렬 : 실전 용도 X
	public static void bubbleSort(int[] ar) {
		int t = 0;
		for (int turn = 0; turn < ar.length - 1; turn++) {
			for (int i = 0; i < ar.length - (1+turn); i++) {
				if (ar[i] > ar[i + 1]) {
					t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] ar = { 123, 456, 789, 29, 781, 33, 90, 56, 111 };
		selectionSort(ar);
		//bubbleSort(ar);
		// Arrays.sort(ar); 자동 정렬 기능(실전용)

		for (int i : ar) {
			System.out.println(i);
		}
	}
}
