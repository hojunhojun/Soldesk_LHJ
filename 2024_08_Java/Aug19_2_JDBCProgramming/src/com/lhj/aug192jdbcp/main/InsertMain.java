package com.lhj.aug192jdbcp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {
		Scanner ci = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null; // 매니저 생성
		try {
			// 연결
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
			con = DriverManager.getConnection(url, "lhj", "qwer1234");
			
			// 데이터 확보
			System.out.print("제품명 : ");
			String name = ci.next();
			
			System.out.print("가격 : ");
			int price = ci.nextInt();
			
			// 변수 넣을자리에 ?를 넣어서 일단 완성 그리고 ; 이건 쓰지마 여기서
			String sql = "";
			sql = "insert into aug19_product values(aug19_product_seq.nextval, ?, ?)";
			
			// 총괄해주는 매니저 하나 만듭시다.
			// 총괄매니저 호출
			pstmt = con.prepareStatement(sql);
			
			// sql완성
			pstmt.setString(1, name); // 1번 물음표에 name 값을 넣으세요
			pstmt.setInt(2, price); // 2번 물음표에 price 값을 넣어라
			
			// sql을 서버로 전송 + 원격실행 -> 데이터 몇개가 영향받았나(row)?
			int row = pstmt.executeUpdate();
			
			// 결과처리
			if (row == 1) {
				System.out.println("등록 성공");				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (SQLException e) {e.printStackTrace();} // 닫는순서 중요함 이렇게 ㄱㄱ
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
		ci.close();
	}
}
