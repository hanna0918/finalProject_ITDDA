<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>

  <div class="TopContent">
    <div class="TopSubContent">
      <div>1:1 문의확인</div></div>
    </div>
    
  <div class="MainContent">
     <br>
        <div class="QnaBoardContent">
          <ul id="QnaList">
            <li>NO</li>
            <li>문의내용</li>
            <li>문의자</li>
            <li>등록일</li>

            <li>1</li>
            <li> </li>
            <li>권순찬</li>
            <li>2014-03-01</li>

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
  <div class="BlackBoardSelectModal">
    <div class="modalOverlay"></div>
    <!-- 수정사항-->
    <article class="BlackModal">
    <div id="blackshow">a</div>
     <!--  <h2>페이지 관리</h2>
      <form method="post" action="#">
        <div style="display:none;">게시물 번호</div>
        <div>순번:vo.list</div>
        <div></div>
        <form>
        <div>제목:test 카테고리:vo.cati <br>태그: test<br> 글쓴이:test </div>
          <hr>
          <textarea style="resize: none; width: 450px; height: 200px;" disabled> 글내용:test  </textarea>
          <br>
          <div>정지사유: 위배된 노출을 사용하여서 블럭처리함</div>
          <hr>
          <div class="">
          <button style="float: right" type="submit" id="joinCancelBtn"  class="btnBlock"><a> 블럭해지</a></button>
        </div>
        </form>
      </form> -->
    </article>
  </div>