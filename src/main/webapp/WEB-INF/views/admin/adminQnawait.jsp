<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>

</script>
  <div class="TopContent">
    <div class="TopSubContent">
      <div>
        <div>1:1 문의확인</div>
 	       <div style="text-align: right; ">
  		</div> 
    </div>
 </div>
 </div>
   <div class="MainContent">
    <div style=" background-color: blanchedalmond; width:100%; height: 90%;">
      <div style=" margin-left:600px;text-align: right; display: inline-block; font-size: 20px;"><h3 style="font-weight: 500;">처리대기</h3></div>
      <div style="margin-left:100px; text-align: right; display: inline-block; font-size: 20px;"><strong>처리완료</strong></div>

      <div class="QnaRightBox">
      <br>
      <div class="QnaBoardContent">
        <ul id="QnaList">
          <li>NO</li>
          <li>문의내용</li>
          <li>문의자</li>
          <li>등록일</li>

 		<c:forEach items="${list}" var="Question">
          <li>${Question.q_number}</li>
          <li style="text-align: left;" class="AdminQna" name="${Question.q_number}">${Question.q_title}</li>
          <li>${Question.m_nickname}</li>
          <li>${Question.q_date}</li>
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
    <div id="modal"> </div>
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
       
        
        <br>
    </article>
  </div>