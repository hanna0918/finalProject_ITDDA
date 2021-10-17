package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MemberService;
import com.finalproject.itda.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	// 로그인폼 삭제 예정!!!!(10-17)
	@RequestMapping("/login")
	public String login() {
		return "register/login";
	}

	// 로그인
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		MemberVO resultVO = memberService.login(vo);
		ModelAndView mav = new ModelAndView();

		if (resultVO == null) {// 로그인 실패
			mav.setViewName("redirect:login");
		} else {// 로그인 성공
			session.setAttribute("login", resultVO.getM_userid());
			session.setAttribute("logname", resultVO.getM_username());
			mav.setViewName("redirect:/");
		}
		return mav;
	}

	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession s) {
		s.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
//		logger.info("memberIdChk() 진입");
		int result = memberService.idCheck(memberId);
//		logger.debug("결과값 = " + result);
		if(result != 0) {
			return "fail";	// 중복 아이디가 존재
		} else {
			return "success";	// 중복 아이디 x
		}	
	} // memberIdChkPOST() 종료

	// 회원가입
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(MemberVO vo, Model model) {

		int result = memberService.join(vo);
		model.addAttribute("result", result);

		return "register/joinResult";

	}

}
