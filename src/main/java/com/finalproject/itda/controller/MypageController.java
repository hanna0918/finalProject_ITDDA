package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MypageService;

@Controller
public class MypageController {
	@Inject
	MypageService mypageService;
	
	@RequestMapping(value="/mypage")
	public String mypage() {
		return "mypage/mypage00Intro";
	}
	
	@RequestMapping(value="/mypagePostList")
	public String myPostList(Model model) {
		model.addAttribute("list", mypageService.mypagePostList());
		return "mypage/mypage01Post";
	}
	
	@RequestMapping(value="/mypageReplyList")
	public String mypageReplyList() {
		return "mypage/mypage02Reply";
	}
	
	@RequestMapping(value="/mypageMatching")
	public String mypageMatching() {
		return "mypage/mypage03Matching";
	}
	
	@RequestMapping(value="/mypageBookmark")
	public String mypageBookmark() {
		return "mypage/mypage04Bookmark";
	}
	
	@RequestMapping(value="/mypageSubscribe")
	public String mypageSubscribe() {
		return "mypage/mypage05Subscribe";
	}
	
	@RequestMapping(value="/mypageCutout")
	public String mypageCutout() {
		return "mypage/mypage06Cutout";
	}
	
	@RequestMapping(value="/mypageQnA")
	public String mypageQnA() {
		return "mypage/mypage07Question";
	}
	@RequestMapping(value="/mypageMsg")
	public String mypageMsg() {
		return "mypage/mypage08Message";
	}
}
