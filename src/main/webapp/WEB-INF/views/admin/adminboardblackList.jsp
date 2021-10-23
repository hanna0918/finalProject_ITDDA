<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>
$(document).ready(function(){

	$('.BlackboardSelect').click(function () {
	    $('.BlackBoardSelectModal').css('display', 'block'); //모든 게시판 모달 뛰우기
	    var seq =$(this).attr("name");
	   	const seqnumber = "m_seq=" + parseInt(seq);
	    console.log(seq);
	    $.ajax({
	    	url:'/itda/BlackBoardBlackView',
	    	data: seqnumber,
	    	type: 'POST',
	    	success: function(result){
	    		console.log("성공");
	    		var result = $(result);
	    		console.log(result);
	    		var tag="";
	    		tag+="<h2 style='text-align:center;'>블럭게시판 관리</h2>";
	    		tag+=`<form method="post" id="form" action="/itda/BlockBoardUpdate">`;
	    		tag+="<div style='float:left display: inline-block;'>"+"제목:"+result[0].board_subject+"<br>"+"카테고리:"+result[0].board_select+"</div>";
	    		tag+="<div style='display: inline-block;'>"+"글쓴이:"+result[0].m_nickname+"</div>";
	    		tag+="<br>";
	    		tag+="<textarea style='resize: none; width: 450px; height: 200px;' disabled>"+ "글내용:"+result[0].b_content+"</textarea>";
	    		tag+="<hr>";
				tag+="<h2 style='text-align:center;'>블럭 사유</h2>";
				tag+="<textarea style='resize: none; width: 450px; height: 50px;' disabled>"+result[0].board_blockcontent+"</textarea>";
				tag+="<input type='hidden' name='board_seq' value='"+result[0].board_seq+"'/>";
				tag+="<input type='hidden' name='board_block' value='2'/>";
				tag+="<input type='hidden' name='board_blockcontent' value='처리해지'/>";
				
				tag+="<input type='button' id='block' style='margin-left:130px;  width: 200px; height: 50px;'value='블럭해지'>"+"</tag>";//1
				tag+=`</form>`;
				
	    	    /* $('#blackshow').html(tag); */
 		}, error: function(){
	    		console.log("왜 실패하니 너는?");
	    	}
	    });
	});
	
	$(document).on('click','#block',function () {
   	 $("#board_block").val(2);
   	 document.getElementById("form").submit();
    });
    
	
	$('.modalOverlay').click(function () {
		 $('.BlackBoardSelectModal').css('display', 'none');
		 console.log("모달 밖에 눌림");
		 
	});
	$('.check').click(function () {
		console.log("모달 밖에 눌림12321");
	});
});
});
</script>
  <div class="TopContent">
    <div class="TopSubContent">블럭게시판관리</div>
  </div>
  <div class="MainContent">
    <div style=" background-color: blanchedalmond; width:100%; height: 90%;">
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
  </div>

  <!-- 모달창... -->
  <div class="BlackBoardSelectModal">
    <div class="modalOverlay"></div>
    <!-- 수정사항-->
    <article class="BlackModal">
    <div id="blackshow"></div>
    
    </article>
  </div>