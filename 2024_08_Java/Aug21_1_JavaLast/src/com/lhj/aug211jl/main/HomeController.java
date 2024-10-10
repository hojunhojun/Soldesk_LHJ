package com.lhj.aug211jl.main;

import java.util.ArrayList;

import com.lhj.aug211jl.company.Company;
import com.lhj.aug211jl.company.CompanyDAO;
import com.lhj.aug211jl.snack.Snack;
import com.lhj.aug211jl.snack.SnackDAO;

public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		
		int menu, page;
		Company c;
		Snack s;
		String result;
		ArrayList<Company> companys;
		ArrayList<Snack> snacks;
		while (true) {
			menu = cs.showMainMenu();
			if (menu == 1) {
				c = cs.showRegCompanyMenu();
				result = CompanyDAO.getCdao().reg(c);
				cs.printResult(result);
			} else if (menu == 2) {
				companys = CompanyDAO.getCdao().get();
				cs.printResult(companys);
			} else if (menu == 3) {
				s = cs.showRegSnackMenu();
				result = SnackDAO.getSdao().reg(s);
				cs.printResult(result);
			} else if (menu == 4) {
				page = SnackDAO.getSdao().getPageCount();
				page = cs.getPageNo(page);
				snacks = SnackDAO.getSdao().get(page);
				cs.printSnackResult(snacks);
			} else if (menu == 10) {
				break;				
			}
		}
		cs.end();
	}
}
