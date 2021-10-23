<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/inc/adminTop.jspf" %>
  
  <div class="TopContent">
    <div class="TopSubContent">
      <div>어드민 추가하기</div>
  </div>

  <div class="MainContent">
      <div style=" background-color: blanchedalmond; width:100%; height: 90%;">
        <div style="background-color: mediumvioletred; width:50%; height: 100%; float: left;">
          <img style="margin-top: 200px;"src="../img/testadmin.png">
        </div>
        <div style=" width:50%; height: 100%; float: left;">
          <form method="post" action="/itda/adminInsertOk">
            <div>
              <label class="Modallabel">아아디:</label>
              <input class="ModalInput" type='text' name='m_userid' placeholder="아아디"/>
            </div>
            <br>
            
             <div>
              <label class="Modallabel">아아디:</label>
              <input class="ModalInput" type='text' name='m_username' placeholder="이름"/>
            </div>
            <br>
            
            
            <div>
              <label class="Modallabel">비밀번호:</label>
              <input class="ModalInput" type='password' name='m_userpwd' id='m_userpwd' placeholder="비밀번호"/>
              <input style="margin-left: 100px;"class="ModalInput" type='password' name='m_userpwdcheck' id="m_userpwdcheck" placeholder="비밀번호 확인"/><br>
              <div name="check" size="2" color="red"></div>
            </div>
            <br>

            <div>
              <label class="Modallabel">닉네임:</label>
              <input class="ModalInput" type='text' name='m_nickname' placeholder="닉네임"/>
            </div>
            <br>

            <div>
              <label class="Modallabel"> 이메일:</label>
              <input class="ModalInput" type='text' name='m_email' placeholder="이메일"/>
            </div>
            <br>

            <div>
              <label class="Modallabel"> 전화번호:</label>
              <input class="ModalInput" type='text' name='m_tel' placeholder="전화번호"/>
            </div>
            <br>

            <div>
              <label class="Modallabel"> 주소:</label>
              <input class="ModalInput" type='text' name='m_addr' placeholder="주소" value="서울특별시 마포구 백범로 13길 비트캠프 신촌"  />
            </div>
            <br>

            <div>
              <label class="Modallabel"> 생일:</label>
              <input class="ModalInput" type='date' name='m_birth' placeholder="생일"/>
            </div>
            <br>
            
            <div>
              <button class="submitbutton" type="submit"><a>회원가입</a></button>
            </div>
          </form>
        </div>
    </div>
  </div>
  </div>
