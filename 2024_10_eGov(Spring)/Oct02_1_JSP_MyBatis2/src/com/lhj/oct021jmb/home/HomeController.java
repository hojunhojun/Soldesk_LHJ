package com.lhj.oct021jmb.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhj.oct021jmb.img.ImgDAO;

import hojun.lee.db.manager.LeeDBManager;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
        try {
        	LeeDBManager.getLdbm().newSSF("com/lhj/oct021jmb/home/config.xml");
        	ImgDAO.getIdao().setAllImgCount();
        } catch (Exception e) {e.printStackTrace();}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImgDAO.getIdao().get(1, request); 
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
