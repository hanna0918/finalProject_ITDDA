<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>로그인</h1>
<form method="post" action="/itda/loginOk">
	<input type="text" name="userid" placeholder="아이디입력">
	<input type="password" name="userpwd" placeholder="비밀번호입력"/>
	<input type="submit" value="로그인">
</form>
