package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

@Controller
public class RecommendController {
	@Inject
	RecommendService recommendService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	// 추천게시판 리스트
	@RequestMapping(value="/recommendList", method = RequestMethod.GET)
	public ModelAndView recommendList(RecommendVO vo) {
		ModelAndView mav = new ModelAndView();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.addObject("pVo", recommendService.page(pVo));
		mav.addObject("list", recommendService.recommendList(pVo));
		mav.setViewName("/recommend/recommendList");
		return mav;
	}
	
	@RequestMapping(value="/recommendListTagSearch", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tagSearch(RecommendPagingVO pVo){
		Map<String, Object> map = new HashMap<String, Object>();
		RecommendPagingVO ppVo = recommendService.page(pVo);
		ppVo.setNowPage(pVo.getNowPage());
		map.put("pVo", ppVo);
		map.put("vo", recommendService.recommendList(pVo));
		return map;
	}

	//추천게시판 글작성 view
	@RequestMapping(value="/recommendWrite")
	public String recommendWrite() {
		return "/recommend/recommendWrite";
	}
	
	//추천게시판 글작성 insert
	@RequestMapping(value="/recommendWriteOk", method = RequestMethod.POST)
	public ModelAndView recommendWriteOk(RecommendVO vo, HttpSession ses, HttpServletRequest req) {
		System.out.println("추천게시판 접속 1");
		vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
		int cnt = recommendService.recommendWriteOk(vo);
		System.out.println(cnt+"추천게시판 글들어갔다");
		
		ModelAndView mav = new ModelAndView();

		
		//파일 업로드**************************************************************************************
		
		//업로드 위치
		String path = req.getSession().getServletContext().getRealPath("/upload");
		System.out.println(path);
		//파일업로드를 위해서는 HttpServletRequest 객체를 이용하여 MultipartHttpServletRequest객체를 구하여야한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		
		//mr에서 MutipartFile객체를 얻어와야된다.
		List<MultipartFile> files= mr.getFiles("i_url");
		//업로드된 파일명들을 저장할 곳
		List<String> fileList = new ArrayList<String>();
		//업로드한 파일이 있으면
		if(files!=null) {//DDDDD
			//업로드 구현
			for(int i=0; i<files.size(); i++) {// CCCCC
				//업로드 할 MultipartFile객체를 얻어오기
				MultipartFile mf = files.get(i);
				//원래 파일명
				String fname = mf.getOriginalFilename();
				System.out.println(fname);
				if (fname!=null && !fname.equals("")) {//~~~~~~~~~~~~~~~~~~~~~
					//같은파일명이 서버에 있는지 확인
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) {	//파일존재여부 확인 있으면 true, 없으면 false	BBBB

						for(int num=1; ; num++) {//숫자가 없을떄 까지
							//파일명 변경
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0,point);//파일명
							String orgFileExt = fname.substring(point+1);//확장자
							String newFileName = orgFileName+"("+num+")."+orgFileExt;//ccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) {
								break;
							}
						}
					
					}//if BBBBB
					try {
						//업로드 실행
						mf.transferTo(newFileObj);
						System.out.println("업로드완료");
					}catch(Exception e) {
						e.printStackTrace();
					}
						
					fileList.add(newFileObj.getName());
				}//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			}//for CCCCC
		}//if 	DDDDD
		vo.setFileList(fileList);
		mav.addObject("vo", vo);
		
		if(cnt>0) {
			mav.setViewName("redirect:recommendList");
		}else {
			mav.setViewName("redirect:recommendWrite");
		}
		return mav;
	}
	
	// 글보기
	@RequestMapping(value="recommendView")
	public ModelAndView recommentView(int board_seq) {
		ModelAndView mav = new ModelAndView();
		int cnt = recommendService.countHit(board_seq);
		mav.addObject("vo", recommendService.recommendView(board_seq));
		mav.setViewName("recommend/recommendView");
		return mav;
	}
	
	
	
}
