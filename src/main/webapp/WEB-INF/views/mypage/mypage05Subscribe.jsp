<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- -----------------------  구독목록 ----------------------- -->
<div id='subscribeDiv'>
	<h2>구독목록</h2>
	<div>
		<ul id='title'>
			<li>닉네임</li>
			<li>소개</li>
			<li>주요관심태그</li>
			<li></li>
		</ul>
		<hr />
	</div>
	<div>
		<ul class='content'>
			<li>노래하는 가물치</li>
			<li><a href='#'>수영을 좋아하는 남자입니다.</a><br /></li>
			<li><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
			<li><input type='button' name='cancleSubscribe' value='구독취소' /></li>
		</ul>
	</div>
</div>
