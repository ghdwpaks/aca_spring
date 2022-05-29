<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
메인화면<br>
<button>로그인</button>
<a href="join.jsp"><button>회원가입</button></a>
<a href="<%= request.getContextPath() %>/join.jsp"><button>회원가입</button></a>
<a href="${ pageContext.request.contextPath }/join.jsp"><button>회원가입</button></a>

</body>
</html>