<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=31a768c4de7ccc4dd10198ce46c22c41&libraries=services"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
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
	
	.freeboardWrite{
		max-width:1250px;   /*대표 이미지 설정 없을 경우 max-width:1100px; padding-left: 0; */
		padding-left:250px; 
		padding-right:10px; 
		width:100%;
		margin:90px auto 80px;
		box-sizing: border-box;
	}
	.freeWriteHeader{
		border-bottom: 1px solid rgba(128, 128, 128, 0.3);
    	position: fixed;
   	 	left: 0;
    	top: 0;
   	 	width: 100%;
    	background: #fff;
   	 	z-index: 111200;
   	 	padding: 17px 15px;
	}
	.freeWriteHeaderLine{
		margin:0 auto;
	}
	.freeWriteHeaderLine>div{
		font-size:20px;
		float: left;
    	/* font-weight: 400; */
    	color: #4a4a4a;
    	padding-left: 4px;
    	font-weight: bolder;
	}
	.freeWriteHeaderLine input[type="submit"]{
		float:right;
	}
	
	.freewriteBody{
		 max-width:1100px; 
		margin:0 auto;
		width:100%;
		float:left;
	}
	.freebodyBlack{
		border-bottom: 0;
	    margin: 30px 0 0 0;
	    max-width: 100%;
	    padding-left: 0;
	    padding-right: 0;
	}
	.freeleftIdImg{
	
   	width: 100%;
    max-width: 300px;
    /* float: left; */
    position: relative;
    z-index: 100;
    padding: 8px 0 20px;
    display: flex;
   		
	}

	/* 		프로필 이미지	 */
	#profilImg{
		display: inline-block;
		padding-right: 10px; /*16px*/
		vertical-align: top;
	}
	.freeleftIdImg img{
		border-radius: 50%;
	    width: 40px;
	    height: 40px;
	    vertical-align: middle;
	    border: 0;
	    
	}
	
	/* 로그인 한 아이디  */
	#profilId {
    padding-top: 10px;
    padding-left: 0px;
	}
	
	#freeleftId{
	position: relative;
    display: block;
    font-size: 14px;
    line-height: 1.5;
    font-weight: bold;
	}
	
	<!-- 제목 태그 등등-->
	#freeboardTitle{
	position: relative;
    margin-top: 5px;
    padding-top: 0;
	}
	
	#freeboardTitleWrap{
	position: relative;
	margin-bottom: 20px;
	display: table;
	width: 100%;
	}
	
	#freeboardTitleWrap>div:nth-child(1){
	    border-bottom: 1px solid rgba(128, 128, 128, 0.3);
    	/* position: relative; */
        vertical-align: middle;
        display: table-cell;
    	padding-right: 3px;
    	width:20%;
    	color: #333;
        font-size: 20px;
    
	}
	
	#freeboardTitleWrap>div:nth-child(2){
		padding-left: 20px;
		vertical-align: middle;
        display: table-cell;
        font-size:20px
	}
	
	

	/* 취소버튼인데 스타일 안되서 아래에 넣음 */
	#freeXBtn{
	background: #fff;
    border: 1px solid #d3d3d3;
    color: #4a4a4a;
    margin-right: 7px;
    padding: 6.5px 12px;
    border-radius: 3px;
    font-size: 12.2px;
    font-weight: bold;
    float:right;
	}
	
	/* 등록 버튼 */
	#freeObtn{
    padding: 6.5px 12px;
    border-radius: 3px;
    font-size: 12px;
    font-weight: bold;
	background: #0e3775; 
    border: 1.5px solid #0e3775; 
    color: #fff; 
    float:right;
	}
	
	/* 대표이미지 설정 */
	#freezImage{
	position: fixed;
    left: 0;
    width: 250px;
    top: 0;
    bottom: 0;
    overflow-y: auto;
    padding: 90px 20px 20px;
    border-right: 1px solid rgba(128, 128, 128, 0.3);
    background: #fafafa;
    z-index: 10;
	}
	
	#freezImage>div{
	
	font-weight: 600;
    color: #333;
    font-style: normal;
    font-size: 14px;
	margin-bottom: 16px;
	}
	
</style>
<body>
	<div class="freeboardWrite">
		<div class="freeWriteHeader"> 
			<div class="freeWriteHeaderLine">
				<div>아무말 대잔치</div>
				<!-- <div>
					<a href="#"><input type="submit" value="취소" /></a>
					<a href="#"><input type="submit" value="등록" /></a>
				</div> -->
			</div>	
		</div>	
		
		
		<form method="post" action="/itda/freeWriteOk" style="width:100%; overflow:auto;">
		<!-- 대표 이미지 설정(넣을지 뺄지 잘 모르겠지만 일단 넣어봅니다) -->
		<div id="freezImage">
			<div>
				<label >대표 이미지 설정</label>
			
			</div>
		</div>
		
		<!-- --------------------------------------------- -->
		
				<!-- 이미지, 아이디  -->
				<div class="freewriteBody">
					<div class="freebodyBlack">
						<div class="freeleftIdImg">
							<div id="profilImg">
								<img src="/itda/img/circle.png" alt="프로필이미지"/>
							</div>
							<div id="profilId" style="  padding-top: 10px; padding-left: 0px;">
								<div id="freeleftId"> ${login}</div>
							</div>
						</div> 
						
						<div id="freeboardTitle">
							<div id="freeboardTitleWrap">
								<div><input type="text" name="board_subject" placeholder="제목" style=" border:none;"/></div>
								<!-- <div>
								<input type="text"  placeholder="#을 이용하여 태그를 작성해보세요! (최대 10개)" style="border: none; border-bottom: 1px solid rgba(128, 128, 128, 0.3); width:100%" font-family:normal;/>
								</div> -->
							</div>
						
						</div>
						
						
						
						<!-- summernote -->
						
						 <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
       					 <!-- <div id="summernote" name="content"></div> -->
       					 
  						<textarea id="freeSummernote" name="board_content"></textarea>
					
       					 

					      <!-- ---------------------물론 여긴 바꿔야함------------------------ -->
					      <input type="submit" value="등록" id="freeObtn" />
        				  <a href="/itda/freeBoard2"><input type="button" value="취소" id="freeXBtn" style="float:right; background: #fff; border: 1px solid #d3d3d3;color: #4a4a4a;margin-right: 7px;padding: 6.5px 12px;border-radius: 3px;font-size: 12.2px;font-weight: bold;"/></a>
					      <!-- ---------------------물론 여긴 바꿔야함------------------------ -->


						
						
					</div>
				</div>
			</form>
		</div>
	
	





	<script>
	$('#freeSummernote').summernote({
        placeholder: '내용을 입력해주세요',
        tabsize: 2,
        height: 600,
    });
	
	

	</script>





</body>
</html>