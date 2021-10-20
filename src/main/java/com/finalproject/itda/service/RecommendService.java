package com.finalproject.itda.service;

import java.util.List;



import com.finalproject.itda.vo.RecommendVO;

public interface RecommendService {
	//추천게시판 리스트
	public List<RecommendVO> recommendList(RecommendVO vo);
}
