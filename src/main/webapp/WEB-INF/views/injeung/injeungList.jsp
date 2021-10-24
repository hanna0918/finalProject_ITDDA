<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div id='container'>
		<!-- 게시판제목 -->
		<div class="boardName">
		    <h2>HANGOUT</h2>
		    <h4>나의 활동을 인증해보자!</h4>
  		</div>
		<!-- 검색창 -->
		<div id='tagSearchDiv'>
			<input type='text' id='searchTag' name='searchTag' placeholder='&nbsp;#태그를입력하세요!' />
		</div>
		<!-- 컨텐츠 -->
		<div id='pic'>
			<c:forEach var="ivo" items="${list}">
				<div>
					<div onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'><img src='/itda/img/bukhansan.jpg' class='injeungImg' /></div>
					<div>${ivo.board_subject}</div>
					<div><img name='heartIcon' src='/itda/img/recommend4.png' />${ivo.b_goodhit} &nbsp;&nbsp;<img  name='bubbleIcon' src='/itda/img/replImg.png' /> 2</div>
					<div class='injeungContentWriter'><!-- 작성자 -->
						<div><img src='img/circle.png' name='profileShot' /></div>
						<div>
							<div id='injeungWriter'>${ivo.m_nickname}</div>
							<div>
								<ul>
									<li>${ivo.board_writedate }</li>
									<li>조회수 ${ivo.board_hit}</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		<div>
			<div onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'><img src='/itda/img/bukhansan.jpg' class='injeungImg' /></div>
			<div>아줜나춥다아~~~~</div>
			<div><img name='heartIcon' src='/itda/img/recommend4.png' />4&nbsp;&nbsp;<img name='bubbleIcon' src='/itda/img/replImg.png' /> 2</div>
			<div class='injeungContentWriter'>
				<!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div>
				<div>
					<div id='injeungWriter'>집가고싶은애</div>
					<div>
						<ul>
							<li>2020-04-23</li>
							<li>조회수 22</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div>
			<div onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'><img src='/itda/img/bukhansan.jpg' class='injeungImg' /></div>
			<div>아줜나춥다아~~~~</div>
			<div><img name='heartIcon' src='/itda/img/recommend4.png' />4&nbsp;&nbsp;<img name='bubbleIcon' src='/itda/img/replImg.png' /> 2</div>
			<div class='injeungContentWriter'>
				<!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div>
				<div>
					<div id='injeungWriter'>집가고싶은애</div>
					<div>
						<ul>
							<li>2020-04-23</li>
							<li>조회수 22</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div>
			<div onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'><img src='/itda/img/bukhansan.jpg' class='injeungImg' /></div>
			<div>아줜나춥다아~~~~</div>
			<div><img name='heartIcon' src='/itda/img/recommend4.png' />4&nbsp;&nbsp;<img name='bubbleIcon' src='/itda/img/replImg.png' /> 2</div>
			<div class='injeungContentWriter'>
				<!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div>
				<div>
					<div id='injeungWriter'>집가고싶은애</div>
					<div>
						<ul>
							<li>2020-04-23</li>
							<li>조회수 22</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div>
			<div onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'><img src='/itda/img/bukhansan.jpg' class='injeungImg' /></div>
			<div>아줜나춥다아~~~~</div>
			<div><img name='heartIcon' src='/itda/img/recommend4.png' />4&nbsp;&nbsp;<img name='bubbleIcon' src='/itda/img/replImg.png' /> 2</div>
			<div class='injeungContentWriter'>
				<!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div>
				<div>
					<div id='injeungWriter'>집가고싶은애</div>
					<div>
						<ul>
							<li>2020-04-23</li>
							<li>조회수 22</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>
		<!-- 글쓰기 버튼 -->
		<div class='boardBtnDiv'>
			<input type='button' name='writeBtn' class='writeBtn' value='글쓰기' onclick='location.href="/itda/writeInjeung"'/>
		</div>
		<!-- 페이지 -->
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
