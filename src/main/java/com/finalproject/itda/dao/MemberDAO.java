package com.finalproject.itda.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.MemberBaseVO;

public interface MemberDAO {
	//로그인
//	@Select("select m_userid, m_username from memberbase where m_userid=#{m_userid} and m_userpwd=#{m_userpwd}")
	@Select("select m_seq, m_userid, m_userpwd, m_username from memberbase where m_userid=#{m_userid}")
	public MemberBaseVO login(MemberBaseVO vo);

	
	//회원가입
	@Insert("insert into memberbase("
			+ "m_seq, m_userid, m_userpwd, m_username, m_nickname, m_tel, m_email, m_addr, m_addrdetail, m_birth, m_gender) "
			+ " values(m_seq.nextval, #{m_userid}, #{m_userpwd}, #{m_username}, #{m_nickname}, #{m_tel}, #{m_email}, #{m_addr}, #{m_addrdetail}, #{m_birth}, #{m_gender})")
	public int join(MemberBaseVO vo);
	
	
	//아이디 중복 확인
	@Select("select count(m_userid) from memberbase where m_userid=#{m_userid}")
	public int idCheck(String m_userid);
	
	
	//닉 중복 확인
	@Select("select count(m_nickname) from memberbase where m_nickname=#{m_nickname}")
	public int nickCheck(String m_nickname);
}
