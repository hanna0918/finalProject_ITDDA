<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" 
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" 
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="css/quesCss.css" type="text/css"/>


</head>
<style>
@import url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
@font-face {
    font-family: 'IBMPlexSansKR-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
body{
	font-family: 'IBMPlexSansKR-Regular';
	}
@charset "UTF-8";

	h1{/*제목*/
		margin-left:20px;
	}
	#qNaContainer{/*컨테이너*/
		width:1100px;
		/*background-color:lightblue;*/
		margin:0 auto;
	}
	ul, li{
		margin:0;
		padding:0;
		list-style:none;
	}
	a{
		text-decoration:none;
		color:black;
	}
	a:hover{
		color:#5e83d1;
	}
	span{
		color:blue;
		font-size:0.85em;
	}
	
	#allSearch{/*검색창 div*/
		width: 100%;
	    height: 60px;
		/*background-color:red;*/
	    display: flex;
	    flex-direction: row;
	    justify-content: flex-end;
	}
	select, input[type="text"]{
		height:30px;
		line-height:30px;
	}
	.list li{
		float:left;
		width:10%;
		text-align:center;
	}
	#freeTitle{
		height:40px;
		line-height:40px;
	}
	#freeTitle>li:nth-child(2){
		width:50%;
	}
	.content{
	  height:80px; 
	}
	.content>li:nth-child(1){
		line-height:80px;
	}
	.content>li:nth-child(2){
		width:50%;
		margin-top:20px;
		text-align:left;
		overflow:hidden; 
		text-overflow:ellipsis;
	}
	.content>li:nth-child(3){
		margin-top:20px;
	}
	.content>li:nth-child(4){
		/* line-height:80px; */
	}
	.content>li:nth-child(5){
		line-height:80px;
	}
	.content>li:nth-child(6){
		line-height:80px;
	}
	.list + div{
		width:100%;
		height:20px;
		text-align:right;
	}
	#writeBtn{/*글쓰기 버튼*/
		float:right;
		margin-right:20px;
		width:70px;
		height:30px;
		background-color:#9d9af5;
		color:white;
		border:none;
		border-radius:20px;
		cursor:pointer;
	}
	#page {
		width:100%;
		height:50px;
	}
	#page ul{/*페이지 div*/
		width:250px;
		height:50px;
		line-height:50px;
		margin:0 auto;
	}
	#page li{/*페이지 1,2,3,4*/
		float:left;
		margin:10px 10px;
	}
	
	/*아이디 드롭다운 메뉴*/
	.dropbtn {
	 	
	  border: none;
	  cursor: pointer;
	}
	
	.dropbtn:hover, .dropbtn:focus {
	  background-color: #2980B9;
	}
	
	.dropdown {
	  position: relative;
	  /* display: inline-block; */
	}
	
	.dropdown-content {
	  display: none;
	  position: absolute;
	  left: 70%;
      top: 0px;
	   background-color: #f1f1f1; 
	  min-width: 160px;
	  overflow: auto;
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	  z-index: 1;
	}
	
	.dropdown-content a {
	  text-align:center;
	  color: black;
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	}
	
	.dropdown a:hover {background-color: #ddd;}
	
	.show {display: block;}
	/* ---------------------------------------------*/
	
	/*차단 모달창 , 차단 yes 모달창*/
	.blockJoinModal, .blockJoinModal2, .mailJoinModal, .mailJoinModal2, .gudokJoinModal, .gudokJoinModal2, .profilJoinModal{
	  display: none;
	  position: fixed;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  bottom: 0;
	  overflow-x: hidden;
	  overflow-y: auto;
	  -ms-overflow-style: none;
	}
	.blockJoinModal::-webkit-scrollbar {
	  display: none;
	}
	
	.blockJoinModal2::-webkit-scrollbar {
	  display: none;
	}
	
	.mailJoinModal::-webkit-scrollbar {
	  display: none;
	}
	
	.mailJoinModal2::-webkit-scrollbar {
	  display: none;
	}
	
	.gudokJoinModal::-webkit-scrollbar {
	  display: none;
	}
	
	.gudokJoinModal2::-webkit-scrollbar {
	  display: none;
	}
	
	.profilJoinModal::-webkit-scrollbar {
	  display: none;
	}
	.blockModalContent, .blockModalContent2, .mailModalContent, .mailModalContent2, .gudokModalContent, .gudokModalContent2, .profilModalContent  {
	  position: relative;
	  margin: 0 auto;
	  width: 380px;
	  padding: 20px;
	  background-color: #fafafa;
	  text-align: center;
	  border-radius: 10px;
	 /*  border: 2px solid #666; */
	  overflow-y: auto;
	}
	
	.gudokModalContent{
		width:340px;
	}
	
	.blockDataInputModal , .blockDataInputModal2, .mailDataInputModal, .mailDataInputModal2, .gudokDataInputModal, .gudokDataInputModal2, .profilDataInputModal {
	  display: none;
	  background-color: whitesmoke;
	  box-shadow: 10px 10px 5px lightgrey;
	}
	
	/*차단, 구독하기 확인 버튼 */
	#yesChadan, #yesGudok{
	border-color: white;
    width: 160px;
    height: 50px;
    background-color: cornflowerblue;
    color: white;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    margin-right: 5px;
	}
	
	/*차단, 구독하기 취소버튼*/
	#noChadan, #noGudok{
	border-color: white;
    width: 20;
    width: 160px;
    height: 50px;
    background-color: white;
    color: black;
    /* border: none; */
    border-radius: 10px;
    cursor: pointer;
	}
	
	#yesGudok, #noGudok{
	width:120px;
	}
	
	
	/*쪽지보내기 모달창 */
	
	/* 
	스타일 안먹어서 개별적으로 줌
	.mailInfo>li:nth-child(1){ 받는사람
	text-align: left;
    padding-left: 25px;
	}
	
	.mailInfo>li:nth-child(2){ 내용
	text-align: left;
    padding-left: 25px;
    padding-top: 10px;
	}
	 
	 
	.mailTextarea{
	margin: 5px;
    width: 325px;
    height: 200px;
    resize: none;
    outline-style: none;
    padding: 0;
    border-radius: 3px 3px 0 0;
    font-size: 14px;
    cursor: text;
   	}
   	*/
   	
	/*취소 버튼*/
	#noMail{
	background-color: white;
    width: 160px;
    height: 3o;
    height: 30px;
    border-radius: 5px;
    border: 1px solid lightgray;
    font-weight: 700;
    box-shadow: 1px 1px 0px 0px lightgrey;
	}
	
	/*보내기 버튼*/
   	
   	#yesMail, #profilebtn{
   	background-color: cornflowerblue;
    width: 160px;
    height: 3o;
    height: 30px;
    color: white;
    border-radius: 5px;
    border: 1px solid lightgray;
    font-weight: 700;
    box-shadow: 1px 1px 0px 0px lightgrey;
	}
	
	/*프로필 모달창*/
	
	/*프로필 */
	#profileTop{
	margin: 0 auto;
    margin-bottom: 20px;
  /*   background: beige; */
    border-radius: 30px;
	}
	
	.profileinfo{
	padding: 20px;
    width: -1px;
    background: lightgray;
    border-radius: 30px;
    font-weight:bold;
	}
	
	.profileinfo img{
	width: 100%;
    height: 100%;
    margin: 0 auto;
    border-radius: 50px;
	}
	
	/*인사말 관심분야*/
	#profileHi { 
	margin-top: 10px;
    text-align: left;
    padding-bottom: 10px;
    font-weight: bold;
    
	}
	
	#profileLike{
	margin-top: 10px;
    text-align: left;
    padding-bottom: 10px;
    font-weight: bold;
	}  
	
	.profilFoot input[type="text"]{
	padding-bottom: 20px;
	border: none;
	cursor: text;
	border-radius: 5px;
	height: 30px; 
	line-height: 30px; 
	width: 300px; 
	}
	
</style>

<body>
	<div id='qNaContainer'>
		<!-- 게시판제목 -->
		<h1>아무말 대잔치</h1>
		<!-- 검색창 -->
		<div id='allSearch'>
			<select name='searchSelec'>
				<option>전체</option>
				<option>글제목</option>
				<option>작성자</option>
				<option>내용</option>
				<option>제목+내용</option>
			</select>
			&nbsp; &nbsp; <input type='text' id='search' name='search'/>
		</div>
		<!-- 자유게시판 리스트 -->
		
		<div class='list'>
			<ul id='freeTitle'>
				<li>NO</li>
				<li>제목</li>
				<li>작성자</li>
				<li>등록일</li>
				<li>조회수</li>
				<li>댓글수</li>
			</ul>
			<hr/>
		</div>	
		
		<c:forEach var="vo" items="${list}">
			<div class='list'>
			<ul class='content'> 
				<li>${vo.board_seq}</li>
				<li><a href="/itda/freeview?board_seq=${vo.board_seq}">${vo.board_subject}</a></li>
				<%--  /itda/view?no=${vo.board_seq --%>
				<div class="dropdown">
				<li><a href='#'>${vo.m_userid} </a><br/><label onclick="myFunction(${vo.m_seq})" class="dropbtn" id="dropbtn">${vo.m_userid}</label></li>
					<!-- ---------------------------------------------------------------------- -->
					<div id="myDropdown" class="dropdown-content">
	    				<a id="profil">프로필</a>
	    				<a id="chadan">차단하기</a>
	    				<a id="gudok">구독하기</a>
	    				<a id="sendMail">쪽지보내기</a>
	    				<a href="/itda/writeList">게시글보기</a>
  					</div>
				</div>
				<li>${vo.board_writedate} </li>
				<li>${vo.board_hit}</li>
				<li>0</li>
			</ul>
			</div>
		</c:forEach>
		
		
			
			<!-- 
			 <ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
			<ul class='content'>
				<li>100</li>
				<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?dddddddddddddddddddddddddddddddlllllllllll</a><br/><span><a href='#'>#곰</a><a href='#'>#살려쥬</a></span></li>
				<li><a href='#'>위기탈출넘버원</a><br/><span>(numberone)</span></li>
				<li>2021-07-01</li>
				<li>50</li>
				<li>19</li>
			</ul>
		</div> -->
		
		<!-- 글쓰기 버튼 -->
		<div>
			<a href="/itda/freeboardWrite"><input type='submit' value='글쓰기' id='writeBtn'/></a>
		</div>
		<!-- 페이지번호 -->
		<div id='page'>
			<ul>
				<li><a href='#'>◁</a></li>
				<li><a href='#'>1</a></li>
				<li><a href='#'>2</a></li>
				<li><a href='#'>3</a></li>
				<li><a href='#'>4</a></li>
				<li><a href='#'>5</a></li>
				<li><a href='#'>▷</a></li>
			</ul>
		</div>
		
		<!---------------- 차단 모달창 ------------- -->
		<div class="blockJoinModal" id="blockJoinModal">
				<article class="blockModalContent blockDataInputModal">
					<div>
						
						<h4>차단하면 서로의 게시글을 볼 수 없고, 서로 쪽지도 <br/>보낼 수 없어요.&nbsp; 차단하시겠습니까?</h4>
						<input type="submit" value="네, 차단할래요." id="yesChadan" />
						<input type="button" value="취소" id="noChadan"/>
						
						<a><img src="/itda/img/close1.png" class="close1" 
				        style="position:absolute;top: 10px; right: 17px;"/></a>
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>

		<!--------------차단 yes 모달창-------------> 
		 
		<div class="blockJoinModal2" id="blockJoinModal2">
				<article class="blockModalContent2 blockDataInputModal2" style="width: 300px; padding:0;">
					<div>
						<div style="background: cornflowerblue; height: 25px;"></div>
						<h4>" ${m_userid } "님이 차단되었습니다.</h4>
						
						<a><img src="/itda/img/close1.png" class="close2" 
				        style="position:absolute;top: 0px; right: 1px;;"/></a>
				     
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
		 
		<!-- ----------쪽지보내기 모달창------------------> 
		
		<div class="mailJoinModal" id="mailJoinModal">
				<article class="mailModalContent mailDataInputModal style="box-shadow: 10px 10px 5px lightgrey;" >
					<div>
						<form>
							<h4 style="background:moccasin;" >🍊 쪽지 보내기</h4>
							<a><img src="/itda/img/close1.png" class="close3" 
					        style="position:absolute;top: 10px; right: 16px;;"/></a>
					     	<ul class="mailInfo">
					     		<li style="text-align: left; padding-left: 25px;">받는사람 &nbsp; : &nbsp; ${m_userid}</li>  
					     		<li style="text-align: left; padding-left: 25px; padding-top: 10px;">내용</li>
					     		<textarea class="mailTextarea" title="쪽지 내용을 입력하세요" placeholder="쪽지 내용을 입력하세요" style="margin:5px; width:325px; height:200px; resize:none; outline-style:none; padding:0; border-radius:3px 3px 0 0; font-size:14px; cursor:text">
					     		</textarea>
					     	</ul>
					     		<input type="submit" value="보내기" id="yesMail"/>
					     		<input type="button" value="취소" id="noMail"/>
					        <!-- <div><input type="button" value="확인"/></div> -->
				        </form>
					</div>
				</article>
		</div> 
		 
		<!------------------- 쪽지 전송 yes 모달창-----------------> 
		 
		 	<div class="mailJoinModal2" id="mailJoinModal2">
				<article class="mailModalContent2 mailDataInputModal2" style="width: 315px; padding:0;">
					<div>
						<div style="background: cornflowerblue; height: 25px;"></div>
						<h4><strong>'${m_userid }'</strong>님에게 쪽지가 전송되었습니다 😊</h4>
						
						<a><img src="/itda/img/close1.png" class="close4" 
				        style="position:absolute;top: 0px; right: 1px;;"/></a>
				     
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
		 
		<!-- --------------구독 모달창-------------- -->
		<div class="gudokJoinModal" id="gudokJoinModal">
				<article class="gudokModalContent gudokDataInputModal">
					<div>
						<h4>" ${m_userid }" 님을 구독하시겠습니까?</h4>
						<input type="submit" value="네, 구독할래요." id="yesGudok"  />
						<input type="button" value="취소" id="noGudok" />
						 
						<a><img src="/itda/img/close1.png" class="close5" 
				        style="position:absolute;top: 10px; right: 17px;"/></a>
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
		
		<!-- --------------구독 yes 모달창  ----------->
		<div class="gudokJoinModal2" id="gudokJoinModal2">
				<article class="gudokModalContent2 gudokDataInputModal2" style="width: 300px; padding:0;">
					<div>
						<div style="background: cornflowerblue; height: 25px;"></div>
						<h4>" ${m_userid } "님 구독이 완료되었습니다.</h4>
						
						<a><img src="/itda/img/close1.png" class="close6" 
				        style="position:absolute;top: 0px; right: 1px;;"/></a>
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
	
	<!-- ---------------프로필 모달창-------------- -->
		 <div class="profilJoinModal" id="profilJoinModal">
				<article class="profilModalContent profilDataInputModal" style="box-shadow: 5px 5px 5px lightgrey; width:320px;">
					<div>
						<form>
							<h4 id="profileTop">🍊&nbsp;프로필</h4>
						<!-- 	<a><img src="..//itda/img/close1.png" class="close7" 
					        style="position:absolute;top: 10px; right: 16px;;"/></a> -->
					     	
					     	<div class="profileinfo">
					     		<div>
						     		<div style="width:100px; height:100px; margin:0 auto;"> <!-- padding -->
						     			<img src="/itda/img/moveprofile.gif"/>
						     		</div>
					     		</div>
					     		<div>${m_username } &nbsp;( ${m_userid} )</div>
					     		<div>Female</div>
					     		<div>브론즈</div>
					     	</div>
					     	
					     	<div class="profilFoot" style="padding:10px;">
					     	<li id="profileHi">인사말</li>
					     	<input type="text" placeholder="인사말" />
					     	
					     	<li id="profileLike">관심분야</li>
					     	<input type="text" placeholder="관심분야 " />
					     	
					     	<input type="button" value="확인" id="profilebtn" style="margin-top: 20px; width: 100%;"/>
					     	</div>
					     		
					        <!-- <div><input type="button" value="확인"/></div> -->
				        </form>
					</div>
				</article>
		</div>   
		 
	</div>
	<script>
		/* 메뉴 드롭다운 */
		function myFunction(m_seq){
		  // 해야할일
		  // 누른 li의 좌표값을 구한다. ->  //x좌표:1073, y좌표:288
		  
		  // 좌표값을 구하면, javascript로 드롭다운 메뉴의 좌상단부분의 좌표를 li좌표로 변경한다.
		  // 기존 메소드에 토글 show가 있으니 위에까지만 하면 될거에요
		  
		  //받아온 값을 ajax로 db에 보내서 필요한 정보를 select해서 ajax(sucess시 필요한 곳에 넣어준다.)
		 
		 /*  const selectedDiv = this.getBoundingClientRect();
		  const selectedDivTop = selectedDiv.top;
		  console.log(selectedDivTop);
		  console.log(getBoundingClientRect()); */
		  
		 
		  
		  
		  var test = $('#myDropdown');
		  test.click(function (event) {
		     x = event.pageX;
		     y = event.pageY; 
		     
		     /* alert('x좌표:' +x + ', y좌표:' + y); */
		  })
		  
		  
		  
		 
		  
		  document.getElementById("myDropdown").classList.toggle("show");
		  console.log(m_seq);
		}
	
		window.onclick = function(event) {
		  if (!event.target.matches('.dropbtn')) {
		    var dropdowns = document.getElementsByClassName("dropdown-content");
		    var i;
		    for (i = 0; i < dropdowns.length; i++) {
		      var openDropdown = dropdowns[i];
		      if (openDropdown.classList.contains('show')) {
		        openDropdown.classList.remove('show');
		   		
		      }
		    }
		  } 
		}
		
		/* 차단 모달창 */
		$('#chadan').click(function () {
			   $('.blockDataInputModal').css('display', 'block');
			   $('.blockJoinModal').css('display', 'block');
			   
			   //취소
			   $('#noChadan').click(function () {
					  $('.blockJoinModal').css('display', 'none');
					});
			   
			   //x버튼
			   $('.close1').click(function () {
					  $('.blockJoinModal').css('display', 'none');  
					});  
			   
			   //차단 예쓰
			   $('#yesChadan').click(function(){
			       $('.blockJoinModal').css('display', 'none');  
			       
			       //차단 yes 모달창
			       $('.blockDataInputModal2').css('display', 'block');
				   $('.blockJoinModal2').css('display', 'block');
			       
				   //x버튼
				   $('.close2').click(function () {
						  $('.blockJoinModal2').css('display', 'none');  
						});  
			   });
			   
			   
			 }); 
		
			/*쪽지보내기 모달창*/
			$('#sendMail').click(function () {
			   $('.mailDataInputModal').css('display', 'block');
			   $('.mailJoinModal').css('display', 'block');
			   
			   //취소버튼
			   $('#noMail').click(function () {
					 $('.mailJoinModal').css('display', 'none');  
			  });   
			   
			   //x버튼
			    $('.close3').click(function () {
					  $('.mailJoinModal').css('display', 'none');  
					});  
			   
			   //보내기버튼
			   $('#yesMail').click(function () {
				   $('.mailJoinModal').css('display', 'none');  
				   
				   //보내기 yes 모달창
				   $('.mailDataInputModal2').css('display', 'block');
				   $('.mailJoinModal2').css('display', 'block');
				   
				 //x버튼
				   $('.close4').click(function () {
						  $('.mailJoinModal2').css('display', 'none');  
					}); 
			   });
			 
			}); 
			
			/*구독하기 모달창*/
			$('#gudok').click(function () {
			   $('.gudokDataInputModal').css('display', 'block');
			   $('.gudokJoinModal').css('display', 'block');
			   
			   //취소버튼
			   $('#noGudok').click(function () {
					 $('.gudokJoinModal').css('display', 'none');  
			  });   
			   
			   //x버튼
			    $('.close5').click(function () {
					  $('.gudokJoinModal').css('display', 'none');  
					});  
			
			  //구독하기 버튼 
			    $('#yesGudok').click(function () {
					   $('.gudokJoinModal').css('display', 'none');  
					   
					   //보내기 yes 모달창
					   $('.gudokDataInputModal2').css('display', 'block');
					   $('.gudokJoinModal2').css('display', 'block');
					   
					 //x버튼
					   $('.close6').click(function () {
							  $('.gudokJoinModal2').css('display', 'none');  
						}); 
				   });
				 
				}); 
			
			/*프로필 모달창*/
			 $('#profil').click(function () {
			   $('.profilDataInputModal').css('display', 'block');
			   $('.profilJoinModal').css('display', 'block');
			   
			 //x버튼
			    $('#profilebtn').click(function () {
					  $('.profilJoinModal').css('display', 'none');  
				}); 
			 });
		
		</script>
</body>

</html>
