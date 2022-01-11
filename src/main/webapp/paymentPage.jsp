<%@page import="com.cjc.mall.web.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
</head>
<body>
	<form action="transaction">
	
		<h2 align="center">Payment Details</h2>
		 
		 <input name="uid" value ="${user.uid}" readonly="readonly" hidden="true" >
		 <input name="pid" value ="${product.productId}" readonly="readonly" hidden="true" >
		<table align="center" border="1">

			
			<tr>
				<th>Product Name</th>
				<td>${product.name}</td>
			</tr>
			
			<tr>
				<th>User</th>
				<td> <label>${user.name}</label> </td>
			</tr>
			<tr>
				<th>Amount</th>
				<td>${product.newPrice}</td>
			</tr>

			<tr>
				<th>Mode</th>
				<td><select name="mode">
						<option selected="selected">Online</option>
						<option>Cash</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Proceed"> </td>
			</tr>


		</table>
	</form>
</body>
</html>