<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- 회원 가입창 -->
<div class="loginJoinModal" id="loginJoinModal">
  <div class="modalOverlay"></div>
  <!-- 약관동의 창 -->
  <article class="joinModalContent checkModal">
    <h2>약관동의</h2>
    <div class="joinInputBox">
      <input type="checkbox" id="allJoinCheckbox" class="allJoinCheckbox joinCheckbox" />
      <label for="allJoinCheckbox">이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</label>
    </div>
    <div class="joinInputBox">
      <input type="checkbox" id="check1" class="joinCheckbox" />
      <label for="check1">이용약관 동의(필수)</label>
    </div>
    <div class="jointextarea">
      <!--약관문-->
      <h3>제1조 목적</h3>
      <pre>
        본 이용약관은 “잇다”(이하 "사이트")의 서비스의 이용조건과 운영에 관한 제반 사항 규정을 목적으로 합니다.
        제2조 용어의 정의
        부칙
      </pre>
    </div>
    <div class="joinInputBox">
      <input type="checkbox" id="check2" class="joinCheckbox" />
      <label for="check2">개인정보 수집 및 이용(필수)</label>
    </div>
    <div class="jointextarea">
      <!--약관문 2-->
      1. 개인정보 수집목적 및 이용목적 (1) 홈페이지 회원 가입 및 관리 회원 가입 의사 확인, 회원제 서비스 제공에 따른 본인 식별․인증, 회원자격 유지․관리, 제한적 본인확인제 시행에 따른 본인확인,
      서비스 부정 이용 방지, 만 14세 미만 아동의 개인정보 처리시 법정대리인의 동의 여부 확인, 각종 고지․통지, 고충 처리 등의 목적 (2) 재화 또는 서비스 제공 물품 배송, 서비스 제공, 계약서․청구서
      발송, 콘텐츠 제공, 맞춤 서비스 제공, 본인인증, 연령인증, 요금 결제 및 정산, 채권추심 등의 목적 (3) 고충 처리 민원인의 신원 확인, 민원사항 확인, 사실조사를 위한 연락․통지, 처리 결과 통보 등
      2. 수집하는 개인정보 항목 1) ID, 성명, 비밀번호, 주소, 휴대폰 번호, 생년월일, 이메일, 14세 미만 가입자의 경우 법정대리인 정보 2) SNS연동 - 카카오: 필수(닉네임, 프로필사진, 카카오ID),
      선택(이메일, 성별) - 페이스북: 페이스북ID, 이름, 프로필사진, 이메일 - 구글: 이름, 구글ID, 이메일, 프로필사진 - 네이버: 이름, 네이버(암호화), 이메일, 프로필사진, 성별 3. 개인정보 보유 및
      이용기간 회원탈퇴 시까지 (단, 관계 법령에 보존 근거가 있는 경우 해당 기간 시까지 보유, 개인정보처리방침에서 확인 가능) *개인정보 수집에 거부할 수 있으나 거부 시 서비스 이용이 제한됩니다
    </div>
    <div class="joinInputBox">
      마케팅 활용 동의 및 광고 수신 동의<br />
      <span style="font-size: 0.8em"> 서비스와 관련된 신상품 소식, 이벤트 안내, 고객 혜택등 다양한 정보를 제공합니다. </span>
    </div>
    <div class="joinInputBox"><input type="checkbox" id="check3" class="joinCheckbox" /><label for="check3">SMS 수신 동의 (선택)</label></div>
    <div class="joinInputBox"><input type="checkbox" id="check4" class="joinCheckbox" /><label for="check4">E-Mail 수신 동의(선택)</label></div>
    <div class="joinInputBox"><input type="checkbox" id="check5" class="joinCheckbox" /><label for="check5">만 14세 이상입니다. (필수)</label></div>
    <div class="">
      <button id="joinCancelBtn" class="btnBlock">취소</button>
      <button id="joinNextBtn" class="btnBlock">다음</button>
    </div>
  </article>

  <!-- 회원가입 정보 입력 창 -->
  <article class="joinModalContent joinDataInputModal">
    <form method="post" id="regForm" action="formOk">
      <h2>회원가입</h2>
      <div><img src="img/member.png" style="width: 100px" alt="" srcset="" /></div>
      <div class="joinCautionText">
        <p>가입시 아래의 항목을 지켜주세요</p>
        <p>-이메일: 실제 사용하시는 이메일</p>
        <p>-비밀번호: 특수문자,숫자,영문 조합으로 8자리 이상</p>
        <p>-생년월일: 만14세미만은 가입이 제한되며, 가입시 확인하여 탈퇴처리합니다.</p>
      </div>
      <!-- 아이디 입력시 서버에서 바로바로 확인하여 아래 중복확인내용 출력 예정 -->
      <div><input class="joinTextBox" type="text" name="joinUserid" id="joinUserid" placeholder="아이디" /></div>
      <div><input class="joinTextBox" type="password" name="joinUserpwd" id="joinUserpwd" placeholder="비밀번호" /></div>
      <div><input class="joinTextBox" type="password" name="joinUserpwdChk" id="joinUserpwdChk" placeholder="비밀번호확인" /></div>

      <!-- 이메일 입력시 서버에서 바로바로 확인하여 아래 중복확인내용 출력 예정 -->
      <div>
        <label>이메일<span class="asterisk">*</span></label>
        <div><input class="joinTextBox" type="email" name="userEmail" id="userEmail" /></div>
        <div id="error_mail" class="result-email result-check"></div>
      </div>
      <!-- 닉네임 입력시 서버에서 바로바로 확인하여 아래 중복확인내용 출력 예정-->
      <div>
        <label>닉네임<span class="asterisk">*</span></label>
        <div><input class="joinTextBox" type="text" name="userNick" id="userNick" /></div>
      </div>
      <div>
        <label>핸드폰번호<span class="asterisk">*</span></label>
        <div><input class="joinTextBox" type="text" name="userTel" id="userTel" /></div>
      </div>
      <div>
        <label>주소<span class="asterisk">*</span></label>
        <div><input class="joinTextBox" type="text" name="addr" id="addr" /></div>
        <div><input class="joinTextBox" type="text" name="addrdetail" id="addrdetail" /></div>
      </div>
      <div>
        <div>
          <label>생년월일 <span class="asterisk">*</span> </label>
        </div>
        <div class="selectBox">
          <select class="joinSelectBox" name="birthY" id="birthY"></select>
          <select class="joinSelectBox" name="birthM" id="birthM"></select>
          <select class="joinSelectBox" name="birthD" id="birthD"></select>
        </div>
      </div>
      <div>
        <label>이름(실명)<span class="asterisk">*</span></label>
        <div><input class="joinTextBox" type="text" name="username" id="username" /></div>
      </div>
      <input type="submit" value="회원가입" class="btnBlock joinSubmitBtn" />
    </form>
  </article>
</div>

</body>
</html>