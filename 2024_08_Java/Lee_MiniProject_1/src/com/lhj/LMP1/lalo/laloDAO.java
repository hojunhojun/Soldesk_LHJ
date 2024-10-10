package com.lhj.LMP1.lalo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// C
public class laloDAO {
    
    public String[] getLalo(String addr) {
        HttpsURLConnection huc = null;
        
        try {
            String search = URLEncoder.encode(addr, "utf-8");
            
            String s = "https://dapi.kakao.com/v2/local/search/address.json?query=" + search;
            URL u = URI.create(s).toURL();
            huc = (HttpsURLConnection) u.openConnection();
            huc.setRequestProperty("Authorization", "KakaoAK 863304c510593e9bd9146a82055066a9");
            
            InputStream is = huc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(isr);
            JSONArray ja = (JSONArray) jo.get("documents");
            JSONObject jo2 = (JSONObject) ja.get(1);
            String x = (String) jo2.get("x"); // 경도
            String y = (String) jo2.get("y"); // 위도
            String z = (String) jo2.get("address_name");
            String[] st = new String[] {y, x, z};
            return st;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (huc != null) {
                huc.disconnect();
            }
        }
        return null;
    }
}
