//========00프로필 이미지 눌렀을때 정보수정======================
$(document).ready(function(){

	$('#profileImg').click(function () {
	    $('.joinDataInputModal').css('display', 'block');
	    $('#loginEidtModal').css('display', 'block');
	  	//정보수정
	  	var m_no = $(this).attr("name");
	  	const m_seq =  parseInt(m_no);
		console.log(m_seq);
		
	$.ajax({
	 url:'/itda/editMyInfo',
       data: m_seq,
       type: 'POST',
       success: function(result){
		var reuslt= $(result);
		
		  
	  
	        }, error: function(){
	          console.log("싰빠이");
	       }
	    });
	 
	});
		      
	$('#joinCancelBtn').click(function () {
		  $('#loginEidtModal').css('display', 'none');
		});
	$('#confirmDelete').click(function(){
		
	});
	$('.close').click(function () {
		  $('#loginEidtModal').css('display', 'none');
		});
		
	 
	

//=========02 내가쓴댓글================
//삭제 확인창 모달
	$('#replyDelBtn').click(function(){
		$('.deleteModal').css('display', 'block');
	 });
	 $('#cancleDelete').click(function(){
		$('.deleteModal').css('display', 'none'); 
	 });
 
	
//댓글모두체크

	$('#replyAllCheck').click(function(){ //만약 전체 선택 체크박스가 체크된상태일경우 
		if($('#replyAllCheck').prop('checked')) { //해당화면에 전체 checkbox들을 체크해준다 
			$('input[name=replyChk]').prop('checked',true); // 전체선택 체크박스가 해제된 경우 
		} else { //해당화면에 모든 checkbox들의 체크를해제시킨다. 
			$('input[name=replyChk]').prop('checked',false); 
		} 
	});




//========= 07 1:1문의================

	//1:1문의
	$('#ask').click(function(){
		$('#askDisplay').toggle();	
	});
	$('li.question').click(function(){
		$(this).next().toggle('fast');
	});	
	


//========= 08 쪽지함===================

	//쪽지함(받은쪽지함/보낸쪽지함)
	$('#receiveMsg').click(function(){
		$('#sendList').css('display', 'none');
		$('#receiveList').css('display', 'block');
	});
	$('#sendMsg').click(function(){
		$('#receiveList').css('display', 'none');
		$('#sendList').css('display', 'block');
	});
	
	$('#msgTab li').click(function(){
		$(this).css('border-bottom', '2px solid black').css('font-weight', 'bold').css('color', '#6f6bdb');
		$('#msgTab li').not(this).css('border-bottom', 'hidden').css('font-weight', 'normal').css('color', 'black');
	});


	//쪽지함 체크박스 전체선택
	$('#receiveMsgAllCheck').click(function(){ 
		if($('#receiveMsgAllCheck').prop('checked')) { 
			$('input[name=receiveChk]').prop('checked',true); 
		} else {  
			$('input[name=receiveChk]').prop('checked',false); 
		} 
	});
	$('#sendMsgAllCheck').click(function(){ 
		if($('#sendMsgAllCheck').prop('checked')) { 
			$('input[name=sendChk]').prop('checked',true); 
		} else {
			$('input[name=sendChk]').prop('checked',false); 
		} 
	});
	
	
	//제목선택시 쪽지모달열기	
		$('.msgListContent li:nth-of-type(4n+3)').click(function () {
	 		$('.msgDataInputModal').css('display', 'block');
	   		$('.readMsgModal').css('display', 'block');
	    });
	    
	    //(쪽지모달)확인버튼
	    $('#checkMsg').click(function () {
	        $('.readMsgModal').css('display', 'none');  
	    });  
	    //(쪽지모달)답장하기
		$('#answerMsg').click(function () {
			$('.msgDataInputModal').css('display', 'none');
			$('.mailDataInputModal').css('display', 'block');
	        $('.mailJoinModal').css('display', 'block');
	    });       
	    //x버튼
	    $('.close3').click(function () {
	        $('.readMsgModal').css('display', 'none');  
	    }); 
});