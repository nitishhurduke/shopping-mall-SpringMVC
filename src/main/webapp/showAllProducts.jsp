<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>
<script type="text/javascript">
	
function deleteProduct(){
	document.sap.action = "deleteProduct";
	document.sap.submit();
}  	
function viewProduct(){
	document.sap.action = "viewProduct";
	document.sap.submit();
}  	
function editProduct(){
	document.sap.action = "editProduct";
	document.sap.submit();
}  	
function addMoreQuantity(){
	document.sap.action = "addMoreQuantity";
	document.sap.submit();
}  	

</script>
</head>
<body>
<form name = "sap" >
	<h2 align="center">All Products</h2>
	<table align="center" border="1">
		<tr>
			<th>Select</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Quantity</th>
			<th>Product Price</th>
			<th>Discount on Product</th>
			<th>Price after Discount</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td  align = "center"><input type="radio" name="productId"
					value="${product.productId}" checked="checked"  ></td>
				<td  align = "center">${product.productId} </td>
				<td  align = "center">${product.name}</td>
				<td nowrap="nowrap" align = "center">${product.quantity}
					<input type="number" placeholder="Add more quantity" name="moreQuantity">
					<button onclick="addMoreQuantity()" >Add</button>	
				</td>
				<td  align = "center">${product.price}₹</td>
				<td  align = "center">${product.discount}%</td>
				<td  align = "center">${product.newPrice}₹</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="7" align="center">
					<button onclick="deleteProduct()" >Delete Product</button>
					<button onclick="viewProduct()" >View Product</button>
					<button onclick="editProduct()" >Edit Product</button>
					<a href = "toAdmin">Back to Admin Portal</a>
				</td>
			</tr>
	</table>
	</form>
</body>
</html>