package com.finalproject.itda.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.finalproject.itda.dao.RegisterDAO;
import com.finalproject.itda.vo.RegisterVO;

@Service
public class RegisterServiceImp implements RegisterService {
	@Inject
	RegisterDAO registerDAO;

	@Override
	public RegisterVO login(RegisterVO vo) {
		// TODO Auto-generated method stub
		return registerDAO.login(vo);
	}
	
}
