package com.lhj.aug082uch.main;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
// parsing : 필요없는 부분 제거하고

// HTML : 웹 사이트 만드는 디자인 언어

// 서로 데이터를 주고받을때 표준화된 형식이 있어야할것
//		XML : 데이터를 HTML모양으로 표현
//		JSON : 데이터를 JAvaScript모양으로 표현

// XML parsing
//		Java에 XMLParsing만 전문으로 하는 클래스 없음.
//		kxml
//		서로 공유하는 문화 -> 중앙제어시스템(maven, gradle)
public class UCMain2 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			// URL u = new URL(s); 구버전
			URL u = URI.create("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2823766100").toURL();
			huc = (HttpsURLConnection) u.openConnection();

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

			int what = xpp.getEventType();
			String tagName = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {						
						System.out.println(xpp.getText());
					} else if (tagName.equals("temp")) {						
						System.out.println(xpp.getText());
					} else if (tagName.equals("wfKor")) {						
						System.out.println(xpp.getText());
						System.out.println("-----------");
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
	}
}
