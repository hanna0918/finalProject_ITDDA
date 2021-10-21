package com.finalproject.itda.service;

import java.util.List;


import com.finalproject.itda.vo.MemberBaseVO;

public interface AdminService {

	public List<MemberBaseVO> MemberList();
	
	public MemberBaseVO MemberView(MemberBaseVO vo);
	
	public int MemberInsert(MemberBaseVO vo);
	
	public int MemberUpdate(MemberBaseVO vo);
	
}
