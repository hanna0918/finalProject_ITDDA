package com.finalproject.itda.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.Board_CallVO;

public interface Board_CallDAO {
	@Select(" select count(call_seq) from board_call where board_seq=${board_seq} and m_seq=${m_seq} ")
	public int boardCallCheck(Board_CallVO vo);
	
	@Insert(" insert into board_call (call_seq, board_seq, m_seq, call_code) values(call_seq.nextval, ${board_seq}, ${m_seq}, ${call_code}) ")
	public int boardCall(Board_CallVO vo);
	
	@Update(" update boardbase set board_call=(select count(call_seq) from board_call where board_seq=${board_seq}) where board_seq=${board_seq} ")
	public int boardCount(Board_CallVO vo);
	
	@Delete(" delete from board_call where board_seq=${board_seq} and m_seq=${m_seq} ")
	public int boardCallBack(Board_CallVO vo);
	
	@Select(" select count(goodhit_seq) from b_goodhit where board_seq=${board_seq} and m_seq=${m_seq} ")
	public int goodHitCheck(Board_CallVO vo);
	
	@Insert(" insert into b_goodhit (b_goodhit, board_seq, m_seq) values (goodhit_seq.nextval, ${board_seq}, ${m_seq}) ")
	public int goodHit(Board_CallVO vo);
	
	@Delete(" delete from b_goodhit where board_seq=${board_seq} and m_seq=${m_seq} ")
	public int goodHitBack(Board_CallVO vo);
	
}
