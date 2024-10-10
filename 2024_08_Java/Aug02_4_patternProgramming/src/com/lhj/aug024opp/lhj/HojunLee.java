// static 멤버변수 : 객체들의 공통속성
// 나는 하나뿐 -> static 멤버변수 쓸 상황X

// singleton 패턴 : only one 객체 - 하나뿐인
package com.lhj.aug024opp.lhj;

public class HojunLee {
	
	// 캡슐화
	private String name;
	private String homeAddress;
	
	// 2) 내부에서 객체 하나만 생성해서 수정불가능하게
	private static final HojunLee lhj = new HojunLee("이호준", "인천");
	
	// singleton 패턴 거는법 : 외부에서 객체 못만들게하기
	// 1) 생성자들 private
	private HojunLee() {

	}

	// 1) 생성자들 private
	private HojunLee(String name, String address) {
		super();
		this.name = name;
		this.homeAddress = address;
	}
	
	// class : 
	// object/instance : 
	
	// 3) getter : getInstance라는 이름을 쓰는경우 꽤 있음
	public static HojunLee getLhj() {
		return lhj;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void printInfo() {
		System.out.println("이름 : " + name);
		System.out.println("집 : " + homeAddress);
	}
}
