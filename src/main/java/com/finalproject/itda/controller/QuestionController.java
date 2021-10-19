package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalproject.itda.service.QuestionService;

@Controller
public class QuestionController {
	@Inject
	QuestionService questionService;
	
	@RequestMapping(value="/questionBoard")
	public String questionBoard(Model model) {
		model.addAttribute("list", questionService.questionBoardList());
		return "question/questionList";
	}
	
	@RequestMapping(value="/questionView")
	public String questionView() {
		return "question/questionView";
	}
}
