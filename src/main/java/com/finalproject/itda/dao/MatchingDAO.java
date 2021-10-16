package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

public interface MatchingDAO {
	@Select({"<script>",
		" select count(b_id) totalRecord from selectboard ",
		" <if test='tag != null and tag != \"\"'> ",
		" where ",
		" <foreach item='item' collection='tag' open='' separator='and' close=''> ",
		" b_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <choose> ",
		" <when test='tag != null and selectedDate != null'> ",
		" and b_matchingdate=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" <when test='tag == null and selectedDate != null'> ",
		" where b_matchingdate=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" </choose> ",
		" <if test='frequency != null and frequency != \"allGroup\"'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null'> ",
		" where b_frequency=#{frequency} ",
		" </when> ",
		" <otherwise> ",
		" and b_frequency=#{frequency} ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" <if test='listup != null and listup != \"recentTime\"'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null and frequency != null and frequency != \"allGroup\"'> ",
		" <![CDATA[where b_matchingDate > sysdate]]> ",
		" </when> ",
		" <otherwise> ",
		" <![CDATA[and b_matchingDate > sysdate]]> ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		" </script>" })
	public MatchingPagingVO page(MatchingPagingVO pVo);
	@Select({" <script> ",
		" select * from ",
		" (select * from ",
		" (select b_id, b_select, b_content, m_userid, to_char(b_writedate, 'YYYY-MM-DD') b_writedate, b_frequency, ",
		" to_char(b_matchingdate, 'YYYY-MM-DD') b_matchingdate, b_where, b_nowpart, b_maxpart, b_hit from selectboard ",
		" <if test='tag != null and tag != \"\"'> ",
		" where ",
		" <foreach item='item' collection='tag' open='' separator='and' close=''> ",
		" b_select like '%${item}%' ",
		" </foreach> ",
		" </if> ",
		" <choose> ",
		" <when test='tag != null and selectedDate != null'> ",
		" and b_matchingdate=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" <when test='tag == null and selectedDate != null'> ",
		" where b_matchingdate=to_date(#{selectedDate}, 'YYYY-MM-DD') ",
		" </when> ",
		" </choose> ",
		" <if test='frequency != null and frequency != \"allGroup\"'> ",
		" <choose> ",
		" <when test='tag == null and selectedDate == null'> ",
		" where b_frequency=#{frequency} ",
		" </when> ",
		" <otherwise> ",
		" and b_frequency=#{frequency} ",
		" </otherwise> ",
		" </choose> ",
		" </if> ",
		
		// 여기 해야함!!!!!!!!!!!!!!!!!!!!!!!
//		" <if test='listup != null and listup != \"recentTime\"'> ",
//		" <choose> ",
//		" <when test='tag == null and selectedDate == null and frequency == null'> ",
//		" <![CDATA[and b_matchingDate > sysdate]]> ",
//		" </when> ",
//		" <otherwise> ",
//		" <![CDATA[where b_matchingDate > sysdate]]> ",
//		" </otherwise> ",
//		" </choose> ",
//		" </if> ",
		// 여기 해야함!!!!!!!!!!!!!!!!!!!!!!!
		
		" order by b_id desc) ",
		" <![CDATA[ where rownum<=${onePageRecord} * ${nowPage} order by b_id asc) ",
		" where rownum< =]]> ",
		" <choose> ",
		" <when test='totalPage==nowPage and totalRecord*onePageRecord != 0'> ",
		" ${totalRecord} % ${onePageRecord} ",
		" </when> ",
		" <otherwise> ",
		" ${onePageRecord} ",
		" </otherwise> ",
		" </choose> ",
		" order by b_id desc ",
		" </script> "})
	public List<MatchingVO> matchingList(MatchingPagingVO pVo);
	
	@Select("select b_id, b_select, b_content, m_userid, to_char(b_writedate, 'YYYY-MM-DD') b_writedate, b_frequency, "
			+ " to_char(b_matchingdate, 'YYYY-MM-DD') b_matchingdate, b_where, b_nowpart, b_maxpart, b_hit from selectboard where b_id=${param1}")
	public MatchingVO matchingView(int b_id);
	
	@Update("update selectboard set b_hit=b_hit+1 where b_id=${param1}")
	public int countHit(int b_id);
}