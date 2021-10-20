package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.QuestionVO;

public interface MypageDAO {
	
	//내정보수정 정보가지고오기
	/*
	 * @Select("select m_userid, m_email, m_nickname, m_tel, m_addr, m_birth, m_username, m_info, m_tag "
	 * + " from memberbase where m_seq=1") public MemberVO editMyInfo(MemberVO vo);
	 */
	//내가쓴글
	@Select("select bc.board_content, b.board_subject, to_char(b.board_writedate, 'YYYY-MM-DD'), b.board_hit, count(br.br_id) br_count "
			+ " from boardbase b full outer join board_code bc on b.board_code=bc.board_code "
			+ " join board_comment br on b.m_seq=br.m_seq where br.m_seq=1 "
			+ " group by bc.board_content, b.board_subject, b.board_writedate, b.board_hit")
	public List<BoardVO> mypagePostList();
	
	//내가 쓴 댓글
	@Select("select bc.br_id, b.board_subject, bc.board_seq, m.m_nickname, bc.br_content, to_char(bc.br_writedate, 'YYYY-MM-DD') br_writedate "
			+ " from board_comment bc join boardbase b on bc.board_seq=b.board_seq "
			+ " join memberbase m on m.m_seq=bc.m_seq where m.m_seq=1")
	public List<BoardCommentVO>myReplyList();
	
	//1:1문의는 글을 뿌리면서 시작합니다.
	@Select("select q_number, q_title, q_date, m_seq, q_result_state from question where m_seq=1 order by q_date desc")
	public List<QuestionVO> MypageQnA();
	
	//1:1문의 글 써봅니다.
	@Insert("insert into question(q_number, q_category, q_title, m_seq) "
			+ " values(3, #{q_category}, #{q_title}, 1)")
	public int QuestionInsert(QuestionVO quesVo);
	
	
	

}
