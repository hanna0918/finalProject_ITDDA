package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.CalendarVO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingDAO {
	@Select({"<script>",
		" select count(b.board_seq) totalRecord ",
		" from boardbase b inner join mc_table m on b.board_seq=m.board_seq ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" where board_block=0 ",
		" <if test='tag != null and tag != \"\"'> ",
		" <foreach item='item' collection='tag' open='' separator='' close=''> ",
		" and board_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <if test='selectedDate != null and selectedDate != \"\"'> ",
		" and to_char(mc_start_date,'YYYY-MM-DD')=#{selectedDate} ",
		" </if> ",
		" <if test='frequency != null and frequency != 0'> ",
		" and mc_state=#{frequency} ",
		" </if> ",
		" <if test='listup != null and listup != 0'> ",
		" and mc_start_date <![CDATA[>]]> sysdate ",
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
		" where board_block in (0, 2) ",
		" <if test='tag != null and tag != \"\"'> ",
		" <foreach item='item' collection='tag' open='' separator='' close=''> ",
		" and board_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <if test='selectedDate != null and selectedDate != \"\"'> ",
		" and to_char(mc_start_date,'YYYY-MM-DD')=#{selectedDate} ",
		" </if> ",
		" <if test='frequency != null and frequency != 0'> ",
		" and mc_state=#{frequency} ",
		" </if> ",
		" <if test='listup != null and listup != 0'> ",
		" and mc_start_date <![CDATA[>]]> sysdate ",
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
	
	@Select(" select * from (select a.board_seq, mc_seq, m_userid, m_nickname, m_info, board_subject, board_writedate, board_hit, b_goodhit, board_call, b_content, "
			+ "	mc_max, mc_state, to_char(mc_start_date,'YYYY-MM-DD HH24:MI') mc_start_date, to_char(mc_end_date,'YYYY-MM-DD HH24:MI') mc_end_date, board_select, "
			+ " lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, "
			+ " lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject, "
			+ " lag(board_select, 1) over(order by a.board_seq) board_prev_select, "
			+ " lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, "
			+ " lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject, "
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
	
	
	
	@Select(" select b.board_seq, to_char(mc_start_date,'YYYY-MM-DD') \"start\", "
			+ " board_subject \"title\" from boardbase b inner join mc_table m on b.board_seq=m.board_seq")
	public List<CalendarVO> dataForJson();
	
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
			+ "			2, "
			+ "			#{board_subject}, "
			+ "			#{b_content}) "
			
			+ "into mc_table("
			+ "			mc_seq, "
			+ "			board_seq, "
			+ "			m_seq, "
			+ "			mc_max, "
			+ "			mc_state ,"
			+ "			mc_start_date, "
			+ "			mc_end_date, "
			+ "			mc_where) "
			+ "		values ( "
			+ "			mc_seq.nextval, "
			+ "			board_seq.currval, "
			+ "			${m_seq}, "
			+ "			${mc_max}, "
			+ "			${mc_state}, "
			+ "			to_date(#{mc_start_date},'yyyy-mm-dd hh24:mi'), "
			+ "			to_date(#{mc_end_date},'yyyy-mm-dd hh24:mi'), "
			+ "			#{mc_where}) "
			+ " into board_content ( "
			+ "			board_seq, "
			+ "			board_select ) "
			+ "		values ( "
			+ "			board_seq.currval, "
			+ "			#{board_select} )"
			+ ""
			+ " select * from dual ")
	public int matchingWriteOk(MatchingVO vo);
	
	@Delete("")
	public int matchingDelete(int board_seq);
	
	
	@Select(" select m_nickname, m_rank from mc_part a join mc_table b on a.mc_seq = b.mc_seq join memberbase c on a.m_seq=c.m_seq where board_seq=${param1} ")
	public List<MatchingVO> matchingUser(int board_seq);
	
	
	@Insert(" insert into mc_part values(${param2}, ${param1}) ")
	public int matchingIn(int m_seq, int mc_seq);
	
	
	
	
}
