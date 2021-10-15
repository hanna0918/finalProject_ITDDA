package com.finalproject.itda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {
	
	@RequestMapping(value="/questionBoard")
	public String questionBoard() {
		return "question/questionList";
	}
	
	@RequestMapping(value="/questionView")
	public String questionView() {
		return "question/questionView";
	}
}
