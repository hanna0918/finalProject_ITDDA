<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id='postViewDiv'><!-- 게시글뷰 페이지 -->
		<form>
			<div class='contentTitle'><!-- 카테고리,제목 -->
				<div>Q&A</div>
				<div>${vo.board_subject}</div>
			</div>
			<div class='contentWriter'><!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div><!-- 프로필이미지 -->
				<div>
					<div>${vo.m_seq}</div>
					<div>
						<ul>
							<li>${vo.board_writedate}</li>
							<li>${vo.board_hit}</li>
							<li>${vo.board_call}</li>
						</ul>
					</div>
				</div>
			</div>
			<div class='contentView'>
				<div><span>#울룰루</span><span>#호주</span><span>#안가보면</span><span>#후회할걸</span><span>#그래서</span><span>#내가후회중</span></div>
				<!-- 글내용박스 -->
				${vo.b_content}
			</div>
			<div class='contentReply'>
				<div><!-- 1 좋아요/댓글수 -->
					<img alt="heart" id='heartIcon' src="https://cdn-icons-png.flaticon.com/512/812/812327.png"> ${vo.b_goodhit}&nbsp;&nbsp;
					<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> 3&nbsp;&nbsp;
					<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${vo.board_black}</span>
				</div>
				<div><!-- 2 댓글박스 -->
					<div><img src='img/circle.png' name='profileShot'></div>
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
					<div class='arrowDiv'><img src='img/up-arrow.png' name='prevPost'/></div>
					<div><a>이전글도 순찬이글 </a></div>
				</div>
				<div>
					<div class='arrowDiv'><img src='img/down-arrow.png' name='nextPost'/></div>
					<div><a>다음글도 순찬이글 </a></div>
				</div>
			</div>
			<div id='bottomBtn'>
				<input type='button' name='postListBtn' value='목록'/>
				<input type='button' name='postWriteBtn' value='글쓰기'/>
			</div>

		</form>
	</div>
