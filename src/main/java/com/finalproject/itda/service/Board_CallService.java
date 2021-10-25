package com.finalproject.itda.service;

import com.finalproject.itda.vo.Board_CallVO;

public interface Board_CallService {
	public int boardCall(Board_CallVO vo);
	public int boardCount(Board_CallVO vo);
	public int boardCallCheck(Board_CallVO vo);
	public int boardCallBack(Board_CallVO vo);
	public int goodHitCheck(Board_CallVO vo);
	public int goodHit(Board_CallVO vo);
	public int goodHitBack(Board_CallVO vo);
}
