package com.lhj.gbraucp.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.lhj.gbraucp.member.Member;
import com.lhj.gbraucp.member.MemberDAO;

import hojun.lee.db.manager.LeeDBManger;

// Data Access Object / DB Access Object
public class NoticeDAO {
	private int noticePerPage;
	private int allNoticeCount;
	
	private static final NoticeDAO NDAO = new NoticeDAO();
	
	private NoticeDAO() {
		noticePerPage = 7;
	}
	public static NoticeDAO getNdao() {
		return NDAO;
	}
	
	public void write(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			request.setCharacterEncoding("euc-kr");
			String title = request.getParameter("title");
			String text = request.getParameter("txt");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			
			String sql = "insert into gbraucp_notice values(gbraucp_notice_seq.nextval, ?, ?, sysdate, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, text);
			pstmt.setString(3, id);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "글쓰기 성공");
				allNoticeCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글쓰기 실패");
		}
	}
	public void get(int page, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			// 검색어를 세션을 통해서 추출함
			String search = (String) request.getSession().getAttribute("search");
			int noticeCount = allNoticeCount;
			if (search == null) { // 전체조회 : 전체 공지사항수로 페이지
				search = "";
			} else { // 검색중
				noticeCount = getSearchNoticeCount(search); // 검색해서 나온거수
			}
			
			int pageCount = (int) Math.ceil(noticeCount / (double) noticePerPage);
			request.setAttribute("pageCount", pageCount);
			
			int start = (page - 1) * noticePerPage + 1;
			int end = noticePerPage * page;
			
			String sql = "select * "
					+ "from ( "
					+ "	select rownum as rn, gn_no, gn_title, gn_date "
					+ "	from ( "
					+ "		select gn_no, gn_title, gn_date "
					+ "		from gbraucp_notice "
					+ "		where gn_title like '%'||?||'%' or gn_txt like '%'||?||'%'"
					+ "		order by gn_date desc "
					+ "	) "
					+ ") "
					+ "where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			ArrayList<Notice> notices = new ArrayList<Notice>();
			while (rs.next()) {
				notices.add(new Notice(rs.getInt("gn_no"), rs.getString("gn_title"), null, rs.getDate("gn_date"), null));
			}
			request.setAttribute("notices", notices);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManger.close(con, pstmt, null);
	}
	
	public void setAllNoticeCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select count(*) from gbraucp_notice";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allNoticeCount = rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeeDBManger.close(con, pstmt, rs);
	}
	
	public void search(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("euc-kr");
			String search = request.getParameter("search");
			request.getSession().setAttribute("search", search);
			// 검색어 -> 그 검색어에 대한 게시판 내용 가져오기
			// 가져온것도 페이지 나눠야겠지...? -> ㅋㅋㅋ로 검색해놓고 2페이지로 이동 -> 2페이지로 이동해도 검색어 남아있어야함(
			// -> 그러므로 세션 사용
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getSearchNoticeCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select count(*) from GBRAUCP_notice where gn_title like '%'||?||'%' or gn_txt like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("count(*)");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			LeeDBManger.close(con, pstmt, rs);
		}
		
	}
	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}
	
	public boolean getDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			int no = Integer.parseInt(request.getParameter("no"));
			
			String sql = "select * from gbraucp_notice where gn_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Notice n = new Notice(rs.getInt("gn_no"), rs.getString("gn_title"), 
						rs.getString("gn_txt"), rs.getDate("gn_date"), rs.getString("gn_writer"));
				String photo = MemberDAO.getMemberPhoto(n.getWriter());
				request.setAttribute("n", n);
				request.setAttribute("photo", photo);
				
				ArrayList<Reply> replys = getNoticeReply(no);
				request.setAttribute("replys", replys);
				return true;
			}
			return false; // 이미 누가 글 지워서 없는상태
		} catch (Exception e) { // DB문제
			e.printStackTrace();
			return false;
		} finally {
			LeeDBManger.close(con, pstmt, rs);			
		}
	}
	
	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			int no = Integer.parseInt(request.getParameter("no"));
			
			String sql = "delete from gbraucp_notice where gn_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제성공");
				allNoticeCount--;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
		LeeDBManger.close(con, pstmt, null);
	}
	
	public void discountNoticeCount(int noticeCount) {
		allNoticeCount -= noticeCount;
	}
	
	public int getNoticeCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select count(*) from gbraucp_notice where gn_writer = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;			
		} finally {
			LeeDBManger.close(con, pstmt, rs);
		}
	}
	
	public void update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "update gbraucp_notice set gn_title = ?, gn_txt = ? where gn_no = ?";
			request.setCharacterEncoding("euc-kr");
			String title = request.getParameter("title");
			String txt = request.getParameter("txt");
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
		}
		LeeDBManger.close(con, pstmt, null);
	}
	public void writeReply(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = LeeDBManger.connect("LeePool");
			String txt = request.getParameter("txt");
			int no = Integer.parseInt(request.getParameter("no"));
			Member m = (Member) request.getSession().getAttribute("loginMember");
			
			String sql = "insert into gbraucp_notice_reply values(gbraucp_notice_reply_seq.nextval, ?, sysdate, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, txt);
			pstmt.setString(2, m.getId());
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "댓글작성성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
		}
		LeeDBManger.close(con, pstmt, null);
	}
	
	private ArrayList<Reply> getNoticeReply(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = LeeDBManger.connect("LeePool");
			
			String sql = "select * from gbraucp_notice_reply where gnr_gn_no = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArrayList<Reply> replys = new ArrayList<Reply>();
			while (rs.next()) {
				replys.add(new Reply(rs.getInt("gnr_no"), rs.getString("gnr_txt"), 
						rs.getDate("gnr_date"), rs.getString("gnr_writer"), rs.getInt("gnr_gn_no")));
			}
			return replys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			LeeDBManger.close(con, pstmt, rs);			
		}
	}
}
