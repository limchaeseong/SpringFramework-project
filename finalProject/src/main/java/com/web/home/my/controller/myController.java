package com.web.home.my.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.web.home.my.model.commentVO;
import com.web.home.my.model.myVO;
import com.web.home.my.model.postVO;
import com.web.home.my.service.myService;
import com.web.home.utils.UploadFileUtils;

@Controller
public class myController {
	private static final Logger logger = LoggerFactory.getLogger(myController.class);
	
	@Autowired
	private myService service;
	
	@RequestMapping(value="/profile")
	public String profile(HttpSession session) {
		
		// s_a_id 에 값이 있다면 진행
		if(session.getAttribute("s_a_id") != null) {
			int a_id = (Integer) session.getAttribute("s_a_id");
			
			// account에서 받은 s_a_id로 회원정보 조회 후 "myInfo"로 session에 저장
			myVO vo = service.readMember(a_id);
			session.setAttribute("myInfo", vo);
			logger.info(" myInfo 저장! ->> " + vo);
			
			return "my/profile";	
			
		} else {
			// s_a_id 에 값이 없으면 로그인 페이지로 이동
			session.invalidate();
			return "account/login";
		}
	}
	
	@RequestMapping(value = "/myPhotoEdit", method= RequestMethod.POST)
	public String myPhotoEdit(HttpSession session, @RequestParam("a_photo") MultipartFile file,
			@SessionAttribute("myInfo") myVO vo, Model model) throws Exception {

		String fileName = null;
		System.out.println("========" + file);
		if(file.isEmpty()) {	
			// 이미지 클릭 시 파일이 없을 때
			fileName = "photoNoNo_B.png";
			logger.info(fileName);
			vo.setA_photo(fileName);
		} else {
			// 파일이 추가된 경우 경로 지정하기
			String uploadPath = session.getServletContext().getRealPath("/resources/img/my");
	
			// 파일 경로 만들기
			String ymdPath = UploadFileUtils.calcPath(uploadPath);
			fileName =  UploadFileUtils.fileUpload(uploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
				 vo.setA_photo(".." + File.separator + "resources" + File.separator + "img"+ File.separator +"my" + ymdPath + File.separator + fileName);
				 logger.info("===== 변경 전 파일명: " + vo.getA_photo() +", ===== 변경 후 파일명: " + fileName);
		}
		// 변경된 파일명 다시 저장
		int data = service.myInfoEdit(vo);
		session.setAttribute("myInfo", data);
			
		return "redirect:profile";
	}

	// 개인정보 변경관련 밑으로!
	
	@RequestMapping(value="/post")
	public String post(HttpSession session, HttpServletRequest request, Model model) {
		int a_id = (Integer) session.getAttribute("s_a_id");
		
		// account에서 받은 s_a_id로 내 게시글 조회 후 "myPost"로 session에 저장
		List<postVO> post = service.myPost(a_id);
		session.setAttribute("myPost", post);
		
		/* 좋아요 클릭시 추가 다시 클릭시 빼기(미구현)
		 * 좋아요를 클릭하면 
		 * b_id를 가져와서 service -> dao 넘겨 mapper 실행하여 갯수를 추가한다.
		 * 다시 좋아요를 클릭하면 되돌아간다.
		 * (mapper만 만들었다 ㅠㅠ)
		 */
		
		// 게시글 댓글 갯수 찾기(미구현)

		return "my/post";	
	}

	@RequestMapping(value="/comment")
	public String comment(HttpSession session, Model model) {
		int a_id = (Integer) session.getAttribute("s_a_id");
		logger.info("login User a_id:" + a_id);

		List<commentVO> comment = service.myComment(a_id);
		logger.info("DB에서 조회하여 CommentVO에 저장: " + comment);
		
		model.addAttribute("myComment", comment);
		return "my/comment";
	}
	
	 //로그아웃
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
			logger.info("logout 진행 : GET method");
		}
		return "account/login";
	}
	
	// 비밀번호 체크
	@RequestMapping(value="/profile.pwCheck", method = RequestMethod.POST)
	@ResponseBody
	public String pwCheck(@RequestParam(value="inputPw", required=false) String inputPw, HttpSession session) {
		int a_id = (Integer) session.getAttribute("s_a_id");
		String result = service.pwCheck(a_id);
		logger.info(inputPw + ", " + result);
		
		if(result.equals(inputPw)) {
			result="go";
		} else {
			result="no";
		}
		return result;
	}
	
	// 비밀번호 변경
	@RequestMapping(value="/profile.pwUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String pwUpdate
			(@RequestParam(value="re_pw") String re_pw, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		vo.setA_pw(re_pw);
		logger.info("변경 전 password: " + vo.getA_pw() +", 변경 후 password: " + re_pw);
		
		int data = service.pwUpdate(vo);
		// session.setAttribute("myInfo", data);
		// model.addAttribute("myInfo", data);

		return "" + data;
	}
	
	// 성별 변경
	@RequestMapping(value="/profile.genderUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String genderUpdate
			(@RequestParam(value="gender") char gender, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		logger.info("변경 전: " +vo.getA_gender() + ", 변경요청: " + gender);
		vo.setA_gender(gender);
		logger.info("vo에서 set으로 변경: " +vo.getA_gender());
		
		int data = service.genderUpdate(vo);
		session.setAttribute("myInfo", data);
		model.addAttribute("myInfo", data);

		return "profile";
	}
	
	// 생년월일 변경
	@RequestMapping(value="/profile.birthUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String birthUpdate
			(@RequestParam(value="bdate") String bdate, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		logger.info("변경 전: " + vo.getA_bdate() + ", 변경요청: " + bdate);
		vo.setA_bdate(bdate);
		logger.info("vo에서 set으로 변경: " + vo.getA_bdate());
		
		int data = service.birthUpdate(vo);
		session.setAttribute("myInfo", data);
		model.addAttribute("myInfo", data);

		return "profile";
	}
	
	// email 변경
	@RequestMapping(value="/profile.emailUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String emailUpdate
			(@RequestParam(value="email") String email, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		logger.info("변경 전: " + vo.getA_email() + ", 변경요청: " + email);
		vo.setA_email(email);
		logger.info("vo에서 set으로 변경: " + vo.getA_email());
		
		int data = service.emailUpdate(vo);
		session.setAttribute("myInfo", data);
		model.addAttribute("myInfo", data);

		return "profile";
	}
	
	// phone 변경
	@RequestMapping(value="/profile.phoneUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String phoneUpdate
			(@RequestParam(value="phone") String phone, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		logger.info("변경 전: " + vo.getA_phone() + ", 변경요청: " + phone);
		vo.setA_phone(phone);
		logger.info("vo에서 set으로 변경: " + vo.getA_phone());
		
		int data = service.phoneUpdate(vo);
		session.setAttribute("myInfo", data);
		model.addAttribute("myInfo", data);

		return "profile";
	}
	
	// ad 변경
	@RequestMapping(value="/profile.adUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String adUpdate
			(@RequestParam(value="ad") String ad, 
			 @SessionAttribute("myInfo") myVO vo, HttpSession session,Model model) {
		logger.info("vo 확인" + vo);
		logger.info("변경 전: " + vo.getA_ad() + ", 변경요청: " + ad);
		vo.setA_ad(ad);
		logger.info("vo에서 set으로 변경: " + vo.getA_ad());
		
		int data = service.adUpdate(vo);
		session.setAttribute("myInfo", data);
		model.addAttribute("myInfo", data);

		return "profile";
	}
	
	
	
	
}
