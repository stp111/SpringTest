<%@page import="com.example.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Student</title>
</head>
<body>
	<h1>check Student in session:</h1>

	<P>id: ${student.id}.</P>
	<P>name: ${student.name}.</P>

	<hr>

	<%
		java.util.Enumeration<String> sessEnum = request.getSession().getAttributeNames();
		while (sessEnum.hasMoreElements()) {
			String s = sessEnum.nextElement();
			out.print(s);
			out.println("==" + request.getSession().getAttribute(s));
	%><br />
	<%
		}
	%>
</body>
</html>
