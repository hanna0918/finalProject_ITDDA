package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.RecommendVO;

@Controller
public class RecommendController {
	@Inject
	RecommendService recommendService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	// 추천게시판
	@RequestMapping(value="/recommendList", method = RequestMethod.GET)
	public ModelAndView recommendList(RecommendVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", recommendService.recommendList(vo));
		System.out.println(vo.getBoard_seq());
		mav.setViewName("/recommend/recommendList");
		return mav;
	}
	
//	//멤버리스트 출력
//		@RequestMapping(value = "/MemberList")
//		public String AdminMember(Model model) {
//			//model.addAttribute("list", adminService.MemberList());
//			return "admin/MemberList";}
}
