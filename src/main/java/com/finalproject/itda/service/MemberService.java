package com.finalproject.itda.service;

import com.finalproject.itda.vo.MemberVO;


public interface MemberService {
	//로그인
	public MemberVO login(MemberVO vo);

	//회원가입
	public int join(MemberVO vo);
	
	//아이디 체크
	public int idCheck(String m_userid);
	
	//닉 체크
	public int nickCheck(String m_nickname);
}
