package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

public interface RecommendService {
	//추천게시판 리스트
	public List<RecommendVO> recommendList(RecommendPagingVO vo);
	
	//추천게시판 글쓰기
	public int recommendWriteOk(RecommendVO vo);
	
	//추천게시판 글보기
	public RecommendVO recommendView(int board_seq);
	
	//추천게시한 보기숫자 증가
	public int countHit(int board_seq);
	
	//추천게시판 글 수정
	public int recommendEdit(int board_seq, int m_seq);
	
	//추천게시판 글 삭제
	public int recommendDelete(int board_seq, int m_seq);
	
	//추천게시판 페이징 관련
	public RecommendPagingVO page(RecommendPagingVO pVo); 
	
	
}
