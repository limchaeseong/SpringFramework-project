package com.web.home.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.metting.model.MettingDTO;
import com.web.home.club.model.ApplyVO;
import com.web.home.club.service.ApplyService;
import com.web.home.member.model.MemberVO;
import com.web.home.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private ApplyService aService;
	
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public String member(Model model, HttpSession session, HttpServletRequest request) {
		int a_id = (int) session.getAttribute("s_a_id");
		int c_id = (int) session.getAttribute("s_c_id");
		MemberVO vo = new MemberVO();
		vo.setA_id(a_id);
		vo.setC_id(c_id);
		
		List<MemberVO> mvo = service.selectMember(vo);
		model.addAttribute("mvo", mvo);
		
		// 멤버 리스트 가져오기
		List<AccountDTO> lDto = service.memberList(vo);
		model.addAttribute("lDto", lDto);
		
		// 내가 모임장인지 여부
		String yN = service.imManager(vo);
		model.addAttribute("yN", yN);
		
		// 멤버 내정보 가져오기
		List<AccountDTO> aDto = service.memberA_id(vo);
		model.addAttribute("aDto", aDto);
		
		// 모임장 정보 가져오기
		List<AccountDTO> managerDto = service.manager(vo);
		model.addAttribute("manager", managerDto);	
		
		// 멤버수 조회
		int mCount = aService.countMember(c_id);
		session.setAttribute("mCount", mCount);
		System.out.println("member.GET동작");
		return "club/member";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(Model model, HttpSession session, HttpServletRequest request) {
		int c_id = (int) session.getAttribute("s_c_id");
		String url = request.getQueryString();
		int a_id = Integer.parseInt(url.substring(5));
		
		model.addAttribute("c_id", c_id);
		
		AccountDTO dto = new AccountDTO();
		dto.setA_id(a_id);
		AccountDTO aDto = aService.selectAccount(a_id);
		model.addAttribute("aDto", aDto);
		
		MemberVO vo = new MemberVO();
		vo.setA_id(a_id);
		vo.setC_id(c_id);
		
		// 멤버 정보 가져오기
		List<MemberVO> mvo = service.selectMember(vo);
		model.addAttribute("mvo", mvo);
		System.out.println("modify.GET동작");
		
		// 내가 모임장인지 여부
		String yN = service.imManager(vo);
		model.addAttribute("yN", yN);
		return "club/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(String delete, String s_a_id, Model model, HttpSession session, HttpServletRequest request) {
		int a_id = (int) session.getAttribute("s_a_id");
		int c_id = (int) session.getAttribute("s_c_id");
		int a_a_id = Integer.parseInt(s_a_id);	
		MemberVO vo = new MemberVO();
		ApplyVO avo = new ApplyVO();
		System.out.println("modify.POST동작");
		
		
		System.out.println("delete ->" + delete);
		if(delete == null) {
			//member 테이블에서 멤버 삭제
			vo.setA_id(a_a_id);
			vo.setC_id(c_id);
			service.memberDelete(vo);
			
			//ap 테이블에서 멤버 삭제
			avo.setA_id(a_a_id);
			avo.setC_id(c_id);
			service.applyDelete(vo);
			
			// 모임 탈퇴 여부 확인 클럽페이지로 이동
			avo = aService.applyState(c_id, a_id);
			session.setAttribute("ap", avo);
		} else {
			service.ccDelete(c_id);
			return "redirect:/";
		}
		if(avo == null) {
			return "redirect:/viewDetail?c_id=" + c_id;
		}
		return "redirect:/member";
	}
}
