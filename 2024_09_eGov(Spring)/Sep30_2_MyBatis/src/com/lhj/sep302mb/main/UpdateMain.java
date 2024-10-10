package com.lhj.sep302mb.main;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.lhj.sep302mb.product.Product2;

import hojun.lee.db.manager.LeeDBManager;

public class UpdateMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner s = new Scanner(System.in);
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			System.out.print("찾을 가격 : ");
			int price1 = s.nextInt();
			BigDecimal bdPrice1 = new BigDecimal(price1);
			
			System.out.print("수정할 가격 : ");
			int price2 = s.nextInt();
			BigDecimal bdPrice2 = new BigDecimal(price2);
			
			Product2 p = new Product2(bdPrice1, bdPrice2);
			
			if (ss.update("productMapper.updatee", p) >= 1) {
				System.out.println("수정 성공");
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
