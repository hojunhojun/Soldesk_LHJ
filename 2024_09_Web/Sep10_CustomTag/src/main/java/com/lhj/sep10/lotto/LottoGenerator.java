package com.lhj.sep10.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class LottoGenerator {
	private Random core;

	private static final LottoGenerator lg = new LottoGenerator();

	public LottoGenerator() {
		core = new Random();
	}

	public static LottoGenerator getLg() {
		return lg;
	}

	public void pick(HttpServletRequest request) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while (true) {
			hs.add(core.nextInt(45) + 1);
			if (hs.size() == 6) {
				break;
			}
		}
		// set을 List로 바꿈
		ArrayList<Integer> al = new ArrayList<Integer>(hs);	
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		request.setAttribute("lotto", al);
	}

}
