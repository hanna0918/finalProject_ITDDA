package com.finalproject.itda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.AdminDAO;
import com.finalproject.itda.vo.MemberVO;



@Service
public class AdmiServiceImp implements AdminService {

	@Inject
	AdminDAO adminDAO;



	@Override
	public List<MemberVO> MemberList() 
	{
		return adminDAO.MemberList();
	}

	@Override
	public MemberVO MemberView(MemberVO vo) {
		return adminDAO.MemberView(vo);
	}

	@Override
	public int MemberInsert(MemberVO vo) {
		return adminDAO.MemberInsert(vo);
	}
	
	


	

}
