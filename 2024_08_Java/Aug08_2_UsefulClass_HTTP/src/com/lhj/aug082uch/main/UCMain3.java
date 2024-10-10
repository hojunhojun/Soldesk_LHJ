package com.lhj.aug082uch.main;
// 자사데이터 공개 -> 위험

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

// 로그인 -> 신청 -> 키

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\1134h\\Eclipse\\dust.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8"); // 인코딩 방식 넣기
			bw = new BufferedWriter(osw);
			
			// URL u = new URL(s); 구버전
			URL u = URI.create("http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/").toURL();
			huc = (HttpURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			// XML : 	DOM객체형태로 데이터 표현해놓은
			// 			Dom(Document Object Model)객체
			// <태그명 속성명="값"...> 	: 시작태그(0)
			// 글자 					: 글자(1)
			// </태그명> 				: 종료태그(2)
			
			// 전체를 다 불러와서(이게맞나) -> 객체지향스타일로
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH/mm");
			String now2 = sdf.format(now);
			int what = xpp.getEventType();
			String tagName = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("MSRRGN_NM")) {						
						bw.write(now2);
						bw.write(xpp.getText() + ", ");
					} else if (tagName.equals("MSRSTE_NM")) {						
						bw.write(xpp.getText() + ", ");
					} else if (tagName.equals("PM10")) {						
						bw.write(xpp.getText() + ", ");
					} else if (tagName.equals("PM25")) {						
						bw.write(xpp.getText() + ", ");
					} else if (tagName.equals("IDEX_NM")) {						
						bw.write(xpp.getText() + "\r\n");
						bw.flush();
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				what = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		huc.disconnect();
		try { bw.close(); } catch (IOException e) { e.printStackTrace(); }
	}
}
