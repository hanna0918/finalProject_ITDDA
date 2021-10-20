package com.finalproject.itda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InjeungController {
	
	@RequestMapping(value="/injeungBoard")
	public String injeungBoard() {
		return "injeung/injeungList";
	}
	
	@RequestMapping(value="/injeungView")
	public String injeungView() {
		return "injeung/injeungView";
	}
	
}
