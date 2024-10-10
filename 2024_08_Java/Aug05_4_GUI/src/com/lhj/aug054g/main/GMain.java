package com.lhj.aug054g.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lhj.aug054g.doctor.Doctor;

// 비만도
public class GMain {
	public static void main(String[] args) {
		JFrame jf = new JFrame("비만도 검사");

		// 객체들 배치 전략(Layout)
		// 4행 2열짜리 GridLayout
		GridLayout gl = new GridLayout(4, 2);
		
		// 그 그리드레이아웃을 저 프레임의 레이아웃으로
		jf.setLayout(gl);
		
		JLabel nameLB = new JLabel("이름");
		jf.add(nameLB);
		JTextField nameTF = new JTextField();
		jf.add(nameTF);
		
		JLabel heightLB = new JLabel("키");
		jf.add(heightLB);
		JTextField heightTF = new JTextField();
		jf.add(heightTF);
		
		JLabel weightLB = new JLabel("몸무게");
		jf.add(weightLB);
		JTextField weightTF = new JTextField();
		jf.add(weightTF);
		
		JLabel resultLB = new JLabel();
		jf.add(resultLB);
		JButton btn = new JButton("확인");
		jf.add(btn);
		
		Doctor d = new Doctor(nameTF, heightTF, weightTF, resultLB);
		btn.addActionListener(d);
		
		jf.setSize(400, 300);
		jf.setVisible(true);
	}
}
