package com.lhj.sep301mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Java vs ConnectionPool : 미리 연결을 만들어놓고 쓰기 -> 빠름
//							유지보수에 용이함.
// 유지보수에 용이 : .java에 써놓으면 기계어로 변환되어 수정힘듬
//		-> 외부 파일에 써놓자(*)

//								서버				SQL
// Java : JDBC(v1.0)			.java			.java
// JSP : ConnectionPool(v2.0)	.xml(외부에*)		.java			톰캣이함
// eGov : MyBatis(v3.0)			.xml(외부에*)		.xml(외부에*)

// MyBatis 쓴 이유가 뭐니..?
//		서버연결정보, SQL문 둘다 외부파일에 써서 -> 유지보수에 용이함
//		DB ORM(Object Relationship Mapping) Framework
//		-> 자동으로 Java 객체로 만들어줌(Good!!)
//		자체적으로 ConnectionPool기능 내장

// LeeDBManager_v2.0.jar -> 뭔가 잘못됨...
// LeeDBManager_v3.0.jar
public class ConnectMain {
	public static void main(String[] args) {
		// Connection con = null;
		SqlSession ss = null; // 기존의 Connection 역할을 얘가함 (예외처리 안해도 되지만 걍해)
		try {
			InputStream is = Resources.getResourceAsStream("aa.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is); // Factory(공장) 이 필요함
			ss = ssf.openSession();
			
			System.out.println("연결성공");
		} catch (Exception e) {
			System.out.println("연결실패");
			e.printStackTrace();
		}
		ss.close(); // ss만 닫으면 됨
	}
}
