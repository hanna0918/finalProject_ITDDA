package com.finalproject.itda.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.vo.BoardVO;

public interface InjeungDAO {
		
		@Select("select distinct b.board_seq, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD') board_writedate, b.board_hit, m.m_nickname, "
				+ "(select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count "
				+ "from boardbase b join memberbase m on b.m_seq=m.m_seq "
				+ "join board_comment bc on b.m_seq=bc.m_seq where b.board_code=3 order by board_writedate desc")
		public List<BoardVO> injeungBoardList();
		
		@Select(" select * from "
				+ " (select board_subject, b_content, to_char(board_writedate,'YYYY-MM-DD') board_writedate, m_nickname, board_select, b_goodhit, board_call, "
				+ " (select count(board_seq) from board_comment e where a.board_seq=e.board_seq) replyCount, "
				+ " lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, "
				+ " lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject, "
				+ " lag(board_select, 1) over(order by a.board_seq) board_prev_select, "
				+ " lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, "
				+ " lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject, "
				+ " lead(board_select) over(order by a.board_seq) board_next_select "
				+ " from boardbase a inner join board_content b on a.board_seq=b.board_seq "
				+ " join memberbase c on a.m_seq=c.m_seq "
				+ " where board_code=3) "
				+ " where board_seq=${board_seq} ")
		public ModelAndView injeungView(BoardVO vo);
}
