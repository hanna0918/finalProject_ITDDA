$(document).ready(function () {
  //로그인 버튼 클릭
  $("#loginBtn").click(function () {
    $(".loginModal").css("display", "block");
  });

  // 회원가입 버튼 클릭
  $("#joinBtn").click(function () {
    $(".loginJoinModal").css("display", "block");

    /* 회원가입 클릭시 값 초기화  -> 체크박스, 텍스트박스, */
    $(".joinCheckbox").prop("checked", false);
    // $("input[name=m_gender]").prop("checked", false);
    $("input[name=m_gender]").prop("checked", false);
    $(".joinTextBox").val("");
  });

  // 클릭시 모달창 닫기
  $(".closeBtn").click(function () {
    $(".loginJoinModal").css("display", "none");
    $(".checkModal").css("display", "block");
    $(".joinDataInputModal").css("display", "none");

    // 로그인창 닫기
    $(".loginModal").css("display", "none");
  });

  // 로그인창 -> 회원가입창 클릭 동작
  $("#joinBtn2").click(function () {
    $(".loginModal").css("display", "none");
    $(".loginJoinModal").css("display", "block");
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

  //아이디 관련
  $(".m_userid").on("propertychange change keyup paste input", function () {
    var m_userid = $(".m_userid").val(); // .m_userid에 입력되는 값
    var data = { m_userid: m_userid }; // '컨트롤에 넘길 데이터 이름' : '데이터(.m_userid에 입력되는 값)'
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
          idckCheck = true;
        } else {
          $(".id_input_re_2").css("display", "inline-block");
          $(".id_input_re_1").css("display", "none");
          idckCheck = false;
        }
      }, // success 종료
    }); // ajax 종료
  }); // function 종료

  //닉네임
  $(".m_nickname").on("propertychange change keyup paste input", function () {
    var m_nickname = $(".m_nickname").val(); // .m_nickname에 입력되는 값
    var data = { m_nickname: m_nickname }; // '컨트롤에 넘길 데이터 이름' : '데이터(.m_nickname에 입력되는 값)'
    // console.log("keyup 테스트");
    $.ajax({
      type: "post",
      url: "/itda/memberNickChk",
      data: data,
      success: function (result) {
        // console.log("성공 여부" + result);
        console.log("성공 여부" + result);
        if (result != "fail") {
          $(".nick_input_re_1").css("display", "inline-block");
          $(".nick_input_re_2").css("display", "none");
        } else {
          $(".nick_input_re_2").css("display", "inline-block");
          $(".nick_input_re_1").css("display", "none");
        }
      }, // success 종료
    }); // ajax 종료
  }); // function 종료

  /* 비밀번호 확인 일치 유효성 검사 */

  $(".m_userpwdchk").on("propertychange change keyup paste input", function () {
    var pw = $(".m_userpwd").val();
    var pwck = $(".m_userpwdchk").val();
    $(".final_pwck_ck").css("display", "none");

    if (pw == pwck) {
      $(".pwck_input_re_1").css("display", "block");
      $(".pwck_input_re_2").css("display", "none");
      pwckcorCheck = true;
    } else {
      $(".pwck_input_re_1").css("display", "none");
      $(".pwck_input_re_2").css("display", "block");
      pwckcorCheck = false;
    }
  });
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

  //주소 카카오api 사용
  document.getElementById("joinAddr").addEventListener("click", function () {
    new daum.Postcode({
      oncomplete: function (data) {
        document.getElementById("joinAddr").value = data.address;
        document.querySelector("input[name=m_addrdetail]").focus();
      },
    }).open();
  });

  //유효성 검사
  /* 유효성 검사 통과유무 변수 */
  var idCheck = false; // 아이디
  var idckCheck = false; // 아이디 중복 검사
  var pwCheck = false; // 비번
  var pwckCheck = false; // 비번 확인
  var pwckcorCheck = false; // 비번 확인 일치 확인
  var mailCheck = false; // 이메일
  var nickCheck = false; //닉네입
  var telCheck = false; //전화번화
  var birthCheck = false; //생일
  var addressCheck = false; // 주소
  var addressDetailCheck = false; // 주소
  var nameCheck = false; // 이름
  var genderCheck = false; //성별

  //var mailnumCheck = false; // 이메일 인증번호 확인

  $(".joinSubmitBtn").click(function () {
    /* 입력값 변수 */
    var id = $(".m_userid").val(); // id 입력란
    var pw = $(".m_userpwd").val(); // 비밀번호 입력란
    var pwck = $(".m_userpwdchk").val(); // 비밀번호 확인 입력란
    var mail = $(".m_email").val(); // 이메일 입력란
    var nick = $(".m_nickname").val(); // 닉네임 입력란
    var tel = $(".m_tel").val(); // 전화번호 입력란
    var birth = $(".m_birth").val(); // 생일 입력란
    var addr = $(".m_addr").val(); // 주소 입력란
    var addrdetail = $(".m_addrdetail").val(); // 상세주소 입력란
    var name = $(".m_username").val(); // 이름 입력란
    var gender = $("input[name=m_gender]").is(":checked"); // 성별 입력란

    /* 아이디 유효성검사 */
    if (id == "") {
      $(".final_id_ck").css("display", "block");
      idCheck = false;
    } else {
      $(".final_id_ck").css("display", "none");
      idCheck = true;
    }

    /* 비밀번호 유효성 검사 */
    if (pw == "") {
      $(".final_pw_ck").css("display", "block");
      pwCheck = false;
    } else {
      $(".final_pw_ck").css("display", "none");
      pwCheck = true;
    }

    /* 비밀번호 확인 유효성 검사 */
    if (pwck == "") {
      $(".final_pwck_ck").css("display", "block");
      pwckCheck = false;
    } else {
      $(".final_pwck_ck").css("display", "none");
      pwckCheck = true;
    }
    /* 이메일 유효성 검사 */
    if (mail == "") {
      $(".final_mail_ck").css("display", "block");
      mailCheck = false;
    } else {
      $(".final_mail_ck").css("display", "none");
      mailCheck = true;
    }
    /* 닉네임 확인 유효성 검사 */
    if (nick == "") {
      $(".final_nick_ck").css("display", "block");
      nickCheck = false;
    } else {
      $(".final_nick_ck").css("display", "none");
      nickCheck = true;
    }

    /* 전화번호 확인 유효성 검사 */
    if (tel == "") {
      $(".final_tel_ck").css("display", "block");
      telCheck = false;
    } else {
      $(".final_tel_ck").css("display", "none");
      telCheck = true;
    }

    /* 주소 유효성 검사 */
    if (addr == "") {
      $(".final_addr_ck").css("display", "block");
      addressCheck = false;
    } else {
      $(".final_addr_ck").css("display", "none");
      addressCheck = true;
    }

    /* 상세주소 유효성 검사 */
    if (addrdetail == "") {
      $(".final_addrdetail_ck").css("display", "block");
      addressDetailCheck = false;
    } else {
      $(".final_addrdetail_ck").css("display", "none");
      addressDetailCheck = true;
    }

    /* 생일 확인 유효성 검사 */
    if (birth == "") {
      $(".final_birth_ck").css("display", "block");
      birthCheck = false;
    } else {
      $(".final_birth_ck").css("display", "none");
      birthCheck = true;
    }

    /* 이름 유효성 검사 */
    if (name == "") {
      $(".final_name_ck").css("display", "block");
      nameCheck = false;
    } else {
      $(".final_name_ck").css("display", "none");
      nameCheck = true;
    }
    /* 성별 유효성 검사 */
    if (gender == false) {
      $(".final_gender_ck").css("display", "block");
      genderCheck = false;
    } else {
      $(".final_gender_ck").css("display", "none");
      genderCheck = true;
    }

    if (idCheck && idckCheck && pwCheck && pwckCheck && pwckcorCheck && mailCheck && nickCheck && telCheck && birthCheck && addressCheck && addressDetailCheck && nameCheck && genderCheck) {
      $("#joinOk").submit();
    }

    console.log(birth);
    console.log("아무것도 안됨");
    return false;
  });
});
