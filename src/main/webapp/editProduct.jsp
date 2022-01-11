<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
<form action="updateProduct">
	
<h2 align="center">Edit Product</h2>
	<table align = "center" border="1">
	<tr>
		<th>Product Id</th>
		<td> <input type="text" value="${product.productId}" name = "productId" readonly="readonly"> </td>
	</tr>
	<tr>
		<th>Product Name</th>
		<td> <input type= "text" value="${product.name}" name = "name" required="required"> </td>
	</tr>
	<tr>
		<th>Product Quantity</th>
		<td><input type= "text" value="${product.quantity}" name = "quantity" required="required"> </td>
	</tr>
	<tr>
		<th>Product Price</th>
		<td><input type= "text" value="${product.price}" name = "price" required="required"></td>
	</tr>
	<tr>
		<th>Discount on Product</th>
		<td><input type= "text" value="${product.discount}" name = "discount" required="required"> </td>
	</tr>
	<tr>
		<td colspan="2" align="center" >
			<input type="submit" value = "Update">
			<a href = "toAdmin">Back to Admin Portal</a>
		</td>
	</tr>
	</table>	
</form>
</body>
</html>