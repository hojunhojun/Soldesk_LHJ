package com.lhj.aug091uch.sc;
// .jar -> 갖고다니면서 : 라이브러리
// html, html특수문자
public class StringCleaner {
	public static String Clean(String s) {
		s = s.replace("<b>", "");
		s = s.replace("</b>", "");
		s = s.replace("&lt;b&gt", "");
		s = s.replace("&lt;/b&gt", "");
		s = s.replace("&apos", "");
		return s;
	}
}
