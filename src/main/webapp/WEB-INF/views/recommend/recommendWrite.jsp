<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/itda/css/reco_injeungWrite.css?a">
<!-- <link rel="stylesheet" href="/itda/css/recommend.css?version=1"> -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<stylie>

</stylie>

<section id="reco_injeungFrame">
	<div class="boardName">
		<h2>RECOMMEND</h2>
		<h4>모두에게 유용한 정보를 추천해보세요!</h4>
	</div>
    <form method="post" action="/itda/recommendWriteOk" id="recommendWriteOk" action="/itda/recommendWriteOk" onsubmit="return false" enctype="multipart/form-data">
   		<div id="reco_injeungInfoArea">
            <div>
                <div id="recommendWrite">
                    <div><input type="text" id="recommendUploadTitle" name="board_subject" placeholder="제목을 입력하세요" required/></div>
                    <div><input type="button" value="지도" id="reco_injeungMapBtn"></div>
                    <div><input type="text" name="searchText" id="searchText" placeholder="태그를 입력하세요(최소 5개, 최대 10개)"/></div>
	                <div>
							<label class="input-file-button" for="input-file">썸네일</label> 
							<input type="file" id="input-file" name="i_url"/>
					</div>
					
						<script>
						$("#input-file").change(function(){
							if(this.files && this.files[0]) {
					    		var reader = new FileReader;
						    	reader.onload = function(data) {
						    		console.log(data.target.result+ 'dddddddd나오냐이미지');
						    		$(".select_img img").attr("src", data.target.result).width(500);        
						    	}
					    		reader.readAsDataURL(this.files[0]);
									reader.readAsText(this.files[0]);
									console.log(reader.readAsText(this.files[0]));
					    	}
				    	});
						</script>
						<div class="select_img"><img src=""/></div>
						<%=request.getRealPath("/") %>
            </div>
		    </div>
	            <div id="addTag">
	                <div id="hiddenTag0" style="display: none;">#</div>
	                <div id="hiddenTag1" style="display: none;">#</div>
	                <div id="hiddenTag2" style="display: none;">#</div>
	                <div id="hiddenTag3" style="display: none;">#</div>
	                <div id="hiddenTag4" style="display: none;">#</div>
	                <div id="hiddenTag5" style="display: none;">#</div>
	                <div id="hiddenTag6" style="display: none;">#</div>
	                <div id="hiddenTag7" style="display: none;">#</div>
	                <div id="hiddenTag8" style="display: none;">#</div>
	                <div id="hiddenTag9" style="display: none;">#</div>
	                <input type="hidden" id="board_select" name="board_select"/>
	                <input type="hidden" id="m_seq" name="m_seq" value="${logseq}"/>
	                <br>
	                <div id="hiddenTagAllDone" style="display: none;"></div>
	            </div>
            </div>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <textarea id="summernote" name="b_content"></textarea>
    <div id="matchingBtnDiv">
        <input type="submit" value="등록" class="recommendSubmitBtn" id="recommendSubmitBtn"/>
        <a href="/itda/recommendList"><input type="button" value="취소" id="matchingCancelBtn"/></a>
    </div>
    
    <div class="mapJoinModal" id="mapJoinModal">
        <div class="mapModalOverlay"></div>
        <article class="mapModalContent">
            <!--                           지도                               -->
            <div class="map_wrap" id="hiddenMap">
                <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
                <div id="menu_wrap" class="bg_white">
                    <div class="option">
                        <div>
                                키워드 : <input type="text" value="신촌 비트캠프" id="keyword" size="15">
                                <button type="submit">검색하기</button>
                        </div>
                    </div>
                    <hr>
                    <ul id="placesList"></ul>
                    <div id="pagination"></div>
                </div>
            </div>
        </article>
    </div>
  	</form>
</section>
<script src="/itda/js/recommendUpload.js?version=111111"></script>