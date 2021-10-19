package com.finalproject.itda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChucheonController {
	
	@RequestMapping(value="/chucheonBoard")
	public String chuchenBoard() {
		return "chucheon/chucheonList";
	}
}
