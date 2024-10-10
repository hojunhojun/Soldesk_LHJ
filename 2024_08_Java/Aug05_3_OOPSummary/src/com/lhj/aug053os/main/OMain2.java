package com.lhj.aug053os.main;
// 자바에 그 클래스가 있으니까 클래스 만들지말고 걍해봐

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.lhj.aug053os.hero.Hulk;

import javax.swing.JButton;
import javax.swing.JFileChooser;

public class OMain2 {
	public static void main(String[] args) {
		// 타이틀이 지구인 JFrame
		JFrame p = new JFrame("지구");

		// 텍스트가 홍길동인 JTextField
		// JTextField h = new JTextField("홍길동");

		// JFileChooser h = new JFileChooser();

		// 텍스트가 홍길동인 JButton
		JButton h = new JButton("홍길동"); // This is GUI

		// 버튼 클릭 구현을 위해서는 무조건 actionPerformed 기능이 있어야함
		// -> JAVA가 ACtionListener 인터페이스를 만들어줌

		// ActionListener인 헐크
		Hulk i = new Hulk();
		// 저 버튼이 본인의 전담 이벤트처리맨으로 헐크 찜
		h.addActionListener(i);
		// 이거 클릭하면 actionPerformed 발동 -> attack

		// 그 프레임에 버튼 추가
		p.add(h);

		// 그거 사이즈 500,300
		p.setSize(500, 300);
		// 그 행성 보임
		p.setVisible(true);
	}
}
