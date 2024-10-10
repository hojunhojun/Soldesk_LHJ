package com.lhj.aug121.uch.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// JSON 파싱 예제

public class UCMain {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		Scanner ci = new Scanner(System.in);
		try {
			System.out.print("키워드 검색 : ");
			String search = ci.next();
			search = URLEncoder.encode(search, "utf-8");
			
			String s = "https://dapi.kakao.com/v2/local/search/keyword.json?x=126.98&y=37.56&radius=100&query=" + search;
			URL u = URI.create(s).toURL();
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 863304c510593e9bd9146a82055066a9");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject loc;
			System.out.println("---------------");
			for (int i = 0; i < ja.size(); i++) {
				loc = (JSONObject) ja.get(i);
				System.out.println("매장명 : " + loc.get("place_name"));
				System.out.println("주소 : " + loc.get("road_address_name"));
				System.out.println("연락처 : " + loc.get("phone"));
				System.out.println("거리 : " + loc.get("distance"));
				System.out.println("------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ci.close();
		huc.disconnect();
	}
}
