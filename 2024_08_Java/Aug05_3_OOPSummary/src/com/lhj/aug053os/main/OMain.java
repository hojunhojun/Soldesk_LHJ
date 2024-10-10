package com.lhj.aug053os.main;
// 자바에 행성 클래스가 없어가지고 만들어서했어욤..

import com.lhj.aug053os.hero.Ironman;
import com.lhj.aug053os.human.Human;
import com.lhj.aug053os.planet.Planet;

public class OMain {
	public static void main(String[] args) {
		Planet p = new Planet("지구");
		
		Human h = new Human("홍길동");
		p.add(h);
		
		Ironman i = new Ironman();
		i.attack();
		
		h.setHero(i);
		h.callHelpMe();
		
		p.setSize(500);
		p.setVisible(true);
	}
}