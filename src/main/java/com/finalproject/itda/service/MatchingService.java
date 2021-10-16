package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingService {
	public List<MatchingVO> matchingList(MatchingPagingVO pVo);
	public MatchingPagingVO page(MatchingPagingVO pVo);
	public MatchingVO matchingView(int b_id);
	public int countHit(int b_id);
}