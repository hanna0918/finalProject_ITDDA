package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardVO;

public interface InjeungDAO {
		
		@Select({" <script> ",
				" select b.board_seq, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD') board_writedate, b.board_hit, m.m_nickname, ",
				" (select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count, i_url, thumbimg, nvl(m_img,'img/user.png') m_img ",
				" from boardbase b join memberbase m on b.m_seq=m.m_seq ",
				" join board_image i on b.board_seq=i.board_seq ",
				" where b.board_code=3 ",
//				" <if test='m_seq!=null and m_seq!=\"\"'> ",
//				" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
//				" </if> ",
				" order by board_writedate desc ",
				" </script> "})
		public List<BoardVO> injeungBoardList();
		
		@Select({" <script> ",
				" select * from (select a.board_seq, board_subject, b_content, to_char(board_writedate,'YYYY-MM-DD') board_writedate, m_nickname, m_userid, board_select, b_goodhit, board_call, board_hit, ",
				" (select count(board_seq) from board_comment e where a.board_seq=e.board_seq) replyCount,",
				" nvl(m_img,'img/user.png') m_img, ",
				" lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, ",
				" lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject, ",
				" lag(board_select, 1) over(order by a.board_seq) board_prev_select, ",
				" lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, ",
				" lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject, ",
				" lead(board_select) over(order by a.board_seq) board_next_select ",
				" from boardbase a inner join board_content b on a.board_seq=b.board_seq ",
				" join memberbase c on a.m_seq=c.m_seq ",
				" where board_code=3 ",
				" <if test='m_seq!=null and m_seq!=\"\"'> ",
				" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
				" </if> ",
				" ) where board_seq=${board_seq} ",
				" </script>"})
		public BoardVO injeungView(BoardVO vo);
		
		@Update("update boardbase set board_hit=board_hit+1 where board_seq=${param1}")
		public int countHit(int b_id);
		
		@Insert(" insert all "
				+ "into boardbase ("
				+ "			board_seq,"
				+ "			m_seq, "
				+ "			board_code, "
				+ "			board_subject, "
				+ "			b_content) "
				+ "		values ("
				+ "			board_seq.nextval, "
				+ "			${m_seq}, "
				+ "			3, "
				+ "			#{board_subject}, "
				+ "			#{b_content}) "
				+ " into board_content ( "
				+ "			board_seq, "
				+ "			board_select ) "
				+ "		values ( "
				+ "			board_seq.currval, "
				+ "			#{board_select} )"
				+ " into board_image ("
				+ "			board_seq,"
				+ "			imageseq, "
				+ "			thumbimg )"
				+ "		values ("
				+ "			board_seq.currval,"
				+ "			imageseq.nextval, "
				+ "			#{thumbImg} ) "
				+ " select * from dual ")
		public int injeungWriteOk(BoardVO vo);
}
