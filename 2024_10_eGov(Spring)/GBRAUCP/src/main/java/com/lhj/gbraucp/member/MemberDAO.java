package com.lhj.gbraucp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	
	private SimpleDateFormat sdf;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}

	public void join(Member m, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/imggg");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, path, 20 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			request.setAttribute("result", "가입실패(DB문제)");
			e.printStackTrace();
		}

		try {
			String id = mr.getParameter("gm_id");
			String pw = mr.getParameter("gm_pw");
			String j1 = mr.getParameter("gm_jumin1");
			String j2 = mr.getParameter("gm_jumin2");

			if (j2.equals("1") || j2.equals("2")) {
				j1 = 19 + j1;
			} else if (j2.equals("3") || j2.equals("4")) {
				j1 = 20 + j1;
			}
			Date bd = sdf.parse(j1);
			String p = URLEncoder.encode(mr.getFilesystemName("gm_photo"), "utf-8").replace("+", " ");
			m.setGm_id(id);
			m.setGm_pw(pw);
			m.setGm_birthday(bd);
			m.setGm_photo(p);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				request.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("gm_photo")).delete();
		}
	}

	public void login(Member m, HttpServletRequest request) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			if (dbMember != null) {
				if (m.getGm_pw().equals(dbMember.getGm_pw())) {
					request.getSession().setAttribute("loginMember", dbMember);
					request.getSession().setMaxInactiveInterval(10000);
				} else {
					request.setAttribute("result", "로그인 실패(pw)");
				}
			} else {
				request.setAttribute("result", "로그인 실패(미가입 ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB문제");
		}
	}

	public boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginPage", "member/logined.jsp");
			return true;
		}
		request.setAttribute("loginPage", "member/login.jsp");
		return false;
	}

	public void logout(HttpServletRequest request) {
		// session 바로 끊기 -> session에 담아놓은거 다사라짐 -> 그라믄안대
		// request.getSession().setMaxInactiveInterval(-1);
		request.getSession().setAttribute("loginMember", null);
	}

	public void bye(HttpServletRequest request) {
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				request.setAttribute("result", "탈퇴성공");
				
				String path = request.getSession().getServletContext().getRealPath("imggg");
				String file = m.getGm_photo();
				new File(path + "/" + file).delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "탈퇴실패");
		}
	}
	
	public void update(Member m, HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/imggg");
		
		try {
			mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패(파일용량)");
		}
		
		String oldPhoto = null;
		String newPhoto = null;
		try {
			Member oldMember = (Member) request.getSession().getAttribute("loginMember");
			String id = oldMember.getGm_id();
			oldPhoto = m.getGm_photo();
			String pw = mr.getParameter("gm_pw");
			newPhoto = mr.getFilesystemName("gm_photo");
			
			if (newPhoto == null) { // 프사 수정하는 정상적인 친구
				newPhoto = oldPhoto;
			} else { // 프사 수정 안하는
				newPhoto = URLEncoder.encode(newPhoto, "utf-8").replace("+", " ");
			}
			
			m.setGm_id(id);		m.setGm_pw(pw);		m.setGm_photo(newPhoto);
			
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				request.setAttribute("result", "수정성공");
				
				m.setGm_birthday(oldMember.getGm_birthday());
				request.getSession().setAttribute("loginMember", m);
				
				if (!oldPhoto.equals(newPhoto)) {
					oldPhoto = URLDecoder.decode(oldPhoto, "utf-8");
					new File(path + "/" + oldPhoto).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
			try {
				if (!oldPhoto.equals(newPhoto)) {
					newPhoto = URLDecoder.decode(newPhoto, "utf-8");
					new File(path + "/" + newPhoto).delete();					
				}
			} catch (Exception e2) {
			}
		}
	}
}
