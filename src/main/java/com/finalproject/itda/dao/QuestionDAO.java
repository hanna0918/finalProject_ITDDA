package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.BoardVO;

public interface QuestionDAO {
	//QnA리스트
	@Select("select distinct b.board_seq, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD') board_writedate, b.board_hit, m.m_nickname, "
			+ "(select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count "
			+ "from boardbase b join memberbase m on b.m_seq=m.m_seq "
			+ "join board_comment bc on b.m_seq=bc.m_seq where b.board_code=6 order by board_writedate desc")
	public List<BoardVO> questionBoardList();
	
	//QnA View
	@Select({" <script> ",
		" select * from (select a.board_seq, board_subject, b_content, to_char(board_writedate,'YYYY-MM-DD') board_writedate, m_nickname, m_userid, board_select, b_goodhit, board_call, board_hit, ",
		" (select count(board_seq) from board_comment e where a.board_seq=e.board_seq) replyCount, ",
		" lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, ",
		" lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject, ",
		" lag(board_select, 1) over(order by a.board_seq) board_prev_select, ",
		" lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, ",
		" lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject, ",
		" lead(board_select) over(order by a.board_seq) board_next_select ",
		" from boardbase a inner join board_content b on a.board_seq=b.board_seq ",
		" join memberbase c on a.m_seq=c.m_seq ",
		" where board_code=6 ",
		" <if test='m_seq!=null and m_seq!=\"\"'> ",
		" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
		" </if> ",
		" ) where board_seq=${board_seq} ",
		" </script>"})
	public BoardVO boardView(int no);
	
	//QnA등록
	@Insert("insert into boardbase(board_seq, m_seq, board_code, board_subject, b_content ) "
			+ " values(board_seq.nextval, ${m_seq}, 6, '${board_subject}', '${b_content}')")
	public int questionInsert(BoardVO vo);
	
	
}
