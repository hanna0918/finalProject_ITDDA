package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.InjeungService;
import com.finalproject.itda.vo.BoardVO;

@Controller
public class InjeungController {
	@Inject
	InjeungService injeungService;
	
	//�씤利앷쾶�떆�뙋
	@RequestMapping(value="/injeungBoard")
	public String injeungBoard(Model model) {
		model.addAttribute("list", injeungService.injeungBoardList());
		return "injeung/injeungList";
	}
	//湲��벐湲고뤌
	@RequestMapping(value="/writeInjeung")
	public String writeInjeung() {
		return "injeung/injeungWrite";
	}
	
	
	@RequestMapping("/injeungWriteOk")
	public ModelAndView injeungWriteOk(BoardVO vo, HttpServletRequest req) {
ModelAndView mav = new ModelAndView();
		
		String contextPath = req.getSession().getServletContext().getRealPath("/img");
//    	System.out.println(contextPath);
    	String[] pathSplit = contextPath.split("\\\\");
    	for(int i=0; i < pathSplit.length; i ++) {
    		System.out.println("split "+ i +" 번째 = "+pathSplit[i]);
    	}
    	
    	String path =  pathSplit[0] + "/" + pathSplit[1] + "/itda/src/main/webapp/upload";
    	System.out.println(path);
		// 파일업로드를 위해서는 HttpServletRequest객체를 이용하여 MultipartHttpServletRequest객체를 구하여야 한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		// mr에서 MultipartFile객체를 얻어와야 한다.
		List<MultipartFile> files = mr.getFiles("input-file");
		// 업로드한 파일이 있으면
		List<String> fileList = new ArrayList<String>(); // 업로드된 파일명들을 저장할 곳
		System.out.println("recommendWriteOk 들어옴");
		if(files != null) {
			System.out.println("recommendWriteOk if 문 들어옴");
			// 업로드 구현
			System.out.println("files.size = " + files.size());
			for(int i=0; i<files.size(); i++) {
				// 업로드 할 MultipartFile 객체를 얻어온다.
				MultipartFile mf = files.get(i);
				// 원래 파일명
				String fname = mf.getOriginalFilename(); // ccc.jpg
				System.out.println("fname=" + fname);
				if(fname!=null && !fname.equals("")) {
					System.out.println("두번째 if문 들어옴");
					// 같은 파일명이 서버에 있는지 확인
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) { // 파일존재여부 확인 --> boolean
						System.out.println("세번째 if문 들어옴");
						for(int num=1; ;num++) {
							// 파일명 변경
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0, point);
							String orgFileExt = fname.substring(point+1);
							String newFileName = orgFileName + "(" + num + ")." + orgFileExt; // ex) ccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) {
								break;
							}
						} // for
					} // if
					// 업로드 실행
					System.out.println("업로드 실행?!");
					try {
						mf.transferTo(newFileObj);
					} catch (Exception e) {
						e.printStackTrace();
					}
					fileList.add(newFileObj.getName());
				} // for
			} // if
		}
		
		String[] image = vo.getB_content().split("<img");
		String[] imageSplit = image[1].split("style");
		String thumbnail = "<img" + imageSplit[0];
		vo.setThumbImg(thumbnail);
		
		int result = injeungService.injeungWriteOk(vo);
		if(result > 0) {
			System.out.println("들어온건가??????????????????");
			mav.setViewName("redirect:injeungBoard");
		} else {
			mav.setViewName("matching/result");
		}
		return mav;
	}
	
	//湲�蹂닿린
	@RequestMapping("/injeungView")
	public ModelAndView injeungView(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		int cnt = injeungService.countHit(vo.getBoard_seq());
		System.out.println(cnt);
		mav.addObject("vo", injeungService.injeungView(vo));
		mav.setViewName("injeung/injeungView");
		return mav;
	}
	
}
