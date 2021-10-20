package com.finalproject.itda.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.MemberVO;

public interface MemberDAO {

	@Select("select m_seq, m_userid, m_nickname from memberbase where m_userid=#{m_userid} and m_userpwd=#{m_userpwd}")
	public MemberVO login(MemberVO vo);

	@Insert("insert into memberbase(m_seq, m_userid, m_userpwd, m_username, m_nickname, m_tel, m_email, m_addr, m_bith, m_info, m_tag)	"
		  + "values(m_seq.nextval, #{m_userid}, #{m_userpwd}, #{m_username}, #{m_nickname}, #{m_tel}, #{m_email}, #{m_addr}, #{m_bith}, #{m_info}, #{m_tag})")
	public MemberVO join(MemberVO vo);

}
