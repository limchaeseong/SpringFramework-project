package com.web.home.club.metting.controller;

import java.io.File;
import java.util.List;

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
import com.web.home.club.metting.model.*;
import com.web.home.club.model.ApplyVO;
import com.web.home.club.model.CategoryVO;
import com.web.home.club.model.ClubVO;
import com.web.home.club.service.ApplyService;
import com.web.home.club.service.ClubService;
import com.web.home.utils.UploadFileUtils;

@Controller
public class MettingController {
	
	@Resource(name="MettingImgPath")
	private String uploadPath;
	
	@Autowired
	private MettingService service;
	
	@Autowired
	private ClubService Cservice;
	
	@Autowired
	private ApplyService Aservice;
	
	@RequestMapping(value="/calendar", method = RequestMethod.GET)
	public String calendar(Model model,HttpSession session) {
		int c_id=(int) session.getAttribute("s_c_id");
		List<MettingDTO> datas = service.MettingList(c_id);
		for(MettingDTO dto2 : datas) {
			dto2.setA_people(service.applyMember(dto2.getMT_ID()));
		}
		System.out.println(datas.size());
		model.addAttribute("MettingList",datas);
		return "club/metting/calendar";
	}
	
	@RequestMapping(value="/schedule", method = RequestMethod.GET)
	public String schedule(Model model,HttpSession session) {

		int c_id=(int) session.getAttribute("s_c_id");
		System.out.println(c_id);
		model.addAttribute("c_id", c_id);
		return "club/metting/schedule";
	}
	
	@RequestMapping(value="/metting", method= RequestMethod.GET)
	public String meeting() {
		return "club/metting/blank";
	}
	
	@RequestMapping(value="/metting", method= RequestMethod.POST)
	public String mettingCreate(MettingVO vo,String s_date,MultipartFile img,Model model,HttpSession session2,HttpServletRequest request) throws Exception{
		
		System.out.println(vo);
		
		MettingDTO dto = new MettingDTO(vo);
		
		String fileName = null;
		if(img.isEmpty()) {
			fileName="basic.png";
			dto.setMT_PHOTO("resources/img/metting/"+fileName);
		} else {
			String imgUploadPath = session2.getServletContext().getRealPath("/resources/img/metting");
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			fileName = UploadFileUtils.fileUpload(imgUploadPath, img.getOriginalFilename(), img.getBytes(), ymdPath);
			System.out.println(fileName);
			dto.setMT_PHOTO("resources/img/metting/"+ymdPath+"/"+fileName);
		}

		HttpSession session = request.getSession();	
		System.out.println(dto);
		int res = service.create(dto);
		if(session.getAttribute("s_a_id")!=null) {
			int a_id = (int)session.getAttribute("s_a_id");
			int res2 = service.applyMM_master(a_id,vo.getC_id());
			System.out.println("일정 신청 :"+res2);
		}
		System.out.println("업로드 파일:"+res);
		System.out.println(service.MettingAllList().size());
		List<MettingDTO> datas = service.MettingList(vo.getC_id());
		System.out.println(datas.size());
		return "club/metting/blank";
	}
	
	@RequestMapping(value="/mettingList",method=RequestMethod.GET)
	public String mettingList(Model model){
		List<MettingDTO> datas = service.MettingAllList();
		for(MettingDTO dto : datas) {
			dto.setA_people(service.applyMember(dto.getMT_ID()));
		}
		System.out.println(datas);
		
		model.addAttribute("MettingList",datas);
		return "club/metting/MettingList";
	}
	
	@RequestMapping(value="/viewMetting",method=RequestMethod.GET)
	public String viewMetting(Model model,int c_id,HttpSession session){
		//int c_id2=(int) session.getAttribute("s_c_id");
		int a_id = (int) session.getAttribute("s_a_id");
		List<MettingDTO> datas = service.MettingList(c_id);
		for(MettingDTO dto2 : datas) {
			dto2.setA_people(service.applyMember(dto2.getMT_ID()));
		}
		System.out.println(datas.size());
		model.addAttribute("MettingList",datas);
		
		ClubVO cvo = Cservice.viewClub(c_id);
		model.addAttribute("club", cvo);
		
		int mCount = Aservice.countMember(c_id);
		model.addAttribute("mCount", mCount);
		
		ApplyVO data = Aservice.selectA_id(c_id);	
		int clubManager = data.getA_id();
		AccountDTO dto = Aservice.selectAccount(clubManager);
		model.addAttribute("avo", dto.getA_name());
		
		CategoryVO cgName = Cservice.selectCgName(c_id);
		model.addAttribute("cgName", cgName.getCg_name());
		System.out.println("cgName : " + cgName);
		
		ApplyVO resultVO = Aservice.applyState(c_id, a_id);
		if(resultVO.getAp_state()=='Y') {
			model.addAttribute("ap", true);
		} else {
			model.addAttribute("ap", false);
		}
		
			
		System.out.println(model);
		return "club/metting/viewMeeting";
	}
	
	
	
	@RequestMapping(value="/m_detail",method=RequestMethod.GET)
	public String mettingDetail1(String m_no) {
		return "club/metting/MettingList";
	}
	
	@RequestMapping(value="/m_detail",method=RequestMethod.POST)
	public String mettingDetail(String m_no,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("s_a_id")==null) {
			return "redirect:login";
		} else {
			System.out.println(m_no);
			int a_id = (int)session.getAttribute("s_a_id");
			List<MettingApplyVo> datas = service.applyCheck(a_id,m_no);
			System.out.println("datas: "+  datas);
			if(datas.size()==1) {
				model.addAttribute("applyCheck",true);
				String a = datas.get(0).getMM_MASTER();
				System.out.println(a);
				if(a.contains("Y")) {
					model.addAttribute("masterCheck",true);
				} else if(a.contains("N")) {
					model.addAttribute("masterCheck",false);
				}
			}			
		}
		MettingDTO dto = service.Metting(Integer.parseInt(m_no));
		dto.setA_people(service.applyMember(dto.getMT_ID()));
		System.out.println(dto);
		model.addAttribute("meeting",dto);
		System.out.println(model);
		return "club/metting/MettingDetail";
	}
	
	@RequestMapping(value={"/mt_apply","/mt_cancle","/mt_modify"},method=RequestMethod.GET)
	public String mt_aaply(String mt_id) {
		System.out.println("get");
		return "redirect:/mettingList";
	}
	
	@RequestMapping(value="/mt_apply",method=RequestMethod.POST)
	public String p_mt_aaply(String mt_id,HttpServletRequest request) {
		System.out.println(mt_id);
		HttpSession session = request.getSession();
		if(session.getAttribute("s_a_id")==null) {
			return "redirect:/login";
		}
		int a_id = (int)session.getAttribute("s_a_id");
		int res = service.applyMetting2(a_id, Integer.parseInt(mt_id));
		if(res==1) {
			System.out.println("데이터 삽입 성공");
		}
		return "club/metting/blank";
	}
	
	@RequestMapping(value="/mt_cancle",method=RequestMethod.POST)
	public String p_mt_cancle(String mt_id,HttpServletRequest request) {
		System.out.println(mt_id);
		HttpSession session = request.getSession();
		if(session.getAttribute("s_a_id")==null) {
			return "redirect:/login";
		}
		int a_id = (int)session.getAttribute("s_a_id");
		int res = service.cancleMetting2(a_id, Integer.parseInt(mt_id));
		System.out.println("res : "+res);
		if(res==1) {
			return "club/metting/blank";
		}
		return null;
	}
	
	@RequestMapping(value="/blank",method=RequestMethod.GET)
	public String blank() {
		return "club/metting/blank";
	}
	
}
