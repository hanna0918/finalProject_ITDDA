package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.BoardVO;

public interface MypageDAO {
	@Select("select board_seq, m_seq, board_code, board_subject, to_char(board_writedate, 'YYYY-MM-DD') board_writedate, "
			+ " board_hit,b_goodhit from board123")
	public List<BoardVO> mypagePostList();
}
