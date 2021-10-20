<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div id='container'>
		<!-- 게시판제목 -->
		<h2>인증게시판</h2>
		<!-- 검색창 -->
		<div id='searchDiv'>
			<input type='text' id='searchTag' name='searchTag' placeholder='&nbsp;#태그를입력하세요!' />
		</div>
		<!-- 컨텐츠 -->
		<div id='pic'>
			<div>
				<div onclick='location.href="/itda/injeungView"'><img src='../img/20210905.jpg' class='mainImg' /></div>
				<div>북한산뷰맛집-----------------------------</div>
				<div><img name='heartIcon' src='https://cdn-icons-png.flaticon.com/512/812/812327.png' />10 &nbsp;&nbsp;<img  name='bubbleIcon' src='../img/talk.png' />2</div>
				<div class='injeungContentWriter'><!-- 작성자 -->
					<div><img src='img/circle.png' name='profileShot' /></div>
					<div>
						<div id='injeungWriter'>내가순찬</div>
						<div>
							<ul>
								<li>2021-09-18</li>
								<li>조회수 18</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 글쓰기 버튼 -->
		<div class='boardBtnDiv'>
			<input type='button' name='writeBtn' value='글쓰기' />
		</div>
		<!-- 페이지 -->
		<div class='pagingDiv'>
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
