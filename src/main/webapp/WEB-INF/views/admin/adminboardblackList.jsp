<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
  <div class="TopContent">
    <div class="TopSubContent">블럭게시판관리</div>
  </div>
  <div class="MainContent">
    <div style=" width:100%; height: 90%;">
          <hr>
          <ul id="BoardView">
            <li>순번</li>
            <li>카테고리</li>
            <li>제목</li>
            <li>글쓴이</li>
            <li>신고수</li>
            <li>등록일</li>
            <li></li>
            <br>
            <!-- 데이터내용-->
            <c:forEach items="${list}" var="black">
            <li>${black.board_seq}</li>
            <li>${black.board_content}</li>
            <li style="overflow:hidden;">${black.board_subject}</li>
            <li>${black.m_nickname}</li>
            <li>${black.board_hit}</li>
             <li>${black.board_writedate}</li>
            <li class="BlackboardSelect" name="${black.board_seq}"/>관리</li>
              <br>
            </c:forEach>
            
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
  <!-- 모달창... -->
  <div class="BlackBoardSelectModal">
    <div class="modalOverlay"></div>
    <!-- 수정사항-->
    <article class="BlackModal">
    <div id="blackshow"></div>
    
    </article>
  </div>