package com.finalproject.itda.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.BoardVO;

public interface InjeungDAO {
		
		@Select("select distinct b.board_seq, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD') board_writedate, b.board_hit, m.m_nickname, "
				+ "(select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count "
				+ "from boardbase b join memberbase m on b.m_seq=m.m_seq "
				+ "join board_comment bc on b.m_seq=bc.m_seq where b.board_code=3 order by board_writedate desc")
		public List<BoardVO> injeungBoardList();
}
