<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="boardContainer">
  <!-- 게시판제목 -->
  <div class="boardName">
    <p>추천</p>
    <p>모두에게 유용한 정보를 추천해봐요</p>
  </div>
  <!-- 검색창 -->
  <div class="allSearch">
    <form>
      <select name="searchSelec">
        <option>전체</option>
        <option>글제목</option>
        <option>작성자</option>
        <option>내용</option>
        <option>제목+내용</option>
      </select>
      &nbsp; &nbsp; <input type="text" id="search" name="search" placeholder="검색어를 입력하세요" />&nbsp;&nbsp;
      <input type="button" name="searchContent" />
    </form>
  </div>
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
  <div class="chucheonList">
    <form>
      <div class="chucheonContentList">
        <div>100</div>
        <div class="recommendContent">
          <div><img src="https://pbs.twimg.com/profile_images/1164662334888898560/hzpBtULq_400x400.jpg" class="chucheonImg" /></div>
          <div class="">
            <div><a href="/itda/questionView">산에서 곰을 만났을때 어떻게 해야하나요..?</a></div>
            <span>#곰#살려쥬</span>
            <div>
              <img src="img/recommend.png" class="recommendImg" />
              <span>10</span>
              <img src="/img/siren3.png" class="commentImg" />
              <span>10</span>
            </div>
          </div>
        </div>
        <div>
          <div>
            위기탈출넘버원
            <span>(numberone)</span>
          </div>
        </div>
        <div>2021-07-01</div>
        <div>50</div>
        <div>19</div>
        <!-- 추천 리스트 start-------------------------------------------------->
        <c:forEach var="vo" items="${list}">
          <div>${vo.board_seq}</div>
          <div class="recommendContent">
            <div><img src="/itda/img/${vo.i_url}" class="chucheonImg" /></div>
            <div class="">
              <div><a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a></div>
              <span>${vo.board_select}</span>
              <div>
                <img src="img/recommend.png" class="recommendImg" />
                <span>${vo.board_hit}</span>
                <img src="img/siren3.png" class="commentImg" />
                <span>${vo.board_call}</span>
              </div>
            </div>
          </div>
          <div>
            <div>
              ${vo.m_nickname}<br />
              <span>(${vo.m_userid})</span>
            </div>
          </div>
          <div>${vo.board_writedate}</div>
          <div>${vo.board_hit}</div>
          <div>${vo.br_cnt}</div>
        </c:forEach>
        <!-- 추천 리스트 end-------------------------------------------------->
      </div>
    </form>
  </div>

  <!-- 글쓰기 버튼 -->
  <div class="boardBtnDiv">
    <input type="button" value="글쓰기" class="writeBtn recommendBtn" onclick="location.href='/itda/recommendWrite'" />
  </div>
  <!-- 페이지번호 -->
  <div class="pagingDiv">
    <ul>
      <li><a href="#">◁</a></li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">▷</a></li>
    </ul>
  </div>
</div>
