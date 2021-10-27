package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;

public interface MypageDAO {
	

	//내가쓴글
	@Select("select b.board_seq, bc.board_content, b.board_subject, b.board_writedate, b.board_hit, b.b_goodhit, b.board_code "
			+ " from boardBase b join board_code bc on b.board_code=bc.board_code where m_seq='${m_seq}' order by board_writedate desc")
	public List<BoardVO> mypagePostList(int m_seq);
	
	//내가 쓴 댓글
	@Select("select bc.br_id, b.board_subject, bc.board_seq, m.m_nickname, bc.br_content, to_char(bc.br_writedate, 'YYYY-MM-DD') br_writedate "
			+ " from board_comment bc join boardbase b on bc.board_seq=b.board_seq "
			+ " join memberbase m on m.m_seq=bc.m_seq where m.m_seq=#{m_seq}")
	public List<BoardCommentVO>myReplyList(MemberBaseVO vo);
	
	//1:1문의는 글을 뿌리면서 시작합니다.
	@Select("select q_number, q_title, q_date, q_category, m_seq, q_result_state,q_result from question where m_seq=2 order by q_date desc")
	public List<QuestionVO> MypageQnA(int seq);
	
	
	//1:1문의는 글을 뿌리면서 시작합니다.
		@Select("select q_number, q_title, q_date, q_category, m_seq, q_result_state,q_result from question where m_seq=${param1} order by q_date desc")
		public List<QuestionVO> MypageQnaList(int seq);
		//1:1문의는 글을 뿌리면서 시작합니다.
	
		
		
	//1:1문의 글 써봅니다.
	@Insert("insert into question(q_number, q_category, q_title, m_seq) "
			+ " values(q_number_seq.nextval, #{q_category}, #{q_title}, #{m_seq})")
	public int QuestionInsert(QuestionVO quesVo);
	
	
	@Select("select m_seq,m_userid,m_nickname,m_username,m_email,m_tel,m_addr,m_addrdetail,to_char(m_birth, 'YYYY-MM-DD') m_birth,nvl(m_info,' ') m_info,nvl(m_tag,' ') m_tag, m_img from MEMBERBASE where m_seq=#{m_seq}")
	public MemberBaseVO MyMemberView(MemberBaseVO vo);

	
	@Update("update memberbase set m_email=#{m_email},m_addr=#{m_addr},m_addrdetail=#{m_addrdetail},m_info =#{m_info},m_tag=#{m_tag},m_img=#{m_img} where m_seq= #{m_seq}")
	public int editMyInfoUpdate(MemberBaseVO vo);
	//구독구독구독
	@Select("select m_nickname, m_info, m_tag from memberbase where m_seq= "
			+ " (select m_seq_sub from memberbase m join user_sub us on m.m_seq=us.m_seq_sub where us.m_seq='${param1}')")
	public List<MemberBaseVO> mypageSubscribeList(int m_seq);
	
	

}
