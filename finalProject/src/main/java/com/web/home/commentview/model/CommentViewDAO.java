package com.web.home.commentview.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentViewDAO {

	@Autowired
	private SqlSession sess;
	
	// 게시글 조회
	public List<PostViewVO> selectPostView(int c_id) {
		List<PostViewVO> postViewDatas = this.sess.selectList("commentViewMapper.selectPostView", c_id);
		System.out.println("dao -> " + postViewDatas);
		
		return postViewDatas;
	}

	// 댓글 조회
	public List<CommentViewVO> selectCommentView(int c_id) {
		List<CommentViewVO> commentViewDatas = this.sess.selectList("commentViewMapper.selectCommentView", c_id);
		System.out.println("dao -> " + commentViewDatas);
		
		return commentViewDatas;
	}

	// 게시글 사진 조회
	public List<PostPhotoVO> selectPhotoView(int c_id) {
		List<PostPhotoVO> photoDatas = this.sess.selectList("commentViewMapper.selectPhotoView", c_id);
		System.out.println("dao -> " + photoDatas);
		
		return photoDatas;
	}
	
	// 좋아요 수 조회
	public int selectLikeCount(int b_id) {
		int likeCount = this.sess.selectOne("commentViewMapper.selectLikeCount", b_id);
		System.out.println("dao -> 좋이요 수 : " + likeCount);
		
		return likeCount;
	}
	
	// 좋아요 +1 업데이트
	public int updateLikeCount(PostViewVO vo) {
		int result = this.sess.update("commentViewMapper.updateLikeCount", vo);
		System.out.println("dao -> 좋이요 수 : " + vo);
		
		return result;
	}

	// 댓글 작성 -> m_id 조회
	public int selectM_ID(MIdFoundVO mid) {
		int m_id = this.sess.selectOne("commentViewMapper.selectM_ID", mid);
		
		return m_id;
	}

	// 댓글작성 저장
	public int insertComment(CommentWriteVO vo) {
		return this.sess.insert("commentViewMapper.insertComment", vo);
	}

	// 작성한 댓글 조회(1개)
	public CommentViewVO selectCommemtOne(int b_id) {
		CommentViewVO commentData = this.sess.selectOne("commentViewMapper.selectCommentOne", b_id);
		
		System.out.println("dao -> " + commentData);
		
		return commentData;
	}
	
	// 조회수 조회
	public int selectVisitCount(int b_id) {
		int visitCount = this.sess.selectOne("commentViewMapper.selectVisitCount", b_id);
		System.out.println("dao -> 조회수 : " + visitCount);
		
		return visitCount;
	}
	
	// 조회수 +1 업데이트
	public int updateVisitCount(PostViewVO vo) {
		int result = this.sess.update("commentViewMapper.updateVisitCount", vo);
		System.out.println("dao -> 조회수 : " + vo);
		
		return result;
	}

}
