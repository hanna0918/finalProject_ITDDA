<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="dropdown">
	<div id="myDropdown${vo.m_nickname}" class="dropdown-content">
		<a class="profil" name="${vo.m_nickname}">프로필</a> 
		<a class="chadan" name="${vo.m_nickname}">차단하기</a> 
		<a class="gudok" name="${vo.m_nickname}">구독하기</a> 
		<a class="sendMail" name="${vo.m_nickname}">쪽지보내기</a> 
		<a href="/itda/writeList">게시글보기</a>
	</div>
</div>