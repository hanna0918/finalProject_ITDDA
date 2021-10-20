<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
  


  <div class="TopContent">
    <div class="TopContent">
      <div class="TopSubContent">게시판관리</div>
      <div style="text-align: right; ">
        <form action="#" method="post">
          <select name="MemberSelect" id="MemberSelect">
            <option value="이름">카테고리</option>
            <option value="아이디">글쓴이</option>
            <option value="아이디">조회수</option>
          </select>
          <input type="text" id="MemberSerch" name="MemberSerch">
          <input type="submit" value="찾기"/>
        </form>
      </div>

    </div>



  </div>
  <div class="MainContent">
    <div style=" background-color: blanchedalmond; width:100%; height: 90%;">
          <hr>
          <ul id="BoardView">
            <li>순번</li>
            <li>카테고리</li>
            <li>제목</li>
            <li>글쓴이</li>
            <li>조회수</li>
            <li>등록일</li>
            <li>버튼</li>
            <br>
            <!-- 데이터내용-->
            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>

            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>
            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>
            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>
            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>
            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>

            <li>1</li>
            <li>장터/매칭</li>
            <li>ksc7662<br> asd <br> asd</li>
            <li>권순찬</li>
            <li>100</li>
            <li>2014-03-01</li>
            <li><a href="#" class="AllboardSelect"/>관리</a></li>
            <br>

          </ul>
    </div>
    <div class="AdminBoardButtonBox">
      <ul class="AdminBoardListButton">
        <li><a href="#"><</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">6</a></li>
        <li><a href="#">></a></li>
      </ul>
    </div>
  </div>
  </div>

  <!-- 모달창... -->
  <div class="AllSelectBoardModal">
    <div class="modalOverlay"></div>
    <!-- 수정사항-->
    <article class="BoardModal">
      <h2>페이지 관리</h2>
      <form method="post" action="#">
        <div style="display:none;">게시물 번호</div>
        <div>순번:vo.list</div>
        <div></div>
        <form>
        <div>제목:test 카테고리:vo.cati <br>태그: test<br> 글쓴이:test </div>
          <hr>
          <textarea style="resize: none; width: 450px; height: 200px;" disabled> 글내용:test  </textarea>
          <br>
          <hr>
          <div class="">
          <button style="float: right" type="submit" id="joinCancelBtn"  class="btnBlock"><a>블럭처리</a></button>
        </div>
        </form>
      </form>
    </article>
  </div>