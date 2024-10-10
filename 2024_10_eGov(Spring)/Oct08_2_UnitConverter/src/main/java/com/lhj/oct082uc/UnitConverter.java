package com.lhj.oct082uc;

import java.util.ArrayList;
import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;


public class UnitConverter {
	
	private ScriptEngine se;
	private HashMap<String, ArrayList<String>> units;
	
	public UnitConverter() {
	}
	
	
	
	public UnitConverter(HashMap<String, ArrayList<String>> units) {
		super();
		this.units = units;
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}



	public void convert(UCData ucd, HttpServletRequest request) {
		
		try {
			double num = ucd.getNum();
			String what = ucd.getWhat();


			String sik = units.get(what).get(2);
			sik = String.format(sik, num);
			sik = sik.replace("n", num + "");

			
			double result = (Double) se.eval(sik);

			ucd.setUnit1(units.get(what).get(0));
			ucd.setResult(result);
			ucd.setUnit2(units.get(what).get(1));
			request.setAttribute("result", ucd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
