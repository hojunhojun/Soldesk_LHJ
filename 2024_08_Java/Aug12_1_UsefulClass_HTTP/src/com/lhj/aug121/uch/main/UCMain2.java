package com.lhj.aug121.uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 대규모의 프로그램은 끊어서 만드는 전략 세우기
public class UCMain2 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\1134h\\Eclipse\\bus2015.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8"); // 인코딩 방식 넣기
			bw = new BufferedWriter(osw);
			
//			for (int n = 2015; n < 2024; n++) { // 전체 데이터 -> 이건 할줄알지만 포기(하드웨어의 한계를 고려)
				for (int m = 1; m < 13; m++) { // 1년치 데이터 -> 1년치단위로 끊기
					for (int d = 1; d < 32; d++) { // 1달치 데이터
						for (int start = 1; start < 41002; start+=1000) { // 1일치 데이터
							String t = String.format("%d/%d/2015%02d%02d", start, start + 999,  m, d);
							
							String s = "http://openapi.seoul.go.kr:8088/baff8f3c6cbc28a4024e336599de28c4/json/CardBusStatisticsServiceNew/" + t;
							URL u = URI.create(s).toURL();
							huc = (HttpURLConnection) u.openConnection();
							
							InputStream is = huc.getInputStream();
							InputStreamReader isr = new InputStreamReader(is, "utf-8");
							
							JSONParser jp = new JSONParser();
							JSONObject jo = (JSONObject) jp.parse(isr);
							JSONObject jo2 = (JSONObject) jo.get("CardBusStatisticsServiceNew");
							if (jo2 != null) {
								JSONArray ja = (JSONArray) jo2.get("row");
								JSONObject station;
								/// ??? -> String 하는법 : 전통 형변환 / 앞에 (String) 붙이기
								//						  String에서만 / 뒤에 .toString();
								//						  간단 예 / 뒤에 + "";
								for (int i = 0; i < ja.size(); i++) {
									station = (JSONObject) ja.get(i);
									
									String use_ymd = station.get("USE_YMD") + ""; // 형변환 예
									bw.write(use_ymd.substring(0, 4) + ",");
									bw.write(use_ymd.substring(4, 6) + ",");
									bw.write(use_ymd.substring(6, 8) + ",");
									
									bw.write(station.get("RTE_NM") + ",");
									bw.write(station.get("SBWY_STNS_NM") + ",");
									
									bw.write(station.get("GTON_TNOPE").toString().replace(".0", ",")); // 생각의 유연함
									bw.write(station.get("GTOFF_TNOPE").toString().replace(".0", "\r\n")); // 생각의유연함
									bw.flush();
								}
							}
							System.out.println(t);
						}
					}
				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {bw.close();} catch (IOException e) {e.printStackTrace();}
	}
}
