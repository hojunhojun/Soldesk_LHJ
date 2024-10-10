package com.lhj.aug211jl.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import hojun.lee.db.manager.LeeDBManager;

public class SnackDAO {
	private int allSnackCount; //Singleton 패턴으로 연산량 줄이기
	private int snackPerPage;
	
	private SnackDAO() {
		setAllSnackCount(); // 생성시에 호출
		snackPerPage = 3;
	}
	
	private static final SnackDAO SDAO = new SnackDAO();
	
	public static SnackDAO getSdao() {
		return SDAO;
	}
	
	public void setAllSnackCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "select count(*) from aug21_snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			allSnackCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String reg(Snack s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			String sql = "insert into AUG21_SNACK values (AUG21_SNACK_seq.nextval, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getPrice());
			pstmt.setDouble(3, s.getWeight());
			pstmt.setString(4, s.getExp2());
			pstmt.setString(5, s.getC_name());
			if (pstmt.executeUpdate() == 1) {
				allSnackCount++;
				System.out.println("과자의 개수 : " + allSnackCount);
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
	public ArrayList<Snack> get(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = LeeDBManager.connect("jdbc:oracle:thin:@192.168.0.44:1521:xe", "lhj", "qwer1234");
			
			int start = (page-1) * snackPerPage +1;
			int end = page * snackPerPage;
			// end = (end > allSnackCount) ? allSnackCount : end;
			
			String sql = "select * from ("
					+ "	select rownum as rn, s_no, s_name, s_price, s_weight, s_exp, s_c_name "
					+ "	from ("
					+ "		select * "
					+ "		from aug21_snack "
					+ "		order by s_name, s_price"
					+ "	)"
					+ ") where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Snack> snacks = new ArrayList<Snack>();
			while (rs.next()) {
				snacks.add(
					new Snack(
						rs.getInt("s_no"),
						rs.getString("s_name"),
						rs.getInt("s_price"),
						rs.getDouble("s_weight"),
						rs.getDate("s_exp"),	
						rs.getString("s_c_name")
					)
				);
			}
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManager.disconnect(con, pstmt, rs);
		}
	}
	public int getPageCount() {
		return (int) Math.ceil(allSnackCount / (double) snackPerPage);
	}
	
}
