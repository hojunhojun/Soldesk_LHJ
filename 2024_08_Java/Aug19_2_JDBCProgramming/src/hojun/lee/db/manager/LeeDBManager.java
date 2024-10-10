package hojun.lee.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// AOP적 관점 : DB작업시에 공통된 부분 정리
// OOP의 장점 : 코드 재사용 -> 라이브러리 제작
// Java의 특성 : jar파일로

// 라이브러리 : 최대한 일반적으로(다양한 상황에 쓸수 있게)
public class LeeDBManager {
	// 연결 안되면 대응은 상황마다 다름 그러므로 throw ㄱㄱ
	public static Connection connect(String url, String id, String pw) throws SQLException {
		return DriverManager.getConnection(url, id, pw);
	}
	
	// close가 안되었을때 대응법 -> 대응을뭘해 자바가 융통성 없어서 억지로하는건데 걍 try_catch ㄱㄱ
	public static void disconnect(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {rs.close();} catch (Exception e) {} // 모든 exception 상황에 대비 (범용적 사용을 위해)
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
}
