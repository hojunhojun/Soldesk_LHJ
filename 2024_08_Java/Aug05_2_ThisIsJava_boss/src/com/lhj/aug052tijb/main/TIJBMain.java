package com.lhj.aug052tijb.main;

import com.lhj.aug052tij.ironman.Ironman;

// 의사소통할때 말로만했더니 의사소통 문제 발생 (ex: 메소드명, 변수명...?)
// 팀장 입장에서 추상 method를 줘버리면 그 작업을 안할수가 없겠죵? 그러면 에러가 없겠죠?
// 그러면 가이드라인을 위해 어벤져스를 만들어볼까요?
// 추상클래스는 안됩니다. (다중상속이 안됨)
// 인터페이스로 가시죠?
// 팀장이 인터페이스 만들어주면서 업무지시를 시작함.
public class TIJBMain {
	public static void main(String[] args) {
		Ironman i = new Ironman();
		i.shoot();
		
	}
}
