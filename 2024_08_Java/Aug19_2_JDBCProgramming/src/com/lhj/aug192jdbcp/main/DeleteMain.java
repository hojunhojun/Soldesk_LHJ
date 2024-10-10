package com.lhj.aug192jdbcp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 제품 삭제
public class DeleteMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			con = DriverManager.getConnection(url, "lhj", "qwer1234");
			
			System.out.print("삭제할 제품명 : ");
			String name = ci.next();
			
			// SQL & Java : 합쳐질때는 사연이 생깁니다.. ex) % 사용 불가
			String sql = "delete from aug19_product where p_name like '%'||?||'%'"; // 이렇게 쓰세요.
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			int row = pstmt.executeUpdate();
			
			if (row == 1) {
				System.out.println("삭제 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
		ci.close();
	}
}
