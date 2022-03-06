package com.web.home.club.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.model.ApplyVO;
import com.web.home.club.model.CategoryVO;
import com.web.home.club.model.ClubVO;
import com.web.home.club.service.ApplyService;
import com.web.home.club.service.ClubService;
import com.web.home.commentview.model.CommentViewVO;
import com.web.home.commentview.model.PostPhotoVO;
import com.web.home.commentview.model.PostViewVO;
import com.web.home.commentview.service.CommentViewService;
import com.web.home.member.model.MemberVO;
import com.web.home.member.service.MemberService;


@Controller
public class ViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	@Autowired
	private ClubService service;
	
	@Autowired
	private ApplyService Aservice;
	
	@Autowired
	private MemberService Mservice;
	
	// 임채연
	@Autowired
	private CommentViewService serviceCY;
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String clubView() {	
		return "club/view";
	}
	
	@RequestMapping("/viewDetail")
	public String list(int c_id, Model model, HttpSession session) {
		int a_id;
		if(session.getAttribute("s_a_id")==null) {
			return "redirect:login";
		}else {
			a_id = (int) session.getAttribute("s_a_id");
		}
		// c_id로 ClubVO 정보 불러오기
		ClubVO cvo = service.viewClub(c_id);
		session.setAttribute("club", cvo);
		
		// 멤버 수 조회
		int mCount = Aservice.countMember(c_id);
		session.setAttribute("mCount", mCount);
		// c_id로 ApplyVO 정보 불러오기
		ApplyVO data = Aservice.selectA_id(c_id);
		session.setAttribute("ap", data);
		
		// a_id로 AccountVO 정보 불러와서 모임장 이름 가져오기
		int clubManager = data.getA_id();
		AccountDTO dto = Aservice.selectAccount(clubManager);
		session.setAttribute("avo", dto);
		
		// c_id로 CategoryVO 정보 이용하여 카테고리 이름 가져오기
		CategoryVO cgName = service.selectCgName(c_id);
		session.setAttribute("cgName", cgName);
		
		// a_id, c_id 비교해서 모임 가입 여부 확인
		ApplyVO resultVO = Aservice.applyState(c_id, a_id);
		session.setAttribute("ap", resultVO);
		session.setAttribute("s_c_id", c_id);
		
		// 내가 모임장인지 여부
		MemberVO mvo = new MemberVO();
		mvo.setA_id(a_id);
		mvo.setC_id(c_id);
		String yN = Mservice.imManager(mvo);
		model.addAttribute("yN", yN);
		
		
		
		// 게시글 조회(cy)
		logger.info("GET -> 게시글/댓글 조회 페이지");
		
		// 세션 정보로 C_ID 조회 (어떤 모임의 게시글인지 알아야 됨)
		int c_idCY = (int) session.getAttribute("s_c_id");
//		int c_idCY = 1;
		
		
		// 게시글 조회
		List<PostViewVO> postViewDatas = serviceCY.selectPostView(c_idCY);
		System.out.println("controller -> " + postViewDatas);
		
		System.out.println(postViewDatas.size() == 0);
		
		model.addAttribute("postViewDatas", postViewDatas);
		
		
		if(postViewDatas.size() != 0) {
			
			// 게시글 사진 조회
			List<PostPhotoVO> photoDatas = serviceCY.selectPhotoView(c_idCY);
			System.out.println("controller -> " + photoDatas);
			
			model.addAttribute("photoDatas", photoDatas);
			
			
			// 댓글 조회
			List<CommentViewVO> commentViewDatas = serviceCY.selectCommentView(c_idCY);
			System.out.println("controller -> " + commentViewDatas);
			
			model.addAttribute("commentViewDatas", commentViewDatas);
			
		}
		
		
		
		return "club/view";			
	}
	
	@RequestMapping(value="/view", method=RequestMethod.POST)
	public String joinClub(ApplyVO vo, Model model, HttpSession session) {	
		int a_id = (int) session.getAttribute("s_a_id");
		int c_id = (int) session.getAttribute("s_c_id");
		vo.setA_id(a_id);
		vo.setC_id(c_id);
		
		// c_id로 ApplyVO 정보 불러오기
		ApplyVO data = Aservice.selectA_id(c_id);
		session.setAttribute("ap", data);
		// 모임 가입
		Aservice.createApply(vo);
		// 가입 상태 확인
		ApplyVO resultVO = Aservice.applyState(c_id, a_id);
		session.setAttribute("ap", resultVO);
		// 멤버 수 조회
		int mCount = Aservice.countMember(c_id);
		session.setAttribute("mCount", mCount);
		// 모임 가입 시 member 테이블 생성
		MemberVO mvo = new MemberVO();
		mvo.setA_id(a_id);
		mvo.setC_id(c_id);
		Mservice.memberApply(mvo);
		return "redirect:/viewDetail?c_id=" + c_id;
	}
	
	@RequestMapping(value="/discription", method=RequestMethod.GET)
	public String discription(Model model, HttpSession session, HttpServletRequest request) {
		int c_id = (int) session.getAttribute("s_c_id");
		model.addAttribute("c_id", c_id);
		return "club/discription";
	}
	
	@RequestMapping(value="/discription", method=RequestMethod.POST)
	public String discription(String c_discription, Model model, HttpSession session, HttpServletRequest request) {
		int c_id = (int) session.getAttribute("s_c_id");
		ClubVO vo = new ClubVO();
		vo.setC_id(c_id);
		vo.setC_discription(c_discription);
		System.out.println("c_discription" + c_discription);
		service.updateDiscription(vo);
		return "redirect:/viewDetail?c_id=" + c_id;
	}
}


