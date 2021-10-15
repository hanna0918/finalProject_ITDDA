package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MypageDAO;
import com.finalproject.itda.vo.BoardVO;

@Service
public class MypageServiceImp implements MypageService {
	@Inject
	MypageDAO mypageDao;
	
	@Override
	public List<BoardVO> mypagePostList() {
		return mypageDao.mypagePostList();
	}

}
