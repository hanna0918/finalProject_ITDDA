<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
<script>
var testdate = "";
var form = "";
$(document).ready(function () {
  $(".BoardBlack").click(function () {
    $(".CallBoardModalTest").css("display", "block"); //신고 게시물 모달
    var test = $(this).attr("name");
    const testInt = "m_seq=" + parseInt(test);
    console.log(testInt);
    $.ajax({
      url: "/itda/CallBoardBlackView",
      data: testInt,
      type: "POST",
      success: function (result) {
        var result = $(result);
        console.log(result);
        var tag = "";
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

        console.log(tag);
        $("#update").html(tag);
        console.log(tag);
      },
      error: function () {
        console.log("싰빠이");
      },
    });

    $(document).on("click", "#block", function () {
      $("#board_block").val(1);
      document.getElementById("form").submit();
    });

    $(document).on("click", "#check", function () {
      $("#board_block").val(2);
      document.getElementById("form").submit();
    });
  });

  $(".modalOverlay").click(function () {
    $(".CallBoardModalTest").css("display", "none");
  });
});

</script>
  <div class="TopContent">
    <div class="TopSubContent">신고 게시판</div>
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
            <li>버튼</li>
            <br>
            <!-- 데이터내용-->
            
            <c:forEach items="${list}" var="call">
              <li>${call.board_seq}</li>
              <li>${call.board_content}</li>
              <li style="overflow:hidden;"> ${call.board_subject} <br> ${call.b_content} </li>
              <li>${call.m_nickname}</li>
              <li>${call.board_call}</li>
              <li>${call.board_writedate}</li>
              <li class="BoardBlack" name="${call.board_seq}">관리</li>
              <br>
          	</c:forEach>
          	<!-- 데이터내용 end-->
            
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
  

 <!--  <!-- 모달창... -->
  <div class="CallBoardModalTest">
    <div class="modalOverlay"></div>
    수정사항
    <article class="BoardModal">
    <div id="update"></div>

     <h2>페이지 관리</h2>
       
    </article> 
  </div> -->

