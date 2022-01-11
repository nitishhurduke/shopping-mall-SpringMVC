<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
	<form action="addNewProduct">
		<table border="" align="center">
			<tr>
				<th>Product Name</th>
				<td><input type="text" required="required"
					autofocus="autofocus" name="name"></td>
			</tr>
			<tr>
				<th>Product Quantity</th>
				<td><input type="number" required="required" name="quantity"
					placeholder="Total products you want initially"></td>
			</tr>
			<tr>
				<th>Set Discount</th>
				<td><input type="number" required="required" name="discount"
					placeholder="Enter Value in '%'"></td>
			</tr>
			<tr>
				<th>Set Price</th>
				<td><input type="number" required="required" name="price"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Add"> 
					<input type="reset" value="Reset">
					<a href = "toAdmin">back to admin Portal</a>
				</td>

			</tr>
		</table>

	</form>
</body>
</html>