package com.finalproject.itda.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.vo.BoardVO;

public interface InjeungService {

	public List<BoardVO> injeungBoardList();
	public ModelAndView injeungView(BoardVO vo);
}
