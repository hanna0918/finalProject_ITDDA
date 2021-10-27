<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- -----------------------  쓴댓글 ----------------------- -->
<div id='myReply'>
	<h3 class="mypageH2">내가 쓴 댓글</h3>
	<div>댓글</div>
	<div>
		<form method='post' action=''>
			<c:forEach var="vo" items="${replyList}">
				<ul class='replyList'>
					<li><input type='checkbox' name='replyChk' value='${vo.br_id}'/></li>
					<li>
						<div>
							<div>${vo.br_content}</div>
							<div>${vo.m_nickname} &nbsp;&nbsp; ${vo.br_writedate}</div>
							<div>${vo.board_subject}</div>
						</div>
					</li>
				</ul>
			</c:forEach>
			<div class='chkAndDel'>
				<div>
					<label><input type='checkbox' name='replyAllCheck'
						id='replyAllCheck' />전체선택</label>
				</div>
				<div>
					<input type='button' name='replyDelBtn' id='replyDelBtn'
						value='✘ 삭제' />
				</div>
			</div>
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
	<!-- ----------------------------------------------------------삭제 확인 모달창------------------------------------------------------- -->
	<div class="deleteModal" id="deleteModal">
		<div class="deleteModalOverlay"></div>
		<article class="deleteContent">
			<form method="post" id="regForm" >
				<div>이 댓글을 삭제하시겠습니까?</div>
				<input type='button' name='confirmDelete' id='confirmDelete'
					class='btnClass' value='삭제' /> <input type='button'
					name='cancleDelete' id='cancleDelete' class='btnClass' value='취소' />
			</form>
		</article>
	</div>
</div>


