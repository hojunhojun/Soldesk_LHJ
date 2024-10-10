package com.lhj.aug205dbt.main;

import java.util.ArrayList;

import com.lhj.aug205dbt.product.Product;
import com.lhj.aug205dbt.product.ProductDAO;

public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		String searchWord = cs.getSearchWord();
		
		ArrayList<Product> products = ProductDAO.getPdao().search(searchWord);
		cs.print(products);
		cs.close();
	}
}
