<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id='postViewDiv'><!-- 게시글뷰 페이지 -->
		<form>
			<div class='contentTitle'><!-- 카테고리,제목 -->
				<div>인증</div>
				<div>${vo.board_subject}</div>
			</div>
			<div class='contentWriter'><!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div><!-- 프로필이미지 -->
				<div>
					<div class='postWirterNick'>${vo.m_nickname }</div>
					<div>
						<ul>
							<li>${vo.board_writedate }</li>
							<li>조회수 ${vo.board_hit }</li>
							<c:when test='${login != null && login != vo.m_userid}'>
                            	<li id='reportMatching'>신고</li>
                            </c:when>
						</ul>
					</div>
				</div>
			</div>
			<div class='contentView'>
				<div>
					<c:forEach var='tags' items='${tag}'>
					<span>#tags</span>
					</c:forEach>
				</div>
				<!-- 글내용박스 -->
				${vo.b_content }
				
			</div>
			<div class='contentReply'>
				<div><!-- 1 좋아요/댓글수 -->
                    <img alt="heart" id='heartIcon' class='goodHit' src="https://cdn-icons-png.flaticon.com/512/812/812327.png"> ${vo.b_goodhit }&nbsp;&nbsp;
                    <!-- 해야함 -->
                    <img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${vo.replyCount}&nbsp;&nbsp;
                    <span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${vo.board_call}</span>
                </div>
                
				<div><!-- 2 댓글박스 -->
					<div><img src='img/circle.png' name='profileShot'></div>
					<div>
						<div class='boardWriter'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
						<div class='replyView'>내글에 내가 댓글달기</div>
						<div><span>수정</span> <span>지우기</span></div>				
					</div>
				</div>
				
				
				<div><!-- 3 댓글 텍스트박스 -->
					<textarea name='replyCommentTextarea' id='replyCommentTextarea'></textarea>
					<div>
						<input type='button' name='writeReplyBtn' class="viewBtn" value='작성'/>
					</div>
				</div>
			</div>
			<div id='otherContent'><!-- 이전글/다음글 -->
                <div>
                    <div class='arrowDiv'><img src='/itda/img/up-arrow.png' name='prevPost'/></div>
                    <c:choose>
                    <c:when test="${vo.board_next_subject=='다음글이 없습니다.'}">
	                    <div class='nextPrevDiv' style="color: gray">${vo.board_next_subject}</div>
                    </c:when>
                    <c:otherwise>
	                    <div class='nextPrevDiv'><a href="/itda/injeungView?board_seq=${vo.board_next_seq}"><span class='nextPrevWord'>다음글</span> ${map.vo.board_next_subject}
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
	                    <div class='nextPrevDiv'><a href="/itda/injeungView?board_seq=${vo.board_prev_seq}"><span class='nextPrevWord'>이전글</span> ${map.vo.board_prev_subject}
	                    	<c:forEach var='prevTag' items='${vo.prevTags}'>
	                    		<span class='nextPrevTag'>#${prevTag}</span>
	                    	</c:forEach>
	                    </a></div>
                    </c:otherwise>
                    </c:choose>
                </div>
            </div>
			<div id='bottomBtn'>
                <a href='/itda/injeungBoard'><input type='button' name='postListBtn' value='목록'/></a>
                <c:if test='${logseq!=null}'>
                <a href='/itda/writeInjeung'><input type='button' name='postWriteBtn' value='글쓰기'/></a>
                </c:if>
            </div>

		</form>
	</div>
