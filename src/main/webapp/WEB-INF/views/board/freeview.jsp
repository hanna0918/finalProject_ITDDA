<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" 
		integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" 
		crossorigin="anonymous" referrerpolicy="no-referrer">

</script>
<script>
	function delChk(no){
		
		if(confirm("삭제할까요?")){
			location.href="/itda/freeDelete?board_seq=${vo.board_seq}";
		}
		/* 	<li><a href="/itda/freeview?board_seq=${vo.board_seq}">${vo.board_subject}</a></li> */	
	}
</script>
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
a{
	text-decoration: none;
	color: #000;
}
.freeBoardView{
	
	padding-left:0;
	padding-right:0;
	width:100%;
}

/*게시판,제목,태그 윗부분 여백*/
.freeBoardTop{ 

	width:100%
	margin:0 auto;
	box-sizing: border-box;
	
	
}

.freeBoardTop>div:nth-child(1){
	text-align: center;
    padding: 80px 0;
    line-height:2;

	
}
.freeBoardTop>div:nth-child(2){
	position: relative;
    z-index: 1;
    max-width: 1100px; /*1100이면 뭔가 가운데가 안맞음*/
    margin: 0 auto;
    display: block;
    width: 100%;
}
.freeBoardTop h4{
	font-size: 15px;
    border-width: 0;
    border-style: solid;
    padding: 0 0 20px;
    display: inline-block;
    margin-bottom: 20px;
    position: relative;
   	color: #000;
	text-decoration: none;
	border-top:ridge; 
	/* border-bottom:dotted; */
}
.freeBoardUser{
	position: relative;
    padding: 20px 15px;
    max-width: 1100px; 
    border-bottom: 0
}
.freeUserinfo{
	display: table-cell;
    vertical-align: middle;
    overflow: hidden;
    line-height: 1.2;
    text-align: left;
}

.freeUserinfo>div{
	position: relative;
    display: block;
    font-size: 14px;
    line-height: 1.5;
}

.freeUserinfo span{
	width: 900px;
    display: flex;
    justify-content: right;
    margin-top: 40px;
    position: absolute;
    top: -0.1px;
    z-index: 30;
}
/*프로필 사진*/
#freeleftIdImg{
	
    width: 100%;
    max-width: 60px;
    /* float: left; */
    /* position: relative; */
    /* z-index: 100; */
    /* padding: 8px 0 20px; */
    display: flex;
   		
	}
	#profilImg{
		display: inline-block;
		padding-right: 10px; /*16px*/
		vertical-align: top;
	}
	#freeleftIdImg img{
		border-radius: 50%;
	    width: 60px;
	    height: 57px;
	    vertical-align: middle;
	    border: 0;
	    
	}
	
/*게시판 내용 */
.freeContent{
	max-width: 1100px; /*1100*/ 
    float: none ;
    width: 100% ;
    min-width: auto;
    padding-left: 15px;
    padding-right: 15px;
    display: block ;
    margin: 0 auto;
}
/*내용 들어가는 곳*/
.freeContentView{
padding: 22px 0;
    margin: 0;
    word-break: normal;
    word-wrap: break-word;
}
/*댓글 들어가는 곳*/
.freeTextarea{
	padding-top:10px;
	margin: 30px 0 0 0;
}
.freeText{
	position: relative;
    padding: 16px;
    border: 1px solid rgba(128, 128, 128, 0.2);
    border-radius: 3px;
    height:145px;
}
.freeText>textarea{
	border: none;
    width: 100%;
    outline-style: none;
    resize: none;
    overflow-y: hidden; !important;
    padding: 0;
    background: transparent;
  /*   vertical-align: top; */
    border-radius: 3px 3px 0 0;
    /* margin-bottom: 12px; */
    min-height: 62px;
    font-size:14px;
    line-height:inherit;
   	text-rendering: auto;
   	display:inline-block;
   	text-align: start;
   	cursor:text;
}

.freeTextBlock input[type="submit"], .freeList input[type="submit"]{
	background: #0e3775;
    border: 2px solid #0e3775;
    color: #fff;
    float:right;
    outline-style:none;
    padding-left: 23px;
    padding-right: 23px;
    border-width:2px;
    border-radius: 5px;
    line-height:1.5;
    padding-top:4px;
    height:32px;
    
    
}


/*하단 이전글 다음글 글쓰기 등 */

.freeList{
	padding-top:12px;
	padding-right:0;
	overflow:hidden;
}

.freelistTap a{
	display: block;
    border-top: 1px solid rgba(128, 128, 128, 0.2);
    border-bottom: 1px solid rgba(128, 128, 128, 0.2);
    /* width: 100%; */
    text-decoration: none;
    font-size: 14px;
    padding: 10px 12px;
    overflow: hidden;
    text-align: left;
}


/*게시글 신고 모달창*/
	.sirenloginJoinModal {
	  display: none;
	  position: fixed;
/* 	  top: 0; */
	  left: 0;
	  width: 101%;
      height: 700px;
	  bottom: 0;
	  overflow-x: hidden;
	  overflow-y: auto;
	  -ms-overflow-style: none;
	}
	
	.sirenloginJoinModal::-webkit-scrollbar {
	  display: none;
	}
	
	.sirenjoinModalContent {
	  position: relative;
	  margin: 0 auto;
	  width: 400px;
	  padding: 20px;
	  background-color: #fafafa;
	  text-align: center;
	  border-radius: 10px;
	  /* border: 2px solid #666; */
	  /* overflow-y: auto; */
	}
	
	/* 모달창 배경 */
	.modalOverlay {
	  background: rgba(0, 0, 0, 0.5);
	  width: 100%;
	  height: 100%;
	  top: 0;
	  overflow-y: auto;
	  position: fixed;
	}
	
	.sirenjoinDataInputModal{
	  display: none;
	  background-color: whitesmoke;
	  box-shadow: 10px 10px 5px lightgrey;
	
	}
	
	/*모달창 안에 내용*/
	#sirenPopup{
		width: 400px;
		text-align: left;
    	margin: 0 auto;
        padding: 0;
        line-height:14px;
	}
	<!--신고하기 -->
	#sirenHeader, #sirenContainer{
	background: #f6f6f5;
    border-bottom: 1px solid #eeeeec;
	}
	#sirenHeader h1{
	height: 25px;
    padding: 13px 0 1px 20px;
    color: #000;
    font-size: 14px;
    letter-spacing: -1px;
    background: linear-gradient(
	143deg, gray, transparent);  /*175deg, lightgray,*/
	}
	#sirenHeader img{
	position: absolute;
    margin-top: -12px;
    margin-left: -10px;
	}
	#sirenHeader label{
	padding-left: 21px;
    padding-top: 10px;	
	}
	
	
	#sirenContainer>div{
	padding: 17px 19px 7px 20px;
	text-align: left;
    margin: 0 auto;
	}
	
	
	<!---- 게시물 번호,  제목, 작성자 ---->
#sirenContainer ul{
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}

ul,li{
padding:0;
list-style-type: none;
}
.sirenInfo{
width: 100%;

}
.sirenInfo:after{
    clear: both;
    display: block;
    content: '';
}

.sirenInfo .first{
margin-top: 0;
    padding-top: 0;
    border-top: none;
    padding-bottom:10px;
}

/* .sirenInfo dt{
	float: left;
    width: 67px;
    color: #333;
    font-weight: bold;

    min-height: 17px;
    _height: 17px;
    margin-top: 18px;
    padding-top: 17px;
    border-top: 1px solid #eeeeec;
    line-height: 16px;
}

.sirenInfo dd{
    position: relative;
    float: left;
    width: 419px;
    color: #555;
    
    min-height: 17px;
    _height: 17px;
    margin-top: 18px;
    padding-top: 17px;
    border-top: 1px solid #eeeeec;
    line-height: 16px;
} */

.sirenInfo .two{
    margin-top: 8px;
    padding-top: 0;
    border-top: none;
    z-index: 100;
    padding-bottom:10px;
}

.sirenWhy{
    /* margin-bottom: -7px; */
    padding-top: 10px;
    padding-left:0;
    text-align:inherit;
}

.sirenWhy p{
    position: relative;
    margin: -1px 0 10px 0;
    color: #999;
    font-size: 12px;
    letter-spacing: -1px;
    text-align: left;
}

/*-----------------*/
.sirenWhySelect{
	display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding:0;
}

.sirenWhySelect li{
	margin-bottom: 7px;
	list-style: none;
    display: list-item;
    text-align: -webkit-match-parent;
}

.sirenWhySelect input[type="radio"]{
	display: inline-block;
    vertical-align: middle;
    width: 13px;
    height: 13px;
        background-color: initial;
    cursor: default;
    appearance: auto;
    box-sizing: border-box;
    margin: 3px 3px 0px 5px;
    padding: initial;
    border: initial;
	
}

.sirenWhySelect label{
    display: inline-block;
    margin: 0 0 0 2px;
    *margin: -1px 0 1px 2px;
    vertical-align: middle;
	cursor: pointer;
}

.sirenWhy textarea{
    display: none;
    margin-bottom: 8px;
    padding: 4px 6px 0 6px;
    border: 1px solid #d1d1d1;
    border-right: 1px solid #e9e9e9;
    border-bottom: 1px solid #e9e9e9;
    /* color: #aaa; */
    font-family: '나눔고딕',NanumGothic,'돋움',dotum;
    font-size: 12px;
    background: #fff;
    line-height: 16px;
    overflow-x: hidden;
	overflow:auto;
	
}

#sirenFooter{
clear: both;
    width: 385px;
    /* margin: 0 19px 0 20px; */
    padding: 10px 0 11px 0;
    border-top: 1px solid #eeeeec;
    text-align: center;
}

#sirenFooter input{
border-radius: 5px;
    border-color: lightgray;
}	

/*북마크 등록 모달창*/
/*모달창*/
	.bookJoinModal {
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
	.bookJoinModal::-webkit-scrollbar {
	  display: none;
	}
	
	.bookModalContent {
	  position: relative;
	  margin: 0 auto;
	  width: 400px;
	  padding: 20px;
	  background-color: #fafafa;
	  text-align: center;
	  border-radius: 10px;
	 /*  border: 2px solid #666; */
	  overflow-y: auto;
	}
	
	.bookDataInputModal {
	  display: none;
	  background-color: whitesmoke;
	  box-shadow: 10px 10px 5px lightgrey;
	}


/*북마크 해제 모달창*/
/*모달창*/
	.bookJoinModal2 {
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
	.bookJoinModal2::-webkit-scrollbar {
	  display: none;
	}
	
	.bookModalContent2 {
	  position: relative;
	  margin: 0 auto;
	  width: 400px;
	  padding: 20px;
	  background-color: #fafafa;
	  text-align: center;
	  border-radius: 10px;
	 /*  border: 2px solid #666; */
	  overflow-y: auto;
	}
	
	.bookDataInputModal2 {
	  display: none;
	  background-color: whitesmoke;
	  box-shadow: 10px 10px 5px lightgrey;
	}
	
	/*댓글 목록 리스트 박스 */
	
	#freeuserid{
		font-size:0.9em;
	}
	.freereplyView{
		margin-top:2%;
	}
	.freecontentReply span{
		font-size:0.85em;
		color:#ddd;
	}
	img[name=freeprofileShot]{
		width:40px;
		height:40px;
		margin:5px;
		float:left;
	}
	
	/*로그인 안되어있을 때 작성버튼->스타일 안먹어서 아래에 넣어줌*/
	#needlogin2{
	background: #0e3775;
    border: 2px solid #0e3775;
    color: #fff;
    float: right;
    outline-style: none;
    padding-left: 23px;
    padding-right: 23px;
    border-width: 2px;
    border-radius: 5px;
    line-height: 1.5;
    padding-top: 4px;
    height: 32px;
	margin-top:-20px;
	}
	
	
</style>
<body>
<section>
	<div class="freeBoardView">
		<div class="freeBoardTop">
			<div>
				<div>
					<a href=""><h4>자유게시판</h4></a>
					<h1 style="background: linear-gradient(45deg, whitesmoke, transparent);">${vo.board_subject }</h1>
					<div>
					<!-- <span><a href='#'>#벌써</a>&nbsp<a href='#'>#10월이라니</a>&nbsp<a href="#">#말도안돼</a></span> -->
					</div>
				</div>	
			</div>
			<div class="freeBoardUser">
				<div class="freeUserinfo">
					<div id="freeleftIdImg">
						<div id="profilImg">
							
							<a href="#"><img src="/itda/img/circle.png" alt="프로필이미지"/></a>
						</div>
					</div>
					<div style="z-index:40; position:absolute; left:86px; top:-1px; margin-top: 24px;"><a href=""><label style="padding-right:3px;">${logname}</label>  @${login}</a></div>
					<div style="position: absolute; top:-0.1px; margin-top: 50px; left: 87px;">${vo.board_writedate}</div>
					
					<span>
					  
					 <!-- 내가 쓴 글이 아닐경우에만 신고,북마크 보이기-->
					<c:if test="${vo.m_seq!=logseq}">
					
						<div style="margin-right:3px; margin-top:-5px;">
							<img src="/itda/img/siren3.png" alt="신고" id="sirenImg"/> 
						</div>
						<div style="margin-right:-10px; margin-left:10px;">
							<a><img src="/itda/img/bookmark4.png" alt="북마크" id="bookmarkOff"/></a>
							<a><img src="/itda/img/bookmarkOn.png" alt="북마크on" id="bookmarkOn"/></a>
						</div>
					</c:if>
					
					<!-- 내가 쓴 글일 경우엔 수정, 삭제 보이기 -->
					<c:if test="${vo.m_seq==logseq}">
						<div style="margin-right:10px; ">
						<a href="/itda/freeEdit?board_seq=${vo.board_seq}">수정</a>
						</div>
						<div style="margin-right:-10px">
						<a href="javascript:delChk(${board_seq})">삭제</a> <!-- 레코드번호 넘겨서 삭제 -->
						</div>
					</c:if>
					
					<div style="margin-right:-160px; margin-left:25px;">
						<a href=""><img src="/itda/img/hit.png" alt="조회수"/>
						<label>${vo.board_hit}</label>
						</a>
					</div>
					</span>
					
				</div> 
			</div>
			
			<div class="freeContent">
			<div class="freeContentView">${vo.b_content}</div>
			<div class="freeComment" style="margin-bottom:24px;">
				<div class="commentBtn" style="display:inline-block; float:left;">
					<a href="" style="font-size:16px;"><img src="/itda/img/like.png" alt="좋아요수"/>${vo.b_goodhit}</a> 
					<span>
					<img src="/itda/img/message3.png" alt="댓글수" style="top:1px; transform:none; position:relative"/>
					${vo.commentcount }
					</span>  
				</div>
			</div>
			
			<!------- 댓글 목록 나오는 리스트---------->
			<div style=" position: relative; left: -55px; top: 25px;"><!-- 2 댓글박스 -->
				<div><img src='/itda/img/circle.png' name='freeprofileShot'></div>
				<div>
					<div id='freeuserid' class='freeuserid'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
					<div class='freereplyView'>${bcVo.br_content}</div>
					<div><span>댓글 / 수정 / 지우기</span></div>				
				</div>
			</div>
			
			
			
			
			<!----------------------------------댓글쓰기 --------------------------------->
			
			<!-- 로그인이 되어있을 경우  -->
			<c:if test="${login ne null}">
				<div class="freeTextarea">
					<form method="post" id="commentFrm" action="/itda/commentWrite">
						<div class="freeTextBlock">
							<div class="freeText">
							<textarea id="freecoment" name="br_content" title="댓글을 남겨주세요" placeholder="댓글을 남겨주세요" rows="1" style="overflow:hidden; overflow-wrap:break-word; height:100px;"></textarea>
							<input type="submit" id="freeComentBtn" value="작성" style="margin-top:-25px;"/>
							
							<input type="hidden" name="board_seq" value="${vo.board_seq}"/> <!-- 원글 글번호 board_seq -->
							<input type="hidden" name="m_userid" value="${vo.m_userid}"/>
							</div>
						</div>
					</form>
				</div>
			</c:if>
			
			<!-- 로그인이 안되어있을 경우 -->
			<c:if test="${empty login}">
				<div class="freeTextarea">
					<form method="post" id="" action="">
						<div class="freeTextBlock">
							<div class="freeText" id="needLogin1">
							<textarea id="freecoment" title="로그인이 필요합니다" placeholder="로그인이 필요합니다" rows="1" style="overflow:hidden; overflow-wrap:break-word; height:95px;"></textarea>
							<input type="button" value="작성" id="needLogin2" style="background: #0e3775;border: 2px solid #0e3775;color: #fff;float: right;outline-style: none;padding-left: 23px;padding-right: 23px;border-width: 2px;border-radius: 5px;line-height: 1.5;padding-top: 4px;height: 32px;margin-top:-20px;" />
							</div>
						</div>
					</form>
				</div>
			</c:if>
	
			<div class="freeBottom" style="margin-bottom:24px;"> <!-- 아래 이전글, 다음글, 글쓰기 목록 -->
				<div class="freelistTap" style="margin-top:32px;"> <!-- 이전글, 다음글  -->
					<a href="">${vo.board_subject }</a>
				</div>
				<div class="freeList"> <!-- 목록, 글쓰기  -->
					<a href="/itda/freeBoard2"><input type="submit" value="목록" style="float:left;"/></a>
					<a href="/itda/freeboardWrite"><input type="submit" value="글쓰기"/></a>
				</div>
			</div>
			
			</div>
		</div>
	</div>
	
	
	

		<!-- 게시글 신고 모달창 -->
		<div class="sirenloginJoinModal" id="sirenloginJoinModal">
			<!-- <div class="modalOverlay"></div> -->
				<article class="sirenjoinModalContent sirenjoinDataInputModal">
					<form method="post" id="freeSiren" action="" >
						<div id="sirenPopup">
							<div id="sirenHeader">
								<h1><img src="/itda/img/siren3.png"/><label>신고하기</label></h1>
								<a><img src="img/close1.png" class="close" 
				        style="position:absolute;top: 18px; right: 17px;"/></a>
							</div>
							<div id="sirenContainer">
								<div> 
									<ul class="sirenInfo">
										<li class="first">게시물번호 :&nbsp; ${vo.board_seq }</li>
										<li class="two">제&nbsp;&nbsp;목 :&nbsp; ${vo.board_subject }</li>
										<li class="two" style="border-bottom:ridge;">작성자 :&nbsp; ${vo.m_userid }</li>
										<li class="two" style="padding-top:10px;">
											<span>사유선택</span>  : 
										</li>	
									
										<div class="sirenWhy">
											<p>"여러 사유에 해당되는 경우, 대표적인 사유 1개를 선택해 주세요"</p>
											<ul class="sirenWhySelect">
												<li>
													<input type="radio" name="sirenRadio" checked/>
													<label>&nbsp;부적절한 홍보 게시글</label>
												</li>
												<li>
													<input type="radio" name="sirenRadio"/>
													<label>&nbsp;음란성 또는 청소년에게 부적합한 내용</label>
												</li>
												<li>
													<input type="radio" name="sirenRadio"/>
													<label>&nbsp;명예훼손/사생활 침해 및 저작권침해 등</label>
												</li>
												<li>
													<input type="radio" name="sirenRadio"/>
													<label>&nbsp;불법촬영물등 신고</label>
												</li>
												<li>
													<input type="radio" id="guitarBtn" name="sirenRadio"/>
													<label>&nbsp;기타</label>
												</li>
											 </ul>
											 
											 <textarea id="guitar" cols="50" rows="5" style="width:350px; height:80px;">
											 "해당 신고는 관리자에게 전달됩니다. 커뮤니티 규정을 위반한 경우 관리자에게 문의 해주세요."
											 </textarea>
										</div>
									</ul>
								</div>
							</div>
							<div id="sirenFooter">
								<input type="submit" value="신고하기" />
								<input type="button" id="sirenX" value="취소"/>
							</div>
						</div>
					</form>
				
				</article>
		</div>
		<!-- ----------------------------------------------------------------------------- -->
		
		<!-- 북마크 등록 모달창 -->
		<div class="bookJoinModal" id="bookJoinModal">
				<article class="bookModalContent bookDataInputModal">
					<div>
						<img src="/itda/img/bookmarkOn.png"/>
						<img src="/itda/img/bookmarkOn.png"/>
						<img src="/itda/img/bookmarkOn.png"/>
						<img src="/itda/img/bookmarkOn.png"/>
						<img src="/itda/img/bookmarkOn.png"/>
					
						<h1>BOOKMARK <span style="color:red; font-size:larger; font-family:initial;">ON</span></h1>
						<label>북마크가 등록되었습니다!</label>
						<a><img src="/itda/img/close1.png" class="close1" 
				        style="position:absolute;top: 10px; right: 17px;"/></a>
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
		
		<!-- 북마크 해제 모달창 -->		
		<div class="bookJoinModal2" id="bookJoinModal2">
				<article class="bookModalContent2 bookDataInputModal2">
					<div>
						<img src="/itda/img/bookmark4.png"/>
						<img src="/itda/img/bookmark4.png"/>
						<img src="/itda/img/bookmark4.png"/>
						<img src="/itda/img/bookmark4.png"/>
						<img src="/itda/img/bookmark4.png"/>
						
						<h1>BOOKMARK <span style="color:navy; font-size:larger; font-family:initial;">OFF</span></h1>
						<label>북마크가 해제되었습니다!</label>
						<a><img src="/itda/img/close1.png" class="close2" 
				        style="position:absolute;top: 10px; right: 17px;"/></a>
				        <!-- <div><input type="button" value="확인"/></div> -->
					</div>
				</article>
		</div>
		
		<!-- 로그인 안했을경우 댓글 클릭시 로그인 모달창 띄우기  -->
		<div class=loginModal" id="loginModal" style="display:none;">
  	<!-- 	<div class="modalOverlay"></div> -->
  		<article class="loginForm">
    	<div class="closeBtn">close</div>
    	<form method="post" action="/itda/loginOk">
     	 <h2>로그인</h2>
      	<input type="text" class="login_userid" name="m_userid" placeholder="아이디" /><br />
      	<input type="password" class="login_userpwd" name="m_userpwd" placeholder="비밀번호" /><br />
      	<input type="submit" value="로그인" />
   	 	</form>
    	<label class="autoLoginLabel">
      	<input type="checkbox" name="autoLogin" id="autoLogin" class="autoLogin" />
      	<span>로그인상태유지</span>
    	</label>
    	<div class="loginBottumBtn">
      	<a href="" class="joinBtn2">회원가입</a>
      	<a href="" class="findId">아이디&비밀번호 찾기</a>
    	</div>
  	</article>
	</div>
				
<script type="text/javascript">

<!-- 게시글 신고 모달창 -->
 $('#sirenImg').click(function () {
    $('.sirenjoinDataInputModal').css('display', 'block');
    $('.sirenloginJoinModal').css('display', 'block');
 }); 
 
$('#guitarBtn').click(function () {
    $('#guitar').css('display', 'block');
});

 $('#sirenX').click(function () {
	  $('.sirenloginJoinModal').css('display', 'none');
	});
 

 $('.close').click(function () {
	  $('.sirenloginJoinModal').css('display', 'none');  
	});  

 <!-- 북마크 이미지 변경-->
 	
 $(document).ready(function(){
     /*웹페이지 열었을 때*/
     $("#bookmarkOff").show();
     $("#bookmarkOn").hide();
 });
     /*img1을 클릭했을 때 img2를 보여줌*/
     $("#bookmarkOff").click(function(){
    	 
        $('.bookDataInputModal').css('display', 'block');
        $('.bookJoinModal').css('display', 'block');
        	    
         $("#bookmarkOff").hide();
         $("#bookmarkOn").show();
         
         $('.close1').click(function () {
        	 $('.bookJoinModal').css('display', 'none');  
         });  	    
      });
         
    
     /*img2를 클릭했을 때 img1을 보여줌*/
     $("#bookmarkOn").click(function(){
    	 
    	 $('.bookDataInputModal2').css('display', 'block');
         $('.bookJoinModal2').css('display', 'block');
    	
         $("#bookmarkOff").show();
         $("#bookmarkOn").hide();
         
         $('.close2').click(function () {
        	 $('.bookJoinModal2').css('display', 'none');  
         });  
         
     });

 
 	/*댓글댓글댓글댓글*/

	/*$(function(){
		//해당게시물의 댓글 목록 구하기(db에서 셀렉트해서)
		 function commentList(){
			var rParam = "board_seq=${vo.board_seq}"; //현재 글번호 레코드 번호 
			var rUrl = "/itda/commentList"; //매핑주소
			$.ajax({
				url : rUrl, 
				data : rParam,
				success :function(result){ //List가 리턴됨 (controller에서) $로 묶어줘야함
					var $result = $(result);
					var tag="";
					//반복문 돌리면서 레코드 수만큼 list출력
					$result.each(function(idx, vo){
						tag += "<li><div>"+vo.m_userid+"("+vo.board_writedate+")";
						//클라이언트쪽에서 실행	//서버에서 실행되서 넘어오고 // ''로 묶어줘야 
						if(vo.userid=='${logid}'){//자기가 쓴 댓글일 때 (로그아이디와 선택한 레코드의 글쓴이(vo)가 같을 때)
							//수정 삭제 <br/>
							tag += "<input type='button' value='수정'/>";
							tag += "<input type='button' value='삭제' title='"+vo.num+"'/><br/>";
							tag += vo.coment+"</div>";
							//수정폼
							tag += "<div style='display:none'>";
							tag += "<form method='post'>"
							tag += "<textarea name='coment'>"+vo.coment+"</textarea>";
							tag += "<input type='submit' value='Edit'/>"
							tag += "<input type='hidden' name='num' value='"+vo.num+"'/>";//댓글의 일련번호
							tag += "</form></div></li>";
						}else{//자기가 쓴 댓글이 아닐 때 
							tag+="<br/>"+vo.coment+"</div></li>";
						}
						// tag += vo.coment+"</li>"; 
					});
					console.log(tag);
					$("#freereplyView").html(tag); //기존에 있는거 지우고 새롭게 태그를 추가해
					
				},error:function(){
					console.log("댓글목록선택에러...");
				}
			});
		}
		
		/*로그인 안되있을 경우 로그인창 띄우기*/
		$("#needLogin1").click(function(){
			 $('.loginModal').css('display','block');
		});

		$("#needLogin2").click(function(){
			 $('.loginModal').css('display','block');
		});
		
		//댓글 쓰기////////////////////////////////////////////////
		$('#freeComentBtn').click(function(){
				//----- 댓글을 입력하지 않은 경우 
				if($("#freecoment").val()==""){ 
				alert("댓글을 입력후 등록하세요.."); //추후 모달창으로 대체하기!!!!!!!!!!!!!!!!!!!!
					return false;
				}else{
					//서버에 댓글을 등록하는 ajax호출
					//폼의 데이터를 전송데이터로 변환해주는 함수
					var params = $("#commentFrm").serialize(); //coment=gjgjgjgj&no=34;
					$.ajax({
						url:"/itda/replyWrite", //boardController에 만들어놓음
						type:"POST", //"POST", "GET"
						data : params,//coment=gjgjgjgj&no=34;
						success:function(result){
							if(result==0){
								alert("댓글등록 실패하였습니다.")//추후 모달창으로 대체!!!!!!!!!
							}else{
								//현재 보고 있는 댓글 목록을 다시 선택한다 (comment에 있는 value 삭제)
								commentList();
								//이전 댓글 지우기
								$("#freecoment").val("");
							}
						},error:function(){
							console.log("댓글쓰기 에러");
						}
					});
				}
			});
			
		 
		
	/* 	//댓글 수정 버튼을 선택하면 (document를 기준으로 ) 나중에 추가된 input
		$(document).on('click','#commentList input[value=수정]',function(){
			//댓글 정보는 숨기고 
			$(this).parent().css("display","none");
			//댓글 수정폼은 보이고
			$(this).parent().next().css("display","block");
		});
		
		//Edit 버튼 선택시 댓글 수정 실행
		$(document).on('submit','#commentList form',function(){
			var url = "/myapp/replyEditOk";
			var params = $(this).serialize();//방금 이벤트가 생긴 폼에서 자동으로 coment=문자&num=888; 만들어짐
			
			$.ajax({
				url : url,
				data : params,
				type : "POST",
				success : function(result){
					commentList();
				}
			});
			return false;//submit은 action으로 이동하여 페이지가 실행되는 것을 차단한다. 
		});
		//댓글 삭제
		$(document).on('click','#commentList input[value=삭제]',function(){
			if(confirm('댓글을 삭제하시겠습니까?')){
				var params = "num="+$(this).attr("title"); //현재 이벤트가 발생한 input 버튼의 속성 중에 title이 가진 레코드 값을 넣어줌 
				$.ajax({
					url : "/myapp/replyDel",
					data : params,
					success:function(result){
						commentList();
					}
				});
			}
		});
		//댓글 목록을 처리하는 함수를 호출한다.
		commentList();
		
		
	}); */


 </script>

	
</section>

<%-- <h1>글내용보기</h1>
<ul>
	<li>번호 : ${vo.no }</li>
	<li>작성자 : ${vo.userid }</li>
	<li>등록일 : ${vo.writedate}, 조회수 : ${vo.hit }</li>
	<li>제목 : ${vo.subject }</li>
	<li>글내용 : ${vo.content }</li>
</ul> --%>









