package com.finalproject.itda.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.MemberbaseVO;
import com.finalproject.itda.vo.PagingVO;

public interface BoardDAO {
	// 게시판 목록 origin 
	/*
	 * @Select(" select * from " + "( select * from " +
	 * "( select b.board_seq,b.BOARD_SUBJECT,b.BOARD_WRITEDATE, M_USERID ,b.board_hit ,nvl(cnt,0) count "
	 * +
	 * " from (SELECT b.BOARD_Seq, b.BOARD_SUBJECT ,m.m_seq, m.m_userid, to_char(b.BOARD_WRITEDATE,'YY-MM-DD')b.BOARD_WRITEDATE, b.board_hit "
	 * +
	 * "        from boardbase b join MEMBERBASE m on(b.M_SEQ=m.M_SEQ) where board_subject like '%${searchKeyword}%' or "
	 * + "   b_content like '%${searchKeyword}%' order by no desc) b full join "
	 * +
	 * "        (select board_seq, count(br_id) cnt from board_comment group by board_seq) bm on b.board_seq=bm.board_seq) "
	 * + "        where<=#{nowPage}*#{onePageRecord} order by board_Seq asc ) " +
	 * "        where rownum<=#{lastPage} order by board_seq desc")
	 */
	
	/*
	 * //게시판 목록
	 * 
	 * @Select("select * from " + "(select * from " +
	 * "(select b.m_seq, b.board_seq,b.BOARD_SUBJECT,to_char(b.board_writedate, 'YYYY-MM-DD HH24:MI') board_writedate, M_USERID ,b.board_hit ,nvl(cnt,0) count "
	 * +
	 * "from (SELECT b.BOARD_Seq, b.BOARD_SUBJECT ,m.m_seq,m.m_userid ,b.BOARD_WRITEDATE, b.board_hit, b.b_content "
	 * +
	 * "        from boardbase b join MEMBERBASE m on(b.M_SEQ=m.M_SEQ) where b.board_block=0) b full join "
	 * +
	 * "        (select board_seq,count(br_id) cnt from board_comment group by board_seq) bm on b.board_seq=bm.board_seq "
	 * + "        where board_subject like '%${searchKeyword}%' or " +
	 * "        b_content like '%${searchKeyword}%' order by board_seq desc) " +
	 * "        where rownum<=#{nowPage}*#{onePageRecord} order by board_seq asc) "
	 * + "        where rownum<=#{lastPage} order by board_seq desc")
	 * 
	 * public List<BoardVO> boardList(PagingVO pVo); // list로 받고 안에는 vo가
	 */	
	//게시판 목록!!!!!!!!!!!!!!!!!!!!!!!
	@Select
//	(" select * from "
		//	("	select * from "
			 	("select distinct b.m_seq, b.board_seq,b.board_subject,to_char(b.board_writedate, 'YYYY-MM-DD HH24:MI') board_writedate, m.m_userid, m.m_nickname ,b.board_hit, "
			+ " (select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count "
			+ "	 from boardbase b join memberbase m on b.m_seq=m.m_seq full join board_comment bc on b.board_seq=bc.board_seq "
			+ "	 where b.board_code=5 and b.board_block=0 order by board_writedate desc ") 
		/*	+ "  where rownum<=#{nowPage}*#{onePageRecord} order by board_writedate desc ")*/
//			+ "	 where rownum<=#{lastPage} order by board_seq desc ")
	public List<BoardVO> boardList(PagingVO pVo);
	
	/*
	 * @Select("     \"select * from \"\r\n" + "      \"(select * from\"\r\n" +
	 * "          \"(select no, title, to_char(writedate, 'YY-MM-DD') writedate, hit, userid from frannotice\" \r\n"
	 * + "\"          where title like '%${searchKeyword}%' or\"\r\n" +
	 * "\"          content like '%${searchKeyword}%' order by no desc)\"\r\n" +
	 * "\"     where rownum<![CDATA[<=]]>#{nowPage}*#{OnePageRecord} order by no asc)\"\r\n"
	 * + "\"     where rownum<![CDATA[<=]]>#{lastPage} order by no desc\"")
	 * 
	 * 
	 * @Select("select * from " + " (select * from " +
	 * " ( select b.board_seq, b.board_subject, m.m_userid, m.m_nickname, b.board_writedate, b.board_hit, (select count(board_seq) from board_comment where board_seq=5) commentcount from memberbase m "
	 * +
	 * " join boardbase b on m.m_seq = b.m_seq where board_code=5 order by board_seq desc ) "
	 * +
	 * " where rownum<![CDATA[ < ]]>= #{nowPage} * #{onePageRecord} order by board_seq asc)"
	 * + " where rownum<![CDATA[ < ]]>= #{totalPage} order by board_seq desc")
	 */
	
	//검색 
	@Select({" <script> ",
			" select count(board_seq) totalRecord from boardbase",
			" <if test='searchKeyword !=null  and searchKeyword !=\"\"'> ",
			" where title like '%${searchKeyword}%' or ",
			" content like '%${searchKeyword}%' ",
			" </if> ",
			" </script>"})
	
	public PagingVO totalRecordCount(PagingVO pVo);
	
	//글쓰기 등록 //게시물 번호(시퀀스) //회원번호 //카테고리 //제목 //글내용 //default값 있는건 굳이 X
		  
		 @Insert("insert into boardbase(board_seq, m_seq, board_code, board_subject, b_content) values "
		  + " (board_seq.nextval, ${m_seq} ,5, #{board_subject}, #{b_content}) ")
		 public int freeboardWrite(BoardVO vo); 
	
	//글내용보기 

		 @Select(" select board_code, board_seq, m_seq, board_subject, b_content, board_hit, b_goodhit, (select count(br_id) "
		 		+ " from board_comment where board_seq=${param1}) commentcount "
		  + " from boardbase where board_code=5 and board_seq=${param1} ")
		 public BoardVO freeView(int board_seq); 
		 
	//수정
		 @Update(" update boardbase set board_subject=#{board_subject}, b_content=#{b_content} "
		 		+ "  where board_seq=#{board_seq} and m_seq=(select m_seq from memberbase where m_userid=#{m_userid} )"
		 		+ " and board_code=5")
		 public int freeUpdate(BoardVO vo);
		 
		 
		 
	//삭제 
		 @Delete("delete from boardbase where board_seq=${board_seq} and m_seq=(select m_seq from memberbase where m_userid=#{userid})")
		 public int freeDelete(Map<String, Object> map);
		 
			/*
			 * delete boardbase, board_comment from boardbase b join board_comment bc on
			 * b.board_seq=bc.board_seq where b.board_seq=64 and b.m_seq=(select m_seq from
			 * memberbase where m_userid='test');
			 */
	
	//댓글
		 @Select(" select b.board_seq, m.m_userid, b.br_content, b.br_id, to_char(b.board_writedate,'MM_DD HH:MI') board_writedate "
		 		+ " from board_comment b join memberbase m on b.m_seq = m.m_seq where board_seq=#{board_seq}")
		 public List<Board_CommentVO> commentList(int board_seq);	
		 
	//댓글 쓰기 
		@Insert("insert into board_comment( br_id, m_seq, board_seq, br_content values "
				+ " (br_id.nextval, ${m_seq}, #{board_seq}, #{br_content}" )
		public int commentInsert(Board_CommentVO commentVo);
	
	// 프로필 모달창 
		
		@Select("select b.m_nickname, b.m_gender, r.m_name, b.m_info, b.m_tag from memberbase b join member_rank r on r.m_rank= b.m_rank where m_nickname=#{m_nickname}")
		/* @Select("select * from memberbase where m_nickname = #{m_nickname}") */
		 public MemberbaseVO freeBoardmodal(MemberbaseVO mbVo);
	
	//차단 모달창
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberbaseVO freeBoardmodalChadan(MemberbaseVO mbVo);   
	
	//구독 모달창 
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberbaseVO freeBoardmodalGudok(MemberbaseVO mbVo);   
	
	//쪽지 모달창
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberbaseVO freeBoardmodalNote(MemberbaseVO mbVo);   
		
	//쪽지 YES 모달창
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberbaseVO freeBoardmodalNoteYes(MemberbaseVO mbVo);   
		
		
		
		
		
		
	/*
	 * //페이징
	 * 
	 * @Select("select count(board_seq) from boardbase") public void
	 * totalRecordCount(PagingVO pVo);// pVo.setTotalRecord(rs.getInt(1)); 이건 어떻게
	 * 가져오지?
	 * 
	 * 
	 * //페이지 개수
	 * 
	 * @Select( "select * from " + " (select * from " +
	 * " (select b.board_seq,b.board_subject,m.m_userid,b.board_hit,to_char(b.board_writedate,'MM_DD HH:MI') board_writedate from boardbase"
	 * +
	 * " join memberbase b on b.m_seq = m.m_seq where board_code=5 order by board_seq desc) "
	 * + " where rownum<![CDATA[ < ]]>=17 order by board_seq asc)" +
	 * " where rownum<![CDATA[ < ]]>=17 order by board_seq desc "
	 * 
	 * ) public List<BoardVO> boardPageSelect(PagingVO pVo); List<BoardVO> list =
	 * new ArrayList<BoardVO>();
	 * 
	 * //글쓰기 등록 //게시물 번호(시퀀스) //회원번호 //카테고리 //제목 //글내용 //default값 있는건 굳이 X
	 * 
	 * @Insert("insert into boardbase(board_seq, m_seq, board_code, board_subject, b_content) values "
	 * +
	 * " (board_seq.nextval, #{m_seq} ,#{board_code}, #{board_subject}, #{b_content}"
	 * ) public int freeboardWrite(BoardVO vo);
	 * 
	 * 
	 * //글내용보기 //
	 * 
	 * @Select("select board_code, board_seq, m_seq, b_content, board_hit, (select count(br_id) from board_comment where board_seq=#{board_seq}) commentcount"
	 * + "from boardbase where board_code=5;")
	 * 
	 * 
	 * //수정
	 * 
	 * @Update("update boardbase set board_subject=#{subject}, b_content=#{content}"
	 * ) <![CDATA[ < ]]>
	 * 
	 * //글내용보기
	 * 
	 * @Select("select no, subject, userid, hit, content, writedate " +
	 * " from board where no=#{no}") public BoardVO boardView(int no); //레코드번호를 가지고
	 * vo리턴
	 * 
	 * @Insert("insert into board(no, subject, content, userid, writedate, hit, ip) "
	 * +
	 * " values(boardsq.nextval, #{subject}, #{content}, #{userid}, sysdate, 0, #{ip})"
	 * ) public int boardInsert(BoardVO vo); //vo에 데이터가 담겨있음
	 * 
	 * //수정
	 * 
	 * @Update("update board set subject=#{subject}, content=#{content} " +
	 * " where no=#{no} and userid=#{userid}") public int boardUpdate(BoardVO vo);
	 * 
	 * //삭제
	 * 
	 * @Delete("delete from board where no=#{param1} and userid=#{param2}")
	 * 
	 * public int boardDelete(int no, String userid);
	 * 
	 * //배열을 이용한 여러개의 레코드 한 번에 삭제하기 (문자열을 스크립트로)
	 * 
	 * @Delete({"<script>", " delete from board where no in ",
	 * " <foreach item=\"item\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">"
	 * , " #{item} ", " </foreach>", " </script>"}) public int boardDelArray(int[]
	 * noDelArray); //array안에 레코드 번호가 다 담겨있음 //컬렉션을 이용한 여러개의 레코드 한번에 삭제하기
	 * 
	 * @Delete({"<script>", " delete from board where no in ",
	 * " <foreach item=\"item\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">"
	 * , " #{item} ", " </foreach>", " </script>"}) public int
	 * boardDelList(List<Integer> noDelList); }
	 */

}
