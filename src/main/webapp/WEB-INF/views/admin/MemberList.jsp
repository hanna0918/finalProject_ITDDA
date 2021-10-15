<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>


  <script defer type="text/javascript" src="js/Admin.js"></script>



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
          <li>순번</li>
          <li>아이디</li>
          <li>닉네임</li>
          <li>전화번호</li>
          <li>게시물 수</li>
          <li>활동상태</li>
          <li>등급</li>
          <li>매너점수</li>
          <li> </li>
          <br>

	  <c:forEach items="${list}" var="list">
	  	<li> ${list.m_seq}</li>
        <li> ${list.m_username }</li>
        <li> ${list.m_nickname }</li>
        <li> ${list.m_tel }</li>
        <li> ${list.m_content }</li>
        <li> test</li>
        <li> test</li>
        <li> test</li>
        <li class="AdminMember" name="${list.m_seq}"/>회원 관리</li>
		<br>
      </c:forEach>
        </ul>
      </div>
    <div class="MemberListButtonBox">
      <ul class="MemberListButton">
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
  <script type="text/javascript">
  
  
  </script>
  
  <!-- 모달창... style=" visibility: hidden; -->
  <div class="AdminInsertModal">
  	<div class="modal">
    <div class="modalOverlay"></div>
    <article class="AdminMemberModal">
    <div id="test">
      <h2>회원 수정</h2>   
      <form method="get">
      <p id="M_seq" name="M_seq">asdf<p>
        <div>
          <label class="Modallabel"> 아이디:</label>
          <input class="ModalInput" type='text' name='M_UserId' id='M_UserId'disabled value="데이터들어갈곳"/>
        </div>
        <br>
      
        <div>
         <label class="Modallabel">닉네임:</label>
         <input class="ModalInput" type='text' name='M_NickName' id='M_NickName' value="데이터들어갈곳"disabled/>
        </div>
        <br>

        <div>
          <label class="Modallabel"> 활동상태:</label>
          <select class="Modalselect" name="M_StateCode" id="M_StateCode" value="양호(현재데이터들어갈곳)">
            <option value="정지">양호</option>
            <option value="양호">정지</option>
          </select>
        </div>
        <br>

        <div>
          <label class="Modallabel"> 회원등급:</label>
          <select class="Modalselect" name="M_rank" id="M_rank" value="ㅁㄴㅇㄹ">
           <option value="골드"selected>db값</option>
            <option value="골드">실버</option>
            <option value="실버">골드</option>
            <option value="브론즈">브론즈</option>
            <option value="관리자">관리자</option>
          </select>
        </div>
        <br>

        <div>
          <label class="Modallabel">가입일자:</label>
          <input class="ModalInput" name='M_REGDATE' id='M_REGDATE' value="데이터들어갈곳" disabled/>
        </div>
        <br>

        <div class="">
          <button type="submit" id="joinCancelBtn"  class="btnBlock"><a>수정</a></button>
        </div>
      </form>
      </div>
    </article>
    </div>
  </div>
