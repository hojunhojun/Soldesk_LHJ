package com.lhj.gbraucp.gallery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhj.gbraucp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class PhotoDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void insertPhoto(Photo p, HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/imggg");
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			request.setAttribute("result", "가입실패(DB문제)");
			e.printStackTrace();
		}
		try {
			String token = mr.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				request.setAttribute("result", "등록실패(새로고침)");
				return;				
			}
			String photo = mr.getFilesystemName("p_photo");
			String name = mr.getParameter("p_name");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			p.setP_gm_id(m.getGm_id());
			p.setP_name(name);
			p.setP_photo(photo);
			
			if (ss.getMapper(PhotoMapper.class).insertPhoto(p) == 1) {
				request.setAttribute("result", "글쓰기 성공");
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getPhoto( HttpServletRequest request) {
		try {			
			List<Photo> photos = ss.getMapper(PhotoMapper.class).getPhoto();
			
			request.setAttribute("photos", photos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deletePhoto(Photo p, HttpServletRequest request) {
		try {
			if (ss.getMapper(PhotoMapper.class).deletePhoto(p) == 1) {
				request.setAttribute("result", "삭제 성공");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
		
	}
}
