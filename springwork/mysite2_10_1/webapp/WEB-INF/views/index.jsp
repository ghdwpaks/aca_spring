<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="info.repository.InfoVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
메인화면<br>
<%
	InfoVo vo = (InfoVo)session.getAttribute("user");
	if(vo == null){
%>
	<a href="login"><button>로그인</button></a>
	<a href="${ pageContext.request.contextPath }/join"><button>회원가입</button></a>
<%  }else { %>
		<%= vo.getInfoId() %>님으로 로그인<a href="logout"><button>로그아웃</button></a>
<%  } %>

</body>
</html>