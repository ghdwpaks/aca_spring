<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form action="step3" method="post">
이메일:<input type="text" name="email"><br>
이름:<input type="text" name="name"><br>
비밀번호:<input type="password" name="password"><br>
비밀번호 확인:<input type="password" name="confirmPassword"><br>
<input type="submit" value="가입완료">

</form>
</body>
</html>