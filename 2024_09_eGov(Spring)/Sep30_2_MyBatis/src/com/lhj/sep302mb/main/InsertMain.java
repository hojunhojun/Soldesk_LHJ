package com.lhj.sep302mb.main;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.lhj.sep302mb.product.Product;

import hojun.lee.db.manager.LeeDBManager;

public class InsertMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			System.out.print("이름 : ");
			String name = s.next();
			
			System.out.print("가격 : ");
			int price = s.nextInt();
			BigDecimal bdPrice = new BigDecimal(price);
			
			Product p = new Product(name, bdPrice);
			
			int row = ss.insert("productMapper.regg", p);
			
			if (row == 1) {
				System.out.println("등록성공");
				// DB작업은 위험 -> 작업이 서버에 바로 반영x
				// 확인해보고 정상이면 -> commit을 해서 실제 반영(수동)
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 확인해보고 잘못된게 있으면 -> rollback해서 취소(수동)
			ss.rollback();
		}
		s.close();
		ss.close();
	}
}
