const bannerDoc = document.querySelector("#matchingDetailBanner");
window.addEventListener("scroll", bannerTop);
window.addEventListener("resize", bannerLeft);
function bannerTop(){
    const bannerTopPx = window.pageYOffset;
    setTimeout(function(){
        bannerDoc.style.top = bannerTopPx + 200 + "px";
    }, 120);
}
function bannerLeft(){
    const bannerWidth = window.innerWidth;
    console.log(bannerWidth);
    bannerDoc.style.left = bannerWidth -450 + "px";
}
bannerTop();
bannerLeft();


/* Modal */
/* ----------------------------------------------------------------- */
$('#bannerBtn').click(function () {
	if($("#logseq").val()=="") {
		let tag = "";
		tag += "<h1>로그인 후 이용해주세요</h1>";
		tag += "<input type='button' id='loginPlsOk' value='확인'>";
		$(".joinModalContent").html(tag);
		$('.matchingModal').css('display', 'block');
		return false;
	} else if($("#m_rank").val()==2) {
		let tag = "";
		tag += "<h1>매칭은 실버 이상부터</h1>";
		tag += "<h1>이용가능합니다.</h1>";
		tag += "<input type='button' id='closeBtn' value='확인'>";
		$(".joinModalContent").html(tag);
		$('.matchingModal').css('display', 'block');
		return false;
	}
	bannerBtnValue = this.value;
	bannerValue = bannerBtnValue.slice(7,12);
	valueBan = bannerValue.split(" / ");
	matchingConfirm();
	if(valueBan[0] == valueBan[1]){
		return false;
	}
	
    $('.matchingModal').css('display', 'block');
});

/* 로그인 필요한 서비스 모달창 확인하면 로그인 모달 뜨게 */
$(document).on('click', '#loginPlsOk', function(){
	$('.matchingModal').css('display', 'none');
	$(".loginModal").css('display', 'block');
});
$(document).on('click', '#closeBtn', function () {
    $('.matchingModal').css('display', 'none');
});

$('.matchingModalOverlay').click(function () {
    $('.matchingModal').css('display', 'none');
});


/* 참가확인 AJAX */
function matchingConfirm(){
	var board_seq = $("#board_seq").val();
    var mc_seq = $("#mc_seq").val();
    var m_seq = $("#logseq").val();
    var lognick = $("#lognick").val();
    var rParam = "mc_seq="+mc_seq+"&m_seq="+m_seq;
    var rUrl = "/itda/matchingConfirm";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        success: function(result){
        	console.log(result);
            var result = $(result);
            if(result.length==0){
            	tag += "<form method='post' id='regForm' action='/itda/matchingIn?mc_seq="+mc_seq+"&m_seq="+m_seq+"&board_seq="+board_seq+"'>"
                tag += "<h1>정말 참가하시겠습니까?</h1>";
                tag += "<input type='submit' id='participateBtn' value='참가'>";
                tag += "<input type='button' id='closeBtn' value='취소'>";
                tag += "</form>";
                $(".joinModalContent").html(tag);
            } else {
            	tag += "<form method='post' id='regForm' action='/itda/matchingCancel?mc_seq="+mc_seq+"&m_seq="+m_seq+"&board_seq="+board_seq+"'>"
                tag += "<h1>정말 취소하시겠습니까?</h1>";
            	tag += "<input type='submit' id='cancelBtn value='확인'>";
                tag += "<input type='button' id='closeBtn' value='취소'></input>";
                tag += "</form>"
	            $(".joinModalContent").html(tag);
            }
        }, error: function(){
            console.log("매칭컨펌에러입니다")
        },
    });
}


$("#loginPls").click(function(){
	let tag = "";
	tag += "<h1>로그인 후</h1>";
	tag += "<h1>이용해주세요</h1>";
	tag += "<input type='button' id='loginPlease' value='확인'>";
	$(".matchingReportModalContent").html(tag);
	$('.matchingReportModal').css('display', 'block');
	return false;
});

/* --------------------------------------------------댓글----------------------------------------------------- */
$(function(){
    function replyList(){
    	var m_seq = $("#logseq").val();
    	board_seq = $("#board_seq").val();
        var rParam = `board_seq=${board_seq}&m_seq=${m_seq}`;
        var rUrl = "/itda/matchingReply";
        $.ajax({
            url: rUrl,
            data: rParam,
          
            success: function(result){
				var result = $(result);
				var tag = "";
				result.each(function(idx, vo){
					tag += "<div class='replyDiv'>";
					tag += "<div><img src='" + vo.m_img + "' name='profileShot'></div>";
					tag += `<div>`;
					tag += `<div id='matchingWriter'>${vo.m_nickname}(${vo.m_userid}) <span>${vo.br_writedate}</span></div>`;
					tag += `<div class='replyView'>${vo.br_content}</div>`;
					
					if(vo.m_seq == m_seq){ // 자신이 쓴 댓글일때
						tag += "<div><span class='modifyReply'>수정</span> <span>/</span> <span class='deleteReply'>지우기</span></div>";
						// 수정폼
						tag += "<div style='display: none;'>";
						
						tag += "<form method='post' class='modifyEditForm' onsubmit='return false'>";
						tag += "<textarea name='br_content'>" + vo.br_content + "</textarea>";
						tag += "<span class='editReplySubmit'>Edit</span>";
						tag += "<span>/</span>";
						tag += "<span class='editCancel'>Cancel</span>";
						tag += "<input type='hidden' name='br_id' value='" + vo.br_id + "'/>"; // 댓글의 일련번호
						tag += "</form></div>";
					}
				tag += "</div>";
				tag += "</div>";
            });
            $("#replyList").html(tag);
    	}, error: function(){
            console.log("댓글목록선택에러")
        }
       });
    }
    // 댓글쓰기 -- 댓글을 입력하지 않은 경우
	$("#writeReplyBtn").click(()=>{
	    if($.trim($("#br_content").val())==""){
	        let tag = "";
			tag += "<h1>댓글 내용을 입력해주세요.</h1>";
			tag += "<input type='button' id='closeBtn' value='확인'>";
			$(".joinModalContent").html(tag);
			$( ".matchingModal" ).css('display', 'block');
	        return false;
	    }else{
	    	const m_seq = $("#logseq").val();
	    	const br_content = $("#br_content").val();
	    	const board_seq = $("#board_seq").val();
	        const params = "m_seq=" + m_seq + "&br_content=" + br_content + "&board_seq=" + board_seq; 
	        $.ajax({
	            url: "/itda/matchingReplyWrite",
	            type: "POST", 
	            data: params, 
	            success: function(result){
	                if(result==0){
	                    alert("댓글등록 실패");
	                }else{
	                    // 목록을 다시 선택한다
	                    replyList();
	                    // 이전 댓글 지우기
	                    $("#br_content").val("");
	                }
	            }, error: function(){
	                console.log("댓글쓰기 에러");
	            }
	        });
	    }
	});
	// 댓글 수정폼 보이기
    $(document).on('click','.modifyReply',function(){
		$(this).parent().next().animate({
		    display: "block",
		    top: "+=5",
		    height: "toggle"
		  }, 200, function() {
		    // Animation complete.
	 	 });
	});
	// 댓글정보숨기기
    $(document).on('click','.editCancel',function(){
		$(this).parent().parent().animate({
		    display: "none",
		    top: "+=5",
		    height: "toggle"
		  }, 200, function() {
		    // Animation complete.
	 	 });
		// 댓글 수정폼 보이기
	});
	$(document).on('click','.editReplySubmit',function(){
		var url = "/itda/matchingReplyEdit";
		var params = $(this).parent().serialize(); // coment=문자&num=888
		console.log(params);
		$.ajax({
			url: url,
			data: params,
			type: "POST",
			success: function(result){
				replyList();
			}
		});
	});
	var deleteParams = "";
	$(document).on('click','.deleteReply',function(){
		deleteParams = $(this).parent().next().children().serialize();
		let tag = "";
		tag += "<h1>댓글을 정말 삭제하시겠습니까?</h1>";
    	tag += "<input type='button' id='deleteReplyBtn' value='확인'>";
        tag += "<input type='button' id='closeBtn' value='취소'></input>";
        $(".joinModalContent").html(tag);
		$('.matchingModal').css('display', 'block');
	});
	$(document).on('click', '#deleteReplyBtn', function(){
		console.log("버튼눌림");
		var url = "/itda/matchingReplyDelete";
		console.log(deleteParams);
		$.ajax({
			url: url,
			data: deleteParams,
			type: "POST",
			success: function(result){
				replyList();
			}
		});
		$('.matchingModal').css('display', 'none');
	});
	replyList();
	console.log("댓글 replyList() 호출했음?");
});

/*    --------------------------         주석 풀고 사용하기 ------------------------------------*/ 
/****
$("#loginPls").click(function(){
	let tag = "";
	tag += "<h1>로그인 후</h1>";
	tag += "<h1>이용해주세요</h1>";
	tag += "<input type='button' id='loginPlease' value='확인'>";
	$(".matchingReportModalContent").html(tag);
	$('.matchingReportModal').css('display', 'block');
	return false;
});
*/
/* --------------------------------------------------댓글----------------------------------------------------- */


/* --------------------------------------------------신고----------------------------------------------------- */

/* 신고한적 있는 게시글인지 아닌지 확인하는 ajax */
function boardCallCheck(){
	var board_seq = $("#board_seq").val();
    var m_seq = $("#logseq").val();
    var rParam = "board_seq="+board_seq+"&m_seq="+m_seq;
    var rUrl = "/itda/boardCallCheck";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        success: function(result){
        	console.log("result = "+result);
            if(result==0){
            	tag += `<form method="post" id="callBoardForm" method="post" >`;
				tag += `<div id="sirenPopup">`;
				tag += `<div id="sirenHeader">`;
				tag += `<h1 id="sirenH1"><img src="/itda/img/siren3.png"/><label>신고하기</label></h1>`;
				tag += `<a><img src="/itda/img/close1.png" class="close" style="position:absolute;top: 18px; right: 17px;"/></a>`;
				tag += `</div>`;
				tag += `<div id="sirenContainer">`;
				tag += `<div> `;
				tag += `<ul class="sirenInfo">`;
				tag += `<span>사유선택</span>`;
				tag += `</li>`;
				tag += `</ul>`;
				tag += `<div class="sirenWhy">`;
				tag += `<p>"여러 사유에 해당되는 경우, <br/>대표적인 사유 1개를 선택해 주세요"</p>`;
				tag += `<ul class="sirenWhySelect">`;
				tag += `<li>`;
				tag += `<input type="radio" name="call_code" id="commercialIssue" value="1" checked/>`;
				tag += `<label for="commercialIssue">&nbsp;부적절한 홍보 게시글</label>`;
				tag += `</li>`;
				tag += `<li>`;
				tag += `<input type="radio" name="call_code" id="sexualIssue" value="2"/>`;
				tag += `<label for="sexualIssue">&nbsp;음란성 또는 청소년에게 부적합한 내용</label>`;
				tag += `</li>`;
				tag += `<li>`;
				tag += `<input type="radio" name="call_code" id="rightsIssue" value="3" />`;
				tag += `<label for="rightsIssue">&nbsp;명예훼손/사생활 침해 및 저작권침해 등</label>`;
				tag += `</li>`;
				tag += `<li>`;
				tag += `<input type="radio" name="call_code" id="illigalIssue" value="4" />`;
				tag += `<label for="illigalIssue">&nbsp;불법촬영물등 신고</label>`;
				tag += `</li>`;
				tag += `<li>`;
				tag += `<input type="radio" name="call_code" id="etcIssue" value="5"/>`;
				tag += `<label for="etcIssue">&nbsp;기타</label>`;
				tag += `</li>`;
				tag += `</ul>`;
				tag += `</div>`;
				tag += `</div>`;
				tag += `</div>`;
				tag += `<div id="sirenFooter">`;
				tag += `<input type="button" id="callBoard" value="신고하기" />`;
				tag += `<input type="button" id="sirenX" value="취소"/>`;
				tag += `</div>`;
				tag += `</div>`;
				tag += `<input type="hidden" name="board_seq" value="${board_seq}"/>`;
				tag += `<input type="hidden" name="m_seq" value="${m_seq}"/>`;
				tag += `</form>`;
            } else {
            	tag += "<form method='post' id='boardCallBackForm'>"
                tag += "<h1>신고를 철회하시겠습니까?</h1>";
            	tag += "<input type='button' id='callCancel' value='철회'/>";
                tag += "<input type='button' id='sirenX' value='취소'/>";
                tag += `<input type="hidden" name="board_seq" value="${board_seq}"/>`;
				tag += `<input type="hidden" name="m_seq" value="${m_seq}"/>`;
                tag += "</form>"
            }
            $(".matchingReportModalContent").html(tag);
        }, error: function(){
            console.log("신고 ajax 에러입니다")
        },
    });
}

/* 신고 버튼 누르면 ajax로 데이터 검색해서 db에 값이 있으면 취소하는지, 없으면 신고페이지 보여줌 */
$(document).on("click", "#reportMatching", function(){
	boardCallCheck();
	$('.matchingReportModal').css('display', 'block');
});
/* ㄹㅇ 신고버튼 누르면 실행되는 ajax */
function boardCall(data){
    var rParam = data;
    var rUrl = "/itda/boardCall";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        method: "POST",
        success: function(result){
			tag += "<h1>신고를</h1>";
			tag += "<h1>완료했습니다.</h1>";
			tag += "<input type='button' id='sirenX' value='확인'>";
			$(".matchingReportModalContent").html(tag);
		}, error: function() {
			console.log("ㄹㅇ 신고에서 에러남");
		}
	});
}

/* ㄹㅇ신고버튼 누르면 */
$(document).on("click", "#callBoard", function(){
	const ajaxData = $("#callBoardForm").serialize();
	boardCall(ajaxData);
	
});

/* 신고했던 사람이면 뜨는 모달에서 신고 철회했을때 가는 ajax */
function boardCallBack(data){
	var rParam = data;
    var rUrl = "/itda/boardCallBack";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        method: "POST",
        success: function(result){
			tag += "<h1>신고를</h1>";
			tag += "<h1>철회했습니다.</h1>";
			tag += "<input type='button' id='sirenX' value='확인'>";
			$(".matchingReportModalContent").html(tag);
		}, error: function() {
			console.log("ㄹㅇ 신고에서 에러남");
		}
	});
}

/* 신고했던 사람이면 뜨는 모달에서 신고 철회했을때 */
$(document).on("click", "#callCancel", function(){
	const ajaxData = $("#boardCallBackForm").serialize();
	boardCallBack(ajaxData);
});

/* 신고 모달 */
$('#etcIssue').click(function () {
    $('#guitar').css('display', 'block');
});

$(document).on("click", "#sirenX", function () {
    $('.matchingReportModal').css('display', 'none');
});

$(document).on("click", ".close", function () {
    $('.matchingReportModal').css('display', 'none');
});

/* --------------------------------------------------신고----------------------------------------------------- */



/* --------------------------------------------------져아요----------------------------------------------------- */

/* 좋아요한적 있는 게시글인지 아닌지 확인하는 ajax 완성하고 js 마지막에 호출하게 만들어놓으면 됨 */
function goodHitCheck(){
	var board_seq = $("#board_seq").val();
    var m_seq = $("#logseq").val();
    var rParam = "board_seq="+board_seq+"&m_seq="+m_seq;
    var rUrl = "/itda/goodHitCheck";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        success: function(result){
        	var rresult=$(result);
        	console.log("rresult[0] = "+rresult[0]);
        	
            if(rresult[0].check.b_goodhit==0){
				tag += `<img alt="heart" id='heartIcon' class='goodHit' src="img/goodHit.png"> ${rresult[0].vo.b_goodhit }&nbsp;&nbsp;`;
				tag += `<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${rresult[0].vo.replyCount}&nbsp;&nbsp;`;
				tag += `<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${rresult[0].vo.board_call}</span>`;
			} else {
				tag += `<img alt="heart" id='heartIcon' class='goodHitBack' src="img/goodHitBack.png"> ${rresult[0].vo.b_goodhit }&nbsp;&nbsp;`;
				tag += `<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${rresult[0].vo.replyCount}&nbsp;&nbsp;`;
				tag += `<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${rresult[0].vo.board_call}</span>`;
				// 좋아요 안 한 글이니 색 안칠해진 죠아요 이미지 그리고 좋아요 하는 매핑 되있는 아이디 부여 id='goodHit'
			}
			// 밑에는 신고버튼용이고 여기서는 죠아요를 구현하는 곳이니 다른 장소를 찾아야함
			$(".contentReply>div:first-child").html(tag);
        }, error: function(){
            console.log("죠아요 확인하는 ajax 에러입니다")
        },
    });
}

// 좋아요 하는 펑션
function goodHit() {
	var board_seq = $("#board_seq").val();
    var m_seq = $("#logseq").val();
    var rParam = "board_seq="+board_seq+"&m_seq="+m_seq;
    var rUrl = "/itda/goodHit";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        success: function(result){
            tag += `<img alt="heart" id='heartIcon' class='goodHitBack' src="img/goodHitBack.png"> ${result.b_goodhit }&nbsp;&nbsp;`;
			tag += `<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${result.replyCount}&nbsp;&nbsp;`;
			tag += `<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${result.board_call}</span>`;
			$(".contentReply>div:first-child").html(tag);
		}, error: function(){
			console.log("죠아요 하는 ajax 에러입니다.");
		}
	});
}

// 좋아요 철회하는 펑션
function goodHitBack() {
	var board_seq = $("#board_seq").val();
    var m_seq = $("#logseq").val();
    var rParam = "board_seq="+board_seq+"&m_seq="+m_seq;
    var rUrl = "/itda/goodHitBack";
    var tag = "";
    $.ajax({
        url: rUrl,
        data: rParam,
        success: function(result){
            tag += `<img alt="heart" id='heartIcon' class='goodHit' src="img/goodHit.png"> ${result.b_goodhit }&nbsp;&nbsp;`;
			tag += `<img alt="bubble" id='bubbleIcon' src="https://cdn-icons-png.flaticon.com/512/1246/1246332.png"> ${result.replyCount}&nbsp;&nbsp;`;
			tag += `<span id='siren'><img alt="siren" id='sirenIcon' src="https://cdn-icons-png.flaticon.com/512/811/811954.png"> ${result.board_call}</span>`;
			$(".contentReply>div:first-child").html(tag);
		}, error: function(){
			console.log("죠아요 하는 ajax 에러입니다.");
		}
	});
}

// 좋아요 눌렀을때 로그인 안되어있으면 신고 모달에 로그인 하라고 내용 넣고 확인누르면 로그인 모달 띄우기 
// 로그인 되어있으면 좋아요 ajax ㄱㄱ
$(document).on("click", ".goodHit", function(){
	console.log("좋아요 하기 클릭");
	if($("#logseq").val()=="") {
		let tag = "";
		tag += "<h1>로그인 후</h1>";
		tag += "<h1>이용해주세요</h1>";
		tag += "<input type='button' id='loginPlease' value='확인'>";
		$(".matchingReportModalContent").html(tag);
		$('.matchingReportModal').css('display', 'block');
		return false;
	}
	goodHit();
});

// 좋아요 눌렀을때 로그인 안되어있으면 신고 모달에 로그인 하라고 내용 넣고 확인누르면 로그인 모달 띄우기 
// 로그인 되어있으면 좋아요 철회 ajax ㄱㄱ
$(document).on("click", ".goodHitBack", function(){
	console.log("좋아요 철회 클릭");
	if($("#logseq").val()=="") {
		let tag = "";
		tag += "<h1>로그인 후</h1>";
		tag += "<h1>이용해주세요</h1>";
		tag += "<input type='button' id='loginPlease' value='확인'>";
		$(".matchingReportModalContent").html(tag);
		$('.matchingReportModal').css('display', 'block');
		return false;
	}
	goodHitBack();
});

// 로그인 되어있으면 페이지 들어와서 좋아요 했는지 확인함
if($("#logseq").val()!="") {
	goodHitCheck();
}

$(document).on('click', '#loginPlease', function(){
	console.log("확인 클릭");
	$('.matchingReportModal').css('display', 'none');
	$(".loginModal").css('display', 'block');
});

/* --------------------------------------------------져아요----------------------------------------------------- */