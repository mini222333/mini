<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>login.jsp page 입니다.</h3>
id <%= request.getParameter("id") %>
/pw <%= request.getParameter("pw") %> 처리 ~~~~
</body>
</html>