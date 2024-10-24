package com.lhj.gbraucp.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhj.gbraucp.LeeTokenGenerator;
import com.lhj.gbraucp.member.MemberDAO;

@Controller
public class GalleryController {
	
	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private PhotoDAO pDAO;
	
	@Autowired
	private LeeTokenGenerator ltg;
	
	@RequestMapping(value = "/gallery.go", method = RequestMethod.GET)
	public String galleryGo(Photo p, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			pDAO.getPhoto( request);
			ltg.generate(request);
			request.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/photo.insert.do", method = RequestMethod.POST)
	public String photoInsertDo(Photo p, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			ltg.generate(request);
			pDAO.insertPhoto(p, request);
			pDAO.getPhoto( request);
			request.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/photo.delete.do", method = RequestMethod.GET)
	public String photoDeleteDo(Photo p, HttpServletRequest request) {
		if (mDAO.isLogined(request)) {
			pDAO.deletePhoto(p, request);
			pDAO.getPhoto( request);
			ltg.generate(request);
			request.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
