package com.finalproject.itda.service;

import org.springframework.stereotype.Service;

import com.finalproject.itda.vo.MemberVO;


public interface MemberService {
	public MemberVO login(MemberVO vo);

	public MemberVO join(MemberVO vo);
}
