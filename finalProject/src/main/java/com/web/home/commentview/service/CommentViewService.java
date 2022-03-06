package com.web.home.commentview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.home.commentview.model.CommentViewDAO;
import com.web.home.commentview.model.CommentViewVO;
import com.web.home.commentview.model.CommentWriteVO;
import com.web.home.commentview.model.MIdFoundVO;
import com.web.home.commentview.model.PostPhotoVO;
import com.web.home.commentview.model.PostViewVO;

@Service
public class CommentViewService {

	@Autowired
	private CommentViewDAO dao;
	
	// 게시글 조회
	public List<PostViewVO> selectPostView(int c_id) {
		List<PostViewVO> postViewDatas = dao.selectPostView(c_id);
		System.out.println("service -> " + postViewDatas);
		
		return postViewDatas;
	}

	// 댓글 조회
	public List<CommentViewVO> selectCommentView(int c_id) {
		List<CommentViewVO> commentViewDatas = dao.selectCommentView(c_id);
		System.out.println("service -> " + commentViewDatas);
		
		return commentViewDatas;
	}

	// 게시글 사진 조회
	public List<PostPhotoVO> selectPhotoView(int c_id) {
		List<PostPhotoVO> photoDatas = dao.selectPhotoView(c_id);
		System.out.println("service -> " + photoDatas);
		
		return photoDatas;
	}
	
	// 좋아요 수 조회
	public int selectLikeCount(int b_id) {
		int likeCount = dao.selectLikeCount(b_id);
		System.out.println("service -> 좋이요 수 : " + likeCount);
		
		return likeCount;
	}

	// 좋아요 +1 업데이트
	@Transactional(rollbackFor=Exception.class)
	public int updateLikeCount(PostViewVO vo) {
		int result = dao.updateLikeCount(vo);
		
		if(result == 1) {
			System.out.println("성공!");
			System.out.println("service -> 좋이요 수 : " + vo.getB_good());
			return vo.getB_good();
		} else {
			System.out.println("실패ㅜㅜ");
			throw new TransientDataAccessResourceException("좋아요 +1 업데이트 시 오류");	// 에러를 새로 만들어서 던짐
			
		}
		
	}

	// 댓글 저장 -> M_ID 조회 (a_id 이용해서)
	public int selectM_ID(MIdFoundVO mid) {
		int m_id = dao.selectM_ID(mid);
		
		return m_id;
	}

	// 댓글작성 저장
	@Transactional(rollbackFor=Exception.class)
	public CommentViewVO insertComment(CommentWriteVO vo) {
		int result = dao.insertComment(vo);
		
		System.out.println("service -> " + result);
		
		if(result == 1) {
			// 작성한 댓글 조회
			CommentViewVO commentData = dao.selectCommemtOne(vo.getB_id());
			
			System.out.println(commentData);
			
			return commentData;
		} else {
			throw new TransientDataAccessResourceException("댓글작성 데이터 처리 과정중 문제 발생");	// 에러를 새로 만들어서 던짐
		}
	}

	// 조회수 조회
	public int selectVisitCount(int b_id) {
		int visitCount = dao.selectVisitCount(b_id);
		System.out.println("service -> 조회수 : " + visitCount);
		
		return visitCount;
	}

	// 조회수 +1 업데이트
	@Transactional(rollbackFor=Exception.class)
	public int updateVisitCount(PostViewVO vo) {
		int result = dao.updateVisitCount(vo);
		
		if(result == 1) {
			System.out.println("성공!");
			System.out.println("service -> 조회수 : " + vo.getB_people());
			return vo.getB_people();
		} else {
			System.out.println("실패ㅜㅜ");
			throw new TransientDataAccessResourceException("조회수 +1 업데이트 시 오류");	// 에러를 새로 만들어서 던짐
			
		}
		
	}
}
