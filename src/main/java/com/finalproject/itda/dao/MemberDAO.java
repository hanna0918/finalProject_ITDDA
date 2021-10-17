package com.finalproject.itda.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.MemberVO;

public interface MemberDAO {

	@Select("select m_userid, m_username from memberbase where m_userid=#{m_userid} and m_userpwd=#{m_userpwd}")
	public MemberVO login(MemberVO vo);

	@Insert("insert into memberbase("
			+ "m_seq, m_userid, m_userpwd, m_username, m_nickname, m_tel, m_email, m_addr, m_bith, m_gender) "
			+ " values(m_seq.nextval, #{m_userid}, #{m_userpwd}, #{m_username}, #{m_nickname}, #{m_tel},#{m_email}, #{m_addr}, #{m_bith}, to_number(#{m_gender}))")
	public int join(MemberVO vo);
	
	@Select("select count(m_userid) from memberbase where m_userid=#{m_userid}")
	public int idCheck(String m_userid);
	
}
