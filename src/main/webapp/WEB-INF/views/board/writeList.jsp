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
<link rel="stylesheet" href="writeListCss.css" type="text/css" />
</head>
<style>
@charset "UTF-8";
@font-face {
    font-family: 'IBMPlexSansKR-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
body, ul, li, img, a {
	font-family: 'IBMPlexSansKR-Regular';
	margin: 0;
	padding: 0;
	list-style: none;
		color: black;
	text-decoration:none;
}
#writerListDiv{
	width: 900px;	
	margin:0 auto;
	overflow:auto;
}
#profileBox, #introDiv, #postList{
	width:100%;
	overflow:auto;
	margin-top:2%;
}
#introDiv>div:first-child{
	width:15%;
	float:left;
}
#introDiv>div:last-child{
	width:70%;
	box-sizing:border-box;
	margin:12px;
}
.list li {
	float: left;
	width: 10%;
	height:50px;
	line-height:50px;
	text-align: center;
}
#title>li:nth-of-type(2), #content>li:nth-of-type(5n+2){
	width:50%;
	overflow: hidden;
	text-overflow: ellipsis;
}
#title>li:nth-of-type(3), #content>li:nth-of-type(5n+3){
	width:20%;	
}
#page { /*페이지 div*/
	width: 250px;
	height: 50px;
	line-height: 50px;
	margin: 0 auto;
}
#page li { /*페이지 1,2,3,4*/
	float: left;
	margin: 10px 10px;
}

</style>
<body>
	<div id='writerListDiv'>
		<form>
			<div id='profileBox'>
				<!-- 프로필박스 -->
				<div id='introDiv'>
					<div><img src='img/circle.png' name='profileImg'	id='profileImg' /></div>
					<div>
						sunchan123(내가순찬)님 <br /> 			
						등급 : bronze<br/>
						작성글 32
					</div>
				</div>
			</div>
			<div id='postList'>
				<div class='list'>
					<ul id='title'>
						<li></li>
						<li>제목</li>
						<li>등록일</li>
						<li>조회수</li>
						<li>댓글수</li>
					</ul>
					<hr />
				</div>
				<div class='list'>
					<ul id='content'>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
						<li class='selectLi'>10</li>
						<li><a href='#'>산에서 곰을 만났을때 어떻게 해야하나요..?</a></li>
						<li>2021-07-01</li>
						<li>50</li>
						<li>19</li>
					</ul>
				</div>
			</div>
			<div id='page'>
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
		</form>
	</div>
</body>
</html>