package com.lhj.aug205dbt.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import hojun.lee.db.manager.LeeDBManager;

public class ProductDAO {
	
	private ProductDAO() {

	}
	private static final ProductDAO PDAO = new ProductDAO();
	
	public static ProductDAO getPdao() {
		return PDAO;
	}
	
	public static String search(String s) {
		ConsoleScreen cs = new ConsoleScreen();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "select p_name, p_price from aug19_product where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
			return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			LeeDBManager.disconnect(con, pstmt, null);
		}
	}
}
