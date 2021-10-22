package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.InjeungDAO;
import com.finalproject.itda.vo.BoardVO;

@Service
public class InjeungServiceImp implements InjeungService{
	@Inject
	InjeungDAO injeungDao;
	
	
	@Override
	public List<BoardVO> injeungBoardList() {
		return injeungDao.injeungBoardList();
	}

}
