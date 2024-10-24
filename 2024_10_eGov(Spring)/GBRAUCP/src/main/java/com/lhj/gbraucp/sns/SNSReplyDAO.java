package com.lhj.gbraucp.sns;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhj.gbraucp.member.Member;

@Service
public class SNSReplyDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void writeReply(SNSReply sr, HttpServletRequest request) {
		try {
			String token = request.getParameter("token");
			String oldSuccessToken = (String) request.getSession().getAttribute("successToken");
			
			if (oldSuccessToken != null && token.equals(oldSuccessToken)) {
				request.setAttribute("result", "등록실패(새로고침)");
				return;				
			}
			Member m = (Member) request.getSession().getAttribute("loginMember");
			sr.setGsr_writer(m.getGm_id());
			
			if (ss.getMapper(SNSMapper.class).writeReply(sr) == 1) {
				request.setAttribute("result", "작성성공");
				request.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "작성실패");
		}
	}
	
	public void updateReply(SNSReply sr, HttpServletRequest request) {
		try {
			if (ss.getMapper(SNSMapper.class).updateReply(sr) == 1) {
				request.setAttribute("result", "수정성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패");
		}
	}
	public void deleteReply(SNSReply sr, HttpServletRequest request) {
		try {
			if (ss.getMapper(SNSMapper.class).deleteReply(sr) == 1) {
				request.setAttribute("result", "삭제성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}
	}
	
}
