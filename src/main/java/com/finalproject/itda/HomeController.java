package com.finalproject.itda;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

@Controller
public class HomeController {
	@Inject
	RecommendService recommendService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.addObject("pVo", recommendService.page(pVo));
		mav.addObject("list", recommendService.recommendList(pVo));
		mav.setViewName("/index");
		return mav;
	}
	

	
}
