package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.itda.service.InjeungService;

@Controller
public class InjeungController {
	@Inject
	InjeungService injeungService;
	
	//인증게시판
	@RequestMapping(value="/injeungBoard")
	public String injeungBoard(Model model) {
		model.addAttribute("list", injeungService.injeungBoardList());
		return "injeung/injeungList";
	}
	//글쓰기폼
	@RequestMapping(value="/writeInjeung")
	public String writeInjeung() {
		return "injeung/injeungWrite";
	}
	
	//글보기
	@RequestMapping(value="/injeungView")
	public String injeungView() {
		return "injeung/injeungView";
	}
	
}
