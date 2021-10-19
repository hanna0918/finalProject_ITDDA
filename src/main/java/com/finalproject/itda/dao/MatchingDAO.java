package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingDAO {
	@Select({"<script>",
		" select count(b.board_seq) totalRecord ",
		" from boardbase b inner join mc_table m on b.board_seq=m.board_seq ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" <if test='tag != null and tag != \"\"'> ",
		" where ",
		" <foreach item='item' collection='tag' open='' separator='and' close=''> ",
		" board_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <choose> ",
		" <when test='tag != null and selectedDate != null'> ",
		" and mc_start_date=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" <when test='tag == null and selectedDate != null'> ",
		" where mc_start_date=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" </choose> ",
		" <if test='frequency != null and frequency != 0'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null'> ",
		" where mc_state=#{frequency} ",
		" </when> ",
		" <otherwise> ",
		" and mc_state=#{frequency} ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" <if test='listup != null and listup != 0'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null and frequency != 1 and frequency !=2'> ",
		" where mc_start_date <![CDATA[>]]> sysdate ",
		" </when> ",
		" <otherwise> ",
		" and mc_start_date <![CDATA[>]]> sysdate ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" </script>" })
	public MatchingPagingVO page(MatchingPagingVO pVo);
	@Select({" <script> ",
		" select * from ",
		" (select * from ",
		" (select b.board_seq, c.m_userid, board_code, board_subject, to_char(board_writedate, 'YYYY-MM-DD') board_writedate, board_hit, b_goodhit, board_call, b_content, ",
		" mc_state, mc_max, to_char(mc_start_date,'YYYY-MM-DD HH24:MI') mc_start_date, to_char(mc_end_date,'YYYY-MM-DD HH24:MI') mc_end_date, mc_where, board_select ",
		" from boardbase b inner join mc_table m on b.board_seq=m.board_seq ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" <if test='tag != null and tag != \"\"'> ",
		" where ",
		" <foreach item='item' collection='tag' open='' separator='and' close=''> ",
		" board_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <choose> ",
		" <when test='tag != null and selectedDate != null'> ",
		" and to_char(mc_start_date,'YYYY-MM-DD')=#{selectedDate} ",
		" </when> ",
		" <when test='tag == null and selectedDate != null'> ",
		" where to_char(mc_start_date,'YYYY-MM-DD')=#{selectedDate} ",
		" </when> ",
		" </choose> ",
		" <if test='frequency != null and frequency != 0'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null'> ",
		" where mc_state=#{frequency} ",
		" </when> ",
		" <otherwise> ",
		" and mc_state=#{frequency} ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" <if test='listup != null and listup != 0'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null and frequency != 1 and frequency !=2'> ",
		" <![CDATA[where mc_start_date > sysdate]]> ",
		" </when> ",
		" <otherwise> ",
		" and mc_start_date <![CDATA[>]]> sysdate ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" <choose> ",
		" <when test='listup != null and listup != 0'> ",
		" order by mc_start_date asc) ",
		" </when> ",
		" <otherwise> ",
		" order by board_seq desc) ",
		" </otherwise> ",
		" </choose> ",
		" where rownum<![CDATA[<=]]>${onePageRecord} * ${nowPage} ",
		" <choose> ",
		" <when test='listup != null and listup != 0'> ",
		" order by mc_start_date desc) ",
		" </when> ",
		" <otherwise> ",
		" order by board_seq asc) ",
		" </otherwise> ",
		" </choose> ",
		" where rownum<![CDATA[<= ]]> ",
		" <choose> ",
		" <when test='totalPage==nowPage and totalRecord*onePageRecord != 0'> ",
		" ${totalRecord} % ${onePageRecord} ",
		" </when> ",
		" <otherwise> ",
		" ${onePageRecord} ",
		" </otherwise> ",
		" </choose> ",
		" <choose> ",
		" <when test='listup != null and listup != 0'> ",
		" order by mc_start_date asc ",
		" </when> ",
		" <otherwise> ",
		" order by board_seq desc ",
		" </otherwise> ",
		" </choose> ",
		" </script> "})
	public List<MatchingVO> matchingList(MatchingPagingVO pVo);
	
	@Select(" select * from (select a.board_seq, m_userid, m_nickname, m_info, board_subject, board_writedate, board_hit, b_goodhit, board_call, b_content, "
			+ "	mc_max, mc_state, to_char(mc_start_date,'YYYY-MM-DD HH24:MI') mc_start_date, to_char(mc_end_date,'YYYY-MM-DD HH24:MI') mc_end_date, board_select, "
			+ " lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, "
			+ " lag(board_subject, 1, '이전 글이 없습니다') over(order by a.board_seq) board_prev_subject, "
			+ " lag(board_select, 1) over(order by a.board_seq) board_prev_select, "
			+ " lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, "
			+ " lead(board_subject, 1, '다음 글이 없습니다') over(order by a.board_seq) board_next_subject, "
			+ " lead(board_select) over(order by a.board_seq) board_next_select "
			+ "	from boardbase a inner join memberbase b on a.m_seq=b.m_seq "
			+ "	inner join mc_table c on a.board_seq=c.board_seq "
			+ "	inner join board_content d on a.board_seq=d.board_seq "
			+ "	where board_code=2) "
			+ " where board_seq=${param1}")
	public MatchingVO matchingView(int b_id);
	
	@Update("update boardbase set board_hit=board_hit+1 where board_seq=${param1}")
	public int countHit(int b_id);
	
	@Select("select a.board_seq, m_seq, m_board_subject, ")
	public int matchingEdit(int board_seq, int m_seq);
	
//	@Select(" select b.board_seq, to_char(mc_start_date,'YYYY-MM-DD') 'start', board_subject as 'title' "
//			+ " from boardbase b inner join mc_table m on b.board_seq=m.board_seq")
//	
//	public List<CalendarVO> dataForJson();
}






































