<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div id='postViewDiv'><!-- 게시글뷰 페이지 -->
		<form>
			<div class='contentTitle'><!-- 카테고리,제목 -->
				<div>HANGOUT</div>
				<div>Uluru 울룰루 안갔다온게 한이된다 진짜 다시간다 호주!!!!</div>
			</div>
			<div class='contentWriter'><!-- 작성자 -->
				<div><img src='img/circle.png' name='profileShot' /></div><!-- 프로필이미지 -->
				<div>
					<div class='postWriterNick'>내가순찬</div>
					<div>
						<ul>
							<li>2021-09-18</li>
							<li>조회수 18</li>
							<li>신고</li>
						</ul>
					</div>
				</div>
			</div>
			<div class='contentView'>
				<div><span>#울룰루</span><span>#호주</span><span>#안가보면</span><span>#후회할걸</span><span>#그래서</span><span>#내가후회중</span></div>
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
					<div class="replyBox">
						<div><img src='img/circle.png' name='profileShot'></div>
						<div>
							<div class='boardWriter'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
							<div class='replyView'>내글에 내가 댓글달기</div>
							<div><span>수정</span> <span>지우기</span></div>				
						</div>
					</div>
					<div class="replyBox">
						<div><img src='img/circle.png' name='profileShot'></div>
						<div>
							<div class='boardWriter'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
							<div class='replyView'>내글에 내가 댓글달기</div>
							<div><span>수정</span> <span>지우기</span></div>				
						</div>
					</div>
					<div class="replyBox">
						<div><img src='img/circle.png' name='profileShot'></div>
						<div>
							<div class='boardWriter'>내가순찬${usernick}(sunchan123${userid}) <span>2021-06-21</span></div>
							<div class='replyView'>내글에 내가 댓글달기</div>
							<div><span>수정</span> <span>지우기</span></div>				
						</div>
					</div>
				</div>
				<div><!-- 3 댓글 텍스트박스 -->
					<textarea name='replyCommentTextarea' id='replyCommentTextarea'></textarea>
					<div>
						<input type='button' id='writeReplyBtn' class="viewBtn" value='작성'/>
					</div>
				</div>
			</div>
			<div id='otherContent'><!-- 이전글/다음글 -->
				<div>
					<div class='arrowDiv'><img src='img/up-arrow.png' name='prevPost'/></div>
					<div>이전글 <a>순찬이글 </a></div>
				</div>
				<div>
					<div class='arrowDiv'><img src='img/down-arrow.png' name='nextPost'/></div>
					<div>다음글 <a>순찬이글 </a></div>
				</div>
			</div>
			<div id='bottomBtn'>
				<input type='button' id='postListBtn' class="viewBtn" value='목록'/>
				<input type='button' id='postWriteBtn' class="viewBtn" value='글쓰기'/>
			</div>

		</form>
	</div>
