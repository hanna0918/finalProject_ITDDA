package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.InjeungService;
import com.finalproject.itda.vo.BoardVO;

@Controller
public class InjeungController {
	@Inject
	InjeungService injeungService;
	
	//�씤利앷쾶�떆�뙋
	@RequestMapping(value="/injeungBoard")
	public String injeungBoard(Model model) {
		model.addAttribute("list", injeungService.injeungBoardList());
		return "injeung/injeungList";
	}
	//湲��벐湲고뤌
	@RequestMapping(value="/writeInjeung")
	public String writeInjeung() {
		return "injeung/injeungWrite";
	}
	
	//湲�蹂닿린
	@RequestMapping(value="/injeungView")
	public ModelAndView injeungView(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", injeungService.injeungView(vo));
		mav.setViewName("injeung/injeungView");
		return mav;
	}
	
}
