package com.finalproject.itda.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.PagingVO;

public interface BoardDAO {
	//게시판 목록!!!!!!!!!!!!!!!!!!!!!!!
	@Select
//	(" select * from "
		//	("	select * from "
			 	("select distinct b.m_seq, b.board_seq,b.board_subject,to_char(b.board_writedate, 'YYYY-MM-DD') board_writedate, m.m_userid, m.m_nickname ,b.board_hit, "
			+ " (select count(board_seq) from board_comment bc where b.board_seq=bc.board_seq) br_count "
			+ "	 from boardbase b join memberbase m on b.m_seq=m.m_seq full join board_comment bc on b.board_seq=bc.board_seq "
			+ "	 where b.board_code=5 and b.board_block=0 order by board_writedate desc ") 
		/*	+ "  where rownum<=#{nowPage}*#{onePageRecord} order by board_writedate desc ")*/
//			+ "	 where rownum<=#{lastPage} order by board_seq desc ")
	public List<BoardVO> boardList(PagingVO pVo);
	
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
		 public MemberBaseVO freeBoardmodal(MemberBaseVO mbVo);
	
	//차단 모달창
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberBaseVO freeBoardmodalChadan(MemberBaseVO mbVo);   
	
	//구독 모달창 
		@Select("select m_nickname from memberbase where m_nickname=#{m_nickname}")
		public MemberBaseVO freeBoardmodalGudok(MemberBaseVO mbVo);   
		
		

}
