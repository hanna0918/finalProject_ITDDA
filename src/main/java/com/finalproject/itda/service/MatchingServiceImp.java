package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MatchingDAO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

@Service
public class MatchingServiceImp implements MatchingService {
	@Inject
	MatchingDAO matchingDAO;

	@Override
	public List<MatchingVO> matchingList(MatchingPagingVO pVo) {
		return matchingDAO.matchingList(pVo);
	}

	@Override
	public MatchingPagingVO page(MatchingPagingVO pVo) {
		return matchingDAO.page(pVo);
	}

	@Override
	public MatchingVO matchingView(int b_id) {
		return matchingDAO.matchingView(b_id);
	}

	@Override
	public int countHit(int b_id) {
		return matchingDAO.countHit(b_id);
	}
}
