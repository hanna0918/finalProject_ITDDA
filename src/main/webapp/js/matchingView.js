const bannerDoc = document.querySelector("#matchingDetailBanner");
window.addEventListener("scroll", bannerTop);
window.addEventListener("resize", bannerLeft);
function bannerTop(){
    const bannerTopPx = window.pageYOffset;
    setTimeout(function(){
        bannerDoc.style.top = bannerTopPx + 50 + "px";
    }, 120);
}
function bannerLeft(){
    const bannerWidth = window.innerWidth;
    console.log(bannerWidth);
    bannerDoc.style.left = bannerWidth -300 + "px";
}
bannerTop();
bannerLeft();


/* Modal */
/* ----------------------------------------------------------------- */
$('#bannerBtn').click(function () {
	bannerBtnValue = this.value;
	bannerValue = bannerBtnValue.slice(7,12);
	valueBan = bannerValue.split(" / ");
	if(valueBan[0] == valueBan[1]){
		return false;
	}
    $('.matchingModal').css('display', 'block');
});

    
$('#participateBtn').one("click", function () {
    $(".joinModalContent").append("<label style='color: red; font-size: 0.8em'>로그인 후 참가버튼을 눌러주세요</label>");
});

$('#closeBtn').click(function () {
    $('.matchingModal').css('display', 'none');
});

$('.matchingModalOverlay').click(function () {
    $('.matchingModal').css('display', 'none');
});


/* 댓글!!! */
$(function(){
    function replyList(){
    	board_seq = $("#board_seq").val();
       var rParam = `board_seq=${board_seq}`;
       var rUrl = "/itda/matchingReply";
       $.ajax({
          url: rUrl,
          data: rParam,
          
          success: function(result){
          	console.log(result);
             var result = $(result);
             var tag = "";
             console.log("히든아이디"+$("#hiddenuserid").val());
             result.each(function(idx, vo){
             	   tag += "<div class='replyDiv'>";
                   tag += "<div><img src='/itda/img/user.png' name='profileShot'></div>";
                   tag += `<div>`;
                   tag += `<div id='userid' class='userid'>${vo.m_nickname}(${vo.m_userid}) <span>${vo.br_writedate}</span></div>`;
                   tag += `<div class='replyView'>${vo.br_content}</div>`;
                if(vo.m_userid == $("#hiddenuserid").val()){ // 자신이 쓴 댓글일때
                   tag += "<div><span>댓글 / 수정 / 지우기</span></div>";
                }
                tag += "</div>";
             });
             console.log(tag);
             $("#replyList").html(tag);
          }, error: function(){
             console.log("댓글목록선택에러")
          }
       });
    }
	replyList();
});