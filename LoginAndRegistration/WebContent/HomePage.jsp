<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body bgcolor="LightSalmon">
	<h1>Welcome To Capgemini</h1>
	<div style="background-color: pink">
		<fieldset>
			<legend>HomePage </legend>
			<form action="preLogInServlet" method="post">
				<input type="submit" value="SignIn">
			</form>
			<form action="preSignUpServlet" method="post">
				<input type="submit" value="SignUp">
			</form>
		</fieldset>
	</div>
</body>
</html>