package com.finalproject.itda.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MemberDAO;
import com.finalproject.itda.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Inject
	MemberDAO memberDAO;				

	@Override
	public MemberVO login(MemberVO vo){
		return memberDAO.login(vo);
	}

	@Override
	public int join(MemberVO vo){
		return memberDAO.join(vo);
	}

	@Override
	public int idCheck(String m_userid) {
		return memberDAO.idCheck(m_userid);
	}

}
