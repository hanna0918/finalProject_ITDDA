<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class='boardContainer'>
		<!-- 게시판제목 -->
		<div class="boardName">
		    <h2>Q&A</h2>
		    <h4>궁금한건 못참지! 궁금함을 공유해보세요!</h4>
  		</div>

		<!-- 검색창 -->
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
			  </select>
			  <input type="text" id="search" name="search" placeholder="검색어를 입력하세요" />
			  <div><img src="img/magnifyingglass.png"></div>
		    </div>
	    </form>
	  </div>
		<!-- 인증게시판/QnA 리스트 -->
		<div class='boardList'>
			<ul id='quesTitle'>
				<li>제목</li>
				<li>작성자</li>
				<li>등록일</li>
				<li>조회수</li>
				<li>댓글수</li>
			</ul>
		</div>	
		<div class="questionList">
			<c:forEach var="questionVo" items="${list}">
				<div class='quesContent'> 
					<div><a href='/itda/questionView?board_seq=${questionVo.board_seq}'>${questionVo.board_subject}</a></div>
					<div>${questionVo.m_nickname}</div>
					<div>${questionVo.board_writedate}</div>
					<div>${questionVo.board_hit}</div>
					<div>${questionVo.br_count}</div>
				</div>
			</c:forEach>
		</div>
		
		<div>
			<!-- 글쓰기 버튼 -->
			<div class="boardBtnDiv">
				<input type="button" value="글쓰기" class="writeBtn" onclick="location.href='/itda/writeQuestion'"/>
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
