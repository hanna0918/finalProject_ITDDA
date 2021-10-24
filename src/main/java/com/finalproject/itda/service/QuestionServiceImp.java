package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.QuestionDAO;
import com.finalproject.itda.vo.BoardVO;

@Service
public class QuestionServiceImp implements QuestionService {
	@Inject
	QuestionDAO questionDAO;

	@Override
	public List<BoardVO> questionBoardList() {
		return questionDAO.questionBoardList();
	}

	@Override
	public int questionInsert(BoardVO vo) {
		return questionDAO.questionInsert(vo);
	}

	@Override
	public BoardVO boardView(int no) {
		return questionDAO.boardView(no);
	}

	
	
	
}
