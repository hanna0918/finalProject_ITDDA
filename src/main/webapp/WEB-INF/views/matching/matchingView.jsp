<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/itda/css/matchingView.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<aside id="matchingDetailBanner">
        <div id="hostIntro">
            주최자 소개<br />
        </div>
        <div id="hostPhoto">
            <img src="/itda/img/retriever.jpg" alt="강아지">
        </div>
        <div id="hostUserid">
            <b>${vo.m_userid }</b><br />
        </div>
        <div id="hostComment">
            안녕하세요.<br /> 런닝맨입니다.<br /> 달리기 위해 사는<br /> 강아지입니다.<br /> 하루종일 달리실 분<br />
            환영<br />
        </div>
        <div id="hostMatchingInfo">
            ${vo.b_where}<br /> 매월 네번째 일요일<br /> ${vo.b_matchingdate }<br /> 15:00~18:00<br />
        </div>
        <div>
            <input type="button" id="bannerBtn" value="신청하기 ( ${vo.b_nowpart} / ${vo.b_maxpart} )" /><br />
        </div>

        <div id="partUserIntro">참가중인유저목록</div>
        <div class="partUsers">골드 세상제일빠른쿼카 5.0</div>
        <div class="partUsers">실버 나고양이키운다 4.4</div>
        <div class="partUsers">(공란)</div>
        <div class="partUsers">(공란)</div>
        <div class="partUsers">(공란)</div>
    </aside>
    <h1>매칭게시판</h1>

    <div id='postViewDiv'><!-- 게시글뷰 페이지 -->
        <form>
            <div class='contentTitle'><!-- 카테고리,제목 -->
                <div>카테고리</div>
                <div>${vo.b_subject }</div>
            </div>
            <div class='contentWriter'><!-- 작성자 -->
                <div><img src='/itda/img/circle.png' name='profileShot' /></div><!-- 프로필이미지 -->
                <div>
                    <div class='userid'>${vo.m_userid }</div>
                    <div>
                        <ul>
                            <li>${vo.b_writedate}</li>
                            <li>조회수 ${vo.b_hit}</li>
                            <li>신고</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class='contentView'>
	            <div>
		            <c:forEach var='item' items='${vo.tags}'>
	     	           <span>#${item}</span>
	                </c:forEach>
   	           </div>
                <!-- 글내용박스 -->
                Uluru is an inselberg, meaning "island mountain". An
                inselberg is a prominent isolated residual knob or hill that rises
                abruptly from and is surrounded by extensive and relatively flat
                erosion lowlands in a hot, dry region. 
                <img src='https://apod.nasa.gov/apod/image/2105/UluruOrion_Liu_1080.jpg' style='width: 900px;' />
                Uluru is also often
                referred to as a monolith, although this is an ambiguous term that
                is generally avoided by geologists. The remarkable feature of
                Uluru is its homogeneity and lack of jointing and parting at bedding
                surfaces, leading to the lack of development of scree slopes and
                soil. These characteristics led to its survival, while the
                surrounding rocks were eroded. For the purpose of mapping and
                describing the geological history of the area, geologists refer to
                the rock strata making up Uluru as the Mutitjulu Arkose, and it is
                one of many sedimentary formations filling the Amadeus Basin. 
                
            </div>
            <div class='contentReply'>
                <div><!-- 1 좋아요/댓글수 -->
                    <img alt="heart" id='heartIcon' src="https://cdn-icons-png.flaticon.com/512/812/812327.png"> 15&nbsp;&nbsp;
                    <img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> 3&nbsp;&nbsp;
                    <span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> 2</span>
                </div>
                <div><!-- 2 댓글박스 -->
                    <div><img src='/itda/img/circle.png' name='profileShot'></div>
                    <div>
                        <div id='userid' class='userid'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
                        <div class='replyView'>내글에 내가 댓글달기</div>
                        <div><span>댓글 / 수정 / 지우기</span></div>				
                    </div>
                </div>
                <div><!-- 3 댓글 텍스트박스 -->
                    <textarea name='replyCommentTextarea' id='replyCommentTextarea'></textarea>
                    <div>
                        <input type='button' name='writeReplyBtn' value='작성'/>
                    </div>
                </div>
            </div>
            <div id='otherContent'><!-- 이전글/다음글 -->
                <div>
                    <div class='arrowDiv'><img src='/itda/img/up-arrow.png' name='prevPost'/></div>
                    <div><a>이전글도 순찬이글 </a></div>
                </div>
                <div>
                    <div class='arrowDiv'><img src='/itda/img/down-arrow.png' name='nextPost'/></div>
                    <div><a>다음글도 순찬이글 </a></div>
                </div>
            </div>
            <div id='bottomBtn'>
                <input type='button' name='postListBtn' value='목록'/>
                <input type='button' name='postWriteBtn' value='글쓰기'/>
            </div>

        </form>
    </div>
    <!-- ----------------------- 참가확인 모달창---------------------------->
    <!-- ------------------------확인 누르면 데이터 전송하고 성공시 innerHTML으로 성공, 실패 여부 보여주기 필요함----------------------------- -->
    <div class="matchingModal" id="matchingModal">
        <div class="matchingModalOverlay"></div>
        <article class="joinModalContent">
            <form method="post" id="regForm" action="formOk">
                <h1>무서운호랑이님 정말 참가하시겠습니까?</h1>
                <input type="button" id="participateBtn" value="참가">
                <input type="button" id="closeBtn" value="취소">
            </form>
        </article>
    </div>
		



<script src="/itda/js/matchingView.js?version=1"></script>
