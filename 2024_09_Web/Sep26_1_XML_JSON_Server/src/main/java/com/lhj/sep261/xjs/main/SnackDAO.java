package com.lhj.sep261.xjs.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import hojun.lee.db.manager.LeeDBManger;

public class SnackDAO {
	// DB에 있는거
	// 		index.jsp에 나오게 : 내부
	//		외부 -> DB서버 주소, 포트, id, pw을 줄순 없음
	//			-> DB에 있는 데이터 외부에서 요청하면 줄수있게
	//				데이터만 줄 수 있는 시스템(XML, JSON)
	public static void getSnack(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select * from sep26_snack";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Snack> snacks = new ArrayList<Snack>();
			while (rs.next()) {
				snacks.add(new Snack(rs.getString("s_name"), rs.getInt("s_price")));
			}
			request.setAttribute("snacks", snacks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManger.close(con, pstmt, rs);
	}
	
	// request parmm - 불가
	// cookie - 위험
	// request attribute - 요청 -> 다음 요청까지만 값이 살아남음
	// session attribute - 서버-사용자 -> 이 사이트 어디서든 값 사용
	
	// 외부 분석가가 데이터좀 주세요..하면?
	// DB의 데이터를 String으로 만들어서 응답
	// A랑 B가 데이터 주고받는 중인데, 정해진 형식이 있어야...
	// -> 한글처리, 파싱
	// 데이터를 주고받을때 쓰는 국제표준형식
	//		XML : 데이터를 HTML모양으로 / JSON : 데이터를 JavaScript 모양으로
	public static String getSnack2(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select * from sep26_snack";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<sep26_snack>");
			while (rs.next()) {
				sb.append("<snack>");
				sb.append("<s_name>" + rs.getString("s_name") + "</s_name>");
				sb.append("<s_price>" + rs.getInt("s_price") + "</s_price>");
				sb.append("</snack>");
			}
			sb.append("</sep26_snack>");
			String snacks = sb.toString();
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManger.close(con, pstmt, rs);			
		}
	}
	
	public static String getSnack3(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select * from sep26_snack";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// XML vs JSON
			//		JavaScript에서 주로 사용 => AJAX
			//		XML이 먼저 탄생 : 데이터를 HTML모양으로
			//		어차피 JS에서 쓰는데 굳이 HTML로?
			//		그럴거면 그냥 JS모양으로..
			//		JSON이 탄생 : 데이터를 JS모양
			//			JSON이 파싱 쉬움 / 용량적음 -> 모든면에서 XML 상위호환
			//			-> 요즘은 JSON이 주력
			//		XML이 JSON보다 가독성은 나아보임 ㅇㅇ -> 설정파일에 활용됨
			StringBuffer sb = new StringBuffer();
			// sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			boolean first = true;
			sb.append("["); // sb.append("<sep26_snack>");
			while (rs.next()) {
				if (first) {
					first = false;
				} else {
					sb.append(",");
				}
				sb.append("{"); // sb.append("<snack>");
				sb.append("\"s_name\" : \"" + rs.getString("s_name") + "\",");// sb.append("<s_name>" + rs.getString("s_name") + "</s_name>");
				sb.append("\"s_price\" : " + rs.getInt("s_price"));// sb.append("<s_price>" + rs.getInt("s_price") + "</s_price>");
				sb.append("}"); // sb.append("</snack>");
				
			}
			sb.append("]"); // sb.append("</sep26_snack>");
			String snacks = sb.toString();
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManger.close(con, pstmt, rs);			
		}
	}
}
