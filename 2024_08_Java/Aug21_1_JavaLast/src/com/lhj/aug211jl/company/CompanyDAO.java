package com.lhj.aug211jl.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hojun.lee.db.manager.LeeDBManager;

public class CompanyDAO {
	private CompanyDAO() {

	}
	
	private static final CompanyDAO CDAO = new CompanyDAO();
	
	public static CompanyDAO getCdao() {
		return CDAO;
	}
	
	public ArrayList<Company> get() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "select * from aug21_company order by c_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Company> companys = new ArrayList<Company>();
			while (rs.next()) {
				companys.add(new Company(rs.getString("c_name"), rs.getString("c_addr"), rs.getInt("c_emp")));
			}
			return companys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManager.disconnect(con, pstmt, rs);
		}
	}
	
	public String reg(Company c) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "insert into aug21_company values (?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddr());
			pstmt.setInt(3, c.getEmp());
			
			if (pstmt.executeUpdate() == 1) {
				return "등록성공";
			}
			return "등록실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "등록실패";
		} finally {
			LeeDBManager.disconnect(con, pstmt, null);
		}
	}
}
