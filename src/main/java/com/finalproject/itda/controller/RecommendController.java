package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;
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
		mav.addObject("vo", recommendService.recommendView(board_seq));
		mav.setViewName("recommend/recommendView");
		return mav;
		
	}
	
}
