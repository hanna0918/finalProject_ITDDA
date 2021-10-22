package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.AdminDAO;
import com.finalproject.itda.vo.MemberBaseVO;



@Service
public class AdmiServiceImp implements AdminService {

	@Inject
	AdminDAO adminDAO;

	@Override
	public List<MemberBaseVO> MemberList() 
	{
		return adminDAO.MemberList();
	}

	@Override
	public MemberBaseVO MemberView(MemberBaseVO vo) {
		return adminDAO.MemberView(vo);
	}

	@Override
	public int MemberInsert(MemberBaseVO vo) {
		return adminDAO.MemberInsert(vo);
	}

	@Override
	public int MemberUpdate(MemberBaseVO vo) {
		return adminDAO.MemberUpdate(vo);
	}


	
	
	

	

}
