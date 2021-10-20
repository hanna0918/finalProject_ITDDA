package com.finalproject.itda.service;

import java.util.List;


import com.finalproject.itda.vo.MemberVO;

public interface AdminService {

	public List<MemberVO> MemberList();
	
	public MemberVO MemberView(MemberVO vo);
	
	public int MemberInsert(MemberVO vo);
	
	public int MemberUpdate(MemberVO vo);
	
}
