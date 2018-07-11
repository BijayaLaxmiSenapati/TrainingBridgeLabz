<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- <style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	margin: 0px
}
</style> -->
<body bgcolor="LightCoral">
	<center>
		<h3>${message}</h3>
		<h1>Welcome To Capgemini</h1>
		<div>
			<table style="width: 60%" border=1>
				<tr>
					<td>SerialNum</td>
					<td>FullName</td>
					<td>MobileNumber</td>
					<td>EmailId</td>
				</tr>
				<tr>
					<td>${serialNum}</td>
					<td>${fullName}</td>
					<td>${mobile}</td>
					<td>${username}</td>
				</tr>
			</table>
			<br>
			<br>
			<form action="SuccessfullyLogoutServlet" method="get" name="Logout">
				<input type="submit" value="Logout" name="Logout">
			</form>
		</div>
	</center>

</body>
</html>