package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.MemberVO;


public interface AdminDAO {


	@Select("select  m.m_seq,m.m_userid,m.m_username,m.m_nickname, m.m_tel, to_char(m_regdate,'YY-MM-DD') m_regdate, count(b.board_seq) board_seq,s.m_state from memberbase m full outer join  boardbase b on m.m_seq = b.m_seq join member_rank mr on m.m_rank = mr.m_rank join states s on m.m_statecode = s.m_statecode group by m.m_seq, m.m_userid, m.m_username, m.m_nickname, m.m_tel, to_char(m_regdate,'YY-MM-DD'), s.m_state")
	public List<MemberVO> MemberList();

	@Select("select m.m_seq,m.m_userid ,m.m_nickname ,to_char(m.m_regdate,'YY-MM-DD') m_regdate, s.m_state, r.m_name,m.m_rank,m.m_statecode from memberbase m  join states s on m.m_statecode = s.m_statecode join member_rank r on m.m_rank = r.m_rank where m.m_seq=#{m_seq}")
	public MemberVO MemberView(MemberVO vo);      
																												//�궃以묒뿉 seq���뒪濡� 諛붽퓭�빞�맖
	@Insert("insert into memberbase(m_seq,m_userid, m_username,m_userpwd,m_nickname,m_email,m_tel,m_addr,m_brith,m_gender) "
			+ "values (6,#{m_userid},#{m_username},#{m_userpwd},#{m_nickname},#{m_email},#{m_tel},#{m_addr},#{m_brith},1)")
	public int MemberInsert(MemberVO vo);
	
	@Update("update memberbase set m_statecode=#{m_statecode},m_rank=#{m_rank} where m_seq=#{m_seq}")
	public int MemberUpdate(MemberVO vo);
}



