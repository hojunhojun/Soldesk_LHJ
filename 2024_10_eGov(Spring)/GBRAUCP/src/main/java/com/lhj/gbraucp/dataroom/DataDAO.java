package com.lhj.gbraucp.dataroom;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhj.gbraucp.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void insertData(Data d, HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/data");
		
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
			String file = mr.getFilesystemName("gd_data");
			String name = mr.getParameter("gd_name");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			d.setGd_gm_id(m.getGm_id());
			d.setGd_name(name);
			d.setGd_data(file);
			
			if (ss.getMapper(DataMapper.class).insertData(d) == 1) {
				request.setAttribute("result", "글쓰기 성공");
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getData(Data d, HttpServletRequest request) {
		try {			
			List<Data> datas = ss.getMapper(DataMapper.class).getData(d);
			request.setAttribute("datas", datas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteData(Data d, HttpServletRequest request) {
		try {
			if (ss.getMapper(DataMapper.class).deleteData(d) == 1) {
				request.setAttribute("result", "삭제 성공");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
	}
}
