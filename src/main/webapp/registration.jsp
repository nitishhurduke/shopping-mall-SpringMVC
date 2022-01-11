<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<form action="registration">
		<h2 align="center">User Registration Form</h2>
		<table align="center">
			<tr>
				<th>Name: </th>
				<td><input type="text" name="name" required="required" ></td>
			</tr>
			<tr>
				<th>Mobile Number: </th>
				<td><input type="text" name="mobile" required="required" ></td>
			</tr>
			<tr>
				<th>Username</th>
				<td><input type="text" name="username" required="required" ></td>
			</tr>
			<tr>
				<th>Set Password</th>
				<td><input type="text" name="password" required="required" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Register"> <input type="reset" value="Reset"> <a href = "home">Back to Login</a>   </td>
			</tr>						


		</table>
	</form>
</body>
</html>