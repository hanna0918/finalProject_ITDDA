<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div class='boardContainer'>
		<!-- 게시판제목 -->
		<h1>추천</h1>
		<!-- 검색창 -->
		<div class='allSearch'>
			<form>
				<select name='searchSelec'>
					<option>전체</option>
					<option>글제목</option>
					<option>작성자</option>
					<option>내용</option>
					<option>제목+내용</option>
				</select> &nbsp; &nbsp; <input type='text' id='search' name='search' placeholder='검색어를 입력하세요' />&nbsp;&nbsp;
										<input type='button' name='searchContent'/>
			</form>
		</div>
		<!-- 인증게시판/QnA 리스트 -->
		<div class='boardList'>
			<ul id='chucheonTitle'>
				<li>NO</li>
				<li>제목</li>
				<li>작성자</li>
				<li>등록일</li>
				<li>조회수</li>
				<li>댓글수</li>
			</ul>
			<hr/>
		</div>	
		<div class='chucheonList'>
			<form>
				<div class='chucheonContent'>
					<div>100</div>
					<div><img src='https://pbs.twimg.com/profile_images/1164662334888898560/hzpBtULq_400x400.jpg' id='chucheonImg'></div>
					<div>
						<div><a href='/itda/questionView'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></div>
						<span>#곰#살려쥬</span>
					</div>
					<div>
						<div>위기탈출넘버원</div>
						<div><span>(numberone)</span></div>
					</div>
					<div>2021-07-01</div>
					<div>50</div>
					<div>19</div>
				</div>
			</form>
		</div>
		
		<!-- 글쓰기 버튼 -->
		<div class='boardBtnDiv'>
			<input type='submit' value='글쓰기' class='writeBtn'/>
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
