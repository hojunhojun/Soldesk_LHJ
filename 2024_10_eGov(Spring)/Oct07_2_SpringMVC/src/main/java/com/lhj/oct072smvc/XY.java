package com.lhj.oct072smvc;

// Spring이 request parameter 받아서 JavaBean객체로 만들어줌
// 조건 : 멤버변수명 = request parameter이름 통일
public class XY {
	private int xx;
	private int yy;
	
	public XY() {
		// TODO Auto-generated constructor stub
	}

	public XY(int xx, int yy) {
		super();
		this.xx = xx;
		this.yy = yy;
	}

	public int getXx() {
		return xx;
	}

	public void setXx(int xx) {
		this.xx = xx;
	}

	public int getYy() {
		return yy;
	}

	public void setYy(int yy) {
		this.yy = yy;
	}

}