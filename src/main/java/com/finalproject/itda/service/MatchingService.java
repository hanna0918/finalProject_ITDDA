package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.CalendarVO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingService {
	public List<MatchingVO> matchingList(MatchingPagingVO pVo);
	public MatchingPagingVO page(MatchingPagingVO pVo);
	public MatchingVO matchingView(int board_seq);
	public int countHit(int board_seq);
	public MatchingVO matchingEdit(int board_seq);
	public List<CalendarVO> dataForJson();
	public int matchingWriteOk(MatchingVO vo);
	public List<MatchingVO> matchingUser(int board_seq);
	public int matchingIn(int m_seq, int mc_seq);
	public List<BoardCommentVO> matchingReply(int board_seq);
	public MatchingVO matchingConfirm(int mc_seq, int m_seq);
	public int matchingCancel(int mc_seq, int m_seq);
	public int matchingReplyWrite(BoardCommentVO vo);
}