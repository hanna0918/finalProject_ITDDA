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
		<form method='post' action="/itda/askSomething">
			<div id='askDiv'>
				<select name='q_category' class='askSelect'>
					<option value='1'>게시판 문의</option>
					<option value='2'>또뭐가있을까요</option>
					<option value='3'>분명뭐가있을텐디</option>
					<option value='4'>기타문의</option>
				</select>
				<div>
					<textarea name='q_title'
						placeholder='&#13;&#10의견을 남겨주세요. &#13;&#10내용 확인을 위해 연락을 드릴 수 있습니다.&#13;&#10내용 본문에 고객님의 개인정보(주민번호 등)가 포함되지 않도록 주의해주세요.'></textarea>
				</div>
				<div>
					<input type='submit' name='sendContent' value='보내기' />
				</div>
			</div>
		</form>
	</div>
	<div>
		<ul>
			<c:forEach var='quesVo' items="${list}">
				<li class="question">
					<div>
						<div>카아테고오리${quesVo.q_category} <input type='hidden' name='q_number' value='${quesVo.q_number}'></div>
						<div>문의내용<br/>${quesVo.q_title}</div>
						<div>작성일 ${quesVo.q_date}</div>
					</div>
				</li>
				
				<c:if test="${quesVo.q_result_state eq 1}">
					<li class="answer">
						<div>
							<div>답변내용<br/>${quesVo.q_result}</div>
							<div>답변일 </div>
						</div>
					</li>
				</c:if>
				<c:choose>
					<c:when test="${quesVo.q_result_state ne 1}">
						<div class="answer">
							<div class="inProgress">아직 처리중입니다.</div>
						</div>
					</c:when>
				</c:choose>
			</c:forEach>
		</ul>
	</div>
</div>
