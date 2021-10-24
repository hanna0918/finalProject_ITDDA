package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardVO;

public interface QuestionService {
	
	//QnAList
	public List<BoardVO> questionBoardList();
	
	//QnA 글보기
	public BoardVO boardView(int no);
	
	//QnA등록
	public int questionInsert(BoardVO vo);
}
