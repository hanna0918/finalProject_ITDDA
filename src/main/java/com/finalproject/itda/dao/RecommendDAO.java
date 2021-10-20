package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.RecommendVO;

public interface RecommendDAO {
	@Select(""
			+ "select "
			+ "b.board_seq, "
//			+ "(select i_url from (select rownum as rownumber, i_url from board_image b where board_seq = ${board_seq} order by imageseq asc) a where a.rownumber=1) as i_url,"
			+ "b.board_subject, "
			+ "t.board_select, "
			+ "b.b_goodhit, "
			+ "m.m_nickname, "
			+ "m.m_userid, "
			+ "to_char(b.board_writedate, 'YYYY-MM-DD HH24:MI') board_writedate, "
			+ "b.board_hit, "
			+ "b.board_call, "
			+ "(select count(*) cnt from board_comment where board_seq = ${board_seq}) br_cnt "
			+ "from boardbase b join board_content t on b.board_seq = t.board_seq "
			+ "join memberbase m on b.m_seq = m.m_seq "
			+ "where board_code = 1 order by board_seq")
	public List<RecommendVO> RecommendList(RecommendVO vo);
}
