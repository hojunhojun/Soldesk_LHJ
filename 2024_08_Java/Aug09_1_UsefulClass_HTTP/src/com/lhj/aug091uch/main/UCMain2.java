package com.lhj.aug091uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// https://openweathermap.org/current 사용법
// 구글지도 가서 위경도값 찾기
// ex)우리집 !3d37.5021217!4d126.7394122
// https://api.openweathermap.org/data/2.5/weather?lat=37.5021217&lon=126.7394122&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr
// -> 우리집 날씨

// 데이터 주는 쪽
// 데이터 받아서 쓰는 쪽
// 간에 표준화된 형식이 있어야 할 것
//		XML : 데이터를 HTML DOM객체 형태로 표현 -> 한물감
//			Extended Markup Language
//		JSON : 데이터를 JavaScript객체 형태로 표현 -> 현재 주력(XML보다 우수한 기술) -> 용량이 적음
//			JavaScript Object Notation
//		-> 현재 사이트 표현 방식(JSON)
public class UCMain2 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			// 서버 연결
			String s = "https://api.openweathermap.org/data/2.5/weather?lat=37.5021217&lon=126.7394122&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
			URL u = URI.create(s).toURL();
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			// 파일 열기 -> 프로세스의 실패 확률을 따져서 위치 조정
			FileOutputStream fos = new FileOutputStream("C:\\Users\\1134h\\Eclipse\\weather.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			
			// 날짜준비 -> 프로세스의 실패 확률을 따져서 위치 조정
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,");
			String now = sdf.format(new Date());
			
			// Java : Int[] ar = {1,2,3} -> 개발자가 자료형 신경써야함
			// Dog d = new Dog -> 객체의 표현
			// d.setName("후추"); -> 객체의 표현
			// d.setAge(3); -> 객체의 표현
			// JavaScript : var ar =[1,2,3] -> 개발자가 자료형신경쓸필요 X
			// var d = { name : 후추, age : 3}; -> 객체의 표현(중괄호 사용)-> 멤버변수명 : 값, 멤버변수명 : 값...

			// XMLPullParser : 하나씩 꺼내와서 처리하고 다음거...
			// -> 대용량 데이터 감당 가능
			// JSONparser : 전체를 한번에 다 받아옴 (객체 지향)
			// 받아온거 제일 앞에있는거 {? [?
			// {면 객체, [면 배열
			// JSON parsing -> json-simple 필요
			JSONParser jp = new JSONParser();
			// JSONArray ja = (JSONArray) jp.parse(isr); 제일 앞에있는게 배열일때
			JSONObject jo = (JSONObject) jp.parse(isr); // 제일 앞에있는게 객체일때
			bw.write(now);
			// bw.write(jo.get("name") + ","); // JSON 객체 안에서 이름 찾아서 가져오기 ex)name

			JSONObject m = (JSONObject) jo.get("main");
			bw.write(m.get("temp") + ",");
			bw.write(m.get("feels_like") + ",");
			bw.write(m.get("humidity") + ",");

			JSONArray w = (JSONArray) jo.get("weather"); // 배열처리되있으면 이렇게 ㄱㄱ
			JSONObject w2 = (JSONObject) w.get(0);
			bw.write(w2.get("description") + "\r\n");
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {bw.close();} catch (IOException e) {e.printStackTrace();}
		huc.disconnect();
	}
}
