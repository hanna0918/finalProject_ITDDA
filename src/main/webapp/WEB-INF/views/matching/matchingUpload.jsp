<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel="stylesheet" href="/itda/css/matchingUpload.css">
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <section id="matchingUploadFrame">
	    <div class="boardName">
		    <h2>MATCHING</h2>
		    <h4>나와 다른사람을 이어보세요!</h4>
	  	</div>
	    <form method="post" action="/itda/matchingWriteOk" id="matchingUploadForm" action="/itda/matchingWriteOk" onsubmit="return false">
	    	<div id="matchingBasicInfoArea">
	            <div>
	                <div id="titleAndMap">
	                    <div><input type="text" id="matchingUploadTitle" name="board_subject" placeholder="제목을 입력하세요" required/></div>
	                    <div><input type="button" value="지도" id="mapBtn"></div>
	                    <div><input type="text" name="searchText" id="searchText" placeholder="#태그를 입력하세요(최소 5개, 최대 10개)"/></div>
	                    <div id="dayAndTime">
		                    <div>매칭시작일</div>
		                    <div><input type="date" name="startDate" required/></div>
		                    <div>매칭시간</div>
		                    <div><input type="time" name="startTime" required/></div>
		                    <div>~</div>
		                    <div><input type="time" name="endTime" required/></div>
	                    </div>
	                    <div id="countAndSido">
	                    	<div>매칭인원</div>
		                    <div><input type="number" name="mc_max" id="mc_max" placeholder="매칭 최대 인원 (최대 10인)" min="2" max="10" required/></div>
		                    <div>매칭지역</div>
		                    <div><select name="sido" id="sido"></select><select name="gugun" id="gugun"></select></div>
		                    <div><input type="radio" class="mc_state" id="mc_state1" name="mc_state" value="1" checked/>
			                <label for="mc_state1">일회성모임</label>
			                <input type="radio" class="mc_state" id="mc_state2" name="mc_state" value="2"/>
			                <label for="mc_state2">정기모임</label>
			            </div>
			        </div>
			         <div>
							<label class="input-file-button" for="input-file">썸네일</label> 
							<input type="file" id="input-file" name="input-file"/>
							<input type="hidden" name="i_url" id="i_url"/>
					</div>
					
						<script>
						$("#input-file").change(function(){
							console.log(this.files && this.files[0]);
							if(this.files && this.files[0]) {
					    		var reader = new FileReader;
						    	reader.onload = function(data) {
						    		console.log(data.target.result+ 'dddddddd나오냐이미지');
						    		$("#thumbnail").attr("src", data.target.result).width(500);
					    		}
					    		reader.readAsDataURL(this.files[0]);
								//reader.readAsText(this.files[0]);
								//console.log(reader.readAsText(this.files[0]));
								fileCheck();
					    	}
				    	});
						function fileCheck() {
							//input file 태그.
							var file = document.getElementById('input-file');
							//파일 경로.
							var filePath = file.value;
							//전체경로를 \ 나눔.
							var filePathSplit = filePath.split('\\'); 
							//전체경로를 \로 나눈 길이.
							var filePathLength = filePathSplit.length;
							//마지막 경로를 .으로 나눔.
							var fileName = filePathSplit[filePathLength-1];
							
							console.log('파일 경로 : ' + filePath);
							console.log('파일명 : ' + fileName);
							$("#i_url").val(fileName);
						}
						</script>
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
	    <textarea id="summernote" name="b_content"><img src="" id="thumbnail" /></textarea>
	    <div id="matchingBtnDiv">
	        <input type="submit" value="등록" id="matchingSubmitBtn"/>
	        <a href="redirect:matchingList"><input type="button" value="취소" id="matchingCancelBtn"/></a>
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
    <script src="/itda/js/matchingUpload.js?version=111111"></script>
