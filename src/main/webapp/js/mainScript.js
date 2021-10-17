//로그인 버튼 클릭
$("#loginBtn").click(function () {
  $(".loginModal").css("display", "block");
});

// 회원가입 버튼 클릭
$("#joinBtn").click(function () {
  $(".loginJoinModal").css("display", "block");

  /* 회원가입 클릭시 값 초기화  -> 체크박스, 텍스트박스, */
  $(".joinCheckbox").prop("checked", false);
  $(".joinTextBox").val("");
});

//오버레이영역 클릭시 모달창 닫기
$(".closeBtn").click(function () {
  $(".loginJoinModal").css("display", "none");
  $(".checkModal").css("display", "block");
  $(".joinDataInputModal").css("display", "none");

  // 로그인창 닫기
  $(".loginModal").css("display", "none");
});

//약관동의창 취소버튼 동작
$("#joinCancelBtn").click(function () {
  $(".loginJoinModal").css("display", "none");
});

//약관동의창 동의 버튼 동작-> 회원가입 입력창 오픈
$("#joinNextBtn").click(function () {
  if ($("input:checkbox[id=check1]").is(":checked") == false) {
    //작업
    alert("가입을 위해서 이용약관에 동의해 주셔야 합니다.");
    return false;
  }
  if ($("input:checkbox[id=check2]").is(":checked") == false) {
    //작업
    alert("가입을 위해서 개인정보 수집 및 이용에 동의해 주셔야 합니다.");
    return false;
  }
  if ($("input:checkbox[id=check5]").is(":checked") == false) {
    //작업
    alert("가입을 위해서 만 14세 미만은 가입이 불가합니다, 14세 이상임을 확인해주세요");
    return false;
  }

  $(".checkModal").css("display", "none");
  $(".joinDataInputModal").css("display", "block");
});

//체크박스 전부 선택
$(".allJoinCheckbox").click(function () {
  $(".joinCheckbox").prop("checked", this.checked);
});

//아이디 정규식
$(".m_userid").on("propertychange change keyup paste input", function () {
  var memberId = $(".m_userid").val(); // .m_userid에 입력되는 값
  var data = { memberId: memberId }; // '컨트롤에 넘길 데이터 이름' : '데이터(.m_userid에 입력되는 값)'
  // console.log("keyup 테스트");
  $.ajax({
    type: "post",
    url: "/itda/memberIdChk",
    data: data,
    success: function (result) {
      // console.log("성공 여부" + result);
      console.log("성공 여부" + result);
      if (result != "fail") {
        $(".id_input_re_1").css("display", "inline-block");
        $(".id_input_re_2").css("display", "none");
      } else {
        $(".id_input_re_2").css("display", "inline-block");
        $(".id_input_re_1").css("display", "none");
      }
    }, // success 종료
  }); // ajax 종료
}); // function 종료

// ---------------------------------------------------------------------아이디

//비밀번호 정규식
$("#joinUserpwd").blur(function () {
  var password = $(this).val();
  if (password == "" || password == "undefined") return;
  if (!password_check(password)) {
    $(".result-password").text("비밀번호가 유효하지 않습니다.");
    $(this).focus();
    return false;
  } else {
    $(".result-password").text("");
  }
});
function password_check(password) {
  var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
  return password != "" && password != "undefined" && regex.test(password);
}

//이메일 정규식
function email_check(email) {
  var regex = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  return email != "" && email != "undefined" && regex.test(email);
}

$("input[type=email]").blur(function () {
  var email = $(this).val();
  if (email == "" || email == "undefined") return;
  if (!email_check(email)) {
    $(".result-email").text("이메일 형식으로 적어주세요");
    $(this).focus();
    return false;
  } else {
    $(".result-email").text("");
  }
});
// // 셀렉트박스 셋팅
// $(document).ready(function () {
//   var now = new Date();
//   var year = now.getFullYear();
//   var mon = now.getMonth() + 1 > 9 ? "" + (now.getMonth() + 1) : "0" + (now.getMonth() + 1);
//   var day = now.getDate() > 9 ? "" + now.getDate() : "0" + now.getDate();
//   //년도 selectbox만들기
//   for (var i = 1900; i <= year; i++) {
//     $("#birthY").append('<option value="' + i + '">' + i + "년</option>");
//   }
//   // 월별 selectbox 만들기
//   for (var i = 1; i <= 12; i++) {
//     var mm = i > 9 ? i : "0" + i;
//     $("#birthM").append('<option value="' + mm + '">' + mm + "월</option>");
//   }
//   // 일별 selectbox 만들기
//   for (var i = 1; i <= 31; i++) {
//     var dd = i > 9 ? i : "0" + i;
//     $("#birthD").append('<option value="' + dd + '">' + dd + "일</option>");
//   }
//   $("#birthY > option[value=" + year + "]").attr("selected", "true");
//   $("#birthM > option[value=" + mon + "]").attr("selected", "true");
//   $("#birthD > option[value=" + day + "]").attr("selected", "true");
// });

document.getElementById("joinAddr").addEventListener("click", function () {
  new daum.Postcode({
    oncomplete: function (data) {
      document.getElementById("joinAddr").value = data.address;
      document.querySelector("input[name=addrDetail]").focus();
    },
  }).open();
});
