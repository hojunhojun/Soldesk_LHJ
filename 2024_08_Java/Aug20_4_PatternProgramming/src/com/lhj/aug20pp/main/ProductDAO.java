package com.lhj.aug20pp.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import hojun.lee.db.manager.LeeDBManager;

// DAO(Data/DB Access Object)
public class ProductDAO {
	
	// Singleton 패턴 : 1) 생성자를 private
	private ProductDAO() {
		
	}
	
	// 2) 수정 불가능하게 만들기
	private static final ProductDAO PDAO = new ProductDAO();

	// 3) getter만들기
	public static ProductDAO getInstance() {
		return PDAO;
	}

	public String reg(Product p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "insert into aug19_product values (aug19_product_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getPrice());
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
