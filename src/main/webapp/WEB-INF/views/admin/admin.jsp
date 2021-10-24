<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>
$(document).ready(function(){
    tag += `<h2>페이지 관리</h2>`;
    tag += "<div style='float:left display: inline-block;'>" + "제목:" + result[0].board_subject + "<br>" + "카테고리:" + result[0].board_select + "</div>";
    tag += "<div style='display: inline-block;'>" + "글쓴이:" + result[0].m_nickname + "</div>";
    tag += "<br>";
    tag += "<textarea style='resize: none; width: 450px; height: 200px;' disabled>" + "글내용:" + result[0].b_content + "</textarea>";
    tag += "<hr>";
    tag += "<br>";
    tag += `<form method="post" id="form" action="/itda/CallBoardUpdate">`;
    tag += "<input type='text' style='resize: none; width: 450px; height: 100px;'name='board_blockcontent' placeholder='블럭사유'>" + "</input>";
    tag += "<br>";
    tag += "<input type='hidden' name='board_seq' value='" + result[0].board_seq + "'/>";
    tag += "<input type='hidden' id='board_block' name='board_block' value='" + testdate + "'/>";

    //--
    tag += "<input type='button' id='block' name='board_block' style='text-align:center; width: 200px; height: 50px;'value='블럭처리하기'>" + "</tag>"; //1
    tag += "<input type='button' id='check' style='text-align: center; width: 200px; height: 50px;'value='확인처리'>" + "</tag>"; //2
    tag += `</form>`;
    
    tag +=`<div> <label class="Modallabel"> 아이디:</label> <input class="ModalInput" type="text" name="M_UserId" id="M_UserId" disabled value="${result[0].m_userid}"/></div>  </div> <br>`;
	
    <%--   <h2>처리 완료</h2>
    <div>게시물번호 : 1</div>
    <div>글쓴이:권순찬</div>
    <div>등록일 : 2014-03-02</div>
    <hr>
    <div style="overflow-y: scroll; width:450px; height: 150px; margin: 0 auto">
      내용:${content}내용:내용:${content}:${content}내용tent}내용:${content}내용:${content}tent}내용:${content}내용:${content}tent}내용:${content}내용:${content}tent}내용:${content}내용:${content}tent}내용:${content}내용:${content}
    </div>
    <hr>
      <div style="text-align:center;">답변처리</div><br>
    <textarea style='resize: none; width: 450px; height: 50px;'/>
 	
  --%>
});
</script>
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
    </article>
  </div>