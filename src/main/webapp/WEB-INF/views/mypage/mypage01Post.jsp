<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- ----------------------- 내가 쓴 글 ----------------------- -->
<div id='myBoardList'>
	<h2>내가 쓴 글</h2>
	<div class='list'>
		<ul id='title'>
			<li><select id='selectCategory'>
					<option>전체</option>
					<option>추천</option>
					<option>매칭</option>
					<option>장터</option>
					<option>자유</option>
					<option>Q&A</option>
			</select></li>
			<li>제목</li>
			<li>등록일</li>
			<li>조회수</li>
			<li>댓글수</li>
		</ul>
		<hr />
	</div>
	<div class='list'>
		<ul class='content'>
			<c:forEach var="vo" items="${list}">
				<li class='selectList'>${vo.board_code}</li>
				<li><a href=''>${vo.board_subject}</a></li>
				<li>${vo.board_writedate}</li>
				<li>${vo.board_hit}</li>
				<li>${vo.b_goodhit}</li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<div class='page'>
			<ul>
				<li><a href='#'>＜</a></li>
				<li><a href='#'>1</a></li>
				<li><a href='#'>2</a></li>
				<li><a href='#'>3</a></li>
				<li><a href='#'>4</a></li>
				<li><a href='#'>5</a></li>
				<li><a href='#'>＞</a></li>
			</ul>
		</div>
	</div>

</div>
