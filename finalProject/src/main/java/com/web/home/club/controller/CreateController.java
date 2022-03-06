package com.web.home.club.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.home.account.model.AccountDTO;
import com.web.home.club.model.ApplyVO;
import com.web.home.club.model.ClubVO;
import com.web.home.club.service.ApplyService;
import com.web.home.club.service.ClubService;
import com.web.home.member.model.MemberVO;
import com.web.home.member.service.MemberService;
import com.web.home.utils.UploadFileUtils;


@Controller
public class CreateController {
	
	@Autowired
	private ClubService service;
	
	@Autowired
	private ApplyService Aservice;
	
	@Autowired
	private MemberService Mservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String choiceCategory(HttpServletRequest request) {
		return "club/category";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String clubCreate() {
		return "club/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String clubCreate(ClubVO vo, ApplyVO avo, AccountDTO dto, MultipartFile file, Model model, String src_info, HttpSession session, HttpServletRequest request)throws Exception {
		String imgUploadPath = session.getServletContext().getRealPath("/resources/imgUpload");
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		int a_id = (int) session.getAttribute("s_a_id");
		
		if(file.isEmpty()) {	
			// 이미지 클릭 시
			fileName = src_info;
			vo.setC_photo(fileName);
		} else {
				// 파일이 추가된 경우
				fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
				 vo.setC_photo(".." + File.separator + "resources" + File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		}
		// 로그인 정보 조회
		dto = Aservice.selectAccount(a_id);
		session.setAttribute("avo", dto);
		
		// 모임 생성
		int sq = service.create(vo);
		avo.setC_id(sq);
		avo.setA_id(a_id);

		// 만든 모임 페이지 정보
		int sql = vo.getSq();
		ClubVO data = service.selectView(sql);
		
		// 모임 생성 시 member 테이블 생성
		MemberVO mvo = new MemberVO();
		mvo.setC_id(data.getC_id());
		mvo.setA_id(a_id);
		Mservice.memberManager(mvo);
		
		if(sq != -1) {
			if(data != null) {
				session.setAttribute("club", data);
				avo.setC_id(data.getC_id());
				// 모임장 가입 권한 부여
				Aservice.createApply(avo);
				if(a_id != -1) {
					// a_id, c_id 비교해서 모임 가입 여부 확인
					ApplyVO resultVO = Aservice.applyState(data.getC_id(), a_id);
					session.setAttribute("ap", resultVO);
					// 멤버수 조회
					int mCount = Aservice.countMember(a_id);
					session.setAttribute("mCount", mCount);
					return "redirect:/viewDetail?c_id=" + data.getC_id();
				}
			}
		}
		return "redirect:/viewDetail?c_id=" + data.getC_id();
	}

}
