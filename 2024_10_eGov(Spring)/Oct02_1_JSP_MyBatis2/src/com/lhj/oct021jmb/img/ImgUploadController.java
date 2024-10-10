package com.lhj.oct021jmb.img;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImgUploadController")
public class ImgUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImgUploadController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ImgDAO.getIdao().upload(request);
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
