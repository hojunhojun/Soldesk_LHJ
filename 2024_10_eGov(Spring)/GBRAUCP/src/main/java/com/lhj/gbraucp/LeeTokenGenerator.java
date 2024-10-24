package com.lhj.gbraucp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

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
