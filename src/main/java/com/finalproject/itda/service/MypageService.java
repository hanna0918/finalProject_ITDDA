package com.finalproject.itda.service;

import java.util.List;


import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberVO;
import com.finalproject.itda.vo.QuestionVO;

public interface MypageService {
	/*
	 * //내정보수정 저장된 정보 가지고오기 public MemberVO editMyInfo(MemberVO vo);
	 */ 
	
	//마이페이지 내가쓴글 리스트
	public List<BoardVO> mypagePostList(MemberVO vo);
	
	//내가쓴댓글 뿌리고 시작
	public List<BoardCommentVO>mypageReplyList(MemberVO vo);
	
	//1:1문의 
	public int QuestionInsert(QuestionVO quesVo);
	
	//1:1문의 글뿌리면서 시작
	public List<QuestionVO> MypageQnA();
	
	
	
}
