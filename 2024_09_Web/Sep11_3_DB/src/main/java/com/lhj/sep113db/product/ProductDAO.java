package com.lhj.sep113db.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import hojun.lee.db.manager.LeeDBManger;

public class ProductDAO {
	private int allProductCount;
	private int productPerPage;
	private static final ProductDAO PDAO = new ProductDAO();
	
	private ProductDAO() {
		productPerPage = 5;
	}
	
	public static ProductDAO getPdao() {
		return PDAO;
	}
	
	public void setAllProductCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select count(*) from sep11_product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			allProductCount = rs.getInt("count(*)");
			System.out.println(allProductCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManger.close(con, pstmt, rs);
	}
	
	public void get(int page, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = LeeDBManger.connect("LeePool");
			
			int pageCount = (int) Math.ceil(allProductCount / (double) productPerPage); // 전체 페이지 수
			request.setAttribute("pageCount", pageCount);
			
			int start = (page - 1) * productPerPage + 1;
			int end = page * productPerPage;
			
			String sql = "select * from (select rownum as rn, p_name, p_price from (select p_name, p_price from sep11_product order by p_name)) where rn >= ? and rn <=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Product> products = new ArrayList<Product>();
			Product p = null;
			while (rs.next()) {
				p = new Product();
				p.setName(rs.getString("p_name"));
				p.setPrice(rs.getInt("p_price"));
				products.add(p);
			}
			request.setAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManger.close(con, pstmt, rs);
	}
	
	public void reg(HttpServletRequest request) {
		// DB서버랑 연결
		Connection con = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null -> 얘는 Select에서 씀
		try {
			con = LeeDBManger.connect("LeePool");
			
			request.setCharacterEncoding("euc-kr");
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			
			String sql = "Insert into sep11_product "
							+ "values(sep11_product_seq.nextval, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "등록성공");
				allProductCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "등록실패");
		}
		LeeDBManger.close(con, pstmt, null);
	}
}
