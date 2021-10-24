<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="boardContainer">
	<!-- 게시판제목 -->
	<!-- 검색창 -->
	<header>
	<div class="boardName">
		<h2>RECOMMEND</h2>
		<h4>모두에게 유용한 정보를 추천해보세요!</h4>
	</div>
		<div id="recommendSerchBox">
			<form method="post" id="tagTranfer" onsubmit="return false">
				<div>
					<input type="text" class="searchText"name="searchText" id="searchText" />
				</div>
				<div id="addTag">
					<div id="hiddenTag0" ></div>
					<div id="hiddenTag1" ></div>
					<div id="hiddenTag2" ></div>
					<div id="hiddenTag3" ></div>
					<div id="hiddenTag4" ></div>
				</div>
			</form>
		</div>
	</header>
	
	
	<!-- 추천 리스트 -->
	<div class="boardList">
		<ul id="chucheonTitle">
			<li>NO</li>
			<li>제목</li>
			<li>작성자</li>
			<li>등록일</li>
			<li>조회수</li>
			<li>댓글수</li>
		</ul>
		<hr />
	</div>
	<div>
		<form>
			<div class="chucheonList">
				<!-- 추천 리스트 start-------------------------------------------------->
				<c:forEach var="vo" items="${list}">
					<div>${vo.board_seq}</div>
					<div class="recommendContent">
						<div>
							<img src="/itda/img/${vo.i_url}" class="chucheonImg" />
						</div>
						<div class="contentInfo"><!-- 2 -->
							<div><a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a></div>
							<span class="tagspan">${vo.board_select}</span>
							<div>
								<div>${vo.m_nickname}</div>
								<div>${vo.board_writedate}</div>
								<div>조회수 ${vo.board_hit}</div>
								<div><img src="img/recommend.png" class="recommendImg" /> <span>${vo.b_goodhit}</span></div>
								<div><img src="img/siren3.png" class="commentImg" /> <span>${vo.board_call}</span></div>
							</div>
						</div>
					</div>
					<!-- 3 -->
					<div><img src="img/replImg.png" class="commentImg" /> ${vo.br_cnt}</div>
				</c:forEach>
			</div>
			<!-- 추천 리스트 end-------------------------------------------------->
		</form>
	</div>

</div>
	<div>
		<!-- 글쓰기 버튼 -->
		<div class="boardBtnDiv">
			<input type="button" value="글쓰기" class="writeBtn recommendBtn" onclick="location.href='/itda/recommendWrite'" />
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
