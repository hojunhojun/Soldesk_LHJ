package com.lhj.aug081uch.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.http.HttpResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// HTTP 통신(주력) -> 인터넷 / request -> response
// GET / POST 방식 요청이 존재.
// 학원 홈페이지에서 데이터를 받아오자
public class UCMain {
	public static void main(String[] args) {
		// Java : 전세계적으로 많이 쓰이는 언어(자기가 작업한거 공유하는 문화)
		// 자바에 HTTP통신관련 클래스는 없었음. -> 만들어야함 X
		// apache재단에서 작업해준 .jar 가져와서 해봅시다.
		
		try {
			DefaultHttpClient dhc = new DefaultHttpClient();
			
			HttpGet hg = new HttpGet("https://soldesk.com/"); // Get방식 요청객체
			HttpResponse hr = dhc.execute(hg);
			HttpEntity he = hr.getEntity(); // 응답 내용
			InputStream is = he.getContent();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			dhc.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
