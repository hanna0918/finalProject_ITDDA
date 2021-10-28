package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;


public interface AdminDAO {


	@Select("select  m.m_seq,m.m_userid,m.m_username,m.m_nickname ,m.m_tel, to_char(m_regdate,'YY-MM-DD') m_regdate,count(b.board_seq) board_seq,s.m_state from memberbase m full outer join  boardbase b on m.m_seq = b.m_seq join member_rank mr on m.m_rank = mr.m_rank join states s on m.m_statecode = s.m_statecode where m.m_rank between 2 and 4 group by m.m_seq, m.m_userid, m.m_username, m.m_nickname, m.m_tel, to_char(m_regdate,'YY-MM-DD'), m.m_rank,s.m_state order by m.m_seq desc")
	public List<MemberBaseVO> MemberList();

	@Select("select  m.m_seq,m.m_userid,m.m_username,m.m_nickname, m.m_tel, to_char(m_regdate,'YY-MM-DD') m_regdate,mr.m_name,s.m_state from memberbase m join member_rank mr on m.m_rank = mr.m_rank join states s on m.m_statecode = s.m_statecode where m.m_rank=1 order by m.m_seq desc")
	public List<MemberBaseVO> AMemberList();

	@Select("select m.m_seq,m.m_userid ,m.m_nickname ,to_char(m.m_regdate,'YY-MM-DD') m_regdate, s.m_state, r.m_name,m.m_rank,m.m_statecode from memberbase m  join states s on m.m_statecode = s.m_statecode join member_rank r on m.m_rank = r.m_rank where m.m_seq=#{m_seq}")
	public MemberBaseVO MemberView(MemberBaseVO vo);      
																												//�궃以묒뿉 seq���뒪濡� 諛붽퓭�빞�맖
	@Insert("insert into memberbase(m_seq,m_userid, m_username,m_userpwd,m_nickname,m_email,m_tel,m_addr,m_addrdetail,m_birth,m_gender,m_rank) "
			+ "values (m_seq.nextval,#{m_userid},#{m_username},#{m_userpwd},#{m_nickname},#{m_email},#{m_tel},#{m_addr},'관리자',#{m_birth},#{m_gender},1)")
	public int MemberInsert(MemberBaseVO vo);
	
	@Update("update memberbase set m_statecode=#{m_statecode},m_rank=#{m_rank} where m_seq=#{m_seq}")
	public int MemberUpdate(MemberBaseVO vo);
	
	/*게시판 블럭 처리 확인 블럭 처리 업데이트*/
	@Update ("update boardbase set board_blockcontent = #{board_blockcontent},board_block=#{board_block} where board_seq= #{board_seq}")
	public int CallBoardUpdate(BoardVO vo);
	/*게시판 블럭 처리 확인 블럭 처리 업데이트*/
	
	/*신고자 게시판*/
	@Select("select b.board_seq,bc.board_content,b.board_subject,b.b_content,bc.board_select,m.m_nickname,b.board_call ,to_char(board_writedate,'YY-MM-DD') board_writedate from boardbase b JOIN memberbase m on b.m_seq = m.m_seq join board_code bc on b.board_code = bc.board_code join board_content bc on b.board_seq = bc.board_seq where board_block=0 and board_call>=1")
	public List<BoardVO> BoardcallList();
	
	@Select("select b.board_seq, b.board_subject,bc.board_content,m.m_nickname,b.b_content, bt.Board_select from boardbase b join memberbase m on b.m_seq = m.m_seq join board_code bc on bc.board_code = b.board_code join Board_content bt on bt.board_seq =b.board_seq where b.board_seq = #{m_seq}")
	public BoardVO CallBoardView(BoardVO vo);
	/*신고자 게시판*/
	
	/*모든 게시판 보기*/
	@Select("select b.board_seq, b.board_subject,b.board_hit,bc.board_content,m.m_nickname,b.b_content, to_char(board_writedate,'YY-MM-DD') board_writedate ,bt.Board_select from boardbase b join memberbase m on b.m_seq = m.m_seq join board_code bc on bc.board_code = b.board_code join Board_content bt on bt.board_seq = b.board_seq")
	public List<BoardVO> AllboardList();
	/*모든 게시판 보기*/
	
	
	
	/*블랙 게시판*/
	@Select("select b.board_seq,bc.board_content,b.board_subject,b.b_content,m.m_nickname,b.board_call ,to_char(board_writedate,'YY-MM-DD') board_writedate from boardbase b JOIN memberbase m on b.m_seq = m.m_seq join board_code bc on b.board_code = bc.board_code join board_content bc on b.board_seq = bc.board_seq where board_block=1")
	public List<BoardVO> BlackBoardList();
	/*블랙 게시판*/
	
	/*블랙 게시판 상태보기*/
	@Select("select b.board_seq, b.board_subject,bc.board_content,m.m_nickname,b.b_content, bt.Board_select,b.board_blockcontent from boardbase b join memberbase m on b.m_seq = m.m_seq join board_code bc on bc.board_code = b.board_code join board_content bt on bt.board_seq =b.board_seq where b.board_block=1 and b.board_seq =#{m_seq}")
	public BoardVO BlackBoardstateView(BoardVO vo);
	/*블랙 게시판 상태보기*/
	
	/*게시판 블럭 처리 확인 블럭 처리 업데이트*/
	@Update ("update boardbase set board_blockcontent = #{board_blockcontent},board_block=#{board_block} where board_seq= #{board_seq}")
	public int BlockBoardUpdate(BoardVO vo);
	/*게시판 블럭 처리 확인 블럭 처리 업데이트*/

	/* 1:1문의 */
	@Select("select q.q_number,q.q_title,m.m_nickname,to_char(q.q_date,'YY-MM-DD')q_date,q.q_result from question q join memberbase m on q.m_seq= m.m_seq where q_result_state=0")
	public List<QuestionVO> QuestionList();
	/* 1:1문의 */


	/* 1:1 문의 모달 */
	@Select("select q.q_number,q.q_title,m.m_nickname,to_char(q.q_date,'YY-MM-DD')q_date,q.q_result from question q join memberbase m on q.m_seq= m.m_seq where q.q_number=#{q_number}")
	public QuestionVO QusetionWaitModallist(QuestionVO vo);
	/* 1:1 문의 모달 */	
	
	
	//update memberbase set m_statecode=#{m_statecode},m_rank=#{m_rank} where m_seq=#{m_seq}
	/* 1:1 문의 업데이트 */
	@Update("update question set "
			+ "q_result_state=#{q_result_state}, "
			+ "q_result=#{q_result} where q_number=#{q_number}")
	public int QusetionupdateModal(QuestionVO vo);
	/* 1:1 문의 업데이트 */
	
	@Select("select q.q_number,q.q_title,m.m_nickname,to_char(q.q_date,'YY-MM-DD')q_date,q.q_result from question q join memberbase m on q.m_seq= m.m_seq where q_result_state=1")
	public List<QuestionVO> QuestionResultList();

	@Select("select b.board_seq, b.board_subject,bc.board_content,m.m_nickname,b.b_content, bt.Board_select,b.board_blockcontent from boardbase b join memberbase m on b.m_seq = m.m_seq join board_code bc on bc.board_code = b.board_code join board_content bt on bt.board_seq =b.board_seq where b.board_seq =#{m_seq}")
	public BoardVO Allboardmodal(BoardVO vo);
}


