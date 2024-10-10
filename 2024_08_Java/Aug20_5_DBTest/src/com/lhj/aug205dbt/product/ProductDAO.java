package com.lhj.aug205dbt.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hojun.lee.db.manager.LeeDBManager;

public class ProductDAO {
	
	private ProductDAO() {

	}
	private static final ProductDAO PDAO = new ProductDAO();
	
	public static ProductDAO getPdao() {
		return PDAO;
	}
	public ArrayList<Product> search(String searchWord) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "select p_name, p_price from aug19_product where p_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchWord);
			
			rs = pstmt.executeQuery();
			
			ArrayList<Product> products = new ArrayList<Product>();
			Product p;
			while (rs.next()) {
				p = new Product();
				p.setName(rs.getString("p_name"));
				p.setPrice(rs.getInt("p_price"));
				products.add(p);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManager.disconnect(con, pstmt, null);			
		}
	}
}

