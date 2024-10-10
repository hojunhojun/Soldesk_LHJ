package com.lhj.aug192jdbcp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 제품 삭제
public class SelectMain {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			con = DriverManager.getConnection(url, "lhj", "qwer1234");
			
			String sql = "select * from aug19_product";
			pstmt = con.prepareStatement(sql);
			
			// 실행
			// pstmt.executeUpdate(); : 영향받은 데이터수가 리턴 : CUD
			// pstmt.executeQuery(); : select한 결과가 리턴 : R
			rs = pstmt.executeQuery();
			
			// rs.next() : 커서를 다음 데이터로, 갔는데 없으면 false
			while (rs.next()) {
				System.out.println(rs.getString("p_name")); // 제품명 꺼내기
				System.out.println(rs.getInt("p_price")); // 제품명 꺼내기
				System.out.println("----------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
