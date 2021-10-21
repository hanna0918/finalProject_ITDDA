package com.finalproject.itda.service;

import com.finalproject.itda.vo.MemberBaseVO;


public interface MemberService {
	//로그인
	public MemberBaseVO login(MemberBaseVO vo);

	//회원가입
	public int join(MemberBaseVO vo);
	
	//아이디 체크
	public int idCheck(String m_userid);
	
	//닉 체크
	public int nickCheck(String m_nickname);
}
