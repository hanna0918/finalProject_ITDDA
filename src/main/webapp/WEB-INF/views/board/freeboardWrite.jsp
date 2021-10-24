<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=31a768c4de7ccc4dd10198ce46c22c41&libraries=services"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<link rel="stylesheet" type="text/css" href="css/freeboardWrite.css?a" />

	<div class="freeboardWrite">
		<div class="freeWriteHeader"> 
			<div class="freeWriteHeaderLine">
				<div class="boardName">
					<h2>FREEBOARD</h2>
					<h4>아무말 대잔치를 열어보자!</h4>
				</div>
			</div>	
		</div>	
		
		
		<form method="post" action="/itda/freeWriteOk" style="width:100%; overflow:auto;">

				<!-- 이미지, 아이디  -->
				<div class="freewriteBody">
					<div class="freebodyBlack">
						<div class="freeleftIdImg">
							<div id="freeProfilImg">
								<img src="/itda/img/circle.png" alt="프로필이미지"/>
							</div>
							<div id="profilId">
								<div id="freeleftId"> ${login}</div>
							</div>
						</div> 
						
						<div id="freeboardTitle">
							<div id="freeboardTitleWrap">
								<div><input type="text" name="board_subject" placeholder="제목" style=" border:none;"/></div>
							</div>
						</div>
						<!-- summernote -->
						 <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
       					 <!-- <div id="summernote" name="content"></div> -->
  						<textarea id="freeSummernote" name="b_content"></textarea>
       					 <div id="matchingBtnDiv">
					        <input type="submit" value="등록" class="recommendSubmitBtn" id="freeObtn"/>
					        <a href="/itda/freeBoard2"><input type="button" value="취소" id="freeXBtn"/></a>
					    </div>
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
