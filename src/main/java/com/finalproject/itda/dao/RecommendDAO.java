package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.RecommendVO;

public interface RecommendDAO {
//	@Select(""
//			+ "select "
//			+ "b.board_seq, "
////			+ "(select i_url from (select rownum as rownumber, i_url from board_image b where board_seq = ${board_seq} order by imageseq asc) a where a.rownumber=1) as i_url,"
//			+ "b.board_subject, "
//			+ "t.board_select, "
//			+ "b.b_goodhit, "
//			+ "m.m_nickname, "
//			+ "m.m_userid, "
//			+ "to_char(b.board_writedate, 'YYYY-MM-DD HH24:MI') board_writedate, "
//			+ "b.board_hit, "
//			+ "b.board_call, "
//			+ "(select count(*) cnt from board_comment where board_seq = ${board_seq}) br_cnt "
//			+ "from boardbase b join board_content t on b.board_seq = t.board_seq "
//			+ "join memberbase m on b.m_seq = m.m_seq "
//			+ "where board_code = 1 order by board_seq")
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
	
//	public recommendVO recommendView(int board )
}
