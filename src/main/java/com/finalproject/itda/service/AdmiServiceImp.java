package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.AdminDAO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;

@Service
public class AdmiServiceImp implements AdminService {

	@Inject
	AdminDAO adminDAO;

	@Override // 관리자 추가하기
	public int MemberInsert(MemberBaseVO vo) {
		return adminDAO.MemberInsert(vo);
	}

	@Override // 멤버리스트
	public List<MemberBaseVO> MemberList() {
		return adminDAO.MemberList();
	}

	@Override // 어드민 멤버리스트
	public List<MemberBaseVO> AMemberList() {
		return adminDAO.AMemberList();
	}

	@Override // 멤버리스트 모달
	public MemberBaseVO MemberView(MemberBaseVO vo) {
		return adminDAO.MemberView(vo);
	}

	@Override // 멤버리스트 모달 업데이트
	public int MemberUpdate(MemberBaseVO vo) {
		return adminDAO.MemberUpdate(vo);
	}

	@Override // 신고 게시판 리스트
	public List<BoardVO> BoardcallList() {
		return adminDAO.BoardcallList();
	}

	@Override // 신고 게시판 리스트 모달
	public BoardVO CallBoardView(BoardVO vo) {
		return adminDAO.CallBoardView(vo);
	}

	@Override // 신고 게시판 리스트 모달 업데이트
	public int CallBoardUpdate(BoardVO vo) {
		return adminDAO.CallBoardUpdate(vo);
	}

	@Override // 모든 게시판 보기
	public List<BoardVO> AllboardList() {
		return adminDAO.AllboardList();
	}

	@Override // 블럭게시판 보기
	public List<BoardVO> BlackBoardList() {
		return adminDAO.BlackBoardList();
	}

	@Override //블럭 게시판 상태보기
	public BoardVO BlackBoardstateView(BoardVO vo) {
		return adminDAO.BlackBoardstateView(vo);
	}

	
	@Override // 블럭 게시판 리스트 모달 업데이트
	public int BlockBoardUpdate(BoardVO vo) {
		return adminDAO.BlockBoardUpdate(vo);
	}

	@Override
	public List<QuestionVO> QuestionList() {
		return adminDAO.QuestionList();
	}
	
	public QuestionVO QusetionWaitModallist(QuestionVO vo)
	{
		return adminDAO.QusetionWaitModallist(vo);
	}

	@Override
	public int QusetionupdateModal(QuestionVO vo) {
		return adminDAO.QusetionupdateModal(vo);
	}

	@Override
	public List<QuestionVO> QuestionResultList() {
		return adminDAO.QuestionResultList();
	}
	
	
}
