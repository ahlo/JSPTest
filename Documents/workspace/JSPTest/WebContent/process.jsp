<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.beans.User" scope="request">
		<jsp:setProperty property="*" name="user" />
	</jsp:useBean>
Hello <jsp:getProperty property="userName" name="user" />!
<br>Address1: <jsp:getProperty property="address1" name="user" />
<br>Address2: <jsp:getProperty property="address2" name="user" />
<br>City: <jsp:getProperty property="city" name="user" />
<br>State: <jsp:getProperty property="state" name="user" />
<br>Pincode: <jsp:getProperty property="pincode" name="user" />
</body>
</html>