package com.lhj.sep302mb.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.lhj.sep302mb.product.Product;

import hojun.lee.db.manager.LeeDBManager;

public class SelectMain3 {		
	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner sc = new Scanner(System.in);
		try {
			LeeDBManager.getLdbm().newSSF("config.xml");
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			BigDecimal bdPrice = new BigDecimal(price);
			
			Product p = new Product(null, bdPrice);
			
			List<Product> products = ss.selectList("productMapper.searchPrice", p);
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
