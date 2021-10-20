<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<link rel="stylesheet" href="/itda/css/matchingUpload.css?version=111111">
    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    <section id="matchingUploadFrame">
    <h1>매칭게시판</h1>
        <div id="matchingBasicInfoArea">
            <form method="post" action="/itda/matchingWriteOk" id="matchingUploadForm" action="/itda/matchingWriteOk" onsubmit="return false">
                <div>
                    <ul id="titleAndMap">
                        <li><input type="text" id="matchingUploadTitle" name="board_subject" placeholder="제목을 입력하세요" required/></li>
                        <li><input type="button" value="지도" id="mapBtn"></li>
                        <li><input type="text" name="searchText" id="searchText" placeholder="태그를 입력하세요(최소 5개, 최대 10개)"/></li>
                        <li>매칭 시작일</li>
                        <li><input type="date" name="startDate" required/></li>
                        <li>매칭 시간</li>
                        <li><input type="time" name="startTime" required/></li>
                        <li>~</li>
                        <li><input type="time" name="endTime" required/></li>
                        <li><input type="number" name="mc_max" id="mc_max" placeholder="매칭 최대 인원 (최대 10인)" min="2" max="10"/></li>
                        <li><select name="sido" id="sido"></select><select name="gugun" id="gugun"></select></li>
                        <li><input type="radio" class="mc_state" id="mc_state1" name="mc_state" value="1" checked/>
			                <label for="mc_state1">일회성모임</label>
			                <input type="radio" class="mc_state" id="mc_state2" name="mc_state" value="2"/>
			                <label for="mc_state2">정기모임</label>
			            </li>
                    </ul>
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
                    <br>
                    <div id="hiddenTagAllDone" style="display: none;"></div>
                </div>
        </div>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <textarea id="summernote" name="b_content"></textarea>
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
        </form>
        </div>
        </section>
    <script src="/itda/js/matchingUpload.js?version=111111"></script>