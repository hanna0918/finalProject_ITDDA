package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MemberService;

@Controller
public class RecommendController {
	@Inject
	MemberService memberService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	// 추천게시판
	@RequestMapping("/recommendList")
	public ModelAndView recommendList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/recommend/recommendList");
		return mav;
	}
}
