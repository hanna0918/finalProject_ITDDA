<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <style>
    .mainHeader,
    .footer {
      display: none;
    }
  </style>
  <script>
    function setUserid(m_userid) {
      //회원가입폼에 셋팅
      console.log('들어오나?');
      opener.document.getElementById("m_userid").value = m_userid;
      opener.document.getElementById("idChkStatus").value="Y";
      window.close();
    }
  </script>
  <!-- 중복아이디가 있을때 -->
  <b>${m_userid}</b>
  <c:if test="${result>0}">
    는 사용불가능한 아이디입니다.
  </c:if>
  <!-- 중복아이디가 없을때 -->
  <c:if test="${result<=0}">
    는 사용가능한 아이디 입니다.
    <input type="button" value="사용하기" onclick="setUserid('${m_userid}')" />
  </c:if>
  <hr />
  <form method="get" action="/myapp/idCheck">
    아이디 : <input type="text" name="m_userid" id="m_userid">
    <input type="submit" value="아이디중복검사하기">
  </form>