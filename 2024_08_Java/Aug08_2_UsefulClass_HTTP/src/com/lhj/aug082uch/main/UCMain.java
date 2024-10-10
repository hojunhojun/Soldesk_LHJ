package com.lhj.aug082uch.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// 1) 자바의 문화를 보자
// 2) HTTP통신을 처음(요청, Get, 응답)

// Java애 HTTP통신관련 클래스 없엇는데
// 버전이 올라가다가 어느날 추가됨
// -> 지금은 있음.

// http / https 구별 필요

// 진짜 ver
public class UCMain {

	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			String s = "https://sdgn-djvemfu.tplinkdns.com/";
			// URL u = new URL(s); 구버전
			URL u = URI.create(s).toURL();
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
