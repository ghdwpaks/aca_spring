<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈 값 입력</title>
</head>
<body>
<form method="post" action="<%= request.getContextPath() %>/calc/add">
	<input type="text" name="n1">+
	<input type="text" name="n2">
	<input type="submit" value="덧셈계산">
</form>
<form method="post" action="<%= request.getContextPath() %>/calc/min">
	<input type="text" name="n1">-
	<input type="text" name="n2">
	<input type="submit" value="뺄셈계산">
</form>
</body>
</html>