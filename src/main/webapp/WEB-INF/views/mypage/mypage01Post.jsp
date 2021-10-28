<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>

<!-- ----------------------- 내가 쓴 글 ----------------------- -->
<div id='myBoardList'>
	<h3 class="mypageH2">내가 쓴 글</h3>
	<div class='list'>
		<ul id='title'>
			<li style="width:15%;">카테고리</li>
			<li>제목</li>
			<li>등록일</li>
			<li>조회수</li>
			<li>댓글수</li>
		</ul>
	</div>
	<input type="hidden" id="target"/>
	<div class='list'>
		<ul class='content'>
			<c:forEach var="vo" items="${list}">
				<li class='selectList'>${vo.board_content}</li>
				<c:choose>
					<c:when test="${vo.board_code==1 }">
						<li><a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
					</c:when>
					<c:when test="${vo.board_code==2 }">
						<li><a href="/itda/matchingView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
					</c:when>
					<c:when test="${vo.board_code==3 }">
						<li><a href="/itda/injeungView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
					</c:when>
					<c:when test="${vo.board_code==5 }">
						<li><a href="/itda/freeview?board_seq=${vo.board_seq}&board_code=${vo.board_code}">${vo.board_subject}</a></li>
					</c:when>
					<c:when test="${vo.board_code==6 }">
						<li><a href="/itda/questionView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
					</c:when>
				</c:choose>
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
