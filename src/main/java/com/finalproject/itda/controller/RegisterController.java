package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RegisterService;
import com.finalproject.itda.vo.RegisterVO;

@Controller
public class RegisterController {
	@Inject
	RegisterService registerService;
	//로그인폼
	@RequestMapping("/login")
	public String login() {
		return "register/login"; 
	}
	//로그인
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
	public ModelAndView loginOk(RegisterVO vo, HttpSession session) {
		RegisterVO resultVO = registerService.login(vo);
		ModelAndView mav = new ModelAndView();

		if(resultVO==null) {//로그인 실패
			mav.setViewName("redirect:login");
		}else {//로그인 성공
			session.setAttribute("login", resultVO.getUserid());
			session.setAttribute("logname", resultVO.getUsername());
			mav.setViewName("redirect:/");
		}
		
		
		
		return mav;
	}
	//로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession s) {
		s.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
}
