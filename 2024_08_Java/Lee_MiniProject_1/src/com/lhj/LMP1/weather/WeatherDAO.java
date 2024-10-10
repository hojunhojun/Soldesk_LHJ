package com.lhj.LMP1.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// C
public class WeatherDAO {
    public String[] getWeather(String lat, String lon, String addr) {
        HttpsURLConnection huc = null;
        
        try {
            String s = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
            
            URL u = URI.create(s).toURL();
            huc = (HttpsURLConnection) u.openConnection();
            
            InputStream is = huc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(isr);
            JSONArray ja = (JSONArray) jo.get("weather");
            JSONObject weather = (JSONObject) ja.get(0);
            String description = (String) weather.get("description");
            
            JSONObject main = (JSONObject) jo.get("main");
            Double temp = (Double) main.get("temp");
            Double feelsLike = (Double) main.get("feels_like");
            String[] sar = new String[3];
            sar[0] = description;
            sar[1] = temp + "";
            sar[2] = feelsLike + "";
            
            return sar;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            huc.disconnect();
        }
		return null;
    }
    public int get(String lat, String lon, String addr) {
    	HttpsURLConnection huc = null;
    	
    	try {
    		  String s = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr";
              
              URL u = URI.create(s).toURL();
              huc = (HttpsURLConnection) u.openConnection();
              
              InputStream is = huc.getInputStream();
              InputStreamReader isr = new InputStreamReader(is, "utf-8");
              
              JSONParser jp = new JSONParser();
              JSONObject jo = (JSONObject) jp.parse(isr);
              JSONObject main = (JSONObject) jo.get("main");
              Long temp = (Long) main.get("temp");
              String temp2 = temp + "";
              Integer temp3 = Integer.parseInt(temp2);
              return temp3;
		} catch (Exception e) {
			e.printStackTrace();
		} finally  {
			huc.disconnect();
		}
		return 0;
    }
   
}