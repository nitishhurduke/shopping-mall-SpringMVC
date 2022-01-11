<%@page import="com.cjc.mall.web.model.User"%>
<%@page import="com.cjc.mall.web.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<script type="text/javascript">

function toPayment(){
	document.up.action = "toPayment";
	document.up.submit();
}


</script>

</head>
<body>
<form action="" name="up">
<% User user = (User) request.getAttribute("user"); %>

<h2 align="center"> Welcome to the Shopping Mall <%= user.getName()%> </h2>
<h3 align="center">Buy Product</h3>
<br>
<input name="userId" hidden="true" value = "${user.uid}" > 

<table align="center" border="1">
		<tr>
			<th>Select</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Discount on Product</th>
			<th>Price After Discount</th>
			
		</tr>
		<%
		List<Product> products = (List) request.getAttribute("products");
		for (Product product : products) {
		%>

		<tr>
			<td  align = "center"><input type="radio" name="productId"
					value="${product.productId}"  ></td>
			<td align = "center"><%=product.getProductId()%></td>
			<td align = "center"><%=product.getName()%></td>
			<td align = "center"><%=product.getPrice()%>₹</td>
			<td align = "center"><%=product.getDiscount()%>%</td>
			<% double newPrice = product.getPrice()-(product.getPrice() * product.getDiscount()/100); %>
			
			<td align = "center" > <font size="4"> <strong> <%=newPrice%>₹ </strong></font><button onclick="toPayment()" >Buy</button> </td>
		</tr>
		<%
		}
		%>
			<tr>
				<td colspan="6" align="center">
					<a href = "login.jsp">Back to Login Page</a>
				</td>
			</tr>
	</table>
</form>
</body>
</html>