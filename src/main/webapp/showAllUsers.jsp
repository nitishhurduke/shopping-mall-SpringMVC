<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function deleteUser(){
	document.sau.action = "deleteUser";
	document.sau.submit();
	
}

</script>
<meta charset="UTF-8">
<title>Show All Users</title>
</head>
<body>
	<form name = "sau">
	<h2 align="center"> All Users </h2>
		<table border="1" align = "center">
			<tr>
				<th align = "center">Select </th>
				<th align = "center">User Id</th>
				<th align = "center">Name</th>
				<th align = "center">Mobile</th>
				<th align = "center">Username</th>
				<th align = "center">Password</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td align = "center"><input type="radio" name="uid" value=${user.uid }>
					</td>
					<td align = "center">${user.uid}</td>
					<td align = "center">${user.name}</td>
					<td align = "center">${user.mobile}</td>
					<td align = "center">${user.username}</td>
					<td align = "center">${user.password}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="center">
					<button onclick="deleteUser()">Delete Student</button>
					<a href = "toAdmin">Back to Admin Portal</a>
				</td>
			</tr>

		</table>
	</form>
</body>
</html>