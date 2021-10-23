<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/itda/css/matchingView.css?version=1111111">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<aside id="matchingDetailBanner">
        <div id="hostIntro">
            주최자 소개<br />
        </div>
        <div id="hostPhoto">
            <img src="/itda/img/retriever.jpg" alt="강아지">
        </div>
        <div id="hostUserid">
            <b>${vo.m_nickname}</b><br />
        </div>
        <div id="hostComment">
            ${vo.m_info }
        </div>
        <div id="hostMatchingInfo">
            ${vo.mc_where}<br />${vo.mc_start_date }<br />~<br/> ${vo.mc_end_date}<br/>
        </div>
        <div>
			<c:choose>
        	<c:when test="${part.size()==vo.mc_max}">
	            <input type="button" id="bannerBtn" value="신청마감 ( ${part.size() } / ${vo.mc_max} )" /><br />
        	</c:when>
        	<c:otherwise>
        		<input type="button" id="bannerBtn" value="신청하기 ( ${part.size() } / ${vo.mc_max} )" /><br />
        	</c:otherwise>
        	</c:choose>
        </div>

        <div id="partUserIntro">참가중인유저목록</div>
        <c:forEach var="matching" items="${part}">
	        <div class="partUsers">
		       <span style="color: blue">
		       <c:choose>
		        	<c:when test='${matching.m_rank==0}'>
		        		슈퍼 
		        	</c:when>
		        	<c:when test='${matching.m_rank==1}'>
		        		관리 
		        	</c:when>
		        	<c:when test='${matching.m_rank==2}'>
		        		브론즈 
		        	</c:when>
		        	<c:when test='${matching.m_rank==3}'>
		        		실버 
		        	</c:when>
		        	<c:when test='${matching.m_rank==4}'>
		        		골드 
		        	</c:when>
		        </c:choose>
		        </span>
	         ${matching.m_nickname} </div>
        </c:forEach>
    </aside>
    

    <div id='postViewDiv'><!-- 게시글뷰 페이지 -->
        <form>
            <div class='contentTitle'><!-- 카테고리,제목 -->
                <div>매칭게시판</div>
                <div>${vo.board_subject}</div>	
            </div>
            <div class='contentWriter'><!-- 작성자 -->
                <div><img src='/itda/img/user.png' name='profileShot' /></div><!-- 프로필이미지 -->
                <div>
                    <div class='userid'>${vo.m_nickname}(${vo.m_userid})</div>
                    <div>
                        <ul>
                            <li>${vo.board_writedate}</li>
                            <li>조회수 ${vo.board_hit}</li>
                            <c:choose>
                            <c:when test='${login != null && login != vo.m_userid}'>
                            	<li>신고</li>
                            </c:when>
                            <c:when test='${vo.m_userid==login }'>
                            	<li><a href='/itda/matchingEdit?board_seq=${vo.board_seq}'>글수정</a></li>
                            </c:when>
                            </c:choose>
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
                ${vo.b_content}
                <br/>
                
            </div>
            <div class='contentReply'>
                <div><!-- 1 좋아요/댓글수 -->
                    <img alt="heart" id='heartIcon' src="https://cdn-icons-png.flaticon.com/512/812/812327.png"> ${vo.b_goodhit }&nbsp;&nbsp;
                    <!-- 해야함 -->
                    <img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${vo.replyCount}&nbsp;&nbsp;
                    <span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${vo.board_call}</span>
                </div>
                <div id='replyList'><!-- 2 댓글박스 -->
                	
                </div>
                <div id="replyTextBox"><!-- 3 댓글 텍스트박스 -->
                    <textarea class='br_content' id='br_content'></textarea>
                    <div>
                    	<c:choose>
                    	<c:when test='${logseq!=null }'>
                        <input type='button' name='writeReplyBtn' id='writeReplyBtn' value='작성'/>
                        </c:when>
                        <c:otherwise>
                        <input type='button' name='loginPls' id='loginPls' value='작성'/>
                        </c:otherwise>
						</c:choose>
                    </div>
                </div>
            </div>
            <input type="hidden" id="board_seq" value="${vo.board_seq}"/>
            <input type="hidden" id="mc_seq" value="${vo.mc_seq}"/>
            <input type="hidden" id="logseq" value="${logseq}"/>
            <input type="hidden" id="lognick" value="${lognick}"/>
            <div id='otherContent'><!-- 이전글/다음글 -->
                <div>
                    <div class='arrowDiv'><img src='/itda/img/up-arrow.png' name='prevPost'/></div>
                    <c:choose>
                    <c:when test="${vo.board_next_subject=='다음글이 없습니다.'}">
	                    <div class='nextPrevDiv' style="color: gray">${vo.board_next_subject}</div>
                    </c:when>
                    <c:otherwise>
	                    <div class='nextPrevDiv'><a href="/itda/matchingView?board_seq=${vo.board_next_seq}"><span class='nextPrevWord'>다음글</span> ${map.vo.board_next_subject}
	                    	<c:forEach var='nextTag' items='${vo.nextTags}'>
	                    		<span class='nextPrevTag'>#${nextTag}</span>
	                    	</c:forEach>
	                    </a></div>
                    </c:otherwise>
                    </c:choose>
                </div>
                <div>
                    <div class='arrowDiv'><img src='/itda/img/down-arrow.png' name='nextPost'/></div>
                    <c:choose>
                    <c:when test="${vo.board_prev_subject=='이전글이 없습니다.'}">
	                    <div class='nextPrevDiv' style="color: gray">${vo.board_prev_subject}</div>
                    </c:when>
                    <c:otherwise>
	                    <div class='nextPrevDiv'><a href="/itda/matchingView?board_seq=${vo.board_prev_seq}"><span class='nextPrevWord'>이전글</span> ${map.vo.board_prev_subject}
	                    	<c:forEach var='prevTag' items='${vo.prevTags}'>
	                    		<span class='nextPrevTag'>#${prevTag}</span>
	                    	</c:forEach>
	                    </a></div>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div id='bottomBtn'>
                <a href='/itda/matchingList'><input type='button' name='postListBtn' value='목록'/></a>
                <a href='/itda/matchingUpload'><input type='button' name='postWriteBtn' value='글쓰기'/></a>
            </div>
        </form>
    </div>
    <!-- ----------------------- 참가확인 모달창---------------------------->
    <!-- ------------------------확인 누르면 데이터 전송하고 성공시 innerHTML으로 성공, 실패 여부 보여주기 필요함----------------------------- -->
    <div class="matchingModal" id="matchingModal">
        <div class="matchingModalOverlay"></div>
        <article class="joinModalContent">
            
        </article>
    </div>
    

<script src="/itda/js/matchingView.js?version=1111111111111111111111111111111111"></script>