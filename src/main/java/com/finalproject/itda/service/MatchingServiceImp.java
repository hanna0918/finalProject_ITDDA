package com.finalproject.itda.service;

import java.util.List;

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
	public MatchingVO matchingEdit(int board_seq) {
		System.out.println("serviceImpµµ µé¾î¿È");
		return matchingDAO.matchingEdit(board_seq);
	}

	@Override
	public List<CalendarVO> dataForJson(MatchingPagingVO pVo) {
		return matchingDAO.dataForJson(pVo);
	}

	@Override
	public int matchingWriteOk(MatchingVO vo) {
		return matchingDAO.matchingWriteOk(vo);
	}

	@Override
	public List<MatchingVO> matchingUser(int board_seq) {
		return matchingDAO.matchingUser(board_seq);
	}

	@Override
	public List<BoardCommentVO> matchingReply(int board_seq) {
		return matchingDAO.matchingReply(board_seq);
	}

	@Override
	public MatchingVO matchingConfirm(int mc_seq, int m_seq) {
		return matchingDAO.matchingConfirm(mc_seq, m_seq);
	}
	
	@Override
	public int matchingIn(int m_seq, int mc_seq) {
		return matchingDAO.matchingIn(m_seq, mc_seq);
	}

	@Override
	public int matchingCancel(int mc_seq, int m_seq) {
		return matchingDAO.matchingCancel(m_seq, mc_seq);
	}

	@Override
	public int matchingReplyWrite(BoardCommentVO vo) {
		return matchingDAO.matchingReplyWrite(vo);
	}

	@Override
	public int matchingEditOk(MatchingVO vo) {
		matchingDAO.matchingEditOkMcTable(vo);
		matchingDAO.matchingEditOkBoardBase(vo);
		return matchingDAO.matchingEditOk(vo);
	}

	@Override
	public int matchingReplyEdit(BoardCommentVO vo) {
		return matchingDAO.matchingReplyEdit(vo);
	}

	@Override
	public int matchingReplyDelete(BoardCommentVO vo) {
		return matchingDAO.matchingReplyDelete(vo);
	}
	
	
}
