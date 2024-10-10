package com.lhj.sep302mb.main;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.lhj.sep302mb.product.Product;

import hojun.lee.db.manager.LeeDBManager;

public class SelectMain2 {		
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner sc = new Scanner(System.in);
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			System.out.print("검색어 : ");
			String n = sc.next();
			
			Product p = new Product(n, null);
			
			List<Product> products = ss.selectList("productMapper.searchhh", p);
			for (Product product : products) {
				System.out.println(product.getP_name());
				System.out.println(product.getP_price());
				System.out.println("--------"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		ss.close();
	}
}
