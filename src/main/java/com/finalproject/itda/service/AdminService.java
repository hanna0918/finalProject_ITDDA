package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;

public interface AdminService {

	//관리자 추가하기
	public int MemberInsert(MemberBaseVO vo);
	
	//멤버리스트
	public List<MemberBaseVO> MemberList();
	
	//어드민 멤버리스트
	public List<MemberBaseVO> AMemberList();
	
	//멤버리스트 모달
	public MemberBaseVO MemberView(MemberBaseVO vo);
	
	//멤버리스트 모달 업데이트
	public int MemberUpdate(MemberBaseVO vo);	

	
	// 신고 게시판 리스트
	public List<BoardVO> BoardcallList();
	
	// 신고 게시판 리스트 모달
	public BoardVO CallBoardView(BoardVO vo);
	
	// 신고 게시판 리스트 모달 업데이트
	public int CallBoardUpdate(BoardVO vo);
	
	// 모든 게시판 보기
	public List<BoardVO> AllboardList();
	
	//모든 게시판 리스트 모달
	public BoardVO Allboardmodal(BoardVO vo);
	
	
	//블럭게시판 보기
	public List<BoardVO> BlackBoardList();
	
	//블럭게시판 모델 사유 보기
	public BoardVO BlackBoardstateView(BoardVO vo);
		
	// 블럭 게시판 리스트 모달 업데이트
	public int BlockBoardUpdate(BoardVO vo);
	
	//Q & A 리스트 보기
	public List<QuestionVO> QuestionList();
	
	//Q & A Wait 모달보기 보기
	public QuestionVO QusetionWaitModallist(QuestionVO vo);

	//Q & A Wait 모달 업데이트
	public int QusetionupdateModal(QuestionVO vo);	
	
	//Q & A  result 리스트 보기
	public List<QuestionVO> QuestionResultList();

}
