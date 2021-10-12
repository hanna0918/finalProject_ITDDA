/**
 * 회원가입 모달창 관련 스크립트
 */
// const openJoinBotton = document.getElementById('joinBtn'); //회원가입 버튼

// const nextJoinBotton1 = document.getElementById('joinNextBtn'); // 회원가입 다음버튼 1
// const cancelJoinBtton = document.getElementById('joinCancelBtn'); // 취소버튼
// const loginJoinModal = document.querySelector('.loginJoinModal');

// const modalOverlay = loginJoinModal.querySelector('.modalOverlay');

// //모달창 실행
// const openJoinModal = function () {
//   loginJoinModal.classList.remove('modalHidden');
// };

// //취소 클릭 이벤트
// const nextJoinModal1 = function () {
//   loginJoinModal.classList.add('modalHidden');
// };

// const closeJoinModal = function () {
//   loginJoinModal.classList.add('modalHidden');
// };
// //회원가입 다음버튼 누르면 동작 실행 바꿔야함!!!!!!!!!!!!!!!!!
// cancelJoinBtton.addEventListener('click', nextJoinModal1);

// // 모달창 종료이벤트 실행
// modalOverlay.addEventListener('click', closeJoinModal);
// nextJoinBotton1.addEventListener('click', closeJoinModal);

// //회원가입창 클릭시 모달창 오픈
// openJoinBotton.addEventListener('click', openJoinModal);

//제이쿼리... 으으으으음......

//로그인 버튼 클릭
$('#loginBtn').click(function () {
  $('.loginModal').css('display', 'block');
});

// 회원가입 버튼 클릭
$('#joinBtn').click(function () {
  $('.loginJoinModal').css('display', 'block');

  /*  값 초기화  -> 체크박스, 텍스트박스, 셀렉트박스*/
  $('.joinCheckbox').prop('checked', false);
  $('.joinTextBox').val('');
  $('.joinSelectBox').prop('selected', false);
});

//오버레이영역 클릭시 모달창 닫기
$('.modalOverlay').click(function () {
  $('.loginJoinModal').css('display', 'none');
  $('.checkModal').css('display', 'block');
  $('.joinDataInputModal').css('display', 'none');

  // 로그인창 닫기
  $('.loginModal').css('display', 'none');
});

//약관동의창 취소버튼 동작
$('#joinCancelBtn').click(function () {
  $('.loginJoinModal').css('display', 'none');
});

//약관동의창 동의 버튼 동작-> 회원가입 입력창 오픈
$('#joinNextBtn').click(function () {
  if($("input:checkbox[id=check1]").is(":checked") == false) {
    //작업
    alert('가입을 위해서 이용약관에 동의해 주셔야 합니다.');
    return false;
  }
  if($("input:checkbox[id=check2]").is(":checked") == false) {
    //작업
    alert('가입을 위해서 개인정보 수집 및 이용에 동의해 주셔야 합니다.');
    return false;
  }
  if($("input:checkbox[id=check5]").is(":checked") == false) {
    //작업
    alert('가입을 위해서 만 14세 미만은 가입이 불가합니다, 14세 이상임을 확인해주세요');
    return false;
  }
  
  $('.checkModal').css('display', 'none');
  $('.joinDataInputModal').css('display', 'block');
});

//체크박스 전부 선택

$('.allJoinCheckbox').click(function () {
  $('.joinCheckbox').prop('checked', this.checked);
});


//이메일
function email_check( email ) {    
  var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  return (email != '' && email != 'undefined' && regex.test(email)); 
}

$("input[type=email]").blur(function(){
var email = $(this).val();
if( email == '' || email == 'undefined') return;
if(! email_check(email) ) {
  $(".result-email").text('이메일 형식으로 적어주세요');
  $(this).focus();
  return false;
}else {
$(".result-email").text('');
}
});
// 셀렉트박스 셋팅
$(document).ready(function () {
  var now = new Date();
  var year = now.getFullYear();
  var mon = now.getMonth() + 1 > 9 ? '' + (now.getMonth() + 1) : '0' + (now.getMonth() + 1);
  var day = now.getDate() > 9 ? '' + now.getDate() : '0' + now.getDate();
  //년도 selectbox만들기
  for (var i = 1900; i <= year; i++) {
    $('#birthY').append('<option value="' + i + '">' + i + '년</option>');
  }
  // 월별 selectbox 만들기
  for (var i = 1; i <= 12; i++) {
    var mm = i > 9 ? i : '0' + i;
    $('#birthM').append('<option value="' + mm + '">' + mm + '월</option>');
  }
  // 일별 selectbox 만들기
  for (var i = 1; i <= 31; i++) {
    var dd = i > 9 ? i : '0' + i;
    $('#birthD').append('<option value="' + dd + '">' + dd + '일</option>');
  }
  $('#birthY > option[value=' + year + ']').attr('selected', 'true');
  $('#birthM > option[value=' + mon + ']').attr('selected', 'true');
  $('#birthD > option[value=' + day + ']').attr('selected', 'true');
});
