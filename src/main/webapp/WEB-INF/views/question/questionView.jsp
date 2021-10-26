<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/itda/css/injeungView.css?version=1111111">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<div id='postViewDiv'><!-- 게시글뷰 페이지 -->
		<form>
			<div class='contentTitle'><!-- 카테고리,제목 -->
				<div>Q&A</div>
				<div>${vo.board_subject}</div>
			</div>
			<div class='contentWriter'><!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div><!-- 프로필이미지 -->
				<div>
					<div>${vo.m_nickname}</div>
					<div>
						<ul>
							<li>${vo.board_writedate }</li>
							<li>조회수 ${vo.board_hit}</li>
							<c:choose>
                            <c:when test='${login != null && login != vo.m_userid}'>
                            	<li id='reportMatching'>신고</li>
                            </c:when>
                            <c:when test='${vo.m_userid==login }'>
                            	<li><a href='/itda/questionEdit?board_seq=${vo.board_seq}'>글수정</a></li>
                            </c:when>
                            </c:choose>
						</ul>
					</div>
				</div>
			</div>
			<div class='contentView'>
				<!-- 글내용박스 -->
				${vo.b_content}
				
			</div>
			<div class='contentReply'>
				<div><!-- 1 좋아요/댓글수 -->
					<img alt="heart" id='heartIcon' src="https://cdn-icons-png.flaticon.com/512/812/812327.png"> ${vo.b_goodhit}&nbsp;&nbsp;
					<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${vo.replyCount }&nbsp;&nbsp;
					<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${vo.board_black}</span>
				</div>
				<div id="replyList"><!-- 2 댓글박스 -->
					
				</div>
				
				
				<div><!-- 3 댓글 텍스트박스 -->
					<textarea name='replyCommentTextarea' id='replyCommentTextarea'></textarea>
					<div>
						<c:choose>
                    	<c:when test='${logseq!=null }'>
                        <input type='button' name='writeReplyBtn' class="viewBtn" id='writeReplyBtn' value='작성'/>
                        </c:when>
                        <c:otherwise>
                        <input type='button' name='writeReplyBtn' class="viewBtn" id='loginPls' value='작성'/>
                        </c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<input type="hidden" id="board_seq" value="${vo.board_seq}"/>
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
	                    <div class='nextPrevDiv'><a href="/itda/questionView?board_seq=${vo.board_next_seq}"><span class='nextPrevWord'>다음글</span> ${vo.board_next_subject}
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
	                    <div class='nextPrevDiv'><a href="/itda/questionView?board_seq=${vo.board_prev_seq}"><span class='nextPrevWord'>이전글</span> ${vo.board_prev_subject}
	                    </a></div>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
			<div id='bottomBtn'>
                <a href='/itda/questionBoard'><input type='button' name='postListBtn' value='목록'/></a>
                <c:if test='${logseq!=null}'>
                <a href='/itda/writeQuestion'><input type='button' name='postWriteBtn' value='글쓰기'/></a>
                </c:if>
            </div>

		</form>
	</div>
	
	
	
	<!-- 신고모달, alert 대용 모달 -->
    <div class="matchingReportModal" id="matchingReportModal">
        <div class="matchingReportModalOverlay"></div>
        <article class="matchingReportModalContent">
            
        </article>
    </div>
    
<script src="/itda/js/injeungView.js?version=11"></script>