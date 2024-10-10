package com.lhj.aug061ucd.main;

// 기본형 : stack에 데이터가 들어감
// 참조형 : stack에는 주소값, heap에 해당 주소값에 맞게 데이터 생성/저장

// heap에 데이터가 있어야 하는 경우가 있음
// Wrapper Class
//		기본형에 해당하는 객체
//		기본형 비슷하게 생겼는데 첫글자가 대문자
// -> 기본형에 해당하는 객체가 필요할떈?
public class UCMain2 {
	public static void main(String[] args) {
		int a = 10;
		Integer aa = 10; // 이게 Wrapper class 임. -> autoboxing 예시
		// Integer aaa = new Integer(10); // Full ver 
		// -> warning 사유 : deprecated (쓰지마)
		// 왜? 자동으로 해주는데 왜 굳이 치고있어? : autoboxing / autounboxing
		int aaa = aa.intValue(); // ??.intValue();
		// int aaa = aa; 위에줄이랑 같은뜻임 -> autounboxing
		
		double b = 3.5;
		// 기본형 -> 객체형 이 하고싶다면? : 생성자 사용(??.xxxValue();)
		Double bb = 3.5; // 이게 Wrapper class 임. -> autoboxing 예시
		// Double bbb = new Double(3.5); // Full ver 
		double bbb = bb.doubleValue(); // ex) ??.doubleValue();
		// double bbb = bb; 위에줄이랑 같은뜻임 -> autounboxing
		
		boolean c = true;
		Boolean cc = true; // 이게 Wrapper class 임. -> autoboxing 예시
		// Boolean ccc = new Boolean(true); // Full ver
		boolean ccc = cc.booleanValue(); // ex) ??.booleanValue();
		// boolean ccc = cc; 위에줄이랑 같은뜻임 -> autounboxing
		
		
		// 기본형 -> String : + "";
		int d = 20;
		String dd = d + ""; // 이거임 ㅇㅇ
		String ddd = String.format("%d", d); // 가능은 한데 이건 좀 비효율
		
		// 어디서 데이터랍시고 가져오면 String임 그래서 변환이 필요하지않을까여?
		String s = "30.5";
		// String -> 기본형 : XXX.parseXXX();
		Double ss = Double.parseDouble(s);
		double sss = ss.doubleValue(); // 이거임 ㅇㅇ
		
		String s2 = "55";
		int s22 = Integer.parseInt(s2); // 이거면 바로 됩니다~
		
	}
}
