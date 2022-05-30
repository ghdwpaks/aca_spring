<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method="post">
	<input type="text" name="infoId" placeholder="아이디" value="${id}" required><br>
	<input type="password" name="infoPw" placeholder="비밀번호" required><br>
	<input type="checkbox" name="rememberId" value="1" <c:if test="${!empty id}">checked</c:if>>아이디 기억하기
	<input type="submit" value="로그인">
</form>
</body>
</html>