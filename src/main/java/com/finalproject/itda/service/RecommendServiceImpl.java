package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.RecommendDAO;
import com.finalproject.itda.vo.RecommendVO;
@Service
public class RecommendServiceImpl implements RecommendService {
	@Inject
	RecommendDAO recommendDAO;
	
	@Override
	public List<RecommendVO> recommendList(RecommendVO vo) {//추천게시판 리스트
		return recommendDAO.RecommendList(vo);
	}

}
