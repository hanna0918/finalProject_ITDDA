<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
@import
   url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff')
   format
   ('woff');

@font-face {
   font-family: 'IBMPlexSansKR-Regular';
   src:
      url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff')
      format('woff');
   font-weight: normal;
   font-style: normal;
}

body {
   font-family: 'IBMPlexSansKR-Regular';
}

@charset "UTF-8";

h1 { /*제목*/
   margin-left: 20px;
}

#qNaContainer { /*컨테이너*/
   width: 1100px;
   /*background-color:lightblue;*/
   margin: 0 auto;
   height: 2000px;
}

ul, li {
   margin: 0;
   padding: 0;
   list-style: none;
}

a {
   text-decoration: none;
   color: black;
}

a:hover {
   color: #5e83d1;
}

span {
   color: blue;
   font-size: 0.85em;
}

#allSearch { /*검색창 div*/
   width: 100%;
   height: 60px;
   /*background-color:red;*/
   display: flex;
   flex-direction: row;
   justify-content: flex-end;
}

select, input[type="text"] {
   height: 30px;
   line-height: 30px;
   border : none;
}

.list li {
   float: left;
   width: 10%;
   text-align: center;
}

#freeTitle {
   height: 40px;
   line-height: 40px;
}

#freeTitle>li:nth-child(2) {
   width: 50%;
}

.content {
   height: 80px;
}

.content>li:nth-child(1) {
   line-height: 80px;
}

.content>li:nth-child(2) {
   width: 50%;
   margin-top: 20px;
   text-align: left;
   overflow: hidden;
   text-overflow: ellipsis;
}

.content>li:nth-child(3) {
   margin-top: 20px;
}

.content>li:nth-child(4) {
   /* line-height:80px; */
   
}

.content>li:nth-child(5) {
   line-height: 80px;
}

.content>li:nth-child(6) {
   line-height: 80px;
}

.list+div {
   width: 100%;
   height: 20px;
   text-align: right;
}

#writeBtn { /*글쓰기 버튼*/
   float: right;
   margin-right: 20px;
   width: 70px;
   height: 30px;
   background-color: #9d9af5;
   color: white;
   border: none;
   border-radius: 20px;
   cursor: pointer;
}

#page {
   width: 100%;
   height: 50px;
}

#page ul { /*페이지 div*/
   width: 250px;
   height: 50px;
   line-height: 50px;
   margin: 0 auto;
}

#page li { /*페이지 1,2,3,4*/
   float: left;
   margin: 10px 10px;
}

/*아이디 드롭다운 메뉴*/
.dropbtn {
   border: none;
   cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
   background-color: #2980B9;
}

.dropdown {
   position: relative;
   /* display: inline-block; */
}

.dropdown-content {
   display: none;
   position: absolute;
   left: 70%;
   top: 0px;
   background-color: #f1f1f1;
   min-width: 160px;
   overflow: auto;
   box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
   z-index: 1;
}

.dropdown-content a {
   text-align: center;
   color: black;
   padding: 12px 16px;
   text-decoration: none;
   display: block;
}

.dropdown a:hover {
   background-color: #ddd;
}

.show {
   display: block;
}
/* ---------------------------------------------*/

/*차단 모달창 , 차단 yes 모달창*/
.blockJoinModal, .blockJoinModal2, .mailJoinModal, .mailJoinModal2,
   .gudokJoinModal, .gudokJoinModal2, .profilJoinModal {
   display: none;
   position: fixed;
   top: 0;
   left: 0;
   width: 100%;
   height: 100%;
   bottom: 0;
   overflow-x: hidden;
   overflow-y: auto;
   -ms-overflow-style: none;
}

.blockJoinModal::-webkit-scrollbar {
   display: none;
}

.blockJoinModal2::-webkit-scrollbar {
   display: none;
}

.mailJoinModal::-webkit-scrollbar {
   display: none;
}

.mailJoinModal2::-webkit-scrollbar {
   display: none;
}

.gudokJoinModal::-webkit-scrollbar {
   display: none;
}

.gudokJoinModal2::-webkit-scrollbar {
   display: none;
}

.profilJoinModal::-webkit-scrollbar {
   display: none;
}

.blockModalContent, .blockModalContent2, .mailModalContent,
   .mailModalContent2, .gudokModalContent, .gudokModalContent2,
   .profilModalContent {
   position: relative;
   margin: 0 auto;
   width: 380px;
   padding: 20px;
   background-color: #fafafa;
   text-align: center;
   border-radius: 10px;
   /*  border: 2px solid #666; */
   overflow-y: auto;
}

.blockModalContent h4 {
   margin-bottom: 5px;
   font-weight: bold;
   font-size: larger;
   margin-top: 5px;
}

.gudokModalContent {
   width: 340px;
}

.blockDataInputModal, .blockDataInputModal2, .mailDataInputModal,
   .mailDataInputModal2, .gudokDataInputModal, .gudokDataInputModal2,
   .profilDataInputModal {
   display: none;
   background-color: whitesmoke;
   box-shadow: 10px 10px 5px lightgrey;
}

/*차단, 구독하기 확인 버튼 */
#yesChadan, #yesGudok {
   border-color: white;
   width: 160px;
   height: 50px;
   background-color: cornflowerblue;
   color: white;
   border: none;
   border-radius: 10px;
   cursor: pointer;
   margin-right: 5px;
}

/*차단, 구독하기 취소버튼*/
#noChadan, #noGudok {
   border-color: white;
   width: 20;
   width: 160px;
   height: 50px;
   background-color: white;
   color: black;
   /* border: none; */
   border-radius: 10px;
   cursor: pointer;
}

#yesGudok, #noGudok {
   width: 120px;
}

/*쪽지보내기 모달창 */

/* 

   스타일 안먹어서 개별적으로 줌
   .mailInfo>li:nth-child(1){ 받는사람
   text-align: left;
    padding-left: 25px;
   }
   
   .mailInfo>li:nth-child(2){ 내용
   text-align: left;
    padding-left: 25px;
    padding-top: 10px;
   }
    */
.mailTextarea {
   margin: 10px;
   width: 325px;
   height: 100px;
   resize: none;
   outline-style: none;
   padding: 0;
   font-size: 16px;
   cursor: text;
   border-radius: 10px;
   border: 1px solid #ddd;
}

/*취소 버튼*/
#noMail {
   background-color: white;
   width: 160px;
   height: 3o;
   height: 30px;
   border-radius: 5px;
   border: 1px solid lightgray;
   font-weight: 700;
   box-shadow: 1px 1px 0px 0px lightgrey;
}

/*보내기 버튼*/
#yesMail, #profilebtn {
   background-color: cornflowerblue;
   width: 160px;
   height: 3o;
   height: 30px;
   color: white;
   border-radius: 5px;
   border: 1px solid lightgray;
   font-weight: 700;
   box-shadow: 1px 1px 0px 0px lightgrey;
}

/*프로필 모달창*/

/*프로필 */
#profileTop {
   margin: 0 auto;
   margin-bottom: 20px;
   /*   background: beige; */
   border-radius: 30px;
}

.profileinfo {
   padding: 20px;
   width: -1px;
   background: lightgray;
   border-radius: 30px;
   font-weight: bold;
}

.profileinfo img {
   width: 100%;
   height: 100%;
   margin: 0 auto;
   border-radius: 50px;
}

/*인사말 관심분야*/
#profileHi {
   margin-top: 10px;
   text-align: left;
   padding-bottom: 10px;
   font-weight: bold;
}

#profileLike {
   margin-top: 10px;
   text-align: left;
   padding-bottom: 10px;
   font-weight: bold;
}

.profilFoot input[type="text"] {
   padding-bottom: 20px;
   border: none;
   cursor: text;
   border-radius: 5px;
   height: 30px;
   line-height: 30px;
   width: 300px;
   background: white;
}

</style>
<script>
   
</script>
<body>
   <!-- <img src="img/photoreview.png"> -->
   <div class='boardContainer'>
      <!-- 게시판제목 -->
      <div class="boardName">
         <h2>아무말 대잔치</h2>
         <h4>JUST WRITE IT! 다양한 주제의 글을 자유롭게 올려보세요!</h4>
      </div>
      <!-- 검색창 -->
      <div class='allSearch'>
         <form action="/itda/test" method="post">
            <div>
               <select name='keywordselect'>
                  <option>전체</option>   <!-- value추가 예정-->
                  <option value="board_subject">글제목</option>
                  <option value="m_nickname">작성자</option>
                  <option value="b_content">내용</option>
                  <option>제목+내용</option>   <!-- value추가 예정-->
               </select> <input type='text' id='search' name='searchkeyword' placeholder="검색어를 입력하세요" />
               <div>
                  <img src="img/magnifyingglass.png">
               </div>
            </div>
         </form>
      </div>

         
         <!-- 자유게시판 리스트 -->

         <div class='boardList'>
            <ul id='basicBoardTitle'>
               <!-- <li>NO</li> -->
               <li>제목</li>
               <li>작성자</li>
               <li>등록일</li>
               <li>조회수</li>
               <li>댓글수</li>
            </ul>
         </div>

         <c:forEach var="vo" items="${list}">
            <div class='basicBoardContent' style="overflow:visible;">

               <%-- <li>${vo.board_seq}</li> --%>
               <div>
                  <a href="/itda/freeview?board_seq=${vo.board_seq}">${vo.board_subject}</a>
               </div>

               <div class="dropdown">
                  <div>
                     <label onclick="myFunction('${vo.m_nickname}');" class="dropbtn"
                        id="droplogin">${vo.m_nickname} <input type="hidden"
                        class="idtest" value="${vo.m_seq}" /></label>
                  </div>
                  <input type="hidden" value="${vo.m_name}" />
               
                  <!-- ---------------------------------------------------------------------- -->
                  <div id="myDropdown${vo.m_nickname}" class="dropdown-content">
                     <a class="profil" name="${vo.m_nickname}">프로필</a> 
                     <!-- <a class="chadan" name="${vo.m_nickname}">차단하기</a> --> 
                     <a class="gudok"  name="${vo.m_nickname}">구독하기</a> <a class="sendMail"
                        name="${vo.m_nickname}">쪽지보내기</a> <a
                        href="/itda/writeList?m_nickname=${vo.m_nickname}&m_name=${vo.m_name}"
                        name="${vo.m_nickname}">게시글보기</a>
                  </div>
               </div>
            

               <div>${vo.board_writedate}</div>
               <div>${vo.board_hit}</div>
               <div>${vo.br_count}</div>
               <input type="hidden" value="${vo.m_name}" />
            </div>
         </c:forEach>

         <!-- 글쓰기 버튼 -->
         <div class="boardBtnDiv">
            <input type="button" value="글쓰기" class="writeBtn"
               onclick="location.href='/itda/freeboardWrite'" />
         </div>
         <!-- 페이지번호 -->
         <div class='pagingDiv'>
            <ul>
               <li><a href='#'>◁</a></li>
               <li><a href='#'>1</a></li>
               <li><a href='#'>2</a></li>
               <li><a href='#'>3</a></li>
               <li><a href='#'>4</a></li>
               <li><a href='#'>5</a></li>
               <li><a href='#'>▷</a></li>
            </ul>
         </div>


         <!---------------- 차단 모달창 -------------->
         <div class="blockJoinModal" id="blockJoinModal">
            <article class="blockModalContent blockDataInputModal">
               <div id="testChadan">

                  <form id="chadanForm">
                     <h4 style="margin-bottom: 5px;">차단 사유를 입력해주세요.</h4>
                     <!-- 차단하면 서로의 게시글을 볼 수 없고, 서로 쪽지도 <br/>보낼 수 없어요. -->
                     <textarea class="mailTextarea" name='b_note'
                        placeholder="차단 사유를 입력하세요"></textarea>
                     <input type="hidden" name="m_seq" value="${logseq}" /> <input
                        type="button" value="네, 차단할래요." id="yesChadan" /> <input
                        type="button" value="취소" id="noChadan" />

                     <!-- <a><img src="/itda/img/close1.png" class="close1" 
                       style="position:absolute;top: 10px; right: 17px;"/></a> -->

                  </form>
                  <!-- <div><input type="button" value="확인"/></div> -->
               </div>
            </article>
         </div>

         <!--------------차단 yes 모달창------------->

         <div class="blockJoinModal2" id="blockJoinModal2">
            <article class="blockModalContent2 blockDataInputModal2"
               style="width: 300px; padding: 0;">
               <div id="testChadanOk">
                  <%-- 
                  <div style="background: cornflowerblue; height: 25px;"></div>
                  <h4>" ${m_userid } "님이 차단되었습니다.</h4>
                  
                  <a><img src="/itda/img/close1.png" class="close2" 
                    style="position:absolute;top: 0px; right: 1px;;"/></a>
                 
                   <!-- <div><input type="button" value="확인"/></div> -->
                    --%>
               </div>

            </article>
         </div>


         <!-- ----------쪽지보내기 모달창------------------>

         <div class="mailJoinModal" id="mailJoinModal">
            <article class="mailModalContent mailDataInputModal style="box-shadow: 10px 10px 5pxlightgrey;" >
               <div id="testNote">
                  <form>
                     <input type='hidden' name='m_seq' value='${logseq}' />
                  </form>
                  <!--  
                  <form>
                     <h4 style="background:moccasin;" >🍊 쪽지 보내기</h4>
                     <a><img src="/itda/img/close1.png" class="close3" 
                       style="position:absolute;top: 10px; right: 16px;;"/></a>
                       <ul class="mailInfo">
                          <li style="text-align: left; padding-left: 25px;">받는사람 &nbsp; : &nbsp; ${m_userid}</li>  
                          <li style="text-align: left; padding-left: 25px; padding-top: 10px;">내용</li>
                          <textarea class="mailTextarea" title="쪽지 내용을 입력하세요" placeholder="쪽지 내용을 입력하세요" style="margin:5px; width:325px; height:200px; resize:none; outline-style:none; padding:0; border-radius:3px 3px 0 0; font-size:14px; cursor:text">
                          </textarea>
                       </ul>
                          <input type="submit" value="보내기" id="yesMail"/>
                          <input type="button" value="취소" id="noMail"/>
                       <div><input type="button" value="확인"/></div> 
                    </form>
                    -->
               </div>
            </article>
         </div>

         <!------------------- 쪽지 전송 yes 모달창----------------->

         <div class="mailJoinModal2" id="mailJoinModal2">
            <article class="mailModalContent2 mailDataInputModal2"
               style="width: 315px; padding: 0;">
               <div id="testNoteYes">

                  <!--  
                  <div style="background: cornflowerblue; height: 25px;"></div>
                  <h4><strong>'${m_userid }'</strong>님에게 쪽지가 전송되었습니다 😊</h4>
                  
                  <a><img src="/itda/img/close1.png" class="close4" 
                    style="position:absolute;top: 0px; right: 1px;;"/></a>
                 
                    <div><input type="button" value="확인"/></div> 
                    
                    -->

               </div>
            </article>
         </div>

         <!-- --------------구독 모달창-------------- -->
         <div class="gudokJoinModal" id="gudokJoinModal">
            <article class="gudokModalContent gudokDataInputModal">

               <div>
                  <form>
                     <h4 style="font-size: large;">구독하시겠습니까?</h4>

                     <input type="hidden" name="m_seq" value="${logseq}" /> <input
                        type="button" value="네, 구독할래요." id="yesGudok" /> <input
                        type="button" value="취소" id="noGudok" />

                     <!--    <a><img src="/itda/img/close1.png" class="close5" 
                    style="position:absolute;top: 10px; right: 17px;"/></a> -->
                     <!-- <div><input type="button" value="확인"/></div> -->
                  </form>
               </div>
            </article>
         </div>

         <!-- --------------구독 yes 모달창  ----------->
         <div class="gudokJoinModal2" id="gudokJoinModal2">
            <article class="gudokModalContent2 gudokDataInputModal2"
               style="width: 300px; padding: 0;">
               <div id="testGudok">
                  <%-- <div style="background: cornflowerblue; height: 25px;"></div>
                  <h4>" ${m_username } "님 구독이 완료되었습니다.</h4>
                  
                  <a><img src="/itda/img/close1.png" class="close6" 
                    style="position:absolute;top: 0px; right: 1px;;"/></a>
                    <!-- <div><input type="button" value="확인"/></div> --> --%>
               </div>
            </article>
         </div>

         <!-- ---------------프로필 모달창-------------- -->
         <div class="profilJoinModal" id="profilJoinModal">
            <article class="profilModalContent profilDataInputModal"
               style="box-shadow: 5px 5px 5px lightgrey; width: 320px;">
               <div id="test">
                  <h1>PROFILE</h1>
                  <h4 id="profileTop">🍊&nbsp;프로필</h4>
                  <%--    <form>
                  <!--    <a><img src="..//itda/img/close1.png" class="close7" 
                       style="position:absolute;top: 10px; right: 16px;;"/></a> -->
                       <div class="profileinfo">
                          <div>
                             <div style="width:100px; height:100px; margin:0 auto;"> <!-- padding -->
                                <img src="/itda/img/moveprofile.gif"/>
                             </div>
                          </div>
                          <div>${vo.m_username } &nbsp;( ${vo.m_userid} )</div>
                          <div>Female</div>
                          <div>브론즈</div>
                       </div>
                       
                       <div class="profilFoot" style="padding:10px;">
                       <li id="profileHi">인사말</li>
                       <input type="text" placeholder="인사말" />
                       
                       <li id="profileLike">관심분야</li>
                       <input type="text" placeholder="관심분야 " />
                       
                       <input type="button" value="확인" id="profilebtn" style="margin-top: 20px; width: 100%;"/>
                       </div>
                          
                       <!-- <div><input type="button" value="확인"/></div> -->
                    </form>  --%>


               </div>
            </article>
         </div>
      </div>

      <script>
         // 해야할일
         // 누른 li의 좌표값을 구한다. ->  //x좌표:1073, y좌표:288
         // 좌표값을 구하면, javascript로 드롭다운 메뉴의 좌상단부분의 좌표를 li좌표로 변경한다.
         // 기존 메소드에 토글 show가 있으니 위에까지만 하면 될거에요
         //받아온 값을 ajax로 db에 보내서 필요한 정보를 select해서 ajax(sucess시 필요한 곳에 넣어준다.)

         /*드롭다운 보여주기*/

         /* 메뉴 드롭다운 */
      
         
            function myFunction(nickname) { /////////////////1
               document.getElementById("myDropdown" + nickname).classList.toggle("show");
               console.log(nickname);

               /*///////////////////////////////프로필 모달창//////////////////////////////////////////////////*/
               nickname1 = "m_nickname=" + nickname;
               console.log("-----------------");
               console.log("jj:" + nickname);

               $('.profil').click(function() { ////////////////////////2
                              $('.profilDataInputModal').css('display', 'block');
                              $('.profilJoinModal').css('display','block');

                              $.ajax({ /////////////////////////////////3
                                       url : '/itda/freeBoardmodal',
                                       data : nickname1,
                                       type : 'POST',
                                       success : function(result) { ///////////////////4
                                          var result = $(result);
                                          console.log(result);
                                          var tag = "";
                                          console.log(result[0].m_img);
                                          tag += `<h4 id='profileTop'> 🍊 프로필 </h4>`;
                                          tag += `<form>`;
                                          tag += `<div class="profileinfo">`;
                                          tag += `<div style='width:100px; height:100px; margin:0 auto;'>`;
                                          tag += `<label class='input-file-button' style='text-align: center' for='input-files'><img  style='width: 100px;height: 100px;border-radius: 50px;' id='profilePic' /></label>`;
                                          tag += `</div>`;
                                          tag += "<div>"+ "닉네임 : "+ result[0].m_nickname + "</div>";
                                          tag += "<div>"+ "F:"+ result[0].m_gender+ "</div>";
                                          tag += "<div>"
                                                + result[0].m_name
                                                + "</div>";

                                          tag += `</div>`;
                                          tag += `<div class='profilFoot' style='padding:10px;'>`;
                                          tag += "<li id='profileHi'>"
                                                + "인사말"
                                                + "</li>";
                                          tag += "<input type='text' name='m_info' placeholder='인사말' value='"+result[0].m_info+"'disabled/>";
                                          tag += "<li id='profileLike'>"
                                                + " 관심분야"
                                                + "</li>";
                                          tag += "<input type='text' name='m_tag 'placeholder='관심분야' value='" + result[0].m_tag + "'disabled/>"
                                                + "</tag>";
                                          tag += "<input type='button' value='확인' id='profilebtn' style='margin-top: 20px; width: 100%;'/>";
                                          tag += `</div>`;
                                          tag += `</form>`;
                                          /*  tag += "<h4 id="profileTop">"+"프로필"+"</h4>"; 
                                          tag += `<div class="profileinfo">`;
                                          
                                             tag += `<div>`;
                                                 tag += `<div style='width:100px; height:100px; margin:0 auto;'>`;
                                                 // tag+= "<img src="/itda/img/moveprofile.gif"/>"; 
                                                 tag += `</div>`;
                                              
                                                 tag += "<div>" + result[0].m_nickname + "</div>";
                                                 tag += "<div>" + result[0].m_gender + "</div>"; //
                                                 tag += "<div>" + result[0].m_name + "</div>"; //m_name?,  m_rank
                                                 tag += `<div class='profilFoot' style='padding:10px;'>`;
                                                 tag += "<li id='profileHi'>" + "인사말" + "</li>";
                                                 tag += "<input type='text' name='m_info' placeholder='인사말' value='"+result[0].m_info+"'/>"; 
                                                 tag += "<li id='profileLike'>" + " 관심분야" + "</li>";
                                                 tag += "<input type='text' name='m_tag 'placeholder='관심분야' value='" + result[0].m_tag + "'>" + "</tag>";
                                                 tag += "<input type='button' value='확인' id='profilebtn' style='margin-top: 20px; width: 100%;'>" + "</tag>";
                                          
                                                 tag += `</div>`; 
                                                 
                                                 
                                                 
                                             tag += `</div>`;

                                           tag += `</div>`;
                                          
                                          tag+=`</form> `;
                                          
                                          tag+=`</div> `;
                                          tag+=`</article>`;
                                          tag += `</div>`;   */

                                          console.log(tag);
                                          $('#test').html(tag);
                                          console.log(tag);

                                       },
                                       error : function() { //////////////4 
                                          console.log("싰빠이프로필");
                                       }

                                    });////////////////3 ajax
                                    $("#profileImg").attr("src", result[0].m_img).width(100).height(100);

                              nickname = "";
                              console.log("초기화후:" + nickname);

                              //x버튼

                              $(document).on(
                                    "click",
                                    "#profilebtn",
                                    function() {
                                       $('.profilJoinModal').css(
                                             'display', 'none');
                                    });

                              /*    $('#profilebtn').click(function () {
                                   console.log("버튼 클릭 이벤트 안들어감");
                                    $('.profilJoinModal').css('display', 'none');
                                 }); */

                              /*드롭다운 다른 곳 누를경우 */

                              window.onclick = function(event) {
                                 if (!event.target
                                       .matches('.dropbtn')) { //.dropbtn
                                    var dropdowns = document
                                          .getElementsByClassName("dropdown-content");
                                    var i;
                                    for (i = 0; i < dropdowns.length; i++) {
                                       var openDropdown = dropdowns[i];
                                       if (openDropdown.classList
                                             .contains('show')) {
                                          openDropdown.classList
                                                .remove('show');
                                       }
                                    }
                                 }
                              }

                              var test1 = $('.dropbtn');
                              test1.click(function(event) {
                                 x = (event.pageX - 270) + 'px';
                                 y = (event.pageY - 300) + 'px';
                                 $('.dropdown-content').css('left',
                                       x).css('top', y);

                                 var popH = $(this).offset().top; //fe_laypopH 의 top 좌표값

                                 //alert('x좌표:' +x + ', y좌표:' + y);
                              });

                           }); ////////////////2

               /*   //차단 ajax (태그 아직 안씀)
                 function Chadan(nickname){
                    $.ajax({ /////////////////////////////////3
                         url:'/itda/freeBoardmodalChadan', 
                         data: nickname1,
                         type: 'POST',
                         success: function (result) { ///////////////////4
                           var result = $(result);
                           console.log(result);
                           var tag = "";   
                          
                        tag+=`<form>`;
                       tag+=`<h2>확인</h2>`
                       tag+=`<h4 style='margin-bottom:5px;'>차단 사유를 입력해주세요.</h4>`;  
                       tag+=   "<textarea class='mailTextarea' title='차단 사유를 입력하세요' placeholder='차단 사유를 입력하세요'>"; 
                       tag+=   "</textarea>";
                       tag+= "<input type='hidden' name='m_nickname'"
                       tag+=   "<input type='submit' value='네, 차단할래요.' id='yesChadan'/>";
                       tag+=   "<input type='button' value='취소' id='noChadan'/>";
                       tag+=`/<form>`;  
                     
                           console.log(tag);
                           $('#testChadan').html(tag);
                           console.log(tag);
                        
                         }, error: function () {  //////////////4 
                           console.log("싰빠이차단");
                         }

                       });////////////////3 ajax
                       nickname="";
                    console.log("초기화후:"+nickname);
                 } */

               /*////////////////////////////////차단 모달창//////////////////////////////////////////// */

               $(document).on("click", ".chadan", function() {

                  $('.blockDataInputModal').css('display', 'block');
                  $('.blockJoinModal').css('display', 'block');

                  //취소
                  $(document).on("click", "#noChadan ", function() {
                     $('.blockJoinModal').css('display', 'none');
                  });

                  //x버튼
                  $(document).on("click", ".close1 ", function() {
                     $('.blockJoinModal').css('display', 'none');

                  });
               }); //.chadan document 이벤트 

               //차단 ok ajax
               function chadanOk(ajaxData) {
                  console.log("ajaxData = " + ajaxData);
                  console.log("nickname = " + nickname);
                  $
                        .ajax({ /////////////////////////////////3
                           url : '/itda/freeBoardmodalChadanOk',
                           data : ajaxData + "&" + nickname1,
                           type : 'POST',
                           success : function(result) { ///////////////////4
                              var result = $(result);
                              console.log(result);
                              var tag = "";

                              tag += `<div style="background: cornflowerblue; height: 25px;"></div>`;
                              tag += `<h4> 차단이 완료되었습니다. </h4>`; //"<h4>" + result[0].m_nickname + "님이 차단되었습니다." +"</h4>";
                              tag += `<div>`;
                              tag += "<input type='submit' id ='chadanOk' value='확인'/>";
                              tag += `</div>`;

                              console.log(tag);
                              $('#testChadanOk').html(tag);
                              console.log(tag);

                           },
                           error : function() { //////////////4 
                              console.log("싰빠이차단yes");
                           }

                        });////////////////3 ajax
                  nickname = "";
                  console.log("초기화후:" + nickname);
               }

               /////////////////////////////////////////////////////////////

               $(document).on("click", "#yesChadan ", function() {
                  $('.blockJoinModal').css('display', 'none');
                  const ajaxData = $(this).parent().serialize();
                  chadanOk(ajaxData);

                  //차단 yes 모달창
                  $('.blockDataInputModal2').css('display', 'block');
                  $('.blockJoinModal2').css('display', 'block');
                  //x확인버튼 
                  $(document).on("click", "#chadanOk", function() {
                     $('.blockJoinModal2').css('display', 'none');

                  }); //x확인버튼
               }); //차단 예쓰

               /*   //차단 예쓰
                 $(document).on("click", "#yesChadan ", function(){
                      $('.blockJoinModal').css('display', 'none');  
                      
                  chadanOk();
                  
                  //차단 yes 모달창
                  $('.blockDataInputModal2').css('display', 'block');
                  $('.blockJoinModal2').css('display', 'block');
                     //x확인버튼 
                     $(document).on("click", "#chadanOk", function(){      
                         $('.blockJoinModal2').css('display', 'none'); 
                     
                     });  //x확인버튼
                }); //차단 예쓰 */

               function gudokYes(ajaxData) {
                  console.log("ajaxData = " + ajaxData);
                  console.log("nickname = " + nickname);

                  $
                        .ajax({ /////////////////////////////////3
                           url : '/itda/freeBoardmodalGudokOk',
                           data : ajaxData + "&" + nickname1,
                           type : 'POST',
                           success : function(result) { ///////////////////4
                              var result = $(result);
                              console.log(result);
                              var tag = "";

                              tag += `<div style='background : cornflowerblue; height: 25px;'></div>`;
                              tag += `<h4> 구독신청이 완료되었습니다. </h4>`; //"<h4>" + result[0].m_nickname + "님 구독이 완료되었습니다." + "</h4>";
                              tag += `<div>`;
                              tag += "<input type='button' id='gudokOk' value='확인'/>";
                              tag += `</div>`;

                              console.log(tag);
                              $('#testGudok').html(tag);
                              console.log(tag);

                           },
                           error : function() { //////////////4 
                              console.log("싰빠이구독");
                           }

                        });////////////////3 ajax
                  nickname = "";
                  console.log("초기화후:" + nickname);
               }

               //////////////////////////////////////구독하기////////////////////////////////////////////// 

               /*구독하기 모달창*/
               $(document).on("click", ".gudok", function() {
                  $('.gudokDataInputModal').css('display', 'block');
                  $('.gudokJoinModal').css('display', 'block');

                  //취소버튼
                  $(document).on("click", "#noGudok", function() {
                     $('.gudokJoinModal').css('display', 'none');
                  });

                  //x버튼
                  $(document).on("click", ".close5", function() {
                     $('.gudokJoinModal').css('display', 'none');
                  });

                  //구독하기 버튼 
                  $(document).on("click", "#yesGudok", function() {
                     $('.gudokJoinModal').css('display', 'none');
                     const ajaxData = $(this).parent().serialize();
                     gudokYes(ajaxData);

                     //보내기 yes 모달창
                     $('.gudokDataInputModal2').css('display', 'block');
                     $('.gudokJoinModal2').css('display', 'block');

                     //x확인버튼

                     $(document).on("click", "#gudokOk", function() {
                        $('.gudokJoinModal2').css('display', 'none');
                     }); //x확인버튼
                  }); //구독하기 
               }); //구독하기 모달

               //쪽지보내기 ajax   
               function sendNote(nickname) {
                  $
                        .ajax({ /////////////////////////////////3
                           url : '/itda/freeBoardmodalNote',
                           data : nickname1,
                           type : 'POST',
                           success : function(result) { ///////////////////4
                              var result = $(result);
                              console.log(result);
                              var tag = "";

                              tag += `<form>`;
                              tag += `<h4 style='background:moccasin;'> 🍊 쪽지보내기 </h4>`;
                              tag += `<ul class='mailInfo'>`;
                              tag += "<li style='text-align: left; padding-left: 25px;'>"
                                    + "받는사람 : "
                                    + result[0].m_nickname
                                    + "</li>";
                              tag += `<li style='text-align: left; padding-left: 25px; padding-top: 10px;'>내용</li>`;
                              tag += "<textarea class='mailTextarea' name='msg_content' title='쪽지 내용을 입력하세요' placeholder='쪽지 내용을 입력하세요' style='margin:5px; width:325px; height:200px; resize:none; outline-style:none; padding:0; border-radius:3px 3px 0 0; font-size:14px; cursor:text'>";
                              tag += "</textarea>";
                              tag += `</ul>`;
                              /*    tag += "<input type='hidden' name='m_seq' value='${logseq}'/>";  */
                              tag += "<input type='button' value='보내기' id='yesMail'/>";
                              tag += "<input type='button' value='취소' id='noMail'/>";
                              tag += `</form>`;

                              console.log(tag);
                              $('#testNote').html(tag);
                              console.log(tag);

                           },
                           error : function() { //////////////4 
                              console.log("싰빠이쪽지");
                           }

                        });////////////////3 ajax
                  nickname = "";
                  console.log("초기화후:" + nickname);

               }

               /*//////////////////////////////////쪽지 모달창////////////////////////////////////*/
               //쪽지보내기 모달창 
               $(document).on("click", ".sendMail", function() {
                  $('.mailDataInputModal').css('display', 'block');
                  $('.mailJoinModal').css('display', 'block');
                  sendNote();

                  //취소버튼
                  $(document).on("click", "#noMail", function() {
                     $('.mailJoinModal').css('display', 'none');

                  });
               });

               /////////////////////쪽지 yes ///////////////////////////////   
               //보내기 yes 모달창
               $(document).on("click", "#yesMail", function() {
                  $('.mailJoinModal').css('display', 'none');
                  const ajaxData = $(this).parent().serialize();
                  sendNoteYes(ajaxData);
                  $('.mailJoinModal2').css('display', 'block');
                  $('.mailDataInputModal2').css('display', 'block');

                  //x버튼
                  $(document).on("click", "#noteYesBtn", function() {
                     $('.mailJoinModal2').css('display', 'none');
                  }); //x버튼 
               }); //보내기 버튼 
               //}); 

               function sendNoteYes(ajaxData) {
                  console.log("쪽지yes 들어오는지 확인???");
                  console.log("ajaxData = " + ajaxData);
                  console.log("nickname = " + nickname1);
                  $
                        .ajax({ /////////////////////////////////3
                           url : '/itda/freeBoardmodalNoteYes',
                           data : ajaxData + "&" + nickname1,
                           type : 'POST',
                           success : function(result) { ///////////////////4
                              var result = $(result);
                              console.log(result);
                              var tag = "";

                              tag += `<div style='background:cornflowerblue; height: 25px;'></div>`;
                              tag += `<h4> 쪽지가 전송되었습니다 😊 </h4>`; //"<h4>"+ result[0].m_nickname +" 님에게 쪽지가 전송되었습니다 😊" + "</h4>"; 
                              tag += `<div>`;
                              tag += "<input type='button' value='확인' id='noteYesBtn'/>";
                              tag += `</div>`;

                              console.log(tag);
                              $('#testNoteYes').html(tag);
                              console.log(tag);

                           },
                           error : function() { //////////////4 
                              console.log("싰빠이쪽지yes");
                           }

                        });////////////////3 ajax
                  nickname = "";
                  console.log("초기화후:" + nickname);

               }

               /*   /////////////////////쪽지 yes ///////////////////////////////
                       //보내기 yes 모달창
                  $(document).on("click", "#yesMail", function(){
                      $('.mailJoinModal').css('display', 'none');  
                     $('.mailDataInputModal2').css('display', 'block');
                     $('.mailJoinModal2').css('display', 'block');
                     sendNoteYes();
                     
                   //x버튼
                      $(document).on("click", "#noteYesBtn", function(){
                          $('.mailJoinModal2').css('display', 'none');  
                     }); //x버튼 
                  }); //보내기 버튼 
               });  */

            }///////////////1

         
         ///////////////////////////////////////////////////////////////////////////

         /*       //프로필 모달창
                $('#profil').click(function () {
                  $('.profilDataInputModal').css('display', 'block');
                  $('.profilJoinModal').css('display', 'block');
                  
                  var test =$(this).attr("");
                     const testInt = "m_seq=" + parseInt(test);
                        console.log(testInt);
                  
                //x버튼
                   $('#profilebtn').click(function () {
                       $('.profilJoinModal').css('display', 'none');  
                  }); 
                
                }); */
      </script>

