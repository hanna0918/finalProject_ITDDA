<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="/itda/css/matchingList.css?version=2">
<link href='/itda/fullcalendar/main.css' rel='stylesheet' />
<script src='/itda/fullcalendar/main.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<div id="matchingFrame">
	<header>
		<div id="searchAndCalendar">
			<form method="post" id="tagTranfer" action="<%=request.getContextPath()%>/matchingList">
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
				<a href="#" class="button" id="calendarBtn">달력</a>
			<div id="selectedDateDiv" style="display: none;"></div>
			</form>
		</div>
	</header>
	<section>
		<header>
			<div id="sortByGroup">
				<ul id="viewByGroup">
					<li id='allGroup'>모두보기</li>
					<li>/</li>
					<li id='once'>일회모임</li>
					<li>/</li>
					<li id='regular'>정기모임</li>
				</ul>
				<ul id="viewByTime">
					<li id='recentTime'>최근 등록순</li>
					<li>/</li>
					<li id='soonTime'>가까운 시일</li>
				</ul>
			</div>
		</header>
			<div id='calendar' style="visibility: hidden;"></div>
		<section id="matchingSection">
			<c:forEach var="vo" items="${list}">
				<a href="/itda/matchingView?b_id=${vo.b_id}"><div class="matchingBox" id="matchingBox">
						<div class="photo">
							<img src="/itda/img/quoka.png" alt="매칭1" width="100%" />
							<div class="endSoon">마감임박</div>
						</div>
						<div class="hashTag">
							<c:forEach var="tag" items="${vo.tags}">#${tag} </c:forEach>
						</div>
						<div class="where">${vo.b_where}</div>
						<div class="writer">${vo.m_userid }</div>
						<div class="matchingDate">${vo.b_matchingdate}</div>
						<div class="matchingStatus">${vo.b_nowpart} / ${vo.b_maxpart}</div>
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
			<li class='page-item'><a href="#" class='page-link'>Prev</a></li>
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
	    	<li class='page-item'><a href="javascript:matchingPaging(${pVo.onePageNumCount+1})">Next</a></li>
	    </c:if>
	</ul>
</div>
		<a href="/itda/matchingUpload" class="button" id="calendarBtn" id="matchingUploadBtn">글쓰기</a>
	</section>
</div>
<script src="/itda/js/matchingList.js?version=333333333333333333333333"></script>