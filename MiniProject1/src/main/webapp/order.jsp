
<%@page import="Model.*"%>
<%@page import="connection.DbCon"%>
<%@page import="Dao.ProductDao"%>
<%@page import="servlet.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnection());
	cartProduct= pDao.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
<link rel="stylesheet" href="include/navbar.css" />

<style type="text/css">

body {
	padding-top: 5%;
	height: 80vh;
	text-align: center;
	align-items: center;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.row {
	padding: 10px;
	display: flex;
}

.column {
	
}



.img {
	width: Auto;
}

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="/include/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			
			
					<tr>
						<td>12-2-2023</td>
						<td>Name</td>
						<td>category</td>
						<td>1</td>
						<td>$345</td>
						<td><a class="btn btn-sm btn-danger" href="cancel-order?id=">Cancel Order</a></td>
					</tr>
			
			
			</tbody>
		</table>
	</div>
</body>
</html>