package com.finalproject.itda.service;

import java.util.List;
import java.util.Map;

import com.finalproject.itda.vo.CalendarVO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingService {
	public List<MatchingVO> matchingList(MatchingPagingVO pVo);
	public MatchingPagingVO page(MatchingPagingVO pVo);
	public MatchingVO matchingView(int board_seq);
	public int countHit(int board_seq);
	public int matchingEdit(int board_seq, int m_seq);
	public List<CalendarVO> dataForJson();
	public int matchingWriteOk(MatchingVO vo);
	public int matchingDelete(int board_seq);
	public List<MatchingVO> matchingUser(int board_seq);
	public int matchingIn(int m_seq, int mc_seq);
}