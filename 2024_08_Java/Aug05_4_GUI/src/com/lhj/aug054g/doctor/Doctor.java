package com.lhj.aug054g.doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Doctor implements ActionListener {
	private JTextField nameTF;
	private JTextField heightTF;
	private JTextField weightTF;
	private JLabel resultLB;
	
	public Doctor() {

	}
	
	public Doctor(JTextField nameTF, JTextField heightTF, JTextField weightTF, JLabel resultLB) {
		super();
		this.nameTF = nameTF;
		this.heightTF = heightTF;
		this.weightTF = weightTF;
		this.resultLB = resultLB;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameTF.getText();
		double height = Double.parseDouble(heightTF.getText());
		double weight = Double.parseDouble(weightTF.getText());
		double bmi = weight / (height * height);
		String status = "저체중";
		if (bmi > 38.9) {
			status = "고도 비만";
		} else if (bmi > 31.9) {
			status = "중도 비만";
		} else if (bmi > 29.9) {
			status = "경도 비만";
		} else if (bmi > 23.9) {
			status = "과체중";
		} else if (bmi > 9.9) {
			status = "정상 체중";
		}
		
		String result = String.format("BMI = %.1f, %s씨는 %s", bmi, name, status);
		resultLB.setText(result);
	}
}
