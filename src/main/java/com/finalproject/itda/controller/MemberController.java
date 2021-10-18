package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MemberService;
import com.finalproject.itda.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;

	// 濡쒓렇�씤�뤌
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}

	@RequestMapping(value="/loginOk",method=RequestMethod.POST)
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		MemberVO resultVO = memberService.login(vo);
		ModelAndView mav = new ModelAndView();
		
		if (resultVO == null) {// 濡쒓렇�씤 �떎�뙣
			mav.setViewName("redirect:login");
		} else {// 濡쒓렇�씤 �꽦怨�
			
			session.setAttribute("lognick", resultVO.getM_nickname());
			session.setAttribute("logseq", resultVO.getM_seq());
			session.setAttribute("logid", resultVO.getM_userid());
			session.setAttribute("logname", resultVO.getM_username());
			mav.setViewName("redirect:/");
		}
		return mav;
	}

	// 濡쒓렇�븘�썐
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession s) {
		s.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	// �쉶�썝媛��엯
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public ModelAndView joinOk(MemberVO vo) {
		MemberVO resultVO = memberService.join(vo);
		ModelAndView mav = new ModelAndView();
		memberService.join(vo);
		
		if(resultVO == null) {
			mav.setViewName("redirect:login");
		}
		
		mav.setViewName("redirect:/");
		return mav;

	}
}
