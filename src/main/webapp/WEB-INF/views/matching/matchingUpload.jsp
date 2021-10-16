<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<link rel="stylesheet" href="/itda/css/matchingUpload.css">
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
            <form method="post" action="#">
                <div>
                    <ul id="titleAndMap">
                        <li><input type="text" id="matchingUploadTitle" name="matchingUploadTitle" placeholder="제목을 입력하세요" /></li>
                        <li><input type="button" value="지도" id="mapBtn"></li>
                        <li><input type="text" name="searchText" id="searchText" placeholder="태그를 입력하세요(최대 10개)" /></li>
                        <li><select name="sido1" id="sido1"></select><select name="gugun1" id="gugun1"></select></li>
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
                </div>
        </div>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <div id="summernote"></div>
        <div id="matchingBtnDiv">
            <input type="submit" value="등록" id="matchingSubmitBtn" />
            <input type="submit" value="취소" id="matchingCancelBtn" />
        </div>
        <div class="loginJoinModal" id="loginJoinModal">
            <div class="modalOverlay"></div>
            <article class="joinModalContent">
                <!--                           지도                               -->
                <div class="map_wrap" id="hiddenMap">
                    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
                    <div id="menu_wrap" class="bg_white">
                        <div class="option">
                            <div>
                                <form onsubmit="searchPlaces(); return false;">
                                    키워드 : <input type="text" value="신촌 비트캠프" id="keyword" size="15">
                                    <button type="submit">검색하기</button>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <ul id="placesList"></ul>
                        <div id="pagination"></div>
                    </div>
                </div>
                </form>
            </article>
        </div>
    </section>
    <script src="/itda/js/matchingUpload.js"></script>