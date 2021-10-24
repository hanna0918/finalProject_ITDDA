<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>

<script>


</script>
 
  <div class="TopContent">
    <div class="TopSubContent">
      <div>회원관리</div>

    <div style="text-align: right; ">
    <form action="#" method="post">
      <select name="MemberSelect" id="MemberSelect">
        <option value="이름">이름</option>
        <option value="아이디">아이디</option>
      </select>
      <input type="text" id="MemberSerch" name="MemberSerch">
      <input type="submit" value="찾기"/>
    </form>
    </div>
  </div>

  <div class="MainContent">
      <div style=" background-color: blanchedalmond; width:100%; height: 90%;">
        <ul id="MemberList">
          <li></li>
          <li>아이디</li>
          <li>이름</li>
          <li>별명</li>
          <li>전화번호</li>
          <li>가입일자</li>
          <li>게시글</li>
          <li>활동상태</li>
          <li> </li>
          <br>
 
	  <c:forEach items="${list}" var="list">
	  	<li> ${list.m_seq}</li>
        <li> ${list.m_userid }</li>
        <li> ${list.m_username }</li>
        <li> ${list.m_nickname }</li>
        <li> ${list.m_tel }</li>
        <li> ${list.m_regdate }</li>
        <li> ${list.board_seq }</li>
        <li> ${list.m_state }</li>
        <li class="AdminMember" name="${list.m_seq}"/>회원관리</li>
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
  </div>

  <!-- 모달창... style=" visibility: hidden; -->
  <div class="AdminInsertModal">
    <div class="modalOverlay"></div>
    <article class="AdminMemberModal">
    <div id="test">
    </div>
    </article>
  </div>

<script type="text/javascript" src="js/admin.js"></script>