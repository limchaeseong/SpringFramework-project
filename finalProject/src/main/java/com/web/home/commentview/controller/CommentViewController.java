package com.web.home.commentview.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.home.commentview.model.CommentViewVO;
import com.web.home.commentview.model.CommentWriteVO;
import com.web.home.commentview.model.MIdFoundVO;
import com.web.home.commentview.model.PostPhotoVO;
import com.web.home.commentview.model.PostViewVO;
import com.web.home.commentview.service.CommentViewService;

@Controller
public class CommentViewController {

	private static final Logger logger = LoggerFactory.getLogger(CommentViewController.class);
	
	@Autowired
	private CommentViewService service;
	
	@RequestMapping(value="/commentView", method=RequestMethod.GET)
	public String view(Model model, HttpSession session) {
		logger.info("GET -> 게시글/댓글 조회 페이지");
		
		// 세션 정보로 C_ID 조회 (어떤 모임의 게시글인지 알아야 됨)
//		int c_id = (int) session.getAttribute("s_c_id");
		int c_id = 1;
		
		
		// 게시글 조회
		List<PostViewVO> postViewDatas = service.selectPostView(c_id);
		System.out.println("controller -> " + postViewDatas);
		
		System.out.println(postViewDatas.size() == 0);
		
		model.addAttribute("postViewDatas", postViewDatas);
		
		
		if(postViewDatas.size() != 0) {
			
			// 게시글 사진 조회
			List<PostPhotoVO> photoDatas = service.selectPhotoView(c_id);
			System.out.println("controller -> " + photoDatas);
			
			model.addAttribute("photoDatas", photoDatas);
			
			
			// 댓글 조회
			List<CommentViewVO> commentViewDatas = service.selectCommentView(c_id);
			System.out.println("controller -> " + commentViewDatas);
			
			model.addAttribute("commentViewDatas", commentViewDatas);
			
		}
		
		return "commentView_cy/commentView";
	}
	
	// 좋아요 +1
	@RequestMapping(value="/likeCount", method=RequestMethod.GET)
	@ResponseBody
	public String like(int b_id) {
		System.out.println("좋아요 수 + 1");
		System.out.println("게시판 번호 -> " + b_id);
		
		// 좋아요 수 조회
		int likeCount = service.selectLikeCount(b_id);
		System.out.println("controller -> 좋이요 수 : " + likeCount);
		
		// 좋아요 +1
		PostViewVO vo = new PostViewVO();
		vo.setB_good(likeCount + 1);
		System.out.println("controller -> 좋아요 수 +1 : " + (likeCount + 1));
		vo.setB_id(b_id);
		
		likeCount = service.updateLikeCount(vo);
		System.out.println("controller -> 좋이요 수 : " + likeCount);
		
		String res = String.valueOf(likeCount);
		
		return res;
	}
	
	// 댓글 작성 저장
	@RequestMapping(value="/commentWrite", method=RequestMethod.GET)
	@ResponseBody
	public CommentViewVO commentWrite(int b_id, String cm_content, CommentWriteVO vo, HttpSession session) {
		System.out.println("댓글작성 저장");
		System.out.println("게시판 번호 -> " + b_id);
		System.out.println("댓글 내용 -> " + cm_content);
		
		// a_id, c_id로 m_id 조회
		// 세션 정보로 a_id
		int a_id = (int) session.getAttribute("s_a_id");
//		int a_id = 3;
		
//		AccountDTO dto = new AccountDTO();
//		dto.setA_id(a_id);
		
		// 세션 정보로 c_id
		int c_id = (int) session.getAttribute("s_c_id");
//		int c_id = 1;
		
		MIdFoundVO mid = new MIdFoundVO();
		mid.setA_id(a_id);
		mid.setC_id(c_id);
		
		int m_id = service.selectM_ID(mid);
		
		
		// 데이터 CommentWriteVO에 저장
		vo.setM_id(m_id);	vo.setB_id(b_id);	vo.setCm_content(cm_content);
		
		System.out.println("controller(작성) -> " + vo);
		
		
		// 댓글작성 저장 (+ 저장된 댓글 조회)
		CommentViewVO commentOneView = null;
		try {
			commentOneView = service.insertComment(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("controller(작성 후 조회) -> " + commentOneView);
		
		return commentOneView;
	}
	
	// 조회수 +1
	@RequestMapping(value="/visitCount", method=RequestMethod.GET)
	@ResponseBody
	public String visit(int b_id) {
		System.out.println("조회수 + 1");
		System.out.println("게시판 번호 -> " + b_id);
		
		// 조회수 조회
		int visitCount = service.selectVisitCount(b_id);
		System.out.println("controller -> 조회수 : " + visitCount);
		
		// 조회수 +1
		PostViewVO vo = new PostViewVO();
		vo.setB_people(visitCount + 1);
		System.out.println("controller -> 조회수 +1 : " + (visitCount + 1));
		vo.setB_id(b_id);
		
		visitCount = service.updateVisitCount(vo);
		System.out.println("controller -> 조회수 : " + visitCount);
		
		String res = String.valueOf(visitCount);
		
		return res;
	}
}
