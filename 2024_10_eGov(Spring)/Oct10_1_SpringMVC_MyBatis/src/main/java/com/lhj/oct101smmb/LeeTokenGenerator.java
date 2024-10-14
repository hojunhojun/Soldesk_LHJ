package com.lhj.oct101smmb;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 새 요청때마다 부여될 유니크한 값
// 앞으로도 영원히 중복 안될 : 현재시간
// 랜덤 : 뭐가 나올지 모르는...
@Service
public class LeeTokenGenerator {
	private SimpleDateFormat sdf;
	
	public LeeTokenGenerator() {
		sdf = new SimpleDateFormat("mmssSS");
	}
	
	public void generate(HttpServletRequest request) {
		Date now = new Date();
		String token = sdf.format(now);
		request.setAttribute("token", token);
	}
}
