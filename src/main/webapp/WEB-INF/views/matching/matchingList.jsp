<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/itda/css/matchingList.css?version=333">
<link href='/itda/fullcalendar/main.css' rel='stylesheet' />
<script src='/itda/fullcalendar/main.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<div id="matchingFrame">
	<header>
	<div class="boardName">
	    <h2>MATCHING</h2>
	    <h4>나와 다른사람을 이어보세요!</h4>
  	</div>
		<div id="searchAndCalendar">
			<form method="post" id="tagTranfer" onsubmit="return false">
				<div>
					<input type="text" name="searchText" id="searchText"/>
				</div>
				<div id="addTag">
					<div id="hiddenTag0" style="display: none;"></div>
					<div id="hiddenTag1" style="display: none;"></div>
					<div id="hiddenTag2" style="display: none;"></div>
					<div id="hiddenTag3" style="display: none;"></div>
					<div id="hiddenTag4" style="display: none;"></div>
				</div>
				<a class="button" id="calendarBtn">달력</a>
			<div id="selectedDateDiv" style="display: none;"></div>
			</form>
		</div>
	</header>
	<section>
		<header>
			<div id="sortByGroup">
				<ul id="viewByGroup">
					<li id='frequency0'>모두보기</li>
					<li>/</li>
					<li id='frequency1'>일회모임</li>
					<li>/</li>
					<li id='frequency2'>정기모임</li>
				</ul>
				<ul id="viewByTime">
					<li id='listup0'>최근 등록순</li>
					<li>/</li>
					<li id='listup1'>가까운 시일</li>
				</ul>
			</div>
		</header>
			<div id='calendar' style="visibility: hidden;"></div>
		<section id="matchingSection">
			<c:forEach var="vo" items="${list}">
				<a href="/itda/matchingView?board_seq=${vo.board_seq}"><div class="matchingBox" id="matchingBox">
						<div class="photo">
							<img src="/itda/img/quoka.png" alt="매칭1" width="100%" />
							<div class="endSoon"><c:if test='${vo.mc_state==1}'>비정기매칭</c:if><c:if test='${vo.mc_state==2}'>정기매칭</c:if></div>
						</div>
						<div class="hashTag">
							<c:forEach var="tag" items="${vo.tags}">#${tag} </c:forEach>
						</div>
						<div class="where">${vo.mc_where}</div>
						<div class="writer">${vo.m_userid }</div>
						<div class="matchingDate">${vo.mc_start_date}</div>
						<div class="matchingStatus">${vo.matchingCount} / ${vo.mc_max}</div>
					</div></a>
			</c:forEach>
		</section>
<!-- 페이징 -->
<div>
	<ul class='pagination' id='matchingPagingUl'>
		<c:if test="${pVo.nowPage>1}">
	    	<li class='page-item'><a href="javascript:matchingPaging(${pVo.nowPage-1})" class='page-link'>Prev</a></li>
	    </c:if>
		<c:if test="${pVo.nowPage==1 }">
			<li class='page-item'><a class='page-link'>Prev</a></li>
		</c:if>
		<c:forEach var="i" begin="${pVo.startPage}" end="${pVo.startPage+pVo.onePageNumCount-1}">
			<c:if test="${i<=pVo.totalPage}">
				<c:if test="${i==pVo.nowPage}">
					<li class='page-item' id="activePage">
				</c:if>
				<c:if test="${i!=pVo.nowPage}">
					<li class='page-item'>
	    		</c:if>
	    		<a href="javascript:matchingPaging(${i})">${i}</a></li>
	    	</c:if>
		</c:forEach>
		<c:if test="${pVo.nowPage<pVo.totalPage}">
	    	<li class='page-item'><a href="javascript:matchingPaging(${pVo.nowPage+1})">Next</a></li>
	    </c:if>
	</ul>
</div>
	<c:if test='${logseq!=null}'>
		<a href="/itda/matchingUpload" class="button" id="calendarBtn" id="matchingUploadBtn">글쓰기</a>
	</c:if>
	</section>
</div>
<script src="/itda/js/matchingList.js?version=333333333333333333333333333333333333"></script>