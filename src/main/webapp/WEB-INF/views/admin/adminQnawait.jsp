<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>

</script>
  <div class="TopContent">
    <div class="TopSubContent">
      <div>
        <div>1:1 wait 문의확인</div>
 	    <div style="text-align:right; margin-top:50px;">
	 	    <a style="font-size:17px; font-weight: bold; color:#ec6827;" href="adminQnawait">wait처리 문의</a>
	 	    <a style="font-size:17px; margin-left: 20px;" href="adminQnaresult">wait처리 완료</a></div>
	    </div>
 	</div>
 </div>
<div class="MainContent">
	<div style="width: 100%; overflow:auto; margin-top:10px;">
		<div class="QnaRightBox">
			<div class="QnaBoardContent">
				<ul class="QnaListTitle">
					<li>NO</li>
					<li>문의내용</li>
					<li>문의자</li>
					<li>등록일</li>
				</ul>
				<ul id="QnaList">
					<c:forEach items="${list}" var="Question">
						<li>${Question.q_number}</li>
						<li style="text-align: left;" class="AdminQna"
							name="${Question.q_number}">${Question.q_title}</li>
						<li>${Question.m_nickname}</li>
						<li>${Question.q_date}</li>
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
</div>

<div class="AdminSendQnqModal">
    <div class="modalOverlay"></div>
    <!-- 약관동의 창 -->
    <article class="AdminQnqModal">
    <div id="waitmodal"> </div>
    
       
        
        <br>
    </article>
  </div>