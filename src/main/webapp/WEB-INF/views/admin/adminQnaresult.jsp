<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>

 <div class="TopContent">
    <div class="TopSubContent">
      <div>
        <div>1:1 wait 문의확인</div>
 	    <div style="text-align: right;">
 	    <a style="font-size:20px;" href="adminQnawait">wait처리 문의</a>
 	    <a style="font-size:20px; margin-left: 20px; font-weight: bold;" href="adminQnaresult">wa처리 완료</a></div>
    </div>
 </div>
 </div>
   <div class="MainContent">
    <div style= "width:100%; height:100%;">
      <div class="QnaRightBox">
      <br>
      <div class="QnaBoardContent">
        <ul id="QnaList">
          <li>NO</li>
          <li>문의내용</li>
          <li>문의자</li>
		  <li>상태</li>	
		
 		<c:forEach items="${list}" var="Question">
          <li>${Question.q_number}</li>
          <li style="text-align: left;" class="AdminQnaresult" name="${Question.q_number}">${Question.q_title}</li>
          <li>${Question.m_nickname}</li>
          <li>처리완료</li>
         <br>
         </c:forEach>
        </ul>
      </div>

      <div class="QnaButtonBox">
        <ul class="QnaButton">
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
  </div>

  <div class="AdminSendQnqModal">
    <div class="modalOverlay"></div>
    <!-- 약관동의 창 -->
    <article class="AdminQnqModal">
    <div id="resultmodal">asdasd </div>
       
        
        <br>
    </article>
  </div>