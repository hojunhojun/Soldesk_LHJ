package com.lhj.oct241xj.snack;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// + DB에 있는 테이블을 표현 가능

@XmlRootElement // 여기에 이거 작성
public class Snacks {
	private List<Snack> snack; // 변수명은 단수명 추천
	
	public Snacks() {

	}

	public Snacks(List<Snack> snack) {
		super();
		this.snack = snack;
	}

	public List<Snack> getSnack() {
		return snack;
	}

	@XmlElement // 세터에 이거 넣기
	public void setSnack(List<Snack> snack) {
		this.snack = snack;
	}
	
}
