<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/inc/mypageTop.jspf"%>
<!-- ----------------------- 1:1 문의 ----------------------- -->
<div id='qNa'>
	<h2>1:1 문의</h2>
	<div>
		<input type='button' name='ask' id='ask' value='문의하기' />
	</div>
	<div id='askDisplay'>
		<form method='post' action="#">
			<div id='askDiv'>
				<select>
					<option>게시판 문의</option>
					<option>기타문의</option>
					<option>또뭐가있을까요</option>
					<option>분명뭐가있을텐디</option>
				</select>
				<div>
					<textarea name='askContent'
						placeholder='&#13;&#10&#13;&#10의견을 남겨주세요. &#13;&#10내용 확인을 위해 연락을 드릴 수 있습니다.&#13;&#10내용 본문에 고객님의 개인정보(주민번호 등)가 포함되지 않도록 주의해주세요.'></textarea>
				</div>
				<div>
					<input type='submit' name='sendContent' value='보내기' />
				</div>
			</div>
		</form>
	</div>
	<div>
		<ul>
			<li class="question">Question 1</li>
			<li class="answer">Answer1</li>
			<li class="question">Question 2</li>
			<li class="answer">Answer2</li>
		</ul>
	</div>
</div>

