$(document).ready(function(){

$('.AdminMember').click(function () {
    $('.AdminInsertModal').css('display', 'block'); //어드민 모달 뛰우기
	      var test = $(this).attr("name");
	      const testInt = "m_seq=" + parseInt(test);
   $.ajax({
    	url:'/itda/MemberView',
    	data: testInt,
    	type: 'POST',
    	success: function(result){
    		var result = $(result);
    		console.log(result);
    		
    		var tag="";
    			tag +=`<form method="post" action="/itda/MemberUpdate">`;
    			tag +=`<div> <label class="Modallabel"> 아이디:</label> <input class="ModalInput" type="text" name="M_UserId" id="M_UserId" disabled value="${result[0].m_userid}"/></div>  </div> <br>`;
    			tag +=`<div> <label class="Modallabel">닉네임:</label> <input class="ModalInput" type='text' name='M_NickName' id='M_NickName'disabled value="${result[0].m_nickname}"/> </div> <br>`;
				tag +=`<div> <label class="Modallabel"> 활동상태:</label> <select class="Modalselect" name="m_statecode" value="${result[0].m_statecode}"> <option value="0">양호</option> <option value="1">정지</option> </select> </div><br>`;
    			tag +=`<div> <label class="Modallabel"> 회원등급:</label> <select class="Modalselect" name="m_rank">  <option value="${result[0].m_rank}">${result[0].m_name}</option> <option value="2">브론즈</option>  <option value="3">실버</option> <option value="4">골드</option> <option value="1">관리자</option> </select> </div> <br>`;
    			tag +=`<div> <label class="Modallabel">가입일자:</label> <input class="ModalInput" name="m_regdate" value="${result[0].m_regdate}" disabled/> </div> <br> `;
    			tag +=`<div class=""> <button type="submit" id="joinCancelBtn"  class="btnBlock"><a>수정</a></button> </div>`;   		
    			tag +=`<input type="hidden" name="m_seq" value="${result[0].m_seq}"/>`;   		
    			tag +=`</form>`;
    		$('#test').html(tag);
    console.log(tag);
  
    	}, error: function(){
    		console.log("싰빠이");
    	}
    });
   console.log("testInt");
});



$('.AllboardSelect').click(function () {
    $('.AllSelectBoardModal').css('display', 'block'); //모든 게시판 모달 뛰우기
});

$('.BlackboardSelect').click(function () {
    $('.BlackBoardSelectModal').css('display', 'block'); //모든 게시판 모달 뛰우기
});
$('.AdminQna').click(function () {
    $('.AdminSendQnqModal').css('display', 'block'); //1:1문의 모달
});

$('.AdminAMember').click(function () {
    $('.AdminModal').css('display', 'block'); //1:1문의 모달
});
$('.BlackBoard').click(function () {
    $('.BlackBoardModal').css('display', 'block'); //블럭게시물 조회모달
});

$('.modalOverlay').click(function () {
    $('.AdminInsertModal').css('display', 'none');
    $('.AdminSendQnqModal').css('display', 'none');
    $('.AllSelectBoardModal').css('display', 'none');
    $('.AdminModal').css('display', 'none');
    $('.BlackBoardSelectModal').css('display', 'none');
});



$('.modalOverlay').click(function () {
    $('.AdminInsertModal').css('display', 'none');
    $('.AdminSendQnqModal').css('display', 'none');
    $('.AllSelectBoardModal').css('display', 'none');
    $('.AdminModal').css('display', 'none');
    $('.BlackBoardSelectModal').css('display', 'none');
});

});