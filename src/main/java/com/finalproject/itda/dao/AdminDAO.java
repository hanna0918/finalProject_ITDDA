package com.finalproject.itda.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.finalproject.itda.vo.MemberVO;


public interface AdminDAO {


	@Select("select m_seq,m_username,m_nickname,m_tel,m_content from member123 order by m_seq")
	public List<MemberVO> MemberList();

	@Select("select m_seq,m_username,m_nickname,m_tel,m_content from member123 where m_seq=#{m_seq}")
	public MemberVO MemberView(MemberVO vo);      
																												//난중에 seq퀀스로 바꿔야됨
	@Insert("insert into member123(m_seq, m_username,m_userpwd,m_nickname,m_email,m_tel,m_addr,m_bith) values (6,#{m_username},#{m_userpwd},#{m_nickname},#{m_email},#{m_tel},#{m_addr},#{m_bith})")
	public int MemberInsert(MemberVO vo);
	

}
