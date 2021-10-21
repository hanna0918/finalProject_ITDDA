package com.finalproject.itda.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MatchingDAO;
import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.CalendarVO;
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
	public MatchingVO matchingView(int board_seq) {
		return matchingDAO.matchingView(board_seq);
	}

	@Override
	public int countHit(int board_seq) {
		return matchingDAO.countHit(board_seq);
	}

	@Override
	public int matchingEdit(int board_seq, int m_seq) {
		return matchingDAO.matchingEdit(board_seq, m_seq);
	}

	@Override
	public List<CalendarVO> dataForJson() {
		return matchingDAO.dataForJson();
	}

	@Override
	public int matchingWriteOk(MatchingVO vo) {
		return matchingDAO.matchingWriteOk(vo);
	}

	@Override
	public int matchingDelete(int board_seq) {
		return matchingDAO.matchingDelete(board_seq);
	}

	@Override
	public List<MatchingVO> matchingUser(int board_seq) {
		return matchingDAO.matchingUser(board_seq);
	}

	@Override
	public int matchingIn(int m_seq, int mc_seq) {
		return matchingDAO.matchingIn(m_seq, mc_seq);
	}

	@Override
	public List<BoardCommentVO> matchingReply(int board_seq) {
		return matchingDAO.matchingReply(board_seq);
	}
}
