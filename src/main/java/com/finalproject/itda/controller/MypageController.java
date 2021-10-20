package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.finalproject.itda.service.MypageService;
import com.finalproject.itda.vo.MemberVO;
import com.finalproject.itda.vo.QuestionVO;

@Controller
public class MypageController {
	@Inject
	MypageService mypageService;
	
	@RequestMapping(value="/mypage")
	public String mypage() {
		return "mypage/mypage00Intro";
	}
	
	@RequestMapping(value="/editMyInfo", method=RequestMethod.POST)
	@ResponseBody 
	public ModelAndView editMyInfo(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	//내가 쓴 글--------------------------------------------------------------------------------------
	@RequestMapping(value="/mypagePostList")
	public String myPostList(Model model) {
		model.addAttribute("list", mypageService.mypagePostList());
		return "mypage/mypage01Post";
	}
	//내가 쓴 댓글--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageReplyList")
	public String mypageReplyList(Model model) {
		model.addAttribute("replyList", mypageService.myReplyList());
		return "mypage/mypage02Reply";
	}
	//매칭--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageMatching")
	public String mypageMatching() {
		return "mypage/mypage03Matching";
	}
	//북마크--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageBookmark")
	public String mypageBookmark() {
		return "mypage/mypage04Bookmark";
	}
	//구독--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageSubscribe")
	public String mypageSubscribe() {
		return "mypage/mypage05Subscribe";
	}
	//차단--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageCutout")
	public String mypageCutout() {
		return "mypage/mypage06Cutout";
	}
	//1:1문의--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageQnA")
	public String mypageQnA(Model model) {
		model.addAttribute("list",mypageService.MypageQnA());
		System.out.println("test중입니다");	
		return "mypage/mypage07Question";
	}
	
	
	//1:1문의 글등록
	@RequestMapping(value="/askSomething", method=RequestMethod.POST)
	public ModelAndView AskSomething(QuestionVO quesVo) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = mypageService.QuestionInsert(quesVo);
		if(cnt>0) {//글등록함!!!
			mav.setViewName("redirect:mypageQnA");
		}else {//글왜등록안됐담.... ㅠㅠ
			mav.setViewName("redirect:mypage");
		}
		return mav;
	}
	
	//쪽지함--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageMsg")
	public String mypageMsg() {
		return "mypage/mypage08Message";
	}
}
