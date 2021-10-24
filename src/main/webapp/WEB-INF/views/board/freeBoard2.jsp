<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class='boardContainer'>
	<!-- 게시판제목 -->
	<div class="boardName">
		<h2>FREEBOARD</h2>
		<h4>아무말 대잔치를 열어보자!</h4>
	</div>
	<!-- 검색창 -->
	<div class="allSearch">
		<form>
			<div>
				<select name="searchSelect">
					<option>전체</option>
					<option>글제목</option>
					<option>작성자</option>
					<option>내용</option>
					<option>제목+내용</option>
				</select> <input type="text" id="search" name="search"
					placeholder="검색어를 입력하세요" />
				<div>
					<img src="img/magnifyingglass.png">
				</div>
			</div>
		</form>
	</div>
	<!-- 자유게시판 리스트 -->
	<div>
		<ul id='basicBoardTitle'>
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>조회수</li>
			<li>댓글수</li>
		</ul>
	</div>

	<div class='list'>
		<c:forEach var="vo" items="${list}">
			<div class='basicBoardContent'>
				<div><a href="/itda/freeview?board_seq=${vo.board_seq}">${vo.board_subject}</a></div>
				<div><label onclick="myFunction('${vo.m_nickname}');" class="dropbtn">${vo.m_nickname}</label></div>
				<div>${vo.board_writedate}</div>
				<div>${vo.board_hit}</div>
				<div>0</div>
			</div>
		</c:forEach>
	</div>

	<div>
		<!-- 글쓰기 버튼 -->
		<div class="boardBtnDiv">
			<input type="button" value="글쓰기" class="writeBtn recommendBtn"
				onclick="location.href='/itda/freeboardWrite'" />
		</div>
		<!-- 페이지번호 -->
		<div class='pagingDiv'>
			<ul>
				<li><a href='#'>◁</a></li>
				<li><a href='#'>1</a></li>
				<li><a href='#'>2</a></li>
				<li><a href='#'>3</a></li>
				<li><a href='#'>4</a></li>
				<li><a href='#'>5</a></li>
				<li><a href='#'>▷</a></li>
			</ul>
		</div>
	</div>
</div>

