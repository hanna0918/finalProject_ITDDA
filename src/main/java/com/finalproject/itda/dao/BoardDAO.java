package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.PagingVO;

public interface BoardDAO {
	// 게시판 목록
	/*
	 * @Select(" select * from " + "( select * from " +
	 * "( select b.board_seq,b.BOARD_SUBJECT,b.BOARD_WRITEDATE, M_USERID ,b.board_hit ,nvl(cnt,0) count "
	 * +
	 * " from (SELECT b.BOARD_Seq, b.BOARD_SUBJECT ,m.m_seq, m.m_userid, to_char(b.BOARD_WRITEDATE,'YY-MM-DD')b.BOARD_WRITEDATE, b.board_hit "
	 * +
	 * "        from boardbase b join MEMBERBASE m on(b.M_SEQ=m.M_SEQ) where board_subject like '%${searchKeyword}%' or "
	 * + "   board_content like '%${searchKeyword}%' order by no desc) b full join "
	 * +
	 * "        (select board_seq, count(br_id) cnt from board_comment group by board_seq) bm on b.board_seq=bm.board_seq) "
	 * + "        where<=#{nowPage}*#{onePageRecord} order by board_Seq asc ) " +
	 * "        where rownum<=#{lastPage} order by board_seq desc")
	 */
	
	//게시판 목록 
	@Select("select * from "
			+ "(select * from "
			+ "(select b.m_seq, b.board_seq,b.BOARD_SUBJECT,BOARD_WRITEDATE, M_USERID ,b.board_hit ,nvl(cnt,0) count "
			+ "from (SELECT b.BOARD_Seq, b.BOARD_SUBJECT ,m.m_seq,m.m_userid ,b.BOARD_WRITEDATE, b.board_hit, b.board_content "
			+ "        from boardbase b join MEMBERBASE m on(b.M_SEQ=m.M_SEQ) where board_black=0 ) b full join "
			+ "        (select board_seq,count(br_id) cnt from board_comment group by board_seq) bm on b.board_seq=bm.board_seq "
			+ "        where board_subject like '%${searchKeyword}%' or "
			+ "        board_content like '%${searchKeyword}%' order by board_seq desc) "
			+ "        where rownum<=#{nowPage}*#{onePageRecord} order by board_seq asc) "
			+ "        where rownum<=#{lastPage} order by board_seq desc")
	
	public List<BoardVO> boardList(PagingVO pVo); // list로 받고 안에는 vo가
	
	
	
	
	
	
	
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
		  
		 @Insert("insert into boardbase(board_seq, m_seq, board_code, board_subject, board_content) values "
		  + " (board_seq.nextval, #{m_seq} ,5, #{board_subject}, #{board_content}) ")
		 public int freeboardWrite(BoardVO vo); 
	
	//글내용보기 

		 @Select(" select board_code, board_seq, m_seq, board_subject, board_content, board_hit, b_goodhit, (select count(br_id) "
		 		+ " from board_comment where board_seq=${param1}) commentcount "
		  + " from boardbase where board_code=5 and board_seq=${param1} ")
		 public BoardVO freeView(int board_seq); 
		 
	//수정
		 @Update(" update boardbase set board_subject=#{board_subject}, board_content=#{board_content} "
		 		+ "  where board_seq=#{board_seq} and m_seq=(select m_seq from memberbase where m_userid=#{m_userid} )"
		 		+ " and board_code=5")
		 public int freeUpdate(BoardVO vo);
		 
		 
		 
	//삭제 //댓글있는 거 아직 삭제 안됨 
		 @Delete("delete from boardbase where board_seq=64 and m_seq=(select m_seq from memberbase where m_userid='test')")
		 public int freeDelete(int board_seq, String m_userid);
		 
			/*
			 * delete boardbase, board_comment from boardbase b join board_comment bc on
			 * b.board_seq=bc.board_seq where b.board_seq=64 and b.m_seq=(select m_seq from
			 * memberbase where m_userid='test');
			 */
	
	//댓글
		 @Select(" select b.board_seq, m.m_userid, b.br_content, b.br_id, to_char(b.board_writedate,'MM_DD HH:MI') board_writedate "
		 		+ " from board_comment b join memberbase m on b.m_seq = m.m_seq where board_seq=#{board_seq}")
		 public List<Board_CommentVO> commentList(int board_seq);	
		 
		 
		 
	
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
	 * @Insert("insert into boardbase(board_seq, m_seq, board_code, board_subject, board_content) values "
	 * +
	 * " (board_seq.nextval, #{m_seq} ,#{board_code}, #{board_subject}, #{board_content}"
	 * ) public int freeboardWrite(BoardVO vo);
	 * 
	 * 
	 * //글내용보기 //
	 * 
	 * @Select("select board_code, board_seq, m_seq, board_content, board_hit, (select count(br_id) from board_comment where board_seq=#{board_seq}) commentcount"
	 * + "from boardbase where board_code=5;")
	 * 
	 * 
	 * //수정
	 * 
	 * @Update("update boardbase set board_subject=#{subject}, board_content=#{content}"
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
