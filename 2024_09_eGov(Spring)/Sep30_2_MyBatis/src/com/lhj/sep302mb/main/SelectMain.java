package com.lhj.sep302mb.main;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lhj.sep302mb.product.Product;

import hojun.lee.db.manager.LeeDBManager;

public class SelectMain {		
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			List<Product> products = ss.selectList("productMapper.gettt");
			for (Product product : products) {
				System.out.println(product.getP_name());
				System.out.println(product.getP_price());
				System.out.println("--------"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
