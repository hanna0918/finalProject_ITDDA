package com.finalproject.itda.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.Board_CallDAO;
import com.finalproject.itda.vo.Board_CallVO;

@Service
public class Board_CallServiceImp implements Board_CallService {
	@Inject
	Board_CallDAO board_CallDAO;
	
	@Override
	public int boardCall(Board_CallVO vo) {
		return board_CallDAO.boardCall(vo);
	}
	@Override
	public int boardCount(Board_CallVO vo) {
		return board_CallDAO.boardCount(vo);
	}
	@Override
	public int boardCallBack(Board_CallVO vo) {
		return board_CallDAO.boardCallBack(vo);
	}
	@Override
	public int boardCallCheck(Board_CallVO vo) {
		return board_CallDAO.boardCallCheck(vo);
	}
	
}
