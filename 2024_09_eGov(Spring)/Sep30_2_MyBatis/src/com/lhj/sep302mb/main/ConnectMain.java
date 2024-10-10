package com.lhj.sep302mb.main;

import org.apache.ibatis.session.SqlSession;

import hojun.lee.db.manager.LeeDBManager;

// MyBatis 
//		서버정보 : xxxConfig.xml
//		SQL : xxxMapper.xml

// 1) maven project로 바꾸고
// 2) ojdbc, mybatis, leeDBManger 불러오고
// 3) config.xml 가져오고
// 4) mapper.xml 만들기 (new 메뉴 잘 써서)
// 5) config.xml 수정
public class ConnectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
