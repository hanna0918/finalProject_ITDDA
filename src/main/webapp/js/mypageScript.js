//========00프로필 이미지 눌렀을때 정보수정======================
$(document).ready(function(){

    $('#profileImg').click(function () {
        $('.joinDataInputModal').css('display', 'block');
        $('#loginEidtModal').css('display', 'block');
        //정보수정
        var test = $(this).attr("name");
        const testInt = "m_seq=" + parseInt(test);
        console.log("testInt");

        $.ajax({
            url:'/itda/editMyInfo',
            data: testInt,
            type: 'POST',
              success: function(result){
                var result = $(result);
                console.log(result);
/*disabled*/
              var tag="";
              tag +=` <form method="post" id="regForm" action="/itda/editMyInfoUpdate">`;
              tag +=`<h2>정보 수정</h2>`;
              tag +=`  <a> <img src="img/close1.png" class="close" style="position: absolute; top: 10px; right: 10px;"/></a>`;
              tag +=`  <div><input type="hidden"class="joinTextBox" name="m_seq" id="m_seq" value="${result[0].m_seq}" /></div>`; //번호로 업데이트
              tag +=`  <div><img src='img/circle.png' style='width: 100px; padding-bottom:40px'/></div> `;
              tag +=`  <div style='height:77.33px;'><input class='joinTextBox' type='text' name='userid' id='joinUserid' placeholder='아이디' value="${result[0].m_userid}" disabled/></div> `;
              tag +=`  <div> <label>이메일<span class="asterisk">*</span></label> <div><input class="joinTextBox" type="text" name="m_email" id="m_email" value="${result[0].m_email}"/></div><div id="error_mail" class="result-email result-check"></div></div>`;
              tag +=`  <div> <label>닉네임<span class="asterisk">*</span></label> <div><input class="joinTextBox" type="text" name="m_nickname" id="m_nickname" value="${result[0].m_nickname}" disabled/></div> </div>`;
              tag +=`  <div> <label>핸드폰번호<span class="asterisk">*</span></label><div><input class="joinTextBox" type="text" name="m_tel" id="m_tel" value="${result[0].m_tel}" disabled/></div> </div>`;
              tag +=`  <div> <label>주소<span class="asterisk">*</span></label>   
              <div><input class="joinTextBox" type="text" name="m_addr" id="m_addr" value="${result[0].m_addr}" style="margin-bottom: 0px;"/></div> 
              <div><input class="joinTextBox" type="text" name="m_addrdetail" id="m_addrdetail" placeholder="상세주소"value="${result[0].m_addrdetail}" /></div></div>`;
              tag +=`  <div> <label>이름(실명)<span class="asterisk">*</span></label><div><input class="joinTextBox" type="text" name="username" id="username" value="${result[0].m_username}" disabled/></div></div>`;
              tag +=`  <div><label>인사말</label><div><input class="joinTextBox" type="text" name="m_info" id="m_info" value="${result[0].m_info.trim()}" placeholder="인사말을 적어주세요 (:^~^:)"/></div></div>`;
              tag +=` <div><label>관심분야태그<span class="asterisk">*</span></label><div><input class="joinTextBox" type="text" name="m_tag" id="m_tag" value="${result[0].m_tag.trim()}" placeholder="관심 태그를 적어주세요 ^모^"/></div></div>`;
              tag +=`    <button id="regFromButton" class="btnBlock">정보업데이트</button> <br> <br> <br>`;
              tag +=` </form>`;
                $('#test').html(tag);
            }, error: function(){
                console.log("왜실패하는거니 너는? 이유가 도대체 왜 짜증나.");
            }
        });

    });
    
   
 
      
/*  tag +`   <div><div><label>생년월일<span class="asterisk">*</span> </label> </div>  <input type="date" class="m_birth" name="m_birth" value="${result[0].m_birth}"/></div> <div>`;*/
   
                          
    $(document).on("click", "#regFromButton", function () {
            document.getElementById("regForm").submit();
        });      
    
    $(document).on("click",".close",function () {
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