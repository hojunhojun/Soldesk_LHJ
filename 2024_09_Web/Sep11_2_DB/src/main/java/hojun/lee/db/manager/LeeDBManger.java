package hojun.lee.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LeeDBManger {
	public static Connection connect(String poolName) throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + poolName);
		return ds.getConnection();
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {rs.close();} catch (Exception e) {} // 모든 exception 상황에 대비 (범용적 사용을 위해)
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
	}
}
