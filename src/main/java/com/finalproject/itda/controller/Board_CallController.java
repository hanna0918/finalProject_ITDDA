package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finalproject.itda.service.Board_CallService;
import com.finalproject.itda.vo.Board_CallVO;

@Controller
public class Board_CallController {
	@Inject
	Board_CallService board_CallService;
	
	// 신고한 게시글인지 확인
	@RequestMapping(value="/boardCallCheck")
	@ResponseBody
	public int boardCallCheck(Board_CallVO vo) {
		return board_CallService.boardCallCheck(vo);
	}
	
	// 신고하기
	@RequestMapping(value="/boardCall", method=RequestMethod.POST)
	@ResponseBody
	public int boardCall(Board_CallVO vo) {
		// 새로운 신고 갱신
		board_CallService.boardCall(vo);
		// 신고글 갱신하고 해당 게시글 총 신고수 세어 boardbase에 넣어주는 쿼리문
		return board_CallService.boardCount(vo);
	}
	
	// 신고 철회
	@RequestMapping(value="/boardCallBack", method=RequestMethod.POST)
	@ResponseBody
	public int boardCallBack(Board_CallVO vo) {
		return board_CallService.boardCallBack(vo);
	}
	
	// 좋아요했던 게시글인지 확인
	@RequestMapping("/goodHitCheck")
	@ResponseBody
	public int goodHitCheck(Board_CallVO vo) {
		return board_CallService.goodHitCheck(vo);
	}
	
	@RequestMapping("/goodHit")
	@ResponseBody
	public int goodHit(Board_CallVO vo) {
		return board_CallService.goodHit(vo);
	}
	
	@RequestMapping("/goodHitBack")
	@ResponseBody
	public int goodHitBack(Board_CallVO vo) {
		return board_CallService.goodHitBack(vo);
	}
	
	
	
	
	
	
	
	
	
	
}
