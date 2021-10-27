package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

public interface RecommendDAO {

	@Select({" <script> ",
		" select * from ",
		" (select * from ",
		" (select b.board_seq, c.m_userid, board_code, board_subject, to_char(board_writedate, 'YYYY-MM-DD') board_writedate, board_hit, b_goodhit, board_call, b_content, ",
		" board_select, i_url, thumbimg ",
		" from boardbase b ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" inner join board_image d on a.board_seq=d.board_seq ",
		" where board_block in (0, 2) and board_code = 1 ",
		" <if test='tag != null and tag != \"\"'> ",
		" 	<foreach item='item' collection='tag' open='' separator='' close=''> ",
		" 		and board_select like '%${item}%' ",
		" 	</foreach> ",
		" </if> ",
		" order by board_seq desc) ",
		" where rownum<![CDATA[<=]]>${onePageRecord} * ${nowPage} ",
		" order by board_seq asc) ",
		" where rownum<![CDATA[<= ]]> ",
		" <choose> ",
		" 	<when test='totalPage == nowPage and lastPage != 0'> ",
		" 		mod(${totalRecord} , ${onePageRecord}) ",
		" 	</when> ",
		" 	<otherwise> ",
		" 		${onePageRecord} ",
		" 	</otherwise> ",
		
		" </choose> ",
		" 	order by board_seq desc ",
		" </script> "})
	public List<RecommendVO> recommendList(RecommendPagingVO vo);
//	@Select(""
//			+ " SELECT "
//			+ " B.BOARD_SEQ, "
//			+ " (SELECT I_URL FROM (SELECT ROWNUM AS ROWNUMBER, I_URL FROM BOARD_IMAGE B1 WHERE B1.BOARD_SEQ = B.BOARD_SEQ ORDER BY IMAGESEQ ASC) A WHERE A.ROWNUMBER=1) AS I_URL,"
//			+ " B.BOARD_SUBJECT, "
//			+ " (SELECT '#' || REPLACE(T1.BOARD_SELECT, '/', ' #') FROM BOARD_CONTENT T1 WHERE B.BOARD_SEQ = T1.BOARD_SEQ) AS BOARD_SELECT  , "
//			+ " B.B_GOODHIT, "
//			+ " M.M_NICKNAME, "
//			+ " M.M_USERID, "
//			+ " TO_CHAR(B.BOARD_WRITEDATE, 'YYYY-MM-DD HH24:MI') BOARD_WRITEDATE, "
//			+ " B.BOARD_HIT, "
//			+ " B.BOARD_CALL, "
//			+ " (SELECT COUNT(*) CNT FROM BOARD_COMMENT C WHERE C.BOARD_SEQ = B.BOARD_SEQ) BR_CNT "
//			+ " FROM BOARDBASE B "
//			+ " JOIN MEMBERBASE M ON B.M_SEQ = M.M_SEQ"
//			+ " WHERE BOARD_CODE=1 ORDER BY BOARD_SEQ")
//	public List<RecommendVO> recommendList(RecommendVO vo);
	
	
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
			+ " into board_image ("
			+ "			board_seq,"
			+ "			imageseq, "
			+ "			thumbimg )"
			+ "		values ("
			+ "			board_seq.currval,"
			+ "			imageseq.nextval, "
			+ "			#{thumbImg} ) "
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
	
	@Update("update boardbase set board_hit=board_hit+1 where board_seq=${param1}")
	public int countHit(int b_id);
	
	@Select({"<script>",
		" select count(b.board_seq) totalRecord ",
		" from boardbase b ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" where board_block in (0 , 2) and board_code=1 ",
		" <if test='tag != null and tag != \"\"'> ",
		" 	<foreach item='item' collection='tag' open='' separator='' close=''> ",
		" 		and board_select like '%${item}%' ",
		" 	</foreach> ",
		" </if> ",
		" </script>" })
	public RecommendPagingVO page(RecommendPagingVO pVo);
	
}



