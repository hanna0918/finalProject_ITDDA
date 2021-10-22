package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.MatchingVO;
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
		mav.addObject("list", recommendService.recommendList(vo));
		
		mav.setViewName("/recommend/recommendList");
		return mav;
	}

	//추천게시판 글작성 view
	@RequestMapping(value="/recommendWrite")
	public String recommendWrite() {
		return "/recommend/recommendWrite";
	}
	
	//추천게시판 글작성 insert
	@RequestMapping(value="/recommendWriteOk", method = RequestMethod.POST)
	public ModelAndView recommendWriteOk(RecommendVO vo, HttpSession ses) {
		System.out.println("추천게시판 접속 1");
		vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
		int cnt = recommendService.recommendWriteOk(vo);
		System.out.println(cnt+"추천게시판 글들어갔다");
		
		ModelAndView mav = new ModelAndView();
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
		System.out.println(cnt+"__________________글보기가 안들어온다");
		mav.addObject("vo", recommendService.countHit(board_seq));
		mav.setViewName("recommend/recommendView");
		return mav;
		
	}
	
}
