<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up Page</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	margin: 0px
}
</style>
<body bgcolor="Salmon">
	<h1>Register Here</h1>
	<div class="ex">
		<form action="signUpServlet" method="post">
			<table style="width: 50%">
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="fname" required
						placeholder="Enter your first name"></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" required
						placeholder="Enter your last name"></input></td>
				</tr>

				<tr>
					<td>Mobile-Number</td>
					<td><input type="tel" name="mobile" maxlength="10"
						title="only 10 digits" required placeholder="123-456-7890"></input></td>
					<!-- pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" -->
				</tr>

				<tr>
					<td>Email Id</td>
					<td><input type="email" name="email" required
						placeholder="abc@mail.com" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required
						placeholder="Bijaya@12#"
						pattern="((?=.*\d)(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&*()!?]).{6,20})"
						title="must Contain atleast( one digit[0-9],one aplha[a-z] and [A-Z],one specialCharacter )"></td>
				</tr>
				
			</table>
			<br> <input type="submit" value="Register">
		</form>
	</div>
</body>
</html>