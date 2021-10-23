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

    
$('#participateBtn').one("click", function () {
    $(".joinModalContent").append("<label style='color: red; font-size: 0.8em'>로그인 후 참가버튼을 눌러주세요</label>");
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
            } else {
            	tag += "<form method='post' id='regForm' action='/itda/matchingCancel?mc_seq="+mc_seq+"&m_seq="+m_seq+"&board_seq="+board_seq+"'>"
                tag += "<h1>정말 취소하시겠습니까?</h1>";
            	tag += "<input type='submit' id='cancelBtn value='취소'>";
                tag += "<input type='button' id='closeBtn' value='취소'></input>";
                tag += "</form>"
            }
            $(".joinModalContent").html(tag);
        }, error: function(){
            console.log("매칭컨펌에러입니다")
        },
    });
}

$("#loginPls").click(function(){
	let tag = "";
	tag += "<h1>로그인 후 이용해주세요</h1>";
	tag += "<input type='button' id='closeBtn' value='확인'>";
	$(".joinModalContent").html(tag);
	$('.matchingModal').css('display', 'block');
});



/* 댓글!!! */
$(function(){
    function replyList(){
    	var m_seq = $("#logseq").val();
    	board_seq = $("#board_seq").val();
    	console.log("board_seq = " + board_seq);
        var rParam = `board_seq=${board_seq}&m_seq=${m_seq}`;
        var rUrl = "/itda/matchingReply";
        $.ajax({
            url: rUrl,
            data: rParam,
          
            success: function(result){
				console.log(result);
				var result = $(result);
				var tag = "";
				result.each(function(idx, vo){
					tag += "<div class='replyDiv'>";
					tag += "<div><img src='/itda/img/user.png' name='profileShot'></div>";
					tag += `<div>`;
					tag += `<div id='userid' class='userid'>${vo.m_nickname}(${vo.m_userid}) <span>${vo.br_writedate}</span></div>`;
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
            console.log(tag);
            $("#replyList").html(tag);
    	}, error: function(){
            console.log("댓글목록선택에러")
        }
       });
    }
    // 댓글쓰기 -- 댓글을 입력하지 않은 경우
	$("#writeReplyBtn").click(()=>{
	    if($("#br_content").val()==""){
	        alert("댓글을 입력후 등록하세요");
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
    $(document).on('click','.modifyReply',function(){
		// 댓글 수정폼 보이기
		$(this).parent().next().css('display', 'block');
	});
    $(document).on('click','.editCancel',function(){
		// 댓글정보숨기기
		$(this).parent().parent().css('display', 'none');
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
		console.log("clickevent"+deleteParams);
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