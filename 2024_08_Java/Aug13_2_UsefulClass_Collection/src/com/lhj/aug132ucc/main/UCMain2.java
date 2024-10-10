package com.lhj.aug132ucc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

import com.lhj.aug132ucc.student.Student;

// [] : 몇명? - 탈락
// ArrayList : 자료형? - 탈락
public class UCMain2 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\soldesk\\Eclipse\\File\\student.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			ArrayList<Student> students = new ArrayList<Student>();

			String line;
			while ((line = br.readLine()) != null) {
				students.add(new Student(line));
			} // 여기까지 파일 불러와서 출력하는 공식

			System.out.println(students.size()); // 총 학생수
			System.out.println("-------------");

			System.out.println(students.get(1).getKor()); // 두번째 학생의 국어점수
			System.out.println("-------------");

			students.get(0).printInfo(); // 첫번째 학생의 정보 출력
			System.out.println("-------------");

			for (Student student : students) { // 모든 학생의 정보 출력
				student.printInfo();
			}

			Comparator<Student> c = new Comparator<Student>() { // 이름 가나다순
				@Override
				public int compare(Student o1, Student o2) {
					String o1Name = o1.getName();
					String o2Name = o2.getName();
					return o1Name.compareTo(o2Name);
				}
			};
			students.sort(c);
			System.out.println("-------------");
			Comparator<Student> c2 = new Comparator<Student>() { // 학생 점수순
				@Override
				public int compare(Student o1, Student o2) {
					Integer o1Score = o1.getEng() + o1.getKor() + o1.getMat();
					Integer o2Score = o2.getEng() + o2.getKor() + o2.getMat();
					return o1Score.compareTo(o2Score);
				}
			};
			students.sort(c2);
			students.get(0).printInfo(); // 꼴등학생 점수 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
