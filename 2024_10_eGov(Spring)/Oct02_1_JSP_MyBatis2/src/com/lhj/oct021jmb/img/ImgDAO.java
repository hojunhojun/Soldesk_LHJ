package com.lhj.oct021jmb.img;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hojun.lee.db.manager.LeeDBManager;

public class ImgDAO {
	private int allImgCount;
	private int imgPerPage;
	
	private static final ImgDAO IDAO = new ImgDAO();

	private ImgDAO() {
		imgPerPage = 3;
	}

	public static ImgDAO getIdao() {
		return IDAO;
	}

	public void upload(HttpServletRequest request) {
		SqlSession ss = null;
		try {
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			String path = request.getSession().getServletContext().getRealPath("imggg");
			System.out.println(path);
			MultipartRequest mr = new MultipartRequest(request, path, 10485670, "utf-8", new DefaultFileRenamePolicy());

			String title = mr.getParameter("title");
			String img = URLEncoder.encode(mr.getFilesystemName("img"), "utf-8").replace("+", " ");

			Img i = new Img(null, title, img, null);

			int row = ss.insert("imgMapper.insertImg", i);

			if (row == 1) {
				request.setAttribute("result", "업로드 성공");
				// DB작업은 위험 -> 작업이 서버에 바로 반영x
				// 확인해보고 정상이면 -> commit을 해서 실제 반영(수동)
				allImgCount++;
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "업로드 실패");
			ss.rollback();
		}
		ss.close();
	}
	
	public void get(int page, HttpServletRequest request) {
		SqlSession ss = null;
		try {
			int pageCount = (int) (Math.ceil(allImgCount / (double)imgPerPage));
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			request.setAttribute("pageCount", pageCount);
			int start = (page -1 ) * imgPerPage + 1;
			int end = page * imgPerPage;
			
			ImgPager ip = new ImgPager(new BigDecimal(start), new BigDecimal(end));
			List<Img> imgs = ss.selectList("imgMapper.gget", ip);
			request.setAttribute("imgs2", imgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
	
	public void setAllImgCount() {
		SqlSession ss = null;
		try {
			ss = LeeDBManager.getLdbm().getSsf().openSession();
			
			allImgCount = ss.selectOne("imgMapper.getImgCount");
			System.out.println(allImgCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
