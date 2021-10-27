<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- <link rel="stylesheet" href="writeListCss.css" type="text/css" /> -->
</head>
<style>
@charset "UTF-8";

@font-face {
	font-family: 'IBMPlexSansKR-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body, ul, li, img, a {
	font-family: 'IBMPlexSansKR-Regular';
	margin: 0;
	padding: 0;
	list-style: none;
	color: black;
	text-decoration: none;
}

#writerListDivDiv {
	width:1100px;
	margin: 0 auto;
	overflow: auto;
}

#profileBoxBox, #introDivDiv, #postListList {
	width: 100%;
	overflow: auto; 
	margin-top: 2%;
	margin-bottom: 2%;
}

#introDivDiv>div:first-child {
	width: 15%;
	float: left;
}

#introDivDiv>div:last-child {
	width: 70%;
	box-sizing: border-box;
	margin: 12px;
}

.listList li {
	float: left;
	width: 10%;
	height: 50px;
	line-height: 50px;
	text-align: center;
}

/* .listList li:nth-child(1){
	width:50%;
}
.listList li:nth-child(2){
	width:20%;
}
 */
 
#titleTitle>li:nth-child(1){
    width: 10%;
}

#titleTitle>li:nth-of-type(2), #contentContent>li:nth-of-type(5n+2) {
	width: 50%;
	overflow: hidden;
	text-overflow: ellipsis;
}

#titleTitle>li:nth-of-type(3), #contentContent>li:nth-of-type(5n+3) {
	width: 20%;
}

#pagePage { /*페이지 div*/
	width: 250px;
	height: 50px;
	line-height: 50px;
	margin: 0 auto;
}

#pagePage li { /*페이지 1,2,3,4*/
	float: left;
	margin: 10px 10px;
}

#selectCategoryGory{
	border: none;
    font-size: 1em;
    width: 70px;
    text-align: center;
}

#viewBoardSubject{
	width:50%;
}
#viewBoardwritedate{
	width:20%;
}


#writeListTitleName{

	text-align: center;
    font-size: 1.5em;
    font-family: cursive;
    color: white;
    line-height: 80px;
 
    background-color: rgba(236,104,39, 1);
    content: ' ';
    display: block;
    height: 80px;
    width: 100%;
    left: 7px;
    bottom: 4px;
    /* opacity: 0.5; */
    transition: all 0.3s ease-out;
    z-index: 1000;
    margin-top: 0px;
    margin-bottom: 0px;

}

</style>
<body>

		<div><img src='/itda/img/what is your story.jpg' style="height: 600px; width: 100%;" /></div> <!-- class='injeungImg' -->
	 	<h2 id="writeListTitleName" >${m_nickname}'s STORY BOARD</h2> 
	<div id='writerListDivDiv'>
		<form >
			<div id='profileBoxBox'>
			 <!-- 프로필박스  -->
				<div id='introDivDiv'>
					<div>
						<img src='img/moveprofile.gif' name='profileImg' id='profileImg' style="width:80px; height:80px; border-radius:80px;" />
					</div>
					<div>
					<!-- <input value='"${m_nickname}"'>
					<input value="test= ${m_name}"> -->
					
						<div name="m_nickname">닉네임 : ${m_nickname} 님 </div> <br /> <div name="m_name">등급 : ${m_rank} </div>
					</div>
				</div>
			</div>
			
			<div class='listList'>
				<!-- postList  / list / title-->
				<ul id='titleTitle'>
					<li><select id='selectCategoryGory'>
							<option>전체</option>
							<option>추천</option>
							<option>매칭</option>
							<option>장터</option>
							<option>자유</option>
							<option>Q&A</option>
					</select></li>
					
					<li>제목</li>
					<li>등록일</li>
					<li>조회수</li>
					<li>댓글수</li>
				</ul>
				<hr />
			</div>

			<div class='listList'>
				<ul class='contentContent'>
					<c:forEach var="vo" items="${list}">
						<li class='selectListList' id="#viewBoardcode">${vo.board_seq}</li>
						<!--selectLi-->  
						<!-- 게시글보기 제목 클릭시 각 게시판 내용보기로 이동  -->
						<c:choose> 
						
							<c:when test="${vo.board_code==1 }">
							<li id="viewBoardSubject"><a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
							</c:when>
							
							<c:when test="${vo.board_code==2 }">
							<li id="viewBoardSubject"><a href="/itda/matchingView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
							</c:when>
							
							<c:when test="${vo.board_code==3 }">
							<li id="viewBoardSubject"><a href="/itda/injeungView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
							</c:when>
							
							<c:when test="${vo.board_code==5 }">
							<li id="viewBoardSubject"><a href="/itda/freeview?board_seq=${vo.board_seq}&board_code=${vo.board_code}">${vo.board_subject}</a></li>
							</c:when>
							
							<c:when test="${vo.board_code==6 }">
							<li id="viewBoardSubject"><a href="/itda/questionView?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
							</c:when>
							
						</c:choose>
						<li id="viewBoardwritedate">${vo.board_writedate}</li>
						<li id="viewBoardHit">${vo.board_hit}</li>
						<li id="viewGoodHit">${vo.b_goodhit}</li>
					</c:forEach>
				</ul>
			</div>
		
			<div>
				<div id='pagePage'>
					<ul>
						<li><a href='#'>＜</a></li>
						<li><a href='#'>1</a></li>
						<li><a href='#'>2</a></li>
						<li><a href='#'>3</a></li>
						<li><a href='#'>4</a></li>
						<li><a href='#'>5</a></li>
						<li><a href='#'>＞</a></li>
					</ul>
				</div>
			</div>

		</form>
	</div>
</body>
</html>
<script>
/* function writtenView(nickname){
	
$.ajax({ /////////////////////////////////3
    url:'/itda/freeBoardWriteView', 
    data: nickname1,
    type: 'POST',
    success: function (result) { ///////////////////4
      var result = $(result);
      console.log(result);
      var tag = "";
      
      tag += `<form>`;
	      tag += `<div id='profileBoxBox'>`;
	      	tag += ` <div id='introDivDiv'>` ;
	        	tag += "<div>" +" 닉네임 : "+ result[0].m_nickname + "님"+ "</div>";
	        	  tag += "<div>" +" 등급 : " + result[0].m_name + "</div>";
	      	tag += `</div>`;
	      tag += `</div>`;    
      tag += `</form>`;  
      
      
      tag += `<form>`;
      	tag += `<div class='listList'>`;
      		tag +=`<ul class='contentContent'>`;
      		//document.getElementById("#viewBoardcode").
      		
      	$.each(result, function(index, item){
    	
      		$(#viewBoardSeq).val(item.board_seq);
      		$(#viewBoardcode).val(item.board_code);
      		$(#viewBoardSubject).val(item.board_subject);
      		$(#viewBoardwritedate).val(item.board_writedate);
      		$(#viewBoardHit).val(item.board_hit);
      	} 
      		
      	document.getElementById("#viewBoardSeq").value = result[0].board_seq;
      	document.getElementById("#viewBoardcode").value = result[0].board_code;
      	document.getElementById("#viewBoardSubject").value = result[0].board_subject;
      	document.getElementById("#viewBoardwritedate").value = result[0].board_writedate;
      	document.getElementById("#viewBoardHit").value = result[0].board_hit;
      
      		tag += `</ul>`; 
      	tag += `</div>`; 
      tag += `</form>`; 
} */

</script>