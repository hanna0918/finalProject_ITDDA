<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- ----------------------- 매칭현황 ----------------------- -->
<div id='matching'>
	<h3 class="mypageH2">나의 매칭 현황</h3>
	<div class='list'>
		<ul id='title'>
			<li>no</li>
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>평가하기</li>
		</ul>
	</div>

	<div class='list'>
		<form>
			<ul class='content'>
				<c:forEach var="mcVo" items="${matchingList}">
					<li>${mcVo.board_seq}</li>
					<li>
						${mcVo.board_subject}<br/>
						<span><c:forEach var="tag" items="${mcVo.tags}">#${tag}</c:forEach></span>						
					</li>
					<li>${mcVo.m_nickname}</li>
					<li>${mcVo.board_writedate}</li>
					<li><input type='button' name='ratingBtn' value='글보기' onclick="location.href='/itda/matchingView?board_seq=${mcVo.board_seq}'" /></li>
				</c:forEach>
			</ul>
		</form>
	</div>
	<div class='page'>
		<ul>
			<li><a href='#'><</a></li>
			<li><a href='#'>1</a></li>
			<li><a href='#'>2</a></li>
			<li><a href='#'>3</a></li>
			<li><a href='#'>4</a></li>
			<li><a href='#'>5</a></li>
			<li><a href='#'>></a></li>
		</ul>
	</div>
</div>
