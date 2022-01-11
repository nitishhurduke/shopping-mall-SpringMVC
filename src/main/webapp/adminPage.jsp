<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal</title>
<script type="text/javascript">

function showAllProducts(){
	document.ad.action = "showAllProducts";
	document.ad.submit();
	
}
function showAllUsers(){
	document.ad.action = "showAllUsers";
	document.ad.submit();
	
}
function toAddNewProduct(){
	document.ad.action = "toAddNewProduct";
	document.ad.submit();
}

</script>
</head>
<body>
<form name = "ad">
	
	<table align = "center" border = "1">
		<tr>
			<th><button onclick="showAllProducts()" >Show All Products</button></th>
		</tr>
		
		<tr>
			<th><button onclick="showAllUsers()" >Show All Users</button></th>
		</tr>
		
		
		<tr>
			<th><button onclick="toAddNewProduct()" >Add New Product</button></th>
		</tr>
		<tr>
				<td>  <a href = "login.jsp">Back to Login</a> </td>
		</tr>
		
	</table>

</form>
</body>
</html>