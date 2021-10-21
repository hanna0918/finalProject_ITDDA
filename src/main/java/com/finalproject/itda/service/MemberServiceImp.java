package com.finalproject.itda.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.MemberDAO;
import com.finalproject.itda.vo.MemberBaseVO;

@Service
public class MemberServiceImp implements MemberService {
	@Inject
	MemberDAO memberDAO;				

	@Override
	public MemberBaseVO login(MemberBaseVO vo){
		return memberDAO.login(vo);
	}

	@Override
	public int join(MemberBaseVO vo){
		return memberDAO.join(vo);
	}

	@Override
	public int idCheck(String m_userid) {
		return memberDAO.idCheck(m_userid);
	}

	@Override
	public int nickCheck(String m_nickname) {
		return memberDAO.nickCheck(m_nickname);
	}

}
