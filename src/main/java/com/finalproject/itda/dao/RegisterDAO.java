package com.finalproject.itda.dao;

import org.apache.ibatis.annotations.Select;

import com.finalproject.itda.vo.RegisterVO;

public interface RegisterDAO {
	@Select("select userid, username from memberbase where userid=#{userid} and userpwd=#{userpwd}")
	public RegisterVO login(RegisterVO vo);

}
