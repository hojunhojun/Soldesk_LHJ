package com.lhj.gbraucp.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhj.gbraucp.SiteOption;
import com.lhj.gbraucp.member.Member;

@Service
public class SNSDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;

	public int allPostCount;
	
	public int postPageCount;
	
	public void write(SNSPost sp, HttpServletRequest request) {
		try {
			String token = request.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				request.setAttribute("result", "등록실패(새로고침)");
				return;				
			}
			String txt = sp.getGs_txt().replace("\r\n", "<br>");
			sp.setGs_txt(txt);
			
			Member m = (Member) request.getSession().getAttribute("loginMember");
			sp.setGs_writer(m.getGm_id());
			
			if (ss.getMapper(SNSMapper.class).write(sp) == 1) {
				request.setAttribute("result", "글쓰기 성공");
				request.getSession().setAttribute("successToken", token);
				allPostCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글쓰기 실패");
		}
	}
	
	
	public void get(int page, HttpServletRequest request) {
		try {
			int postCount = allPostCount;
			
			String search = (String) request.getSession().getAttribute("search");
			SNSPostSelector sps = new SNSPostSelector(null, null, search);
			if (search == null) { // 전체조회 : 전체 공지사항수로 페이지
				sps.setSearch("");
			} else { // 검색중
				postCount = ss.getMapper(SNSMapper.class).getPostCount(sps); // 검색해서 나온거수
			}
			int pageCount = (int) Math.ceil(postCount / (double) so.getSnsPostPerPage());
			request.setAttribute("pageCount", pageCount);
			
			request.setAttribute("page", page);
			BigDecimal start = new BigDecimal((page - 1) * so.getSnsPostPerPage() + 1);
			BigDecimal end = new BigDecimal(so.getSnsPostPerPage() * page);
			sps.setStart(start);
			sps.setEnd(end);

			List<SNSPost> posts = ss.getMapper(SNSMapper.class).get(sps);
			for (SNSPost sp : posts) {
				sp.setGs_replys(ss.getMapper(SNSMapper.class).getReply(sp));
			}
			request.setAttribute("posts", posts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAllPostCount() {
		SNSPostSelector sps = new SNSPostSelector(null, null, "");
		allPostCount = ss.getMapper(SNSMapper.class).getPostCount(sps);
	}


	public void search(HttpServletRequest request) {
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
	}
	
	public void searchClear(HttpServletRequest request) {
		SNSPostSelector sps = new SNSPostSelector(null, null, "");
		allPostCount = ss.getMapper(SNSMapper.class).getPostCount(sps);
	}
	
	public void delete(SNSPost sp, HttpServletRequest request) {
		try {
			if (ss.getMapper(SNSMapper.class).delete(sp) == 1) {
				request.setAttribute("result", "삭제성공");
				allPostCount--;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
	}

	public void update(SNSPost sp, HttpServletRequest request) {
		try {
			if (ss.getMapper(SNSMapper.class).update(sp) == 1) {
				request.setAttribute("result", "수정성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
		}
	}
}
