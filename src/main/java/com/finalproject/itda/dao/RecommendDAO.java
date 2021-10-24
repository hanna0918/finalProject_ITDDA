package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.MatchingVO;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

public interface RecommendDAO {

	@Select(""
			+ " SELECT "
			+ " B.BOARD_SEQ, "
			+ " (SELECT I_URL FROM (SELECT ROWNUM AS ROWNUMBER, I_URL FROM BOARD_IMAGE B1 WHERE B1.BOARD_SEQ = B.BOARD_SEQ ORDER BY IMAGESEQ ASC) A WHERE A.ROWNUMBER=1) AS I_URL,"
			+ " B.BOARD_SUBJECT, "
			+ " (SELECT '#' || REPLACE(T1.BOARD_SELECT, '/', '#') FROM BOARD_CONTENT T1 WHERE B.BOARD_SEQ = T1.BOARD_SEQ) AS BOARD_SELECT  , "
			+ " B.B_GOODHIT, "
			+ " M.M_NICKNAME, "
			+ " M.M_USERID, "
			+ " TO_CHAR(B.BOARD_WRITEDATE, 'YYYY-MM-DD HH24:MI') BOARD_WRITEDATE, "
			+ " B.BOARD_HIT, "
			+ " B.BOARD_CALL, "
			+ " (SELECT COUNT(*) CNT FROM BOARD_COMMENT C WHERE C.BOARD_SEQ = B.BOARD_SEQ) BR_CNT "
			+ " FROM BOARDBASE B "
			+ " JOIN MEMBERBASE M ON B.M_SEQ = M.M_SEQ"
			+ " WHERE BOARD_CODE=1 ORDER BY BOARD_SEQ")
	public List<RecommendVO> recommendList(RecommendVO vo);
	
	
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
			+ "			1, "
			+ "			#{board_subject}, "
			+ "			#{b_content}) "
			
			+ " into board_content ( "
			+ "			board_seq, "
			+ "			board_select ) "
			+ "		values ( "
			+ "			board_seq.currval, "
			+ "			#{board_select} )"
			+ ""
			+ " select * from dual ")
	public int recommendWriteOk(RecommendVO vo);

	@Select(" "
			+ "select * from "
			+ "    (select a.board_seq "
			+ "           , m_userid "
			+ "           , m_nickname "
			+ "           , m_info "
			+ "           , board_subject "
			+ "           , board_writedate "
			+ "           , board_hit"
			+ "           , b_goodhit "
			+ "           , board_call "
			+ "           , b_content "
			+ "           , board_select "
			+ "           , lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq "
			+ "           , lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject "
			+ "           , lag(board_select, 1) over(order by a.board_seq) board_prev_select "
			+ "           , lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq "
			+ "           , lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject "
			+ "           , lead(board_select) over(order by a.board_seq) board_next_select "
			+ "    from boardbase a "
			+ "    inner join memberbase b "
			+ "            on a.m_seq=b.m_seq "
			+ "    inner join board_content d "
			+ "            on a.board_seq=d.board_seq "
			+ "    where board_code=1) "
			+ "where board_seq=${param1}")
	public RecommendVO recommendView(int board_seq);
	
	@Select("select count(*) from baordbase where board_code=1")
	public RecommendPagingVO page(RecommendPagingVO pVo);
	
}



