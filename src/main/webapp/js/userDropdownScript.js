
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
        console.log("jj:"+nickname);
        
        $('.profil').click(function (){ ////////////////////////2
          $('.profilDataInputModal').css('display', 'block');
          $('.profilJoinModal').css('display', 'block');
      
            $.ajax({ /////////////////////////////////3
            url:'/itda/freeBoardmodal', 
            data: nickname1,
            type: 'POST',
            success: function (result) { ///////////////////4
              var result = $(result);
              console.log(result);
              var tag = "";
              
            
                    tag += `<h4 id='profileTop'> 🍊  프로필 </h4>`; 
                    tag += `<form>`;
                       tag += `<div class="profileinfo">`;
                       tag += `<div style='width:100px; height:100px; margin:0 auto;'>`;
                    tag += `</div>`;
                                
                               tag += "<div>" +"닉네임 : "+ result[0].m_nickname + "</div>";
                              tag += "<div>" +"F:"+ result[0].m_gender + "</div>"; 
                              tag += "<div>" + result[0].m_name + "</div>";
                              
                    tag += `</div>`;     
                    
                              tag += `<div class='profilFoot' style='padding:10px;'>`;
                                 tag += "<li id='profileHi'>" + "인사말" + "</li>";
                                 tag += "<input type='text' name='m_info' placeholder='인사말' value='"+result[0].m_info+"'disabled/>"; 
                                 tag += "<li id='profileLike'>" + " 관심분야" + "</li>";
                                 tag += "<input type='text' name='m_tag 'placeholder='관심분야' value='" + result[0].m_tag + "'disabled/>" + "</tag>";
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
           
            }, error: function () {  //////////////4 
              console.log("싰빠이프로필");
            }

          });////////////////3 ajax
          nickname="";
        console.log("초기화후:"+nickname);
          
          //x버튼
          
          $(document).on("click", "#profilebtn", function(){
             console.log("버튼 클릭 이벤트 안들어감");
                $('.profilJoinModal').css('display', 'none');
          });
          
       /*    $('#profilebtn').click(function () {
            console.log("버튼 클릭 이벤트 안들어감");
             $('.profilJoinModal').css('display', 'none');
          }); */

          /*드롭다운 다른 곳 누를경우 */
          
          window.onclick = function (event) {
            if (!event.target.matches('.dropbtn')) {
              var dropdowns = document.getElementsByClassName("dropdown-content");
              var i;
              for (i = 0; i < dropdowns.length; i++) {
                var openDropdown = dropdowns[i];
                if (openDropdown.classList.contains('show')) {
                  openDropdown.classList.remove('show');
                }
              }
            }
          }
          
     var test1 = $('.dropbtn');
          test1.click(function (event) {
            x = (event.pageX - 270) + 'px';
            y = (event.pageY - 300) + 'px';
            $('.dropdown-content').css('left', x).css('top', y);
       //alert('x좌표:' +x + ', y좌표:' + y);
          });

        }); ////////////////2
            
      /*////////////////////////////////차단 모달창//////////////////////////////////////////// */
      
        $(document).on("click", ".chadan", function(){
           $('.blockDataInputModal').css('display', 'block');
            $('.blockJoinModal').css('display', 'block');
        ///////////////////////////////////////////////////////////////////////
       $.ajax({ /////////////////////////////////3
            url:'/itda/freeBoardmodalChadan', 
            data: nickname1,
            type: 'POST',
            success: function (result) { ///////////////////4
              var result = $(result);
              console.log(result);
              var tag = "";   
              
            
                tag+=`<div class='profilJoinModal' id='profilJoinModal'></div>`;
                tag+="<h4>" + result[0].m_nickname + "님이 차단되었습니다." +"</h4>";
                 tag+=`<div>`;
                    tag+= "<input type='submit' id ='chadanOk' value='확인'/>";
               tag+=`</div>`;
              
              
              console.log(tag);
              $('#testChadan').html(tag);
              console.log(tag);
           
              

            }, error: function () {  //////////////4 
              console.log("싰빠이차단");
            }

          });////////////////3 ajax
          nickname="";
        console.log("초기화후:"+nickname);
         /////////////////////////////////////////////////////////////
          //취소
           $(document).on("click", "#noChadan ", function(){
            $('.blockJoinModal').css('display', 'none');
             });
           
         //x버튼
           $(document).on("click", ".close1 ", function(){
              $('.blockJoinModal').css('display', 'none');  
                 
             });
         
           //차단 예쓰
           $(document).on("click", "#yesChadan ", function(){
                $('.blockJoinModal').css('display', 'none');  
         
            //차단 yes 모달창
            $('.blockDataInputModal2').css('display', 'block');
            $('.blockJoinModal2').css('display', 'block');
         
               //x확인버튼 
               $(document).on("click", "#chadanOk", function(){      
                   $('.blockJoinModal2').css('display', 'none'); 
               
               });  //x확인버튼
          }); //차단 예쓰
      
        });  //.chadan document 이벤트 
        
       //////////////////////////////////////구독하기////////////////////////////////////////////// 
        
        /*구독하기 모달창*/
        
        $(document).on("click", ".gudok", function(){
            $('.gudokDataInputModal').css('display', 'block');
            $('.gudokJoinModal').css('display', 'block');
      ///////////////////////////////////////////////////////////////////////////////////////////
      
      $.ajax({ /////////////////////////////////3
            url:'/itda/freeBoardmodalGudok', 
            data: nickname1,
            type: 'POST',
            success: function (result) { ///////////////////4
              var result = $(result);
              console.log(result);
              var tag = "";   
            
                 tag+=`<div style='background: cornflowerblue; height: 25px;'></div>`;
               tag+= "<h4>" + result[0].m_nickname + "님 구독이 완료되었습니다." + "</h4>";
               tag += `<div>`; 
               tag += "<input type='submit' id='gudokOk' value='확인'/>";
               tag += `</div>`; 
               
              console.log(tag);
              $('#testGudok').html(tag);
              console.log(tag);
           
            }, error: function () {  //////////////4 
              console.log("싰빠이구독");
            }

          });////////////////3 ajax
          nickname="";
        console.log("초기화후:"+nickname);   
            
            //취소버튼
              $(document).on("click", "#noGudok", function(){
                $('.gudokJoinModal').css('display', 'none');  
              });   
            
            //x버튼
            $(document).on("click", ".close5", function(){
                 $('.gudokJoinModal').css('display', 'none');  
               });  
         
           //구독하기 버튼 
            $(document).on("click", "#yesGudok", function(){
                  $('.gudokJoinModal').css('display', 'none');  
                  
                  //보내기 yes 모달창
                  $('.gudokDataInputModal2').css('display', 'block');
                  $('.gudokJoinModal2').css('display', 'block');
                  
                //x확인버튼
                  $('#gudokOk').click(function () {
                       $('.gudokJoinModal2').css('display', 'none');  
                  }); //x확인버튼
               }); //구독하기 
            }); //구독하기 모달
    
       /*//////////////////////////////////쪽지 모달창////////////////////////////////////*/
    
       
       
    
    
    }///////////////1
   
    ///////////////////////////////////////////////////////////////////////////
   
         //쪽지보내기 모달창
             $(document).on("click", ".sendMail", function(){
         $('.mailDataInputModal').css('display', 'block');
         $('.mailJoinModal').css('display', 'block');
            
          /*   $.ajax({ /////////////////////////////////3
                  url:'/itda/freeBoardmodalNote', 
                  data: nickname1,
                  type: 'POST',
                  success: function (result) { ///////////////////4
                    var result = $(result);
                    console.log(result);
                    var tag = "";   
             */
                     
           
            
            
            
            
            
            
            
            
            
            //취소버튼
             $(document).on("click", "#noMail", function(){
                $('.mailJoinModal').css('display', 'none');  
           });   
           
            //x버튼
             $(document).on("click", ".close3", function(){
                 $('.mailJoinModal').css('display', 'none');  
               });  
            
            //보내기버튼
             $(document).on("click", "#yesMail", function(){
               $('.mailJoinModal').css('display', 'none');  
               
               //보내기 yes 모달창
               $('.mailDataInputModal2').css('display', 'block');
               $('.mailJoinModal2').css('display', 'block');
               
             //x버튼
                $(document).on("click", ".close4", function(){
                    $('.mailJoinModal2').css('display', 'none');  
               }); 
            });
         }); 
         
         
      
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
      
