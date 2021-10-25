package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.Map;

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
		board_CallService.boardCallBack(vo);
		return board_CallService.boardCount(vo);
	}
	
	// 좋아요했던 게시글인지 확인
	@RequestMapping("/goodHitCheck")
	@ResponseBody
	public Map<String, Board_CallVO> goodHitCheck(Board_CallVO vo) {
		Map<String,Board_CallVO> map = new HashMap<String,Board_CallVO>();
		map.put("vo", board_CallService.reprint(vo));
		vo.setB_goodhit(board_CallService.goodHitCheck(vo));
		map.put("check", vo);
		return map;
	}
	
	// 좋아요 하기
	@RequestMapping("/goodHit")
	@ResponseBody
	public Board_CallVO goodHit(Board_CallVO vo) {
		board_CallService.goodHit(vo);
		board_CallService.goodHitCount(vo);
		return board_CallService.reprint(vo);
	}
	
	// 좋아요 철회
	@RequestMapping("/goodHitBack")
	@ResponseBody
	public Board_CallVO goodHitBack(Board_CallVO vo) {
		board_CallService.goodHitBack(vo);
		board_CallService.goodHitCount(vo);
		return board_CallService.reprint(vo);
	}
	
	
	
	
	
	
	
	
	
	
}
