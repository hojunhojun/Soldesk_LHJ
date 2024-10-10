package com.lhj.sep112db.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 원격지에 OracleDB서버가 있는데, 원격제어를 해야
// 그 프록램이 sqlplus인데 불편함
// -> 그래서 EclipseIDE로 원격제어 하자
// .sql파일 만들자
// EclipseIDE가 프로젝트 없이 파일만 만들지 못하는 구조
// 그냥 지금 프로젝트에 대충 만들어서 쓰다가 버리자
// 개발중인 프로젝트랑은 상관없음
public class ProductDAO {
	// ConnectionPool 방식
	//		미리 만들어놓은 Connection을 빠르게 주는 방식
	//		Tomcat에 DataSource를 만들어놔야함(톰캣 설정파일)
	
	// 웹 개발자
	// 		인천공항 프로젝트 : A서버
	//		한화생명 프로젝트 : B서버
	//		...
	//		-> 저 프로젝트들이 다 같은 DB서버? 과연?
	//		-> 프로젝트 별로 톰캣 설정파일 따로 쓰는게 맞을거임 ㅇㅇ
	//		-> 프로젝트의 META-INF폴더에 톰캣 설정파일을 넣자
	//		context.xml : 거기다 객체를 등록해놓고.java에서 불러다 쓸 수 있음
	//		name : .java에서 부를때 쓸 이름 / username : id / password : pw / url : 서버주소
	//		maxTotal : 최대 동시접속자수 / maxIdle=미리 만들어놓을 Connection 개수
	public static void connectTest() {
		Connection con = null;
		try {
			// context.xml(설계된 설정파일)
			Context ctx = new InitialContext();
			// 에 써놓은 정보 불러와서 DataSource만들고 
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/LeePool");
			// Connection 빌려오기
			con = ds.getConnection();
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
		
	}
	
	// 옛날방식(Original JDBC방식)
	//		필요할때마다 Connection을 만들어서... -> 느림
	public static void connectTestold() {
		Connection con = null;
		try {
			// jsp에서는 oracledriver를 알아서 못찾음
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 그러니까 이거 쓰셈 ㅇㅇ
			String url="jdbc:oracle:thin:@192.168.0.44:1521:xe";
			con = DriverManager.getConnection(url, "lhj", "qwer1234");
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
