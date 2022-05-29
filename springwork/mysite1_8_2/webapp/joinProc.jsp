<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="info.InfoVo, info.InfoDao"%>
<%
	String infoId = request.getParameter("info_id");
	String infoPw = request.getParameter("info_pw");
	String infoNick = request.getParameter("info_nick");
	
	System.out.println("infoId:"+infoId);
	System.out.println("infoPw:"+infoPw);
	System.out.println("infoNick:"+infoNick);
	
	InfoVo vo = new InfoVo(infoId, infoPw, infoNick);
	InfoDao dao = new InfoDao();
	dao.insertInfo(vo);
	response.sendRedirect("index.jsp");
%>
