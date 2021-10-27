package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.CalendarVO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingDAO {
	
	// 매칭 리스트 조회하는 미친 쿼리 페이징하는 쿼리
	@Select({"<script>",
		" select count(b.board_seq) totalRecord ",
		" from boardbase b inner join mc_table m on b.board_seq=m.board_seq ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" where board_block in (0, 2) ",
		" <if test='m_seq!=null and m_seq!=\"\"'> ",
		" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
		" </if> ",
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
	
	// 매칭 리스트 조회하는 미친쿼리
	@Select({" <script> ",
		" select * from ",
		" (select * from ",
		" (select b.board_seq, c.m_userid, board_code, board_subject, to_char(board_writedate, 'YYYY-MM-DD') board_writedate, board_hit, b_goodhit, board_call, b_content, ",
		" mc_state, mc_max, to_char(mc_start_date,'YYYY-MM-DD HH24:MI') mc_start_date, to_char(mc_end_date,'YYYY-MM-DD HH24:MI') mc_end_date, mc_where, board_select, ",
		" (select count(m_seq) from mc_part d where d.mc_seq=m.mc_seq) matchingCount, i_url, thumbimg ",
		" from boardbase b inner join mc_table m on b.board_seq=m.board_seq ",
		" inner join board_content a on b.board_seq=a.board_seq ",
		" inner join memberbase c on b.m_seq=c.m_seq ",
		" inner join board_image d on b.board_seq=d.board_seq ",
		" where board_block in (0, 2) ",
		" <if test='m_seq!=null and m_seq!=\"\"'> ",
		" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
		" </if> ",
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
		" mod(${totalRecord} , ${onePageRecord}) ",
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
	
	// 매칭 글보기
	@Select({" <script> ",
			" select * from ",
			" (select a.board_seq, mc_seq, a.m_seq, m_userid, m_nickname, m_info, nvl(m_img,'img/user.png') m_img, board_subject, board_writedate, board_hit, b_goodhit, board_call, b_content, ",
			"	mc_max, mc_where, mc_state, to_char(mc_start_date,'YYYY-MM-DD HH24:MI') mc_start_date, to_char(mc_end_date,'YYYY-MM-DD HH24:MI') mc_end_date, board_select,",
			" (select count(board_seq) from board_comment e where a.board_seq=e.board_seq) replyCount, ",
			" lag(a.board_seq, 1) over(order by a.board_seq) board_prev_seq, ",
			" lag(board_subject, 1, '이전글이 없습니다.') over(order by a.board_seq) board_prev_subject, ",
			" lag(board_select, 1) over(order by a.board_seq) board_prev_select, ",
			" lead(a.board_seq, 1) over(order by a.board_seq) board_next_seq, ",
			" lead(board_subject, 1, '다음글이 없습니다.') over(order by a.board_seq) board_next_subject, ",
			" lead(board_select) over(order by a.board_seq) board_next_select ",
			"	from boardbase a inner join memberbase b on a.m_seq=b.m_seq ",
			"	inner join mc_table c on a.board_seq=c.board_seq ",
			"	inner join board_content d on a.board_seq=d.board_seq ",
			"	where board_code=2 ",
			" <if test='m_seq!=null and m_seq!=\"\"'> ",
			" and c.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
			" </if> ",
			" ) ",
			" where board_seq=${param1} ",
			" </script> "})
	public MatchingVO matchingView(int b_id);
	
	// 매칭 글 조회수 증가
	@Update("update boardbase set board_hit=board_hit+1 where board_seq=${param1}")
	public int countHit(int b_id);
	
	// 캘린더에 들어갈 값
	@Select({" <script> ",
			"select b.board_seq, to_char(mc_start_date,'YYYY-MM-DD') \"start\", ",
			" board_subject \"title\" from boardbase b inner join mc_table m on b.board_seq=m.board_seq",
			" <if test='m_seq!=null and m_seq!=\"\"'> ",
			" where b.m_seq not in (select m_seq_ban from user_ban where m_seq=${m_seq}) ",
			" </if> ",
			" </script>"})
	public List<CalendarVO> dataForJson(MatchingPagingVO pVo);
	
	// 매칭 글등록
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
			+ " into mc_part ( "
			+ "			mc_seq, "
			+ "			m_seq ) "
			+ "			values ( "
			+ "			mc_seq.currval, "
			+ "			${m_seq}) "
			+ " into board_image ("
			+ "			board_seq,"
			+ "			imageseq, "
			+ "			thumbimg )"
			+ "		values ("
			+ "			board_seq.currval,"
			+ "			imageseq.nextval, "
			+ "			#{thumbImg} ) "
			+ " select * from dual ")
	public int matchingWriteOk(MatchingVO vo);

	// 매칭 글 수정페이지 이동
	@Select(" select a.board_seq, board_subject, a.m_seq, mc_max, mc_state, to_char(mc_start_date,'YYYY-MM-DD') startDate, "
			+ " to_char(mc_start_date,'HH24:MI') startTime, to_char(mc_end_date,'HH24:MI')endTime, mc_where, board_select, b_content "
			+ " from boardbase a join mc_table b on a.board_seq=b.board_seq "
			+ " join board_content c on a.board_seq=c.board_seq "
			+ " where a.board_seq=${param1}")
	public MatchingVO matchingEdit(int board_seq);
	
	
	
	// 매칭 글 수정하기...!!!1
	@Update(" update "
		+ "			board_content set "
			+ "			board_select=#{board_select} "
			+ " 	where board_seq=${board_seq} ")
	public int matchingEditOk(MatchingVO vo);
	
	// 매칭 글 수정하기...!!!2
	@Update(" update "
			+ "		boardbase set "
			+ "			board_subject=#{board_subject}, "
			+ "			b_content=#{b_content} "
			+ "		where board_seq=${board_seq} ")
	public int matchingEditOkBoardBase(MatchingVO vo);
	
	// 매칭 글 수정하기...!!!3
	@Update(" update "
			+ "		mc_table set "
			+ "			mc_max = ${mc_max}, "
			+ "			mc_state = ${mc_state}, "
			+ "			mc_start_date = to_date(#{mc_start_date},'YYYY-MM-DD HH24:MI'), "
			+ "			mc_end_date = to_date(#{mc_end_date},'YYYY-MM-DD HH24:MI'), "
			+ "			mc_where = #{mc_where} "
			+ "		where board_seq = ${board_seq} ")
	public int matchingEditOkMcTable(MatchingVO vo);
	
	// 매칭 참가하려는 사람 rank 확인
	@Select(" select a.m_rank, m_name from memberbase a join member_rank b on a.m_rank=b.m_rank where a.m_seq=${param} ")
	public MatchingVO getRank(int m_seq);
	
	// 매칭 인원 불러오는 쿼리문
	@Select(" select m_nickname, m_rank from mc_part a join mc_table b on a.mc_seq = b.mc_seq join memberbase c on a.m_seq=c.m_seq where board_seq=${param1} ")
	public List<MatchingVO> matchingUser(int board_seq);
	
	// 댓글 불러오기
	@Select(" select board_seq, br_id, m_nickname, m_userid, a.m_seq, br_content, to_char(br_writedate, 'YYYY-MM-DD HH24:MI') br_writedate "
			+ " from board_comment a join memberbase b on a.m_seq=b.m_seq where board_seq=${param1} "
			+ " order by br_writedate asc ")
	public List<BoardCommentVO> matchingReply(int board_seq);
	
	// 매칭 참가중인지 확인하는 쿼리문
	@Select(" select m_seq from mc_part where mc_seq=${param1} and m_seq=${param2} ")
	public MatchingVO matchingConfirm(int mc_seq, int m_seq);
	
	// 매칭 참가 쿼리문
	@Insert(" insert into mc_part values(${param2}, ${param1}) ")
	public int matchingIn(int m_seq, int mc_seq);
	
	// 매칭 취소 쿼리문
	@Delete(" delete from mc_part where m_seq=${param2} and mc_seq=${param1} ")
	public int matchingCancel(int m_seq, int mc_seq);
	
	// 댓글 입력
	@Insert(" insert into board_comment (br_id, board_seq, br_content, m_seq) "
			+ " values(br_id.nextval, ${board_seq}, #{br_content}, ${m_seq}) ")
	public int matchingReplyWrite(BoardCommentVO vo);
	
	// 댓글 수정
	@Update(" update board_comment set br_content=#{br_content} where br_id=#{br_id} ")
	public int matchingReplyEdit(BoardCommentVO vo);
	
	@Delete(" delete board_comment where br_id=#{br_id} ")
	public int matchingReplyDelete(BoardCommentVO vo);
}