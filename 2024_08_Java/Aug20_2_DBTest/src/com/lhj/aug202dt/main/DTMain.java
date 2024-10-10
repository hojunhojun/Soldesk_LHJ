package com.lhj.aug202dt.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import hojun.lee.db.manager.LeeDBManager;

// 평균값 구하기
public class DTMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			// String sql = "select * from aug19_product"; -> 이거는 데이터를 다 가져오는거라 비효율
			String sql = "select avg(p_price) from aug19_product";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // 실행
			rs.next();
			System.out.println(rs.getDouble("avg(p_price)"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManager.disconnect(con, pstmt, rs);
	}
}
