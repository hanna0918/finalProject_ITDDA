package com.finalproject.itda.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.MemberbaseVO;
import com.finalproject.itda.vo.PagingVO;


public interface BoardService {
	public List<BoardVO> boardList(PagingVO pVo); //글목록 리스트 origin
	 public MemberbaseVO freeBoardmodal(MemberbaseVO mbVo); // 프로필 모달창 
	 public MemberbaseVO freeBoardmodalChadan(MemberbaseVO mbVo); //차단
	 public MemberbaseVO freeBoardmodalGudok(MemberbaseVO mbVo);  //구독
	 public MemberbaseVO freeBoardmodalNote(MemberbaseVO mbVo); //쪽지 
	 public MemberbaseVO freeBoardmodalNoteYes(MemberbaseVO mbVo); //쪽지 yes
	 
	/* public List<BoardVO> boardList(); */
	public PagingVO totalRecordCount(PagingVO pVo); //검색
	public int freeboardWrite(BoardVO vo); //글쓰기
	public BoardVO freeView(int board_seq); //글내용보기
	public int freeUpdate(BoardVO vo);//수정
	public int freeDelete(Map<String, Object> map);//삭제
	public List<Board_CommentVO> commentList(int board_seq); //댓글 리스트 
	public int commentInsert(Board_CommentVO commentVo); //댓글쓰기
	
	
//	
//	public void totalRecordCount(PagingVO pVo);
//	
//	public List<BoardVO> boardPageSelect(PagingVO pVo);
	/*
	 * public int freeboardWrite(BoardVO vo); public BoardVO boardView(int no);
	 * public int boardEdit(BoardVO vo);//글수정 public int boardDel(int no, String
	 * userid);
	 */
	
	//public BoardVO boardView(int no);
	//public int boardEdit(BoardVO vo);//글수정
	//public int boardDel(int no, String userid); 
}
