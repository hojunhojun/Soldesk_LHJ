package com.lhj.aug091uch.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.lhj.aug091uch.sc.StringCleaner;

// HTTP통신(인터넷)
//		요청할때 서버측에 보내주는 정보 - 응답의 순서
//			request parameter = 변수명=값&변수명=값...부분
//			request header(내부적으로 전달되는 : 사람들이 못봄)

// https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%ED%94%84%EB%A1%9C%EC%95%BC%EA%B5%AC
// 통신방식://서버주소/파일명?변수명=값&변수명=값&변수명=값...
// 인터넷 주소에는 한글불가. -> URL인코딩.

// IP주소 -돈듬-> 글자로 된 서버주소

// 파일명.확장자
// abcd.txt
// 확장자 : MS진영에만있는 사람보기좋으라고 붙여놓은것
// .hwp - 한글에서 잘 열리는 파일이겠거니...
// .xls - 엑셀에서 잘 열리는 파일이겠거니...
// .csv(comma separated value) - 값들이 콤마로 구분되어있겠거니...
public class UCMain {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			
			// 서버연결 -> 프로세스의 실패 확률을 따져서 위치 조정
			String search = "코로나";
			search = URLEncoder.encode(search, "utf-8"); // URL방식으로 인코딩(네이버 개발자센터 참고)			
			String s = "https://openapi.naver.com/v1/search/blog.xml?query="+ search;
			URL u = URI.create(s).toURL();
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "9fpNoNG2I28Il_g1YDwK");
			huc.addRequestProperty("X-Naver-Client-Secret", "ze2X8TyNTE");
			
			InputStream is = huc.getInputStream();
			
			// 파일 열기 -> 프로세스의 실패 확률을 따져서 위치 조정
			FileOutputStream fos = new FileOutputStream("C:\\Users\\1134h\\Eclipse\\naverNews.txt", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			
			// 날짜준비 -> 프로세스의 실패 확률을 따져서 위치 조정
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy\tMM\tdd\tHH\t");
			String now = sdf.format(new Date());
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			
			int what = xpp.getEventType();
			String tn = null;
			boolean news = false;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tn = xpp.getName();
					if (tn.equals("item")) {
						news = true;
					}
				} else if (what == XmlPullParser.TEXT) {
					if (news) {
						if (tn.equals("title")) {
							bw.write(now);
							bw.write(StringCleaner.Clean(xpp.getText()) + "\t");
						} else if (tn.equals("description")) {						
							bw.write(StringCleaner.Clean(xpp.getText()) + "\r\n");
						}
					}
				} else if (what == XmlPullParser.END_TAG) {

				}
				xpp.next();
				what = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {bw.close();} catch (IOException e) {e.printStackTrace();}
		huc.disconnect();
	}
}
