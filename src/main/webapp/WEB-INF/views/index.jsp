<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/itda/css/matchingList.css?version=indexpage" />
<section class="videoMain">
  <div>
    <video autoplay muted loop id="myVideo" height="1200">
      <source src="/itda/video/itda.mp4" type="video/mp4" />
    </video>
  </div>
</section>

<!-- 매칭 게시판-------------------------------------------------->
<div style="margin: 0 auto; width: 1200px; margin-top: 60px; margin-bottom: 30px;" >
  <h1><a href="/itda/matchingList" style="font-weight:bold;">MATCHING BOARD</a></h1>
</div>
<section id="matchingSection" style="width: 1200px; margin: 0 auto; overflow: auto">
  <c:forEach var="vo_mc" items="${list_MC}" begin="0" end="3">
    <div class="matchingBox" id="matchingBox">
      <div class="photo">
        <a href="/itda/matchingView?board_seq=${vo_mc.board_seq}"> ${vo_mc.thumbImg} alt="매칭1" width="100%" /></a>
        <div class="endSoon"><c:if test="${vo_mc.mc_state==1}">비정기매칭</c:if><c:if test="${vo_mc.mc_state==2}">정기매칭</c:if></div>
      </div>
      <div class="writer">${vo_mc.m_userid }</div>
      <div class="hashTag">
        <c:forEach var="tag" items="${vo_mc.tags}">#${tag} </c:forEach>
      </div>
      <div>
        <div>
          <div class="where">${vo_mc.mc_where}</div>
          <div class="matchingDate">${vo_mc.mc_start_date}</div>
        </div>
        <div class="matchingStatus">${vo_mc.matchingCount} / ${vo_mc.mc_max}</div>
      </div>
    </div>
  </c:forEach>
</section>


<!-- 인증 게시판--------------------------------------------------------------->
<div style="margin: 0 auto; width: 1200px; margin-top: 60px; margin-bottom: 30px;" >
  <h1><a href="/itda/injeungList" style="font-weight:bold;" >HANGOUT BOARD</a></h1>
</div>
<section class="matchingBoard">
	<div id='pic'>
		<c:forEach var="ivo" items="${list_ij}" begin="0" end="3" >
			<div>
				<div
					onclick='location.href="/itda/injeungView?board_seq=${ivo.board_seq}"'>
					${ivo.thumbImg} class='injeungImg'/></div>
				<div>${ivo.board_subject}</div>
				<div>
					<span class="injeungTag">${vo.board_select}#태그#태그</span>
				</div>
				<div>
					<img name='goodhit' src='/itda/img/goodHit.png' />${ivo.b_goodhit}&nbsp;&nbsp;<img name='bubbleIcon' src='/itda/img/replImg.png' />
					${ivo.br_count }
				</div>
				<div class='injeungContentWriter'>
					<!-- 작성자 -->
					<div>
						<img src='img/circle.png' name='profileShot' />
					</div>
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
	</div>
</section>


<!-- 추천 게시판==================================================================== -->
<div style="margin: 0 auto; width: 1200px; margin-top: 60px; margin-bottom: 30px;" >
  <h1><a href="/itda/recommendList" style="font-weight:bold;">RECOMMEND BOARD</a></h1>
</div>
<section class="recommendBoard">
  <div>
    <form>
      <div class="chucheonList">
        <!-- 추천 리스트 start-------------------------------------------------->
        <c:forEach var="vo" items="${list_RC}" begin="0" end="4">
          <div>${vo.board_seq}</div>
          <div class="recommendContent">
            <div>${vo.thumbImg} style="width: 120px;" class="chucheonImg" /></div>
            <div class="contentInfo">
              <!-- 2 -->
              <div>
                <a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a>
              </div>
              <span class="tagspan"><c:forEach var="tag" items="${vo.tags}">#${tag} </c:forEach></span>
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
    </form>
  </div>
</section>


