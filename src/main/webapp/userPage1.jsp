<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<script type="text/javascript">
	function toPayment() {
		document.up.action = "toPayment";
		document.up.submit();
	}
</script>

</head>
<body>
	<form action="" name="up">

		<h2 align="center">Welcome to the Shopping Mall ${user.name}</h2>
		<h3 align="center">Buy Product</h3>
		<br> <input name="userId" hidden="true" value="${user.uid}">

		<table align="center" border="1">
			<tr>
				<th>Select</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Discount on Product</th>
				<th>Price After Discount</th>

			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td align="center"><input type="radio" name="productId"
						value="${product.productId}" checked="checked"></td>
					<td align="center">${product.productId}</td>
					<td align="center">${product.name}</td>
					<td align="center">${product.price}₹</td>
					<td align="center">${product.discount}%</td>
					<td align="center"><font size="4"> <strong> ${product.newPrice}₹
						</strong></font>
						<button onclick="toPayment()">Buy</button></td>
				</tr>

			</c:forEach>


			<tr>
				<td colspan="6" align="center"><a href="login.jsp">Back to
						Login Page</a></td>
			</tr>
		</table>
	</form>
</body>
</html>