package com.finalproject.itda;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.InjeungService;
import com.finalproject.itda.service.MatchingService;
import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.RecommendPagingVO;

@Controller
public class HomeController {
	@Inject
	RecommendService recommendService;
	@Inject
	MatchingService matchingService;
	
	@Inject
	InjeungService injeungService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		MatchingPagingVO mpv = new MatchingPagingVO();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.addObject("list_RC", recommendService.recommendList(pVo));
		mav.addObject("list_MC", matchingService.matchingList(mpv));
		mav.addObject("list_ij", injeungService.injeungBoardList());
		mav.setViewName("/index");
		
		return mav;
	}

}
