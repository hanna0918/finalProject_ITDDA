package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.RecommendDAO;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;
@Service
public class RecommendServiceImpl implements RecommendService {
	@Inject
	RecommendDAO recommendDAO;
	
	@Override
	public List<RecommendVO> recommendList(RecommendPagingVO pVo) {//추천게시판 리스트
		return recommendDAO.recommendList(pVo);
	}

	@Override
	public int recommendWriteOk(RecommendVO vo) {
		return recommendDAO.recommendWriteOk(vo);
	}

	@Override
	public RecommendVO recommendView(int board_seq) {
		return recommendDAO.recommendView(0);
	}

	@Override
	public int countHit(int board_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recommendEdit(int board_seq, int m_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recommendDelete(int board_seq, int m_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecommendPagingVO page(RecommendPagingVO pVo) {
		return recommendDAO.page(pVo);
	}

	

}
