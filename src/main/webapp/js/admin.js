$(document).ready(function(){

    /*멤버 리스트 start*/
    $('.AdminMember').click(function () {
        $('.AdminInsertModal').css('display', 'block'); //어드민 모달 뛰우기
        var test = $(this).attr("name");
        const testInt = "m_seq=" + parseInt(test);
        console.log("testInt");
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
                tag +=`<div> <label class="Modallabel"> 활동상태:</label> <select class="Modalselect" name="m_statecode" value="${result[0].m_statecode}"> <option value="${result[0].m_statecode}" selected>${result[0].m_state}</option>  <option value="0">양호</option> <option value="1">정지</option> </select> </div><br>`;
                tag +=`<div> <label class="Modallabel"> 회원등급:</label> <select class="Modalselect" name="m_rank" value="${result[0].m_name}>"><option value="${result[0].m_rank}" selected>${result[0].m_name}</option><option value="2">브론즈</option>  <option value="3">실버</option><option value="4">골드</option> <option value="1">관리자</option></select> </div><br>`;
                tag +=`<div> <label class="Modallabel">가입일자:</label> <input class="ModalInput" name="m_regdate" value="${result[0].m_regdate}" disabled/> </div> <br> `;
                tag +=`<div class=""> <button style="background-color:white" type="submit" id="joinCancelBtn"  class="btnBlock"><a>수정</a></button> </div>`;
                tag +=`<input type="hidden" name="m_seq" value="${result[0].m_seq}"/>`;
                tag +=`</form>`;
                $('#test').html(tag);
                console.log(tag);

            }, error: function(){
                console.log("싰빠이");
            }
        });
        $('.modalOverlay').click(function () {
            $('.AdminInsertModal').css('display', 'none');
        });
    });
    /*멤버 리스트 end*/

    /* 신고 리스트 start*/
    $(".BoardBlack").click(function () {
        $(".CallBoardModalTest").css("display", "block"); //신고 게시물 모달
        var test = $(this).attr("name");
        const testInt = "m_seq=" + parseInt(test);
        console.log(testInt);
        $.ajax({
            url: "/itda/CallBoardBlackView",
            data: testInt,
            type: "POST",
            success: function (result) {
                var result = $(result);
                console.log(result);
                var tag = "";
                tag += `<h2>페이지 관리</h2>`;
                tag += "<div style='float:left display: inline-block;'>" + "제목:" + result[0].board_subject + "<br>" + "카테고리:" + result[0].board_select + "</div>";
                tag += "<div style='display: inline-block;'>" + "글쓴이:" + result[0].m_nickname + "</div>";
                tag += "<br>";
                tag += "<textarea style='resize: none; width: 450px; height: 200px;' disabled>" + "글내용:" + result[0].b_content + "</textarea>";
                tag += "<hr>";
                tag += "<br>";
                tag += `<form method="post" id="form" action="/itda/CallBoardUpdate">`;
                tag += "<input type='text' style='resize: none; width: 450px; height: 100px;'name='board_blockcontent' placeholder='블럭사유'>" + "</input>";
                tag += "<br>";
                tag += "<input type='hidden' name='board_seq' value='" + result[0].board_seq + "'/>";
                tag += "<input type='hidden' id='board_block' name='board_block' value=''/>";

                //--
                tag += "<input type='button' id='block' name='board_block' style='text-align:center; width: 200px; height: 50px;'value='블럭처리하기'>" + "</tag>"; //1
                tag += "<input type='button' id='check' style='text-align: center; width: 200px; height: 50px;'value='확인처리'>" + "</tag>"; //2
                tag += `</form>`;

                console.log(tag);
                $("#update").html(tag);
                console.log(tag);
            },
            error: function () {
                console.log("싰빠이");
            },
        });
        $(".modalOverlay").click(function () {
            $(".CallBoardModalTest").css("display", "none");
        });
        $(document).on("click", "#block", function () {
            $("#board_block").val(1);
            document.getElementById("form").submit();
        });

        $(document).on("click", "#check", function () {
            $("#board_block").val(2);
            document.getElementById("form").submit();
        });
    });
    /* 신고 리스트 ennd*/

    /* 블랙 게시판 start*/
    $('.BlackboardSelect').click(function () {
        $('.BlackBoardSelectModal').css('display', 'block'); //모든 게시판 모달 뛰우기
        var seq =$(this).attr("name");
        const seqnumber = "m_seq=" + parseInt(seq);
        console.log(seq);
        $.ajax({
            url:'/itda/BlackBoardBlackView',
            data: seqnumber,
            type: 'POST',
            success: function(result){
                console.log("성공");
                var result = $(result);
                console.log(result);
                var tag="";
                tag+="<h2 style='text-align:center;'>블럭게시판 관리</h2>";
                tag+=`<form method="post" id="form" action="/itda/BlockBoardUpdate">`;
                tag+="<div style='float:left display: inline-block;'>"+"제목:"+result[0].board_subject+"<br>"+"카테고리:"+result[0].board_select+"</div>";
                tag+="<div style='display: inline-block;'>"+"글쓴이:"+result[0].m_nickname+"</div>";
                tag+="<br>";
                tag+="<textarea style='resize: none; width: 450px; height: 200px;' disabled>"+ "글내용:"+result[0].b_content+"</textarea>";
                tag+="<hr>";
                tag+="<h2 style='text-align:center;'>블럭 사유</h2>";
                tag+="<textarea style='resize: none; width: 450px; height: 50px;' disabled>"+result[0].board_blockcontent+"</textarea>";
                tag+="<input type='hidden' name='board_seq' value='"+result[0].board_seq+"'/>";
                tag+="<input type='hidden' name='board_block' value='2'/>";
                tag+="<input type='hidden' name='board_blockcontent' value='처리해지'/>";

                tag+="<input type='button' id='block' style='margin-left:130px;  width: 200px; height: 50px;'value='블럭해지'>"+"</tag>";//1
                tag+=`</form>`;

                $('#blackshow').html(tag);
            }, error: function(){
                console.log("왜 실패하니 너는?");
            }
        });
    });

    $(document).on('click','#block',function () {
        $("#board_block").val(2);
        document.getElementById("form").submit();
    });


    $('.modalOverlay').click(function () {
        $('.BlackBoardSelectModal').css('display', 'none');
        console.log("모달 밖에 눌림");
    });
    
    $('.check').click(function () {
        console.log("모달 밖에 눌림12321");
    });
    /* 블랙 게시판 end*/
    
    
    /* Qna wait start*/
    $('.AdminQna').click(function () {
    $('.AdminSendQnqModal').css('display', 'block'); //1:1문의 모달
    var test = $(this).attr("name");
    const testInt = "q_number=" + parseInt(test);
    console.log(testInt);
    $.ajax({
        url:'/itda/QnaModalwaitView',
        data: testInt,
        type: 'POST',
        success: function(result){
            var result = $(result);   console.log("성공"); console.log(result);

            var tag ="<h2 style='text-align:center;'>블럭게시판 관리</h2>";

            tag += "<div>"+"게시물번호 :"+ result[0].q_number +"</div>";
            tag += "<div>"+"문의자 :"+result[0].m_nickname +"</div>"+"<hr>";
            tag += "<div>"+"등록일 :"+result[0].q_date +"</div>"+"<hr>";
            tag += "<div style='overflow-y: scroll; width:450px; height: 150px; margin: 0 auto'>"+result[0].q_title+"</div>"+"<hr>";
            tag += `<form method="post" id="form" action="/itda/CallwaitUpdate">`;
            tag += "<input type='hidden' name='q_number' value='" + result[0].q_number + "'/>";
            tag += "<input type='hidden' name='q_result_state' value='1'/>";
            tag +="<div style='text-align:center;'>"+"답변처리"+"</div>"+"<br>";
            tag += "<input type='text' style='resize: none; width: 450px; height: 100px;'name='q_result' placeholder='문의답변'>" + "</input>";
            tag += "<br>";
            tag += "<input type='submit' id='block' style='text-align:center; margin-left: 120px; background-color:white; width: 200px; height: 50px;'value='답변처리하기'>";

            tag += `</form>`;

            $('#waitmodal').html(tag);
        }, error: function(){
            console.log("왜 실패하니 너는?");
        }

    });

    $('.modalOverlay').click(function () {

        $('.AdminSendQnqModal').css('display', 'none');
    });
});
/* Qna wait end*/
/*  test*/
  /* Qna result start*/
    $('.AdminQnaresult').click(function () {
    $('.AdminSendQnqModal').css('display', 'block'); //1:1문의 모달
    var test = $(this).attr("name");
    const testInt = "q_number=" + parseInt(test);
    console.log(testInt);
    $.ajax({
        url:'/itda/QnaModalwaitView',
        data: testInt,
        type: 'POST',
        success: function(result){
            var result = $(result);   console.log("성공"); console.log(result);
            var tag ="<h2 style='text-align:center;'>블럭게시판 관리</h2>";
            tag += "<div>"+"게시물번호 :"+ result[0].q_number +"</div>";
            tag += "<div>"+"문의자 :"+result[0].m_nickname +"</div>"+"<hr>";
            tag += "<div>"+"등록일 :"+result[0].q_date +"</div>"+"<hr>";
            tag += "<div style='overflow-y: scroll; width:450px; height: 150px; margin: 0 auto'>"+result[0].q_title+"</div>"+"<hr>";
            tag +="<div style='text-align:center;'>"+"답변완료"+"</div>"+"<br>";
            tag+="<textarea style='resize: none; width: 450px; height: 50px;' disabled>"+result[0].q_result+"</textarea>";
         tag += "<br>";

            $('#resultmodal').html(tag);
        }, error: function(){
            console.log("왜 실패하니 너는?");
        }

    });   
   
    $('.modalOverlay').click(function () {
        $('.AdminSendQnqModal').css('display', 'none');
    });
    $('.resultQnabutton').click(function () {
        $('.AdminSendQnqModal').css('display', 'none');
    });
   });
    /* Qna result end 어머님이 누구시니 왜 이렇게 날 힘들게하니 쉐떌뿌리부리*/ 

/* 모든 게시판 리스트 만들기 start*/
$('.AllboardSelect').click(function () {
    $('.AllSelectBoardModal').css('display', 'block'); //모든 게시판 모달 뛰우기.
       var test = $(this).attr("name");
        const testInt = "m_seq=" + parseInt(test);
        console.log(testInt);
        $.ajax({
            url: "/itda/BoardAllViewmodal",
            data: testInt,
            type: "POST",
            success: function (result) {
                var result = $(result);
                console.log(result);
           var tag ="<h2>게시판</h2>";
           tag +="<div>"+"게시물번호 :"+ result[0].board_seq +"</div>";
           tag+="<div style='float:left display: inline-block;'>"+"제목:"+result[0].board_subject+"카테고리:"+result[0].board_select +"글쓴이:"+result[0].m_nickname+"<br>"+ "</div>";
         tag +="<hr>";
           tag += "<textarea style='resize: none; width: 450px; height: 200px;' disabled>" + "글내용:" + result[0].b_content + "</textarea>";
           tag +="<br>";
           tag +="<hr>";
           tag +=`<button style="text-align:center; background-color:white;" type="submit" id="checkallboard"  class="btnBlock"><a>확인</a></button>`;
           tag +="</div>";
           
            $('#allBoardList').html(tag);
        }, error: function(){
            console.log("왜 실패하니 너는?");
        }

    });   
    
    
});


                


    $(document).on('click','#checkallboard',function () {
       $('.AllSelectBoardModal').css('display', 'none');
    });
    
 $('.modalOverlay').click(function () {

        $('.AllSelectBoardModal').css('display', 'none');
    });
/* 모든 게시판 리스트 만들기 end*/
});