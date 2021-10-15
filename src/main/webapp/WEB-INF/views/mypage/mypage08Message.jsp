<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="/inc/mypageTop.jspf"%>
<!-- -----------------------  쪽지함 ----------------------- -->
<div id='messageBox'>
	<h2>쪽지함</h2>
	<div id='msgTab'>
		<ul>
			<li id='receiveMsg'>받은쪽지함</li>
			<li id='sendMsg'>보낸쪽지함</li>
		</ul>
	</div>
	<div id='msgListDiv'>
		<div id='receiveList'>
			<div class='msgList'>
				<ul class='msgListTitle'>
					<li>&nbsp</li>
					<li>발신자</li>
					<li>내용</li>
					<li>보낸날짜</li>
				</ul>
				<ul class='msgListContent'>
					<li><input type='checkbox' name='receiveChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>안녕하세요 장터에 올려둔 텐트보고 연락드립니다ㅇㅅㅇ</li>
					<li>2021-05-16 18:23</li>
					<li><input type='checkbox' name='receiveChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>안녕하세요 장터에 올려둔 텐트보고 연락드립니다ㅇㅅㅇ</li>
					<li>2021-05-16 18:23</li>
					<li><input type='checkbox' name='receiveChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>안녕하세요 장터에 올려둔 텐트보고 연락드립니다ㅇㅅㅇ</li>
					<li>2021-05-16 18:23</li>
				</ul>
			</div>
			<div class='msgChkAndDel'>
				<div>
					<label><input type='checkbox' name='receiveMsgAllCheck'
						id='receiveMsgAllCheck' />전체선택</label>
				</div>
				<div>
					<input type='button' name='msgDelBtn' value='✘ 삭제' />
				</div>
			</div>
			<div id='page'>
				<ul>
					<li><a href='#'><</a></li>
					<li><a href='#'>1</a></li>
					<li><a href='#'>2</a></li>
					<li><a href='#'>3</a></li>
					<li><a href='#'>4</a></li>
					<li><a href='#'>5</a></li>
					<li><a href='#'>></a></li>
				</ul>
			</div>
		</div>
		<div id='sendList'>
			<div class='msgList'>
				<ul class='msgListTitle'>
					<li>&nbsp</li>
					<li>수신자</li>
					<li>내용</li>
					<li>보낸날짜</li>
				</ul>
				<ul class='msgListContent'>
					<li><input type='checkbox' name='sendChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>캠핑자리남았나요</li>
					<li>2021-05-16 18:23</li>
					<li><input type='checkbox' name='sendChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>캠핑자리남았나요</li>
					<li>2021-05-16 18:23</li>
					<li><input type='checkbox' name='sendChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>캠핑자리남았나요</li>
					<li>2021-05-16 18:23</li>
					<li><input type='checkbox' name='sendChk' /></li>
					<li id='userid'>캠핑요정(camping)</li>
					<li>캠핑자리남았나요</li>
					<li>2021-05-16 18:23</li>
				</ul>
			</div>
			<div class='msgChkAndDel'>
				<div>
					<label><input type='checkbox' name='sendMsgAllCheck'
						id='sendMsgAllCheck' />전체선택</label>
				</div>
				<div>
					<input type='button' name='msgDelBtn' value='✘ 삭제' />
				</div>
			</div>
			<div id='page'>
				<ul>
					<li><a href='#'><</a></li>
					<li><a href='#'>1</a></li>
					<li><a href='#'>2</a></li>
					<li><a href='#'>3</a></li>
					<li><a href='#'>4</a></li>
					<li><a href='#'>5</a></li>
					<li><a href='#'>></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 쪽지확인 모달창 -->
	<div class="readMsgModal" id="readMsgModal">
		<article class="msgModalContent msgDataInputModal style="
			box-shadow: 10px 10px 5pxlightgrey;" >
			<div>
				<form>
					<h4>쪽지</h4>
					<a><img src="../img/close1.png" class="close3"
						style="position: absolute; top: 10px; right: 16px;" /></a>
					<ul class="msgInfo">
						<li style="text-align: left; padding-left: 25px;">받는사람 &nbsp;
							: &nbsp; ${userid}</li>
						<li
							style="text-align: left; padding-left: 25px; padding-top: 10px;">내용</li>
						<li>Uluru is also often referred to as a monolith, although
							this is an ambiguous term that is generally avoided by
							geologists. The remarkable feature of Uluru is its homogeneity
							and lack of jointing and parting at bedding surfaces, leading to
							the lack of development of scree slopes and soil. These
							characteristics led to its survival, while the surrounding rocks
							were eroded. For the purpose of mapping and describing the
							geological history of the area, geologists refer to the rock
							strata making up Uluru as the Mutitjulu Arkose, and it is one of
							many sedimentary formations filling the Amadeus Basin.</li>
					</ul>
					<div id='msgBtnDiv'>
						<input type="submit" value="답장" id="answerMsg" /> <input
							type="button" value="취소" id="checkMsg" />
					</div>
				</form>
			</div>
		</article>
	</div>

	<!-- 쪽지답장하기 모달창 -->
	<div class="mailJoinModal" id="mailJoinModal">
		<article class="mailModalContent mailDataInputModal style="
			box-shadow: 10px 10px 5pxlightgrey;" >
			<div>
				<form method='post' action=''>
					<h4>🍊 쪽지 보내기</h4>
					<a><img src="../img/close1.png" class="close3"
						style="position: absolute; top: 10px; right: 16px;" /></a>
					<ul class="mailInfo">
						<li style="text-align: left; padding-left: 25px;">받는사람 &nbsp;
							: &nbsp; ${userid}</li>
						<li
							style="text-align: left; padding-left: 25px; padding-top: 10px;">내용</li>
						<li><textarea class="mailTextarea" title="쪽지 내용을 입력하세요"
								placeholder="쪽지 내용을 입력하세요"
								style="margin: 5px; width: 325px; height: 200px; resize: none; outline-style: none; padding: 0; border-radius: 3px 3px 0 0; font-size: 14px; cursor: text">
                          </textarea></li>
					</ul>
					<input type="submit" value="보내기" id="yesMail" /> <input
						type="button" value="취소" id="noMail" />
				</form>
			</div>
		</article>
	</div>
</div>

