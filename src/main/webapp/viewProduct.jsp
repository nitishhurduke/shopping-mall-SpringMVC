<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
<form action="">

<h2 align="center">Product Details</h2>
	<table align = "center" border="1">
	<tr>
		<th>Product Id</th>
		<td>${product.productId}</td>
	</tr>
	<tr>
		<th>Product Name</th>
		<td>${product.name}</td>
	</tr>
	<tr>
		<th>Product Quantity</th>
		<td>${product.quantity}</td>
	</tr>
	<tr>
		<th>Product Price</th>
		<td>${product.price}</td>
	</tr>
	<tr>
		<th>Discount on Product</th>
		<td>${product.discount}% </td>
	</tr>
	
	<tr>
		<td colspan="2" align="center"><a href = "toAdmin">Back to Admin Portal</a></td>
	</tr>
	
	</table>	
</form>
</body>
</html>