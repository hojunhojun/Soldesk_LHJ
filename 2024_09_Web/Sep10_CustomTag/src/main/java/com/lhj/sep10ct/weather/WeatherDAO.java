package com.lhj.sep10ct.weather;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherDAO {
	public static void getWeather(HttpServletRequest request) {
		HttpsURLConnection huc = null;
		try {
			URL u = URI.create("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2823766100").toURL();
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			int what = xpp.getEventType();
			String tagName = null;
			ArrayList<Weather> weathers = new ArrayList<Weather>();
			Weather w = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) {
						w = new Weather();
					}
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						w.setHour(xpp.getText());
					} else if (tagName.equals("wfKor")) {	
						w.setWfKor(xpp.getText());
						if (w.getWfKor().equals("맑음")) {
							w.setImg("img/weather/sun.gif");
						} else if (w.getWfKor().contains("구름")) {
							w.setImg("img/weather/somecloud.gif");
						} else if (w.getWfKor().contains("흐림")) {
							w.setImg("img/weather/cloud.gif");
						} else {
							w.setImg("img/weather/rain.gif");
						}
					} else if (tagName.equals("temp")) {
						w.setTemp(xpp.getText());
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals("data")) {
						weathers.add(w);
					}
				}
				xpp.next();
				what = xpp.getEventType();
			}
			request.setAttribute("weathers", weathers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
