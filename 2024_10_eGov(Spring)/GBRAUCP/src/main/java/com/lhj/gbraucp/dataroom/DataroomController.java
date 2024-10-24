package com.lhj.gbraucp.dataroom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.gbraucp.LeeTokenGenerator;
import com.lhj.gbraucp.member.MemberDAO;

@Controller
public class DataroomController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private DataDAO dDao;
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/dataroom.go", method = RequestMethod.GET)
	public String dataroomGo(Data d, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			dDao.getData(d, request);
			ltg.generate(request);
			request.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/data.insert.do", method = RequestMethod.POST)
	public String dataInsertDo(Data d, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			dDao.insertData(d, request);
			dDao.getData(d, request);
			request.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/data.delete.do", method = RequestMethod.GET)
	public String dataDeleteDo(Data d, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			dDao.deleteData(d, request);
			dDao.getData(d, request);
			request.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
