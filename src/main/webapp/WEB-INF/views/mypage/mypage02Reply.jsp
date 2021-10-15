<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- -----------------------  쓴댓글 ----------------------- -->
<div id='myReply'>
	<h2>내가 쓴 댓글</h2>
	<div>댓글</div>
	<hr />
	<div>
		<form method='get' action='#'>
			<ul class='replyList'>
				<li><input type='checkbox' name='replyChk' /></li>
				<li>
					<div>
						<div>평일 낮에 가면 대시간 많이
							걸릴까요?---------------------------------------------------1111111111111111111111111---------------------</div>
						<div>이구역백종원 &nbsp;&nbsp; 2021.08.16</div>
						<div>
							제목이될수도<a href='#'>#맛집</a> <a href='#'>#이태원</a> <a href='#'>#치킨</a><a
								href='#'>#탄두리</a> <a href='#'>#이색맛집</a>
						</div>
					</div>
				</li>
				<li><input type='checkbox' name='replyChk' /></li>
				<li>
					<div>
						<div>평일 낮에 가면 대시간 많이
							걸릴까요?---------------------------------------------------1111111111111111111111111---------------------</div>
						<div>이구역백종원 &nbsp;&nbsp; 2021.08.16</div>
						<div>
							제목이될수도<a href='#'>#맛집</a> <a href='#'>#이태원</a> <a href='#'>#치킨</a><a
								href='#'>#탄두리</a> <a href='#'>#이색맛집</a>
						</div>
					</div>
				</li>
				<li><input type='checkbox' name='replyChk' /></li>
				<li>
					<div>
						<div>평일 낮에 가면 대시간 많이
							걸릴까요?---------------------------------------------------1111111111111111111111111---------------------</div>
						<div>이구역백종원 &nbsp;&nbsp; 2021.08.16</div>
						<div>
							제목이될수도<a href='#'>#맛집</a> <a href='#'>#이태원</a> <a href='#'>#치킨</a><a
								href='#'>#탄두리</a> <a href='#'>#이색맛집</a>
						</div>
					</div>
				</li>
				<li><input type='checkbox' name='replyChk' /></li>
				<li>
					<div>
						<div>평일 낮에 가면 대시간 많이
							걸릴까요?---------------------------------------------------1111111111111111111111111---------------------</div>
						<div>이구역백종원 &nbsp;&nbsp; 2021.08.16</div>
						<div>
							제목이될수도<a href='#'>#맛집</a> <a href='#'>#이태원</a> <a href='#'>#치킨</a><a
								href='#'>#탄두리</a> <a href='#'>#이색맛집</a>
						</div>
					</div>
				</li>
			</ul>
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
	<div id='page'>
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
			<form method="post" id="regForm" action="formOk">
				<div>이 댓글을 삭제하시겠습니까?</div>
				<input type='button' name='confirmDelete' id='confirmDelete'
					class='btnClass' value='삭제' /> <input type='button'
					name='cancleDelete' id='cancleDelete' class='btnClass' value='취소' />
			</form>
		</article>
	</div>
</div>


