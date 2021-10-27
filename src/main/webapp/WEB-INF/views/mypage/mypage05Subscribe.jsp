<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- -----------------------  구독목록 ----------------------- -->
<div id='subscribeDiv'>
	<h3>구독목록</h3>
	<div>
		<ul id='title'>
			<li>닉네임</li>
			<li>소개</li>
			<li>주요관심태그</li>
			<li></li>
		</ul>
	</div>
	<div>
		<ul class='content'>
			<c:forEach var="vo" items="${subList}">
				<li>${vo.m_nickname}</li>
				<li><a href='#'>${vo.m_info}</a><br /></li>
				<li><span>${vo.m_tag }</span></li>
				<li>
					<input type='button' name='viewList' value='글보기' onclick="location.href='/itda/writeList?m_nickname=${vo.m_nickname}'"/>
					<input type='button' name='cancleSubscribe' value='구독취소' onclick="location.href='/itda/cancleSubscribe?m_nickname=${vo.m_nickname}'"/>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
