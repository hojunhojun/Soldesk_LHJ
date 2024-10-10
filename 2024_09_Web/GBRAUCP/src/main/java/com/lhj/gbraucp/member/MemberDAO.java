package com.lhj.gbraucp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.lhj.gbraucp.notice.NoticeDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hojun.lee.db.manager.LeeDBManger;

public class MemberDAO {
	
	// 유효성 검사
	// 파일 : 필수, 사진파일만
	// 저상적인 사진파일 선택해야하는데 만약에 .xls -> .png로 바꿔서하면
	// 사용자 손해 -> 서버쪽에서는 손해볼게 없음
	// -> 유효성검사를 약하게
	
	// 정상적인 사진파일 선택해야하는데 고화질 사진 선택하면
	// 가입실패 -> 서버쪽의 용량손해
	
	// 사용자 잘못은 아니지만, DB서버에 문제가 발생하면 가입실패
	
	// 1) 사용자가 10M 넘는 사진 파일 선택 -> DB연결을 굳이?
	// 2) 사용자가 정상 입력 -> DB서버 문제 -> 이미 업로드된 파일 처리는 어떻게?
	public static void join(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("img");
		try { // 파일 관련 처리를 먼저
			mr = new MultipartRequest(request, path, 10485670, "euc-kr", new DefaultFileRenamePolicy()); // 10메가
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패(파일 용량)");
			return;
		}
		
		// 파일 업로드 성공
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String y = mr.getParameter("y");
			int m = Integer.parseInt(mr.getParameter("m"));
			int d = Integer.parseInt(mr.getParameter("d"));
			
			String bd = String.format("%s%02d%02d", y, m, d);
			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "euc-kr").replace("+",  " ");
			
			String sql = "insert into gbraucp_member values(?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, bd);
			pstmt.setString(5, photo);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패(서버 문제)");
			// 이미 파일이 올라가있는데...? -> 삭제
			File f = new File(path+ "/" + mr.getFilesystemName("photo"));
			f.delete();
		}
		LeeDBManger.close(con, pstmt, null);
	}
	
	public static void login(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String sql = "select * from gbraucp_member where gm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 비밀번호 검사
				String dbPw = rs.getString("gm_pw");
				if (pw.equals(dbPw)) {
					Member m = new Member(id, pw, rs.getString("gm_name"), rs.getDate("gm_birthday"), rs.getString("gm_photo"));
					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(10 * 60);
				} else {
					request.setAttribute("result", "다시 입력하세요");
				}
			} else {
				request.setAttribute("result", "다시 입력하세요");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인 실패(서버오류)");
		}
		LeeDBManger.close(con, pstmt, rs);
		
	}
	
	public static boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) { // 로그인됨
			request.setAttribute("loginPage", "member/logined.jsp");
			return true;
		}
		// 로그인 풀림
		request.setAttribute("loginPage", "member/login.jsp");
		return false;
	}
	
	public static void logout(HttpServletRequest request) {
		// session 바로 끊기 -> session에 담아놓은거 다사라짐 -> 그라믄안대
		// request.getSession().setMaxInactiveInterval(-1);
		request.getSession().setAttribute("loginMember", null);
	}
	
	public static void bye(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		// Get방식 요청 : 파라메터값이 주소에 실려서 요청 주소만 알면 그냥 탈퇴가 가능하니
		// 세션을 활용해서 값을 받아오자
		// 신경쓸점 : DB삭제, 서버컴에 남아잇는 프사 삭제
		try {
			con = LeeDBManger.connect("LeePool");
			
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			String sql = "delete from GBRAUCP_MEMBER where gm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			
			// 그 사람이 쓴 글 수
			int noticeCount = NoticeDAO.getNdao().getNoticeCount(m.getId());
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "회원탈퇴 완료");
				
				String path = request.getSession().getServletContext().getRealPath("img");
				
				String file = m.getPhoto();
				file = URLDecoder.decode(file, "euc-kr");
				File f = new File(path + "/" + file);
				f.delete();
				// 그 회원이 쓴 글 수만큼 allNoticecount처리
				NoticeDAO.getNdao().discountNoticeCount(noticeCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "탈퇴실패(서버 문제)");
		}
		LeeDBManger.close(con, pstmt, null);
	}
	
	public static void update(HttpServletRequest request) {
		// 프로필사진 선택안한사람
		//		성공
		//		실패
		// 프로필사진 선택한사람
		//		성공
		//		실패
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("img");
		try {
			mr = new MultipartRequest(request, path, 10485760, "euc-kr", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패(파일용량)");
		}
		String newPhoto = null;
		String oldPhoto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			newPhoto = mr.getFilesystemName("photo");
			oldPhoto = m.getPhoto();
			if (newPhoto != null) { // 프사 수정하는 정상적인 친구
				newPhoto = URLEncoder.encode(newPhoto, "euc-kr").replace("+", " ");
			} else { // 프사 수정 안하는
				newPhoto = oldPhoto;
			}
			String sql = "update GBRAUCP_MEMBER set gm_pw=?, gm_name=?, gm_photo=? where gm_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, newPhoto);
			pstmt.setString(4, m.getId());
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정성공");
				m.setPw(pw);	m.setName(name);	m.setPhoto(newPhoto);
				request.getSession().setAttribute("loginMember", m);
				
				if (!newPhoto.equals(oldPhoto)) {
					oldPhoto = URLDecoder.decode(oldPhoto, "euc-kr");
					File f = new File(path + "/" + oldPhoto);
					f.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
			// 프사 바꾸는 : 새 파일 삭제
			if (!newPhoto.equals(oldPhoto)) {
				newPhoto = mr.getFilesystemName("photo");
				File f = new File(path+"/"+newPhoto);
				f.delete();
			}
		}
		LeeDBManger.close(con, pstmt, null);
		
	}
	public static String getMemberPhoto(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select gm_photo from gbraucp_member where gm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("gm_photo");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManger.close(con, pstmt, rs);
		}
	}
}
