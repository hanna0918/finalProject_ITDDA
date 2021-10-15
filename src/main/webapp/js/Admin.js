	
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
				console.log(result[0].m_username);
	
	    		var tag="";
	    		tag += `<h2>회원 수정</h2>`;
	    			tag +=`<form method="get">`;
	    			tag +=`<div>  <label class="Modallabel"> 아이디:</label> <input class="ModalInput" type="text" name="M_UserId" id="M_UserId" disabled value="${result[0].m_username}"/></div>`;
	    			
	    		
	  			$('#test').html(tag);
	  
	    	}, error: function(){
	    		console.log("싰빠이");
	    	}
	    });
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



 /*$('#m_userpwd').keyup(function(){
        $('div[name=check]').text('');
        $('.submitbutton').css('visibility','hidden');
      });

     
      $('#M_USERPWDCheck').keyup(function(){
        if($('#m_userpwd').val()!=$('#m_userpwdcheck').val()){
          $('div[name=check]').text('');
          $('div[name=check]').html("암호틀림");
          $('.submitbutton').css('visibility','hidden');
        }
        else{
          $('div[name=check]').text('');
          $('div[name=check]').html("암호맞음");
          $('.submitbutton').css('visibility','visible');
        }

      });
      
*/