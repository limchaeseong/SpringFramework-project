package com.web.home.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.web.home.board.model.BoardService;
import com.web.home.club.model.ClubVO;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite() {
		logger.info("method: GET, boardWrite(),페이지 요청");
		return "board/boardWrite";
	}
	
	//2번 동작 
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(HttpServletRequest request, HttpServletResponse response
			, MultipartFile upload, Model model, String name, String content, HttpSession session) {
		logger.info("method: POST, boardWrite(),페이지 요청");
//		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//		response.setHeader("Expires", "0"); // Proxies.
		String fileName = "";
		PrintWriter printWriter = null;
	    // 업로드한 파일 이름
		try {  
			if(upload != null) { //파일 업로드 시 실행
				System.out.println("fileName : " + upload.getOriginalFilename());
			    fileName = upload.getOriginalFilename();
			    session.setAttribute("fileName", fileName);
			      	
			        byte[] bytes = upload.getBytes();
			 
			        String uploadPath = request.getServletContext().getRealPath("/resources/boardFileUpload/");
			        OutputStream out = new FileOutputStream(new File(uploadPath + fileName));
			 
			        out.write(bytes);
			 
			        // 클라이언트에 결과 표시
			        String callback = request.getParameter("CKEditorFuncNum");
			            
					printWriter = response.getWriter();
			        String fileUrl = request.getContextPath() + "/boardFileUpload/" + fileName;
			        System.out.println("fileUrl : " + fileUrl);
			        printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + fileUrl
			                + "','이미지가 업로드되었습니다.')" + "</script>");
			        printWriter.flush();
			//글쓰기 시
			} else {
				fileName = (String) session.getAttribute("fileName"); 
				System.out.println("fileName" + fileName);
				Map<String, Object> map = new HashMap<String, Object>();
			    String b_name = name;
			    String b_content = content;
			    int a_id = (int)session.getAttribute("s_a_id");
			    ClubVO data = (ClubVO) session.getAttribute("club");
				System.out.println("data.getC_id() ->" + data.getC_id());
				
				map.put("b_name", b_name);
				map.put("b_content", b_content);
				map.put("a_id", a_id);
				map.put("c_id", data.getC_id());
				map.put("p_name", fileName);
				
				int res = service.boardWrite(map);	
				int b_id = (int)map.get("seq");
				
				if(!fileName.isEmpty()) {
					Map<String, Object> photoMap = new HashMap<String, Object>();
					System.out.println("b_id ->" + b_id);
					photoMap.put("p_name", fileName);
					photoMap.put("b_id", b_id);
					int res2 = service.photoAdd(photoMap);
				}
				
				model.addAttribute("name", b_name);
				model.addAttribute("content", b_content);
				printWriter = response.getWriter();
				printWriter.println("<script>opener.location.reload()</script>");
		        printWriter.flush();
			
				}
		 } catch (IOException e) {
		 }
		//샘플게시글보기
		return "board/okay";
		//게시글목록페이지로가야돼
		//return "commentView_cy/commentView";
	}

}
