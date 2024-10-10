package com.lhj.aug192jdbcp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// OracleDB를 제어하는 정품 프로그램 : sqlplus -> CMD기반이라 불편함
// 편한거 찾으려고하니 Eclipse가 있네? 어? 개꿀 ㅋㅋ
// Eclipse로 OracleDB제어하기 위해 수업용 OracleDB서버를 만들어놓음

// 프로그램 != Eclipse

// 프로그램, DB서버 통신 : 자바에 없어서 만들어보자
//		Socket통신(실시간) : HTTP통신(요청-응답)

// DB서버의 메이커가 다양하고 통신방식은 같은데 드라이버가 다을
// 각 DB회사에서 드라이버를 만들어줌 -> ojdbc9.jar
public class ConnectMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe"; // DB작성 양식이 메이커별로 다름
			con = DriverManager.getConnection(url, "lhj", "qwer1234");
			System.out.println("성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
