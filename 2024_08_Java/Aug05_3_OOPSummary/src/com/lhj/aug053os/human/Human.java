package com.lhj.aug053os.human;

import com.lhj.aug053os.hero.Hero;

public class Human {
	private String name;
	private Hero hero;

	public Human() {

	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setHero(Hero h) {
		hero = h;
	}
	
	public void callHelpMe() {
		hero.attack();
	}
}
