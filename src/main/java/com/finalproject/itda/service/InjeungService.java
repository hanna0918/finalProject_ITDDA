package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardVO;

public interface InjeungService {

	public List<BoardVO> injeungBoardList();
	public BoardVO injeungView(BoardVO vo);
	public int countHit(int board_seq);
	public int injeungWriteOk(BoardVO vo);
}
