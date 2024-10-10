package com.lhj.aug132ucc.student;

// 학생객체 생성
public class Student {
	private String name;
	private int kor;
	private int eng;
	private int mat;

	public Student() {

	}
	
	public Student(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public Student(String line) {
		String[] line2 = line.split(",");
		name = line2[0];
		kor = Integer.parseInt(line2[1]);
		eng = Integer.parseInt(line2[2]);
		mat = Integer.parseInt(line2[3]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public void printInfo() {
		System.out.println("학생 정보 출력");
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
	}
}
