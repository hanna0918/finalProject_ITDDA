package com.finalproject.itda.service;

import java.util.List;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.PagingVO;


public interface BoardService {
	public List<BoardVO> boardList(PagingVO pVo); 
	public PagingVO totalRecordCount(PagingVO pVo); //검색
	public int freeboardWrite(BoardVO vo); //글쓰기
	public BoardVO freeView(int board_seq); //글내용보기
	public int freeUpdate(BoardVO vo);//수정
	public int freeDelete(int board_seq, String m_userid);//삭제
	public List<Board_CommentVO> commentList(int board_seq); //댓글 리스트 
	
	
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
